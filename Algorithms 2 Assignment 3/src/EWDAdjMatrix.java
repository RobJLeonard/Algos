import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EWDAdjMatrix {
	//verticies
	private int V = 0;
	//edges
	private int E = 0;
	//adjacency table
	private WeightedDirectedEdge[][] edgeFromTo;
	private boolean isValid;

	public EWDAdjMatrix(Scanner scanner)
	{

		this.V = scanner.nextInt();
		this.E = scanner.nextInt();
		this.isValid = true;

		if(V>0)
		{

			int edges = this.E;
			this.edgeFromTo = new WeightedDirectedEdge[this.V][this.V];

			for(int i=0; i < edges; i++){
				int v = scanner.nextInt();
				int w = scanner.nextInt();
				double weight = scanner.nextDouble();

				if(v >= 0 && w >=0){
					if(v == w)
						addEdge(new WeightedDirectedEdge(v, w, Math.abs(weight)));
					else
						addEdge(new WeightedDirectedEdge(v, w, weight));
				}
				else
					this.isValid = false;
			}
		}


	}

	public boolean isValid(){
		return this.isValid;
	}

	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}


	public void addEdge(WeightedDirectedEdge e){
		int v = e.from();
		int w = e.to();
		if(edgeFromTo[v][w] == null){
			E++;
			edgeFromTo[v][w] = e;
		}
	}

	//returns edges incident to vertex
	public Iterable<WeightedDirectedEdge> edgeFromTo(int v){
		return new AdjIterator(v);
	}

	private class AdjIterator implements Iterator<WeightedDirectedEdge>, Iterable<WeightedDirectedEdge> {
		private int v;
		private int w = 0;

		public AdjIterator(int v){
			this.v = v;
		}

		public Iterator<WeightedDirectedEdge> iterator(){
			return this;
		}

		public boolean hasNext(){
			while(w < V) {
				if(edgeFromTo[v][w] != null) return true;
				w++;
			}
			return false;
		}

		public void remove(){
			System.out.println("UnsupportedOperationException");
		}

		public WeightedDirectedEdge next(){
			if(!hasNext())
				System.out.println("No such element");
			return edgeFromTo[v][w++];
		}
	}
}