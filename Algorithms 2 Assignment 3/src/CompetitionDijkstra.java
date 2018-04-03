import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
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
 * This class implements the competition using Dijkstra's algorithm
 */

public class CompetitionDijkstra {
	private EdgeWeightedDigraph G;
	private int slowest;
	private double maxDist;
	private static int timeRequired = -1;


	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 * @throws Exception 
	 */
	CompetitionDijkstra (String fileName, int sA, int sB, int sC) throws Exception
	{
		this.slowest = Math.min(Math.min(sA,sB),sC);
		this.maxDist = 0.0;

		// Initialize the graph
		this.G = new EdgeWeightedDigraph(fileName);
		if(G.isValidGraph)
		{
			for(int i = 0; i < G.V(); i++){ 
				DijkstraSP routedGraph = new DijkstraSP(G, i);
				for(int j = 0; j < G.V(); j++){
					if(routedGraph.hasPathTo(j)){
						if(this.maxDist < routedGraph.distTo(j))
							this.maxDist = routedGraph.distTo(j);
					}
				}
			}
			timeRequired = timeRequiredforCompetition();
		}
	}

	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 * 			   regardless of their starting positions
	 */
	public int timeRequiredforCompetition()
	{
		if(G.isValidGraph)
		{
		double time = (1000*this.maxDist)/this.slowest;

		return (int) Math.ceil(time);
		}
		else
			return -1;
	}


	//	public static void main(String[] args) throws IOException
	//	{
	//		
	//		CompetitionDijkstra cD = new CompetitionDijkstra("tinyEWD.txt", 50, 80, 60);
	//		System.out.println("tinyEWD: Minimum time required: " + timeRequired + " (mins)");
	//		cD = new CompetitionDijkstra("1000EWD.txt", 50, 80, 60);
	//		System.out.println("1000EWD: Minimum time required: " + timeRequired + " (mins)");
	//	}

}