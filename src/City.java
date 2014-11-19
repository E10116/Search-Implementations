import java.util.ArrayList;
import java.util.List;

public class City
{
    private String name;
    private int numConnections = 0;
    private List<City> nextCity = new ArrayList<City>();
    private List<Integer> distance = new ArrayList<Integer>();
    private int SLD; // Straight line distance to Bucharest

    // Hacks to make searching meaningful and illustrative.
    public int depth;
    public City cameFrom;

    public City(String n, int s)
    {
        this.name = n;
        this.SLD = s;
    }

    public void addConnection(City conn, int dist)
    {
        numConnections++;
        nextCity.add(conn);
        distance.add(dist);
    }

    public int getSLD()
    {
        return this.SLD;
    }

    public int getConnections()
    {
        return numConnections;
    }

    public City getCity(int index)
    {
        return (City)nextCity.get(index);
    }

    public int getDist(int index)
    {
        return (Integer)distance.get(index);
    }

    public String getName()
    {
        return this.name;
    }
}
