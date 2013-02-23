import java.util.ArrayList;


public class city
{
	private String name;
	private int numconnections = 0;
	private ArrayList nextcity = new ArrayList();
	private ArrayList distance = new ArrayList();
	// Straight line distance to Bucharest
	private int SLD;


	// Hacks to make searching meaningful and illustrative. See source.
	public int depth;
	public city camefrom;


	public city (String n, int s)
	{
		this.name = n;
		this.SLD = s;
	}

	@SuppressWarnings ("unchecked") 
	public void addconnection (city conn, int dist)
	{
		numconnections++;
		nextcity.add (conn);
		distance.add (dist);
	}

	public int getSLD()
	{
		return this.SLD;
	}

	public int getconnections()
	{
		return numconnections;
	}
	public city getcity (int index)
	{
		return (city)nextcity.get(index);
	}
	public int getdist (int index)
	{
		return (int)distance.get(index);
	}
	public String getname()
	{
		return this.name;
	}

}

