package mojprojekat;

import java.util.List;
import javax.ejb.Remote; 
import javax.ejb.Stateless; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Remote(KorisnikService.class) 
@Stateless
public class KorisnikServiceImpl implements KorisnikService  {

	private EntityManager em;
	
	public KorisnikServiceImpl()
	{
		EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("mojprojekatPU"); //argument koji se nalazi u persistance.xml u <persistence-unit name="EmployeePU>"
	       em = emf.createEntityManager();
	}
	
	public void createKorisnik(double jmbg, String ime, String prezime, int godine, String grad, String drzava)
	{
		em.getTransaction().begin();
		Korisnik user = new Korisnik(jmbg, ime, prezime, godine, grad, drzava);
		em.persist(user);
		em.getTransaction().commit();
	}
	

	public String getKorisnik(double jmbg) 
	{
		Korisnik user = em.find(Korisnik.class, jmbg);
		String opisKorisnika = user.toString();
		
		return opisKorisnika;
	}


	public void updateKorisnik(double jmbg, String grad, String drzava)
	{
		em.getTransaction().begin();
		Korisnik userKorisnik = em.find(Korisnik.class, jmbg);
		userKorisnik.setGrad(grad);
		userKorisnik.setDrzava(drzava);
		em.getTransaction().commit();
	}


	public void deleteKorisnik(double jmbg) 
	{
		em.getTransaction().begin();
		Korisnik user = em.find(Korisnik.class, jmbg);
		em.remove(user);
		em.getTransaction().commit();
	}


	public Korisnik getKorisnikObj(double jmbg) 
	{
		Korisnik user= em.find(Korisnik.class, jmbg);
		return user;
	}
	

	public String prikazSvihKorisnika() 
	{
		String ListaKorsnika="";                              //obratiti paznju na ovo korisnik, mozda treba KORISNIK
		TypedQuery<Korisnik> query = em.createQuery("SELECT e FROM Korisnik e", Korisnik.class);
        List<Korisnik> users = query.getResultList();
    
       for (Korisnik e1: users) 
       {
    	   ListaKorsnika+= e1.toString();
    	   ListaKorsnika += "/n";
       }
       return ListaKorsnika;
	}
}
