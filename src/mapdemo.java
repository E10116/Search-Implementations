/*
 * A demonstration of the map functions created by map and city.java
 *
 * 2/3/2013, S. Harrison
 */

import java.util.*;

public class mapdemo
{

	public static void main (String args[])
	{
		int i, numcities;

		/*
		 * To create the map, simply give it a name and call the
		 * no-argument constructor.
		 *
		 * Note that the map has extra features we're not using yet,
		 * so the souce and this demo won't match up completely.
		 */
		map Romania = new map();

		/*
		 * "city" is the object representing the nodes within the 
		 * map.
		 */
		city mycity;

		/*
		 * Now, let's see the number of connections from Arad.
		 * getconnections will tell you. 
		 */
		numcities = Romania.Arad.getconnections();
		System.out.printf ("Arad Connections: %d\n",
			Romania.Arad.getconnections());

		for (i=0; i<numcities; i++)
		{
			/*
			 * Distances are indexed. Thus, if there are three
			 * cities connected to Arad, and you want to look
			 * at the distances, you refer to
			 * Romania.Arad.getdist (0-2);
			 */
			System.out.printf ("Dist: %d\n",
				Romania.Arad.getdist(i));
		}
		/*
		 * It's worth pointing out that you can't get the names
		 * of the cities until you expand the node (truly
		 * a blind search). If I want to look at a successor to
		 * a city, I call getcity(index), which, for Arad, will be
		 * Romania.Arad.getcity(0-2). This returns a city.
		 *
		 * In this case, city(1) is Zerind. 
		 */
		mycity = Romania.Arad.getcity(1);

		/*
		 * ...which we can now prove...
		 */
		System.out.printf ("City 1 was %s\n", mycity.getname());
		/*
		 * This shows how the indexing works.
		 */
		System.out.printf ("Distance Arad->%s: %d\n",
					Romania.Arad.getcity(1).getname(),
					Romania.Arad.getdist(1) );
		 
		 /*
		  * This is a method which will perform a (really stupid)
		  * search.
		  */
		 System.out.printf ("Beginning random search...\n\n");
		 searchmap (Romania);

	}

	/*
	 * A dumb search. We will move to 6 random cities from Arad.
	 * If one is Bucharest, we win. Otherwise, we'll try again.
	 */

	public static void searchmap (map Romania)
	{
		/*
		 * Do we quit, or keep going?
		 */
		boolean done = false;

		/*
		 * This will keep track of our current city.
		 */
		city	current;

		/*
		 * The maximum number of steps, and the current count.
		 */
		int	numsteps = 10;
		int	cursteps;

		/* 
		 * Our "choice" of node to expand
		 */
		int choice;

		/*
		 * For random numbers
		 */
		Random ran = new Random();

		/*
		 * The number of connections from the current city.
		 */
		int	numconnections;

		/*
		 * And, for fun, how long the trip took.
		 */
		int	totaldist;


		while (!done)
		{
			/*
			 * Currently, we're in Arad, and no miles
			 * travelled. Or is it kilometers? I never
			 * thought about that before.
			 */
			cursteps = 0;
			current = Romania.Arad;
			totaldist = 0; 

			while ((cursteps != numsteps) && (!done))
			{
				System.out.printf ("Step %d, In %s, Distance\t%d\n", 
					cursteps, current.getname(), totaldist);
				/*
				 * Goal test
				 */
				if (current.getname() == "Bucharest")
					done = true;
				else
				{
					cursteps++;
					numconnections = current.getconnections();
					choice = ran.nextInt(numconnections);
					totaldist += current.getdist(choice);
					current = current.getcity(choice);
				}
			}
			System.out.printf ("-----------------------\n");
		}
	}
					
				


}
