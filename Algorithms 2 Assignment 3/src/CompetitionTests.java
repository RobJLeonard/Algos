import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class CompetitionTests {


	@Test
	public void testDijkstraConstructor() 
	{
		System.out.println("\nDijkstra Valid"); 
		CompetitionDijkstra cD = new CompetitionDijkstra("tinyEWD.txt", 50, 80, 60);
		assertEquals("Time required", 38, cD.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		cD = new CompetitionDijkstra("tinyEWD.txt", 60, 80, 60);
		assertEquals("Time required", 31, cD.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		cD = new CompetitionDijkstra("tinyEWD.txt", 100, 100, 100);
		assertEquals("Time required", 19, cD.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		cD = new CompetitionDijkstra("1000EWD.txt", 50, 80, 60);
		assertEquals("Time required", 28, cD.timeRequiredforCompetition());
		System.out.println("1000EWD: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
	}
	
	@Test
	public void testDijkstraLoop()
	{
		System.out.println("\nDijkstra Loops"); 
		CompetitionDijkstra cD = new CompetitionDijkstra("tinyLoopEWD.txt", 50, 80, 60);
		//assertEquals("Time required", 38, cD.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
	}

	@Test
	public void testInvalidDijkstraConstructor()
	{
		System.out.println("\nDijkstra Invalid");
		
		//vertices not in graph
		CompetitionDijkstra cD = new CompetitionDijkstra("invalidTinyEWD.txt", 50, 80, 60);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		//negative distances
		cD = new CompetitionDijkstra("invalidTinyEWD2.txt", 50, 80, 60);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD2: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		//negative edges
		cD = new CompetitionDijkstra("invalidTinyEWD3.txt", 50, 80, 60);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD3: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		//negitive vertices
		cD = new CompetitionDijkstra("invalidTinyEWD4.txt", 50, 80, 60);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD4: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
	
	}  
	
	
	@Test 
	public void testSpeedsDijkstra()
	{
		System.out.println("\nDijkstra Speeds"); 
		CompetitionDijkstra cD = new CompetitionDijkstra("tinyEWD.txt", -1, -1, -1);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		cD = new CompetitionDijkstra("tinyEWD.txt", 20, 10, 5);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		cD = new CompetitionDijkstra("tinyEWD.txt", 120, 200, 999);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
	}
	
	@Test
	public void testFNFDijkstra()
	{
		System.out.println("\nDijkstra missing file");
		CompetitionDijkstra cD = new CompetitionDijkstra("", 50, 80, 60);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("null: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		cD = new CompetitionDijkstra("whereAmI.txt", 50, 80, 60);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("whereAmI.txt: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		cD = new CompetitionDijkstra(null, 50, 80, 60);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("whereAmI.txt: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
	}
	
	
	//@Test
//	public void testWebcatDijkstra() throws FileNotFoundException, Exception
//	{
//		System.out.println("\n****Webcat Dijkstra****\n");
//		String letters = "ABCDEFGHIJKLMN";
//		CompetitionDijkstra cD;
//		for(int i = 0; i<letters.length(); i++)
//		{
//			String fileName = ("input-" + letters.charAt(i) + ".txt");
//			System.out.println(fileName);
//			cD = new CompetitionDijkstra(fileName, 50, 60, 70);
//			
//			System.out.println(fileName + " V: " + cD.G.V() + " E: " + cD.G.E());
//			System.out.println("time: " + cD.timeRequiredforCompetition());
//
//		}
//			
//	}

	@Test
	public void testFWConstructor()
	{
		System.out.println("\nFW Valid");
		CompetitionFloydWarshall cFW = new CompetitionFloydWarshall("tinyEWD.txt", 50, 80, 60);
		assertEquals("Time required", 38, cFW.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		cFW = new CompetitionFloydWarshall("tinyEWD.txt", 60, 80, 60);
		assertEquals("Time required", 31, cFW.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		cFW = new CompetitionFloydWarshall("tinyEWD.txt", 100, 100, 100);
		assertEquals("Time required", 19, cFW.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
//		cFW = new CompetitionFloydWarshall("1000EWD.txt", 50, 80, 60);
//		assertEquals("Time required", 28, cFW.timeRequiredforCompetition());
//		System.out.println("1000EWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
//		
	}
	
	
	@Test
	public void testFWLoop() 
	{
		System.out.println("\nFW Loop");
		CompetitionFloydWarshall cFW = new CompetitionFloydWarshall("tinyLoopEWD.txt", 50, 80, 60);
		//assertEquals("Time required", 38, cFW.timeRequiredforCompetition());
		System.out.println("tinyLoopEWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
	}

	@Test
	public void testInvalidFWConstructor()
	{
		System.out.println("\nFW Invalid");
		//vertices not in graph
		CompetitionFloydWarshall cFW = new CompetitionFloydWarshall("invalidTinyEWD.txt", 50, 80, 60);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		//negative distances
		cFW = new CompetitionFloydWarshall("invalidTinyEWD2.txt", 50, 80, 60);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD2: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		//negative edges
		cFW = new CompetitionFloydWarshall("invalidTinyEWD3.txt", 50, 80, 60);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD3: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		//negative vertices
		cFW = new CompetitionFloydWarshall("invalidTinyEWD4.txt", 50, 80, 60);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD4: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
	
	}
	
	@Test 
	public void testSpeedsFW()
	{
		System.out.println("\nFW Speeds"); 
		CompetitionFloydWarshall cFW = new CompetitionFloydWarshall("tinyEWD.txt", -1, -1, -1);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		cFW = new CompetitionFloydWarshall("tinyEWD.txt", 20, 10, 5);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		cFW = new CompetitionFloydWarshall("tinyEWD.txt", 120, 200, 999);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
	}
	
	
	@Test
	public void testFNFFW()
	{
		System.out.println("\nFW missing file");
		CompetitionFloydWarshall cFW = new CompetitionFloydWarshall("", 50, 80, 60);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("null: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		cFW = new CompetitionFloydWarshall("whereAmI.txt", 50, 80, 60);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("whereAmI.txt: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		cFW = new CompetitionFloydWarshall(null, 50, 80, 60);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("whereAmI.txt: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
	}
	
	//@Test
//	public void testWebcatFW() throws FileNotFoundException, Exception
//	{
//		System.out.println("\n****Webcat FloydWarshall****\n");
//		String letters = "ABCDEFGHIJKLMN";
//		CompetitionFloydWarshall cFW;
//		for(int i = 0; i<letters.length(); i++)
//		{
//			String fileName = ("input-" + letters.charAt(i) + ".txt");
//			System.out.println(fileName);
//			cFW = new CompetitionFloydWarshall(fileName, 50, 60, 70);
//			try{System.out.println(fileName + " V: " + cFW.G.V() + " E: " + cFW.G.E());}
//			catch(NullPointerException e){System.out.println("Could not create graph");}
//			System.out.println(" time: " + cFW.timeRequiredforCompetition());
//			
//		}
//			
//	}

}
