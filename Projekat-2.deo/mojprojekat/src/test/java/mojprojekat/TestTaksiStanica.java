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

public class TestTaksiStanica 
{
	private static TaksiStanicaServiceImpl service;
	
	   @BeforeClass
	   public static void initTest()
	   {
		   service = new TaksiStanicaServiceImpl();
		   System.out.println("BeforeClass: Uspesno inicijalizovan test");
	   }
		
	  	
	   @Before
	   public void testPrecondition()
	   {
		   TaksiStanica station = service.getTaksiStanicaObj(1111);
	       assertNull(station);
		   System.out.println("Before: Preduslov");

	   }
	   
	   @Test
	   public void testAssertions() 
	   {
		   service.createTaksiStanica(111, "Halo taksi", 20, 5, 50);
		   System.out.println("Test:izvrsen");

	   }
	   
	   @After
	   public void testPostcondition()
	   {
		   TaksiStanica station = service.getTaksiStanicaObj(111);
	       assertNotNull(station);
	       System.out.println("After: post-uslov");
	   }
	   
	   
	   @AfterClass
	   public static void clearTest()
	   {
		   service.deleteTaksiStanica(111);
		   System.out.println("AfterClass:obrisani test podaci");

	   }
}