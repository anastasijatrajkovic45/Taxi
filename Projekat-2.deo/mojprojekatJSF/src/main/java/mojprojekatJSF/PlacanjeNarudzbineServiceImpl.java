package mojprojekatJSF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Remote(PlacanjeNarudzbineService.class) 
@Stateless
public class PlacanjeNarudzbineServiceImpl implements PlacanjeNarudzbineService 
{
	@PersistenceContext(name = "mojprojekatJSF")
	private EntityManager em;
	
	private static int id;
	public PlacanjeNarudzbineServiceImpl()
	{

	}

	public void createPlacanjeNarudzbine(String cena, String brojPredjKM, String jmbgKor, String idNarudzbine) 
	{
		try
		{
			int Cena=Integer.parseInt(cena);
			int BrojPredjKM=Integer.parseInt(brojPredjKM);
			int JMBGKor=Integer.parseInt(jmbgKor);
			int IdNarudzbina=Integer.parseInt(idNarudzbine);
			int newCena=50*BrojPredjKM;
			
			PlacanjeNarudzbine p = new PlacanjeNarudzbine(newCena,BrojPredjKM,JMBGKor,IdNarudzbina);
			em.persist(p);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(PlacanjeNarudzbineServiceImpl.createPlacanjeNarudzbine): \n" + ex.getMessage()); }
		

	}

	public String getPlacanjeNarudzbine(String idRacuna) 
	{
		PlacanjeNarudzbine p=null;
		try
		{
			int IdRacuna=Integer.parseInt(idRacuna);
			p=em.find(PlacanjeNarudzbine.class,IdRacuna);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(PlacanjeNarudzbineServiceImpl.getPlacanjeNarudzbine): \n" + ex.getMessage()); }
		
		return p.toString();
	}


	public void updatePlacanjeNarudzbine(String idRacuna, String predjeniKm) 
	{
		try
		{
			int IdRacuna=Integer.parseInt(idRacuna);
			int predjeniKmm=Integer.parseInt(predjeniKm);
			
			PlacanjeNarudzbine p=em.find(PlacanjeNarudzbine.class,IdRacuna);
			p.setpredjeniKm(predjeniKmm);
			int newCena=this.getCenuZaUslugu(predjeniKm);
			p.setCena(newCena);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(PlacanjeNarudzbineServiceImpl.updatePlacanjeNarudzbine): \n" + ex.getMessage()); }
		
	}

	public void deletePlacanjeNarudzbine(String idRacuna) 
	{
		try
		{
			int IdRacunaInt=Integer.parseInt(idRacuna);
			PlacanjeNarudzbine p=em.find(PlacanjeNarudzbine.class,IdRacunaInt);
			em.remove(p);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(PlacanjeNarudzbineServiceImpl.deletePlacanjeNarudzbine): \n" + ex.getMessage()); }
		
	}


	public PlacanjeNarudzbine getPlacanjeRacunaObj(String idRacuna) 
	{
		PlacanjeNarudzbine p=null;
		try
		{
			int IDRacuna=Integer.parseInt(idRacuna);
			p=em.find(PlacanjeNarudzbine.class,IDRacuna);
			return p;
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(PlacanjeNarudzbineServiceImpl.getPlacanjeRacunaObj): \n" + ex.getMessage()); }
		
		return p;
	}


	public List<PlacanjeNarudzbine> prikazSvihPlacanjaNarudzbine() 
	{
		List<PlacanjeNarudzbine> sveNarudzbine = em.createQuery("SELECT k FROM PlacanjeNarudzbine k", PlacanjeNarudzbine.class).getResultList();
		return sveNarudzbine;
		
	}


	public int getCenuZaUslugu(String brPredjenihKM) 
	{
		int cena=0;
		try
		{
			int BrPredjenihKM=Integer.parseInt(brPredjenihKM);
			int tarifa=50;
			cena=tarifa*BrPredjenihKM;
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(PlacanjeNarudzbineServiceImpl.getCenuZaUslugu): \n" + ex.getMessage()); }
		
		return cena;
	}
	
	/*@Override
	public int createPlacanjeNarudzbineZaTest(int cena, int brojPredjKM, int jmbgKor, int idNarudzbine) 
	{
		try
		{
			
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at(PlacanjeNarudzbineServiceImpl.): \n" + ex.getMessage()); }
		
		int newCena=50*brojPredjKM;
		em.getTransaction().begin();
		PlacanjeNarudzbine p = new PlacanjeNarudzbine(newCena,brojPredjKM,jmbgKor,idNarudzbine);
		em.persist(p);
		em.getTransaction().commit();
		id=p.getIdRacuna();
		return id;
	}*/

	
	
	private static final String USER_AGENT = "Mozilla/5.0";



}
