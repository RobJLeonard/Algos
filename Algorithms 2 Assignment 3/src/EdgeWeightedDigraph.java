import java.util.ArrayList;
import java.util.Scanner;

public class EdgeWeightedDigraph 
{
	private int V;                // number of vertices in this digraph
	private int E;                      // number of edges in this digraph
	private ArrayList<WeightedDirectedEdge>[] adj;    // adj[v] = adjacency list for vertex v
	private int[] indegree;             // indegree[v] = indegree of vertex v
	public boolean isValidGraph;


	@SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(Scanner input){


		this.V = input.nextInt();
		this.E = input.nextInt();
		this.isValidGraph = true;

		if(this.V<0)
			this.isValidGraph = false;

		if(this.isValidGraph)
		{

			// Init adjacency and indgree arrays to graph size
			this.adj = new ArrayList[V];
			this.indegree = new int[V];

			for(int i = 0; i < V; i++)
				adj[i] = new ArrayList<WeightedDirectedEdge>();

			if(this.E < 0)
				System.out.println("Edges cannot be negative"); 


			int edges = this.E;

			for (int i = 0; i < edges; i++) 
			{

				if(input.hasNextInt())
				{
					int v = input.nextInt();
					int w = input.nextInt();
					double weight = input.nextDouble();
					if( v >= 0 && w >= 0 && weight >= 0.0)
						addEdge(new WeightedDirectedEdge(v, w, weight));
					else
						this.isValidGraph = false; 
				}

			}
			validateGraph();
		}

		input.close();

	}

	public void validateGraph(){

		if(!this.isValidGraph)
			return;

		boolean graphValid = true;

		for(int v=0; v<this.V; v++){
			if(indegree[v] < 0){
				graphValid = false;
				break;
			}
		}
		this.isValidGraph = graphValid;

	}

	public boolean isValid() {
		if(this.isValidGraph)
			return true;
		else
			return false;
	}




	/**
	 * Returns the number of vertices in this edge-weighted digraph.
	 *
	 * @return the number of vertices in this edge-weighted digraph
	 */
	public int V(){return V;}
	
	public int E(){return E;}


	private boolean validate(int v){
		if(v < 0 || v >= this.V)
		{
			System.out.println("Vertex: " + v + " is not between 0 and " + (this.V -1));
			return false;
		}
		return true;
	}

	/**
	 * Adds a weighted edge to the Digraph
	 * 
	 * @param e the edge to be added
	 */
	public void addEdge(WeightedDirectedEdge e){
		int v = e.from();
		int w = e.to();

		adj[v].add(e);
		indegree[w]++;
		E++;

	}

	/**
	 * Returns an Iterable of all the vertices incident to v
	 * @param v
	 * @return the directed edges incident from vertex v as an Iterable
	 */
	public Iterable<WeightedDirectedEdge> adj(int v)
	{
		return adj[v];
	}

	/**
	 * Returns all directed edges in this edge-weighted digraph.
	 * To iterate over the edges in this edge-weighted digraph, use foreach notation:
	 * {@code for (DirectedEdge e : G.edges())}.
	 *
	 * @return all edges in this edge-weighted digraph, as an iterable
	 */
	public Iterable<WeightedDirectedEdge> edges()
	{
		ArrayList<WeightedDirectedEdge> list = new ArrayList<WeightedDirectedEdge>();
		for (int v = 0; v < V; v++) {
			for (WeightedDirectedEdge e : adj(v)) {
				list.add(e);
			}
		}
		return list;
	} 





}
