package mojprojekat;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Remote(TaksiStanicaService.class) 
@Stateless
public class TaksiStanicaServiceImpl implements TaksiStanicaService {

	private EntityManager em;
	public TaksiStanicaServiceImpl()
	{
		EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("mojprojekatPU"); //argument koji se nalazi u persistance.xml u <persistence-unit name="EmployeePU>"
	       em = emf.createEntityManager();
	}
	

	public void createTaksiStanica(int id, String ime, int brojSlobodnihVozila, int brojZauzetihVozila, int cenaPoKilometru)
	{
		TaksiStanica station = new TaksiStanica(id, ime, brojSlobodnihVozila, brojZauzetihVozila, cenaPoKilometru);
		em.getTransaction().begin();
		em.persist(station);
		em.getTransaction().commit();
	}


	public String getTaksiStanica(int id) 
	{
		TaksiStanica station=em.find(TaksiStanica.class, id);
		return station.toString();
	}


	public void updateTaksiStanica(int id, String ime, int brojSlobodnihVozila, int brojZauzetihVozila, int cenaPoKilometru)
	{
		TaksiStanica station=em.find(TaksiStanica.class, id);
		em.getTransaction().begin();
		station.setIme(ime);
		station.setBrojSlobodnihVozila(brojSlobodnihVozila);
		station.setBrojZauzetihVozila(brojZauzetihVozila);
		station.setCenaPoKilometru(cenaPoKilometru);
		em.getTransaction().commit();
	}


	public void deleteTaksiStanica(int id) 
	{
		TaksiStanica station= em.find(TaksiStanica.class, id);
		em.getTransaction().begin();
		em.remove(station);
		em.getTransaction().commit();
	}


	public TaksiStanica getTaksiStanicaObj(int id) 
	{
		TaksiStanica station= em.find(TaksiStanica.class, id);
		return station;
	}


	public String prikazTaksiStanica() 
	{
		String ListaTaksiStanica="";
		TypedQuery<TaksiStanica> query = em.createQuery("SELECT e FROM TaksiStanica e", TaksiStanica.class);
        List<TaksiStanica> stanice = query.getResultList();
    
       for (TaksiStanica e1: stanice) 
       {
    	   ListaTaksiStanica+= e1.toString();
    	   ListaTaksiStanica += "/n";
       }
       return ListaTaksiStanica;
	}


	public void updateTaksiStanicaSlobodnaVozila(int id) 
	{
		TaksiStanica station = em.find(TaksiStanica.class, id);
		int brojSlobodnih = station.getBrojSlobodnihVozila();
		int brojZauzetih = station.getBrojZauzetihVozila();
		brojSlobodnih++;
		brojZauzetih--;
		
		em.getTransaction().begin();
		station.setBrojSlobodnihVozila(brojSlobodnih);
		station.setBrojZauzetihVozila(brojZauzetih);
		em.getTransaction().commit();

	}


	public void updateTaksiStanicaVozilaNaZadatku(int id) 
	{
		TaksiStanica station = em.find(TaksiStanica.class, id);
		int brojSlobodnih = station.getBrojSlobodnihVozila();
		int brojZauzetih = station.getBrojZauzetihVozila();
		if(brojSlobodnih!= 0)
		{
			brojSlobodnih--; 
		}
		brojZauzetih++;
		
		em.getTransaction().begin();
		station.setBrojSlobodnihVozila(brojSlobodnih);
		station.setBrojZauzetihVozila(brojZauzetih);
		em.getTransaction().commit();
	}
}

