import java.util.Stack;

public class FloydWarshall{
	private boolean hasNegativeCycle;
	private double[][] distTo;
	private WeightedDirectedEdge[][] edgeTo;

	public FloydWarshall(EWDAdjMatrix G){
		int V = G.V();
		if(V>0)
		{
			distTo = new double[V][V];
			edgeTo = new WeightedDirectedEdge[V][V];
			for(int v = 0; v < V; v++){
				for(int w = 0; w < V; w++){
					distTo[v][w] = Double.POSITIVE_INFINITY;
				}
			}

			for(int v = 0; v < G.V(); v++){
				for(WeightedDirectedEdge e: G.edgeFromTo(v)){
					distTo[e.from()][e.to()] = e.weight();
					edgeTo[e.from()][e.to()] = e;
				}

				if(distTo[v][v] >= 0.0){
					distTo[v][v] = 0.0;
					edgeTo[v][v] = null;
				}
			}

			for(int i = 0; i < V; i++){
				for(int v = 0; v < V; v++){
					if(edgeTo[v][i] == null) continue;
					for(int w = 0; w < V; w++){
						if(distTo[v][w] > distTo[v][i] + distTo[i][w]){
							distTo[v][w] = distTo[v][i] + distTo[i][w];
							edgeTo[v][w] = edgeTo[i][w];
						}
						if(distTo[v][w] < 0.0){
							this.hasNegativeCycle = true;
							return;
						}
					}
				}
			}
		}
	}

	public boolean hasNegativeCycle(){
		return hasNegativeCycle;
	}


	public boolean hasPath(int f, int t){
		return distTo[f][t] < Double.POSITIVE_INFINITY;
	}

	public double dist(int f, int t){
		return distTo[f][t];
	}


}