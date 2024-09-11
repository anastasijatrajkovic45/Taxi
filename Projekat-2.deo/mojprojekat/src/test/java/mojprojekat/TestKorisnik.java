package mojprojekat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestKorisnik
{
	 private static KorisnikServiceImpl service;
		
	   @BeforeClass
	   public static void initTest()
	   {
		   service = new KorisnikServiceImpl();
		   System.out.println("BeforeClass: Uspesno inicijalizovan test");
	   }
		
	  //Preduslov:Ne postoji korisnik sa jmbg-om 222
	   @Before
	   public void testPrecondition()
	   {
		   Korisnik user = service.getKorisnikObj(222);
	       assertNull(user);
		   System.out.println("Before: Preduslov");

	   }
	   
	   //Dodajemo korisnika sa jmbg-om 222
	   @Test
	   public void testAssertions() 
	   {
		   service.createKorisnik(222, "Petar", "Petrovic", 25, "Beograd", "Srbija"); 
		   System.out.println("Test:izvrsen");

	   }
	   
	   //Post-uslov:Postoji korisnik sa jmbg-om 222 	
	   @After
	   public void testPostcondition()
	   {
		   Korisnik user= service.getKorisnikObj(222);
	       assertNotNull(user);
	       System.out.println("After: post-uslov");
	   }
	   
	   //Brisemo test podatke iz baze
	   @AfterClass
	   public static void clearTest()
	   {
		   service.deleteKorisnik(222);
		   System.out.println("AfterClass:obrisani test podaci");

	   }
}