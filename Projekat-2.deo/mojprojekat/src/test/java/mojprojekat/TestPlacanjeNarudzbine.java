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

public class TestPlacanjeNarudzbine 
{
	private static PlacanjeNarudzbineServiceImpl service;
	private static int ID;
	
	   @BeforeClass
	   public static void initTest()
	   {
		   service = new PlacanjeNarudzbineServiceImpl();
		   System.out.println("BeforeClass: Uspesno inicijalizovan test");
	   }
		 	
	   @Before
	   public void testPrecondition()
	   {
		   PlacanjeNarudzbine payment = service.getPlacanjeRacunaObj(11111);
	       assertNull(payment);
		   System.out.println("Before: Preduslov");
	   }
	   
	   @Test
	   public void testAssertions() 
	   {
		   //int cena=service.getCenuZaUslugu(6);
		   //service.createPlacanjeNarudzbine(500, 5, 123456, 5 );
		   ID = service.createPlacanjeNarudzbineZaTest(0, 5, 11111, 22222);
		  
		   System.out.println("Test:izvrsen");

	   }
	   
	   //Post-uslov:Postoji zaposleni sa id-om 103 	
	   @After
	   public void testPostcondition()
	   {
		   PlacanjeNarudzbine payment = service.getPlacanjeRacunaObj(ID);
	       assertNotNull(payment);
	       System.out.println("After: post-uslov");
	   }
	   
	   //Brisemo test podatke iz baze
	   @AfterClass
	   public static void clearTest()
	   {
		   service.deletePlacanjeNarudzbine(ID);
		   System.out.println("AfterClass:obrisani test podaci");

	   }
}