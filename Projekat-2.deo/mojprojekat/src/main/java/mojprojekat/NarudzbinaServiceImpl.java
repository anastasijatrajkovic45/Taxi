package mojprojekat;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Stateless
@Remote(NarudzbinaService.class) 
public class NarudzbinaServiceImpl implements NarudzbinaService  {

	private EntityManager em;
	private static int id;
	public NarudzbinaServiceImpl()
	{
		EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("mojprojekatPU"); //argument koji se nalazi u persistance.xml u <persistence-unit name="EmployeePU>"
	       em = emf.createEntityManager();
	}
	

	public void createNarudzbina(int id, String pocAdr, String krajnjaAdr, String vremePorudzbine, int brOsoba, int idTaksiStanice) 
	{
		Narudzbina order = new Narudzbina(id, pocAdr, krajnjaAdr, vremePorudzbine, brOsoba, idTaksiStanice);
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
		
	}
	

	public void createNarudzbina(String pocAdr, String krajnjaAdr, String vremePorudzbine, int brOsoba, int idTaksiStanice) 
	{
		Narudzbina order = new Narudzbina(pocAdr, krajnjaAdr, vremePorudzbine, brOsoba, idTaksiStanice);
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
	}
	

	public String getNarudzbina(int idNarudzbine) 
	{
		Narudzbina order = em.find(Narudzbina.class, idNarudzbine);
		return order.toString();
	}


	public void updateNarudzbina(int idNarudzbine, String krajnjaAdr, String vremePorudzbine, int brOsoba) 
	{
		Narudzbina order=em.find(Narudzbina.class, idNarudzbine);
		em.getTransaction().begin();
		order.setIdNarudzbine(50);
		order.setKrajnjaAdresa(krajnjaAdr);
		order.setvremePorudzbine(vremePorudzbine);
		order.setBrojOsoba(brOsoba);
		em.getTransaction().commit();
	}


	public void deleteNarudzbina(int idNarudzbine) 
	{
		Narudzbina order=em.find(Narudzbina.class, idNarudzbine);
		em.getTransaction().begin();
		em.remove(order);
		em.getTransaction().commit();
		// TODO Auto-generated method stub
	}


	public Narudzbina getNarudzbinaObj(int idNarudzbine) 
	{
		Narudzbina order=em.find(Narudzbina.class, idNarudzbine);
		return order;
	}


	public String prikazSvihNarudzbina() 
	{
		String ListaNarudzbina="";
		TypedQuery<Narudzbina> query = em.createQuery("SELECT e FROM Narudzbina e", Narudzbina.class);
        List<Narudzbina> orders = query.getResultList();
    
       for (Narudzbina e1: orders) 
       {
    	   ListaNarudzbina+= e1.toString();
    	   ListaNarudzbina += "/n";
       }
       return ListaNarudzbina;
	}
	

	public int createNarudzbinaForTest(String pocAdr, String krajnjaAdr, String vremePorudzbine, int brOsoba, int idTaksiStanice) 
	{
		em.getTransaction().begin();
		Narudzbina order = new Narudzbina(pocAdr, krajnjaAdr, vremePorudzbine, brOsoba, idTaksiStanice);
		em.persist(order);
		em.getTransaction().commit();
		
		NarudzbinaServiceImpl.id=order.getIdNarudzbine();
		return id;
	}
}
