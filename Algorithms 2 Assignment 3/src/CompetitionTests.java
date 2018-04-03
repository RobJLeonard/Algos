import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.*;

public class CompetitionTests {


	@Test
	public void testDijkstraConstructor() throws Exception 
	{
		System.out.println("Dijkstra Valid"); 
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
	public void testInvalidDijkstraConstructor() throws Exception 
	{
		System.out.println("Dijkstra Invalid");
		
		CompetitionDijkstra cD = new CompetitionDijkstra("invalidTinyEWD.txt", 50, 80, 60);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		cD = new CompetitionDijkstra("invalidTinyEWD2.txt", 50, 80, 60);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD2: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		cD = new CompetitionDijkstra("invalidTinyEWD3.txt", 50, 80, 60);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD3: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		cD = new CompetitionDijkstra("invalidTinyEWD4.txt", 50, 80, 60);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD4: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
	
	} 
	
	@Test
	public void testFNFDijkstra() throws Exception
	{
		System.out.println("Dijkstra missing file");
		CompetitionDijkstra cD = new CompetitionDijkstra("", 50, 80, 60);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("null: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
		
		cD = new CompetitionDijkstra("whereAmI.txt", 50, 80, 60);
		assertEquals("Time required", -1, cD.timeRequiredforCompetition());
		System.out.println("whereAmI.txt: Minimum time required: " + cD.timeRequiredforCompetition() + " (mins)");
	}

	@Test
	public void testFWConstructor() throws FileNotFoundException 
	{
		System.out.println("FW Valid");
		CompetitionFloydWarshall cFW = new CompetitionFloydWarshall("tinyEWD.txt", 50, 80, 60);
		assertEquals("Time required", 38, cFW.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		cFW = new CompetitionFloydWarshall("tinyEWD.txt", 60, 80, 60);
		assertEquals("Time required", 31, cFW.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		cFW = new CompetitionFloydWarshall("tinyEWD.txt", 100, 100, 100);
		assertEquals("Time required", 19, cFW.timeRequiredforCompetition());
		System.out.println("tinyEWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		cFW = new CompetitionFloydWarshall("1000EWD.txt", 50, 80, 60);
		assertEquals("Time required", 28, cFW.timeRequiredforCompetition());
		System.out.println("1000EWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
	}

	@Test
	public void testInvalidFWConstructor() throws Exception 
	{
		System.out.println("FW Invalid");
		CompetitionFloydWarshall cFW = new CompetitionFloydWarshall("invalidTinyEWD.txt", 50, 80, 60);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		cFW = new CompetitionFloydWarshall("invalidTinyEWD2.txt", 50, 80, 60);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD2: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
	
		cFW = new CompetitionFloydWarshall("invalidTinyEWD3.txt", 50, 80, 60);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD3: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		cFW = new CompetitionFloydWarshall("invalidTinyEWD4.txt", 50, 80, 60);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("invalidTinyEWD4: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
	
	}
	
	
	@Test
	public void testFNFFW() throws Exception
	{
		System.out.println("FW missing file");
		CompetitionFloydWarshall cFW = new CompetitionFloydWarshall("", 50, 80, 60);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("null: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
		
		cFW = new CompetitionFloydWarshall("whereAmI.txt", 50, 80, 60);
		assertEquals("Time required", -1, cFW.timeRequiredforCompetition());
		System.out.println("whereAmI.txt: Minimum time required: " + cFW.timeRequiredforCompetition() + " (mins)");
	}

}
