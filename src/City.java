import java.util.ArrayList;


public class City
{
	private String name;
	private int numConnections = 0;
	private ArrayList nextCity = new ArrayList();
	private ArrayList distance = new ArrayList();
	// Straight line distance to Bucharest
	private int SLD;


	// Hacks to make searching meaningful and illustrative. See source.
	public int depth;
	public City cameFrom;


	public City (String n, int s)
	{
		this.name = n;
		this.SLD = s;
	}

	@SuppressWarnings ("unchecked") 
	public void addConnection (City conn, int dist)
	{
		numConnections++;
		nextCity.add (conn);
		distance.add (dist);
	}

	public int getSLD()
	{
		return this.SLD;
	}

	public int getConnections()
	{
		return numConnections;
	}

	public City getCity (int index)
	{
		return (City)nextCity.get(index);
	}

	public int getDist (int index)
	{
		return (Integer)distance.get(index);
	}

	public String getName()
	{
		return this.name;
	}
}
