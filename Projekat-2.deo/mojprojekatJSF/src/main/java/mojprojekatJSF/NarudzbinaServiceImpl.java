package mojprojekatJSF;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Remote(NarudzbinaService.class) 
@Stateless
public class NarudzbinaServiceImpl implements NarudzbinaService 
{
	@PersistenceContext(name = "mojprojekatJSF")
	private EntityManager em;
	
	private static int id;
	public NarudzbinaServiceImpl()
	{
		
	}

	public void createNarudzbina(String pocAdr, String krajnjaAdr, String vremePorudzbine, String brOsoba, String idTaksiStanice) 
	{
		try 
		{
			int BrOsoba=Integer.parseInt(brOsoba);
			int iddTaksiStanice=Integer.parseInt(idTaksiStanice);
			Narudzbina order=new Narudzbina(pocAdr,krajnjaAdr,vremePorudzbine,BrOsoba,iddTaksiStanice);
			em.persist(order);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at (NarudzbinaServiceImpl.CreateNarudzbina): \n" + ex.getMessage()); }
	
	}
	
	/*@Override
	public void createNarudzbina(String id, String pocAdr, String krajnjaAdr, String vremePorudzbine, String brOsoba,
			String idTaksiStanice) 
	{
		try 
		{
		
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom (NarudzbinaServiceImpl.): \n" + ex.getMessage()); }
		
		Narudzbina order=new Narudzbina(id,pocAdr,krajnjaAdr,vremePorudzbine,brOsoba,idTaksiStanice);
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
		
	}*/


	public String getNarudzbina(String idNarudzbine) 
	{
		Narudzbina order=null;;
		try 
		{
			int ID=Integer.parseInt(idNarudzbine);
			order=em.find(Narudzbina.class,ID);
			//return order.toString();
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at (NarudzbinaServiceImpl.getNarudzbina): \n" + ex.getMessage()); }
		
		return order.toString();
	}

	@Override
	public void updateNarudzbina(String idNarudzbine, String krajnjaAdr, String vremePorudzbine, String brOsoba) 
	{
		try 
		{
			int IdNarudzbine=Integer.parseInt(idNarudzbine);
			int BrOsoba=Integer.parseInt(brOsoba);
			
			Narudzbina order=em.find(Narudzbina.class, IdNarudzbine);
			order.setIdNarudzbine(50);
			order.setKrajnjaAdresa(krajnjaAdr);
			order.setvremePorudzbine(vremePorudzbine);
			order.setBrojOsoba(BrOsoba);
			

		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at (NarudzbinaServiceImpl.updateNarudzbina): \n" + ex.getMessage()); }
		
	}

	@Override
	public void deleteNarudzbina(String idNarudzbine) 
	{
		try 
		{
			int IdNarudzbine=Integer.parseInt(idNarudzbine);
			
			Narudzbina order=em.find(Narudzbina.class, IdNarudzbine);
			em.remove(order);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at (NarudzbinaServiceImpl.deleteNarudzbina): \n" + ex.getMessage()); }	

	}

	@Override
	public Narudzbina getNarudzbinaObj(String idNarudzbina) 
	{
		Narudzbina order=null;
		try 
		{
			int IdNarudzbine=Integer.parseInt(idNarudzbina);
			order=em.find(Narudzbina.class, IdNarudzbine);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(NarudzbinaServiceImpl.getNarudzbina): \n" + ex.getMessage()); }
		
		
		return order;
	}

	@Override
	public List<Narudzbina> prikazSvihNarudzbina() 
	{
		List<Narudzbina> sveNarudzbine = em.createQuery("SELECT k FROM Narudzbina k", Narudzbina.class).getResultList();
		return sveNarudzbine;
	}

}

