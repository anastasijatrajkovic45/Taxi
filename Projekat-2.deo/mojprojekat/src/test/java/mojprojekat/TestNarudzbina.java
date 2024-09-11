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

public class TestNarudzbina 
{
	private static NarudzbinaServiceImpl service;
	private static int ID;
	
	   @BeforeClass
	   public static void initTest()
	   {
		   service = new NarudzbinaServiceImpl();
		   System.out.println("BeforeClass: Uspesno inicijalizovan test");
	   }
		
	  
	   @Before
	   public void testPrecondition()
	   {
		   Narudzbina order = service.getNarudzbinaObj(60);
	       assertNull(order);
		   System.out.println("Before: Preduslov");
	   }
	   
	   
	   @Test
	   public void testAssertions() 
	   {
		   // service.createNarudzbina(111, "Test", "Test", "9:21", 2,123);
		   this.ID=service.createNarudzbinaForTest( "Test", "Test", "9:21", 2, 123);
		   System.out.println("Test:izvrsen");

	   }
	   
	   @After
	   public void testPostcondition()
	   {
		   Narudzbina order = service.getNarudzbinaObj(ID);
	       assertNotNull(order);
	       System.out.println("After: post-uslov");
	   }
	   
	   // Brisemo test podatke iz baze
	   @AfterClass
	   public static void clearTest()
	   {
		   service.deleteNarudzbina(ID);
		   System.out.println("AfterClass:obrisani test podaci");
	   }
}
