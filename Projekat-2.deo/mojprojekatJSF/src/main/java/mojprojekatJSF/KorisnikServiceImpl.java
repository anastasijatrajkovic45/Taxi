package mojprojekatJSF;

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
public class KorisnikServiceImpl implements KorisnikService 
{
	@PersistenceContext(name = "mojprojekatJSF")
	private EntityManager em;
	
	public KorisnikServiceImpl()
	{
	}
	
	public void createKorisnik(double jmbg, String ime, String prezime, int godine, String grad, String drzava) 
	{
		try 
		{
			double JMBG=jmbg;
			Korisnik user=new Korisnik(JMBG,ime,prezime,godine,grad,drzava);
			em.persist(user);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom (KorisnikServiceImpl.createKorisnik): \n" + ex.getMessage()); 
		}
	}
	
	public String getKorisnik(double jmbg) 
	{
		String opisKorisnika="";
		try 
		{
			double JMBG=jmbg;
			
			Korisnik user=em.find(Korisnik.class,jmbg);
			opisKorisnika= user.toString();
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom (KorisnikServiceImpl.getKorisnik): \n" + ex.getMessage()); }
		
		return opisKorisnika;		
	}

	public void updateKorisnik(double jmbg, String grad, String drzava)
	{
		try 
		{
			double JMBG=jmbg;
			Korisnik userKorisnik=em.find(Korisnik.class, JMBG);
			userKorisnik.setGrad(grad);
			userKorisnik.setDrzava(drzava);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom (KorisnikServiceImpl.updateKorisnik): \n" + ex.getMessage()); }
		
	}

	public void deleteKorisnik(double jmbg) 
	{
		try 
		{
			double JMBG=jmbg;
			Korisnik user=em.find(Korisnik.class, JMBG);
			em.remove(user);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom at (KorisnikServiceImpl.deleteKorisnik): \n" + ex.getMessage()); }
		
	}

	public Korisnik getKorisnikObj(double jmbg) 
	{
		Korisnik user=null;
		try 
		{
			double JMBG=jmbg;
			user=em.find(Korisnik.class, JMBG);
		}
		catch(Exception ex) { System.out.println("Greska prilikom rada sa bazom (KorisnikServiceImpl.getKorisnikObj): \n" + ex.getMessage()); }
		
		return user;
	}
	
	@Override
	public List<Korisnik> prikazSvihKorisnika() 
	{
		
			List<Korisnik> sviKorisnici = em.createQuery("SELECT k FROM Korisnik k", Korisnik.class).getResultList();
			return sviKorisnici;
			
	}
}