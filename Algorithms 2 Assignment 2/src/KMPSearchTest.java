import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class KMPSearchTest {

	@Test
	public void testSearchFirst()
	{
		// Empty strings 
		assertEquals("Empty text or pattern is invalid",-1,KMPSearch.searchFirst("",""));
		assertEquals("Empty text or pattern is invalid",-1,KMPSearch.searchFirst("Hello",""));
		assertEquals("Empty text or pattern is invalid",-1,KMPSearch.searchFirst("","Goodbye"));

		// All Equal
		assertEquals("String and Pattern are the same",0, KMPSearch.searchFirst("Hello","Hello"));
		assertEquals("String and Pattern are the same",0, KMPSearch.searchFirst("A","A"));

		// Case does not match
		assertEquals("String and Pattern are the same",-1, KMPSearch.searchFirst("A","a"));


		assertEquals("Text contains substring at beginning",0, KMPSearch.searchFirst("Hello","H"));

		assertEquals("Text contains substring at middle",2, KMPSearch.searchFirst("Hello","ll")); 

		assertEquals("Text contains substring at end",4, KMPSearch.searchFirst("Hello","o"));

 
		assertEquals("Pattern not present",-1, KMPSearch.searchFirst("Hello","sup"));
		assertEquals("Pattern longer than text",-1, KMPSearch.searchFirst("Hello","Goodbye"));
	}

	@Test
	public void testSearchAll()
	{
		// Empty strings error state
		assertEquals("Empty text or pattern is invalid",0,KMPSearch.searchAll("",""));
		assertEquals("Empty text or pattern is invalid",0,KMPSearch.searchAll("Hello",""));
		assertEquals("Empty text or pattern is invalid",0,KMPSearch.searchAll("","Goodbye"));
		
		assertEquals("No occurence of the pattern",0, KMPSearch.searchAll("Goodbye","Hello"));
		
		assertEquals("1 occurence of the pattern",1, KMPSearch.searchAll("Hello","Hello"));
		
		assertEquals("2 occurences of the pattern",2, KMPSearch.searchAll("HelloHello","Hello"));
		
		assertEquals("Case does not match",0, KMPSearch.searchAll("AAAAAAAA","a"));
		
		assertEquals("3 occurences but overlapping patterns",3, KMPSearch.searchAll("AAAAAAAAA","AAA"));
		
		
	}

	@Test
	public void testContains()
	{
		// Empty strings
		assertFalse("Empty text or pattern is invalid",KMPSearch.contains("",""));
		assertFalse("Empty text or pattern is invalid",KMPSearch.contains("Hello",""));
		assertFalse("Empty text or pattern is invalid",KMPSearch.contains("","Goodbye"));
		
		// All Equal
		assertTrue("String and Pattern are the same", KMPSearch.contains("Hello","Hello"));
		assertTrue("String and Pattern are the same", KMPSearch.contains("A","A"));
		
		assertFalse("Case does not match", KMPSearch.contains("A","a"));
		
		
		assertTrue("Text contains substring at beginning", KMPSearch.contains("Hello","He"));
		
		assertTrue("Text contains substring at middle", KMPSearch.contains("Hello","ll")); 
		 
		assertTrue("Text contains substring at end", KMPSearch.contains("Hello","lo"));
		
		
		assertFalse("Pattern not present", KMPSearch.contains("Hello","sup"));
		assertFalse("Pattern longer than text", KMPSearch.contains("Hello","Goodbye"));

	}
	
	public static String readAll( String fileName) throws FileNotFoundException
    {
    	Scanner scanner = new Scanner(new FileInputStream(fileName));
    	
    	String a = scanner.useDelimiter("\\Z").next();
    	scanner.close();	
    	return a;
    }
	
	@Test
	public void main ()
	{
		try 
		{
			String busData = readAll("BUSES_SERVICE_0.json");
			System.out.print("Number of vehicles in data: " + KMPSearch.searchAll(busData, "VehicleNo") + "\n");
			System.out.print("Contains info on vehicle no. 16555: "+ KMPSearch.contains(busData, "\"VehicleNo\":\"16555\"") + "\n");
			System.out.print("Number of mentions of 16555 in data: " + KMPSearch.searchAll(busData, "16555") + "\n");
			System.out.print("Position of 16555 in data: " + KMPSearch.searchFirst(busData, "16555") + "\n");
			System.out.print("First occurence of HAMPTON PARK in data: " + KMPSearch.searchFirst(busData, "HAMPTON PARK") + "\n");
			System.out.print("Contains info on vehicle no. 9043409: "+ KMPSearch.contains(busData, "\"VehicleNo\":\"9043409\"") + "\n");
			System.out.print("Contains any info on 9043409: "+ KMPSearch.contains(busData, "9043409") + "\n");

			

		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
		
	}
  
  
}