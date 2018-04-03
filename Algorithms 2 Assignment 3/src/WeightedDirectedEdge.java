
public class WeightedDirectedEdge 
{
	private final int v;
	private final int w;
	private final Double weight;

	public WeightedDirectedEdge(int v, int w, Double weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int from()
	{
		return v;
	}

	public int to()
	{
		return w;
	}

	public Double weight() {
		return weight;
	}
	
}
