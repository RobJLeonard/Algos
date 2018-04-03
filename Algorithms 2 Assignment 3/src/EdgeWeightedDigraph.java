import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EdgeWeightedDigraph 
{
	private int V;                // number of vertices in this digraph
	private int E;                      // number of edges in this digraph
	private ArrayList<WeightedDirectedEdge>[] adj;    // adj[v] = adjacency list for vertex v
	private int[] indegree;             // indegree[v] = indegree of vertex v
	public boolean isValidGraph = false;


	public EdgeWeightedDigraph(String fileName) throws Exception
	{

		try
		{
			File file = new File(fileName);

			Scanner input = new Scanner(file);
			this.V = input.nextInt();

			// Init adjacency and indgree arrays to graph size
			if(V>0)
			{
				this.adj = new ArrayList[V];
				this.indegree = new int[V];

				for(int i = 0; i < V; i++)
					adj[i] = new ArrayList<WeightedDirectedEdge>();
				int E = input.nextInt();
				if(E < 0)
					System.out.println("Edges cannot be negative"); 
				for (int i = 0; i < E; i++) {
					int v = input.nextInt();
					int w = input.nextInt();
					if(!validate(v) || !validate(w))
						break; 
					double weight = input.nextDouble();
					addEdge(new WeightedDirectedEdge(v, w, weight));
					isValidGraph = true;
				} 
			}
			input.close();
		}
		catch (FileNotFoundException e){
			System.out.println("FileNotFoundException");
		}
	}




	/**
	 * Returns the number of vertices in this edge-weighted digraph.
	 *
	 * @return the number of vertices in this edge-weighted digraph
	 */
	public int V(){return V;}


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
	 * @throws Exception 
	 */
	public void addEdge(WeightedDirectedEdge e) throws Exception {
		int v = e.from();
		int w = e.to();
		validate(v);
		validate(w);
		adj[v].add(e);
		indegree[w]++;
		E++;
	}

	/**
	 * Returns an Iterable of all the vertices incident to v
	 * @param v
	 * @return the directed edges incident from vertex v as an Iterable
	 * @throws Exception 
	 */
	public Iterable<WeightedDirectedEdge> adj(int v) throws Exception 
	{
		validate(v);
		return adj[v];
	}

	/**
	 * Returns all directed edges in this edge-weighted digraph.
	 * To iterate over the edges in this edge-weighted digraph, use foreach notation:
	 * {@code for (DirectedEdge e : G.edges())}.
	 *
	 * @return all edges in this edge-weighted digraph, as an iterable
	 * @throws Exception 
	 */
	public Iterable<WeightedDirectedEdge> edges() throws Exception {
		ArrayList<WeightedDirectedEdge> list = new ArrayList<WeightedDirectedEdge>();
		for (int v = 0; v < V; v++) {
			for (WeightedDirectedEdge e : adj(v)) {
				list.add(e);
			}
		}
		return list;
	} 





}
