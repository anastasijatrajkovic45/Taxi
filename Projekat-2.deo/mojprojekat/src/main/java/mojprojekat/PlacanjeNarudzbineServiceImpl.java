package mojprojekat;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


@Remote(PlacanjeNarudzbineService.class) 
@Stateless
public class PlacanjeNarudzbineServiceImpl implements PlacanjeNarudzbineService
{
	private EntityManager em;
	private static int id;
	public PlacanjeNarudzbineServiceImpl()
	{
		EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("mojprojekatPU"); //argument koji se nalazi u persistance.xml u <persistence-unit name="EmployeePU>"
	       em = emf.createEntityManager();
	}
	
	public void createPlacanjeNarudzbine(int cena, int brojPredjKM, int jmbgKor, int idNarudzbine) 
	{
		int newCena = 50 * brojPredjKM;
		em.getTransaction().begin();
		PlacanjeNarudzbine p = new PlacanjeNarudzbine(newCena, brojPredjKM, jmbgKor, idNarudzbine);
		em.persist(p);
		em.getTransaction().commit();
	}

	public String getPlacanjeNarudzbine(int idRacuna) 
	{
		PlacanjeNarudzbine p = em.find(PlacanjeNarudzbine.class, idRacuna);
		return p.toString();
	}

	public void updatePlacanjeNarudzbine(int idRacuna, int brojPredjenihKM) 
	{
		PlacanjeNarudzbine p=em.find(PlacanjeNarudzbine.class, idRacuna);
		em.getTransaction().begin();
		p.setPredjeniKm(brojPredjenihKM);
		int newCena = this.getCenuZaUslugu(brojPredjenihKM);
		p.setCena(newCena);
		em.getTransaction().commit();
	}
	
	public void deletePlacanjeNarudzbine(int idRacuna) 
	{
		PlacanjeNarudzbine p = em.find(PlacanjeNarudzbine.class, idRacuna);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
	}
	
	public PlacanjeNarudzbine getPlacanjeRacunaObj(int idRacuna) 
	{
		PlacanjeNarudzbine p=em.find(PlacanjeNarudzbine.class, idRacuna);
		return p;
	}
	
	public String prikazSvihPlacanjaNarudzbine() 
	{
		String ListaPlacanja = "";
		TypedQuery<PlacanjeNarudzbine> query = em.createQuery("SELECT e FROM PlacanjeNarudzbine e", PlacanjeNarudzbine.class);
        List<PlacanjeNarudzbine> payments = query.getResultList();
    
       for (PlacanjeNarudzbine e1: payments) 
       {
    	   ListaPlacanja+= e1.toString();
    	   ListaPlacanja += "/n";
       }
       return ListaPlacanja;
	}
	
	public int getCenuZaUslugu(int brPredjenihKM) 
	{
		int tarifa = 50;
		int cena;
		cena = tarifa*brPredjenihKM;
		return cena;
	}
	
	public int createPlacanjeNarudzbineZaTest(int cena, int brojPredjKM, int jmbgKor, int idNarudzbine) 
	{
		int newCena = 50*brojPredjKM;
		em.getTransaction().begin();
		PlacanjeNarudzbine p = new PlacanjeNarudzbine(newCena, brojPredjKM, jmbgKor, idNarudzbine);
		em.persist(p);
		em.getTransaction().commit();
		id=p.getIdRacuna();
		return id;
	}
}