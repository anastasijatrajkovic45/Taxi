package mojprojekatJSF;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Remote(TaksiStanicaService.class) 
@Stateless
public class TaksiStanicaServiceImpl implements TaksiStanicaService 
{
	@PersistenceContext(name = "mojprojekatJSF")
	private EntityManager em;
	
	public TaksiStanicaServiceImpl()
	{
		
	}
	
	@Override
	public void createTaksiStanica(String id, String ime, String brSlobodnihVozila, String brVozilaNaZadaktu) 
	{
		try
		{
			int idd=Integer.parseInt(id);
			int BrSlobodnihVozila=Integer.parseInt(brSlobodnihVozila);
			int BrVozilaNaZadatku=Integer.parseInt(brVozilaNaZadaktu);
			
			TaksiStanica station=new TaksiStanica(idd,ime,BrSlobodnihVozila, BrVozilaNaZadatku);
			em.persist(station);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(TaksiStanicaNarudzbineServiceImpl.createTaksiStanica): \n" + ex.getMessage()); }
		
	}

	@Override
	public String getTaksiStanica(String id) 
	{
		TaksiStanica station=null;
		try
		{
			int idd=Integer.parseInt(id);
			station=em.find(TaksiStanica.class,idd);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(TaksiStanicaNarudzbineServiceImpl.getTaksiStanica): \n" + ex.getMessage()); }
		
		return station.toString();
	}

	@Override
	public void updateTaksiStanica(String id, String ime, String brSlobodnihVozila, String brVozilaNaZadaktu) 
	{
		try
		{
			int idd=Integer.parseInt(id);
			int BrSlobodnihVozila=Integer.parseInt(brSlobodnihVozila);
			int BrVozilaNaZadatku=Integer.parseInt(brVozilaNaZadaktu);
			
			TaksiStanica station=em.find(TaksiStanica.class,idd);
			station.setime(ime);
			station.setBrojSlobodnihVozila(BrSlobodnihVozila);
			station.setbrojZauzetihVozila(BrVozilaNaZadatku);
			
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(TaksiStanicaNarudzbineServiceImpl.updateTaksiStanica): \n" + ex.getMessage()); }
		

	}

	@Override
	public void deleteTaksiStanica(String id) 
	{
		try
		{
			int idd=Integer.parseInt(id);
			TaksiStanica station= em.find(TaksiStanica.class, idd);
			em.remove(station);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(TaksiStanicaNarudzbineServiceImpl.deleteTaksiStanica): \n" + ex.getMessage()); }
		

	}

	@Override
	public TaksiStanica getTaksiStanicaObj(String id) 
	{
		TaksiStanica station=null;
		try
		{
			int id_=Integer.parseInt(id);
			station= em.find(TaksiStanica.class, id_);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(TaksiStanicaNarudzbineServiceImpl.getTaksiStanicaOBJ): \n" + ex.getMessage()); }
		
		
		return station;
	}

	@Override
	public List<TaksiStanica> prikazTaksiStanica() 
	{
		List<TaksiStanica> sveStanice = em.createQuery("SELECT k FROM TaksiStanica k", TaksiStanica.class).getResultList();
		return sveStanice;
		
	}

	@Override
	public void updateTaksiStanicaSlobodnaVozila(String id) 
	{
		try
		{
			int id_=Integer.parseInt(id);
			
			TaksiStanica station=em.find(TaksiStanica.class,id_);
			int brojSlobodnih= station.getBrojSlobodnihVozila();
			int brojNaZadatku=station.getbrojZauzetihVozila();
			brojSlobodnih++;
			brojNaZadatku--;
			
			station.setBrojSlobodnihVozila(brojSlobodnih);
			station.setbrojZauzetihVozila(brojNaZadatku);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(TaksiStanicaNarudzbineServiceImpl.updateTaksiStanicaSlobodnihVozila): \n" + ex.getMessage()); }
		
	}

	@Override
	public void updateTaksiStanicaVozilaNaZadatku(String id) 
	{
		try
		{
			int id_=Integer.parseInt(id);
			
			TaksiStanica station=em.find(TaksiStanica.class,id_);
			int brojSlobodnih= station.getBrojSlobodnihVozila();
			int brojNaZadatku=station.getbrojZauzetihVozila();
			if(brojSlobodnih!= 0)
			{
				brojSlobodnih--; 
			}
			brojNaZadatku++;
			
			station.setBrojSlobodnihVozila(brojSlobodnih);
			station.setbrojZauzetihVozila(brojNaZadatku);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(TaksiStanicaNarudzbineServiceImpl.updateTaksiStanicaVozilaNaZadatku): \n" + ex.getMessage()); }
		
	}

}
