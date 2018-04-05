import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
/* * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */

public class CompetitionFloydWarshall {
	public EWDAdjMatrix G;
	private int slowest;
	private double maxDistance;
	private boolean isValidGraph = false;
	private FloydWarshall shortestPaths;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants 
	 * @throws Exception 
	 */
	CompetitionFloydWarshall (String fileName, int sA, int sB, int sC)
	{

		int totalSpeed = sA + sB + sC;
		if(0 <= totalSpeed )
		{
			try
			{
				File file = new File(fileName);
				Scanner input = new Scanner(file);
				this.G = new EWDAdjMatrix(input);
				isValidGraph = G.isValid();
				this.shortestPaths = new FloydWarshall(this.G); 
				this.maxDistance = 0.0;
				this.slowest = Math.min(Math.min(sA,sB),sC);
			}
			catch( FileNotFoundException | NullPointerException | OutOfMemoryError e)
			{
				this.G= null;
				this.isValidGraph = false;
			}
				
				
				
				if(this.shortestPaths != null && this.G.isValid())
				{
					int vertices = this.G.V();
					
					for(int v = 0; v < vertices; v++){
						for(int w = 0; w < vertices; w++){
							if(shortestPaths.hasPath(v,w)){
								if(this.maxDistance < shortestPaths.dist(v,w))
									this.maxDistance = shortestPaths.dist(v,w);
							}
							else
								this.isValidGraph = false;
						}
						
					}
				}
		}
				

	}


	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition(){
		if(this.G != null && this.isValidGraph && this.maxDistance > 0.0 && this.slowest > 0){
			return (int) Math.ceil((1000*this.maxDistance)/this.slowest);
		}
		return -1;
	}

	//  public static void main(String[] args) throws FileNotFoundException{
	//	  CompetitionFloydWarshall cFW = new CompetitionFloydWarshall("tinyEWD.txt", 50, 80, 60);
	//	  System.out.println("tinyEWD: Minimum time required: " + timeRequired + " (mins)");
	//	  cFW = new CompetitionFloydWarshall("1000EWD.txt", 50, 80, 60);
	//	  System.out.println("1000EWD: Minimum time required: " + timeRequired + " (mins)");
	//  }
}