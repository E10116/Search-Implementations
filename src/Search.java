import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.InputMismatchException;

public class Search
{
    public static void main(String[] args)
    {
        Map Romania = new Map();

        System.out.println();

        loop(Romania);
    }

    public static void loop(Map Romania)
    {
        int choice = 9;
        boolean quit = false;
        boolean found = false;

        while(!quit)
        {
            printMenu();

            choice = getChoice();
            System.out.println();

            switch(choice)
            {
                case 1:
                         System.out.printf("Breadth-First Search\n");
                         System.out.printf("####################\n");
                         breadth(Romania);
                         break;
                case 2:
                         System.out.printf("Depth-First Search\n");
                         System.out.printf("####################\n");
                         depth(Romania);
                         break;
                case 3:
                         System.out.printf("Depth-Limited Search\n");
                         System.out.printf("####################\n");

                         System.out.printf("\nSelect limit for the search: ");
                         choice = getChoice();
                         System.out.println();

                         found = limitedDepth(Romania, choice);

                         if(!found)
                         {
                             System.out.printf("\nNo solution found.\n\n");
                         }

                         break;
                case 4:
                         System.out.printf("Iterative-Deepening Depth-First Search\n");
                         System.out.printf("######################################\n");
                         iterativeDeepening(Romania);
                         break;
                case 5:
                        System.out.printf("Greedy Search\n");
                        System.out.printf("#############\n");
                        greedy(Romania);
                        break;
                case 6:
                        System.out.printf("A* Search\n");
                        System.out.printf("#########\n");
                        aStar(Romania);
                        break;
                case 0:
                        quit = true;
                        break;
                default:
                        System.out.printf("Error: Not a valid option.  Please choose again.\n\n");
                        break;
            }
        }
    }

    public static void breadth(Map Romania)
    /* performs breadth-first search */
    {
        Queue<City> frontier = new LinkedList<City>();
        ArrayList<City> explored = new ArrayList<City>();
        boolean done = false;
        int stepNum = 0;
        int i = 0;
        int numConnects = 0;
        City current;

        current = Romania.Arad;

        while(!done)
        {
            System.out.printf("Step %d: Expanding %s\n", stepNum, current.getName());
            explored.add(current);

            if(current.getName().equals("Bucharest"))
            {
                getPath(current);
                System.out.println();
                done = true;
            }
            else
            {
                numConnects = current.getConnections();

                for(i=0; i<numConnects; i++)
                {
                    /* checks to see if child node exists in explored list or frontier queue */
                    if(!explored.contains(current.getCity(i)) && !frontier.contains(current.getCity(i)))
                    {
                        current.getCity(i).cameFrom = current;
                        frontier.add(current.getCity(i));
                        System.out.printf("\t   Pushing %s\n", current.getCity(i).getName());
                    }
                }

                stepNum++;
                current = frontier.remove();
            }
        }
    }

    public static void depth(Map Romania)
    /* performs depth-first search */
    {
        Stack<City> frontier = new Stack<City>();
        ArrayList<City> explored = new ArrayList<City>();
        boolean done = false;
        int stepNum = 0;
        int i = 0;
        int numConnects = 0;
        City current;

        current = Romania.Arad;

        while(!done)
        {
            System.out.printf("Step %d: Expanding %s\n", stepNum, current.getName());

            if(current.getName().equals("Bucharest"))
            {
                getPath(current);
                System.out.println();
                done = true;
            }
            else
            {
                numConnects = current.getConnections();

                for(i=0; i<numConnects; i++)
                {
                    /* checks to see if child node exists in explored list or frontier stack*/
                    if(!explored.contains(current.getCity(i)) && !frontier.contains(current.getCity(i)))
                    {
                        current.getCity(i).cameFrom = current;
                        frontier.push(current.getCity(i));
                        System.out.printf("\t   Pushing %s\n", current.getCity(i).getName());
                    }
                }

                stepNum++;
                explored.add(current);
                current = frontier.pop();
            }
        }
    }

    public static boolean limitedDepth(Map Romania, int limit)
    /* performs depth-limited search using limit chosen by user, or from passed limit from IDDSearch */
    {
        Stack<City> frontier = new Stack<City>();
        ArrayList<City> explored = new ArrayList<City>();
        boolean done = false;
        boolean found = false;
        int stepNum = 0;
        int i = 0;
        int counter = 0;         /* keeps track of current level */
        int depthLimit = limit;  /* provides maximum level to search */
        int numConnects = 0;
        City current;

        current = Romania.Arad;
        current.depth = 0;

        while(!done)
        {
            System.out.printf("Step %d: Expanding %s\n", stepNum, current.getName());

            if(current.getName().equals("Bucharest"))
            {
                getPath(current);
                System.out.println();
                found = true;
                done = true;
            }
            else
            {
                numConnects = current.getConnections();

                for(i=0; i<numConnects; i++)
                {
                    /* checks to see if child node exists in explored list or frontier stack and makes sure the max level is not exceeded */
                    if(!explored.contains(current.getCity(i)) && !frontier.contains(current.getCity(i)) && (current.depth < depthLimit))
                    {
                        current.getCity(i).cameFrom = current;
                        current.getCity(i).depth = current.depth + 1;   /* increments level for each successive node */
                        frontier.push(current.getCity(i));
                        System.out.printf("\t   Pushing %s\n", current.getCity(i).getName());
                    }
                }

                counter++;
                stepNum++;
                explored.add(current);

                if(frontier.empty())
                {
                    done = true;
                }
                else
                {
                    current = frontier.pop();
                }
            }
        }

        return found;
    }

    public static void iterativeDeepening(Map Romania)
    /* makes repeated calls to depthLimited using increasing limits until solution is found */
    {
        int limit = 0;
        boolean done = false;

        while(!done)
        {
            limit++;
            System.out.printf("\n****Limit of %d****\n", limit);

            done = limitedDepth(Romania, limit);
        }
    }

    public static void greedy(Map Romania)
    /* performs greedy search */
    {
        boolean done = false;
        City current = null;
        City lowestSLD = null;      /* most attractive heuristic City */
        int stepNum = 0;
        int numConnects = 0;
        int i = 0;

        current = Romania.Arad;

        while(!done)
        {
            System.out.printf("Step %d: Expanding %s\n", stepNum, current.getName());

            if(current.getName().equals("Bucharest"))
            {
                getPath(current);
                System.out.println();
                done = true;
            }
            else if(stepNum == 30)   /* breaks infinite loop.  can't happen in this Map, but better safe than sorry */
            {
                System.out.printf("\nError: No solution found.\n\n");
                done = true;
            }
            else
            {
                numConnects = current.getConnections();

                for(i=0; i<numConnects; i++)
                {                              /* h(n) check between current child node and lowest child node*/
                    if((lowestSLD == null) || (current.getCity(i).getSLD() < lowestSLD.getSLD()))
                    {
                        lowestSLD = current.getCity(i);
                    }
                }

                lowestSLD.cameFrom = current;
                current = lowestSLD;
                lowestSLD = null;
                System.out.printf("\t  Going to %s\n", current.getName());
                stepNum++;
            }
        }
    }

    public static void aStar(Map Romania)
    /* performs A* search */
    {
        ArrayList<City> frontier = new ArrayList<City>();
        ArrayList<City> explored = new ArrayList<City>();
        boolean done = false;
        int stepNum = 0;
        int i = 0;
        int numConnects = 0;
        City current = null;
        City next = null;

        current = Romania.Arad;
        current.depth = 0;      /* used for calculating total path cost of each City */

        while(!done)
        {
            System.out.printf("Step %d: Expanding %s\n", stepNum, current.getName());

            if(current.getName().equals("Bucharest"))
            {
                getPath(current);
                System.out.printf("Total path cost: %d\n", current.depth);
                System.out.println();
                done = true;
            }
            else
            {
                numConnects = current.getConnections();

                for(i=0; i<numConnects; i++)
                {
                    if(!explored.contains(current.getCity(i)))
                    /*    If in explored, node can't be reached faster, so no need to visit again.
                     *    No check on frontier because a node can be on the frontier in multiple places. */
                    {
                        current.getCity(i).depth = current.depth + current.getDist(i); /* total path cost of parent + cost to reach child */
                        current.getCity(i).cameFrom = current;
                        frontier.add(current.getCity(i));
                    }
                }

                explored.add(current);
                current = getNextCity(frontier);
                stepNum++;
            }
        }
    }

    public static City getNextCity(ArrayList<City> frontier)
    {
        City next = null;
        City lowest = null;
        int lowestIndex = 0;

        for(int i=0; i<frontier.size(); i++)
        {                                     /* if f(n) of current child is less than f(n) of lowest found thus far */
            if((lowest == null) || ((frontier.get(i).depth+frontier.get(i).getSLD()) < (lowest.depth+lowest.getSLD())))
            {
                lowest = frontier.get(i);
                lowestIndex = i;
            }
        }

        next = lowest;
        frontier.remove(lowestIndex);

        return next;     
    }

    public static void printMenu()
    {
        System.out.printf("Select the type of search:\n");
        System.out.printf("1. Breadth-first search\n");
        System.out.printf("2. Depth-first search\n");
        System.out.printf("3. Depth-limited search\n");
        System.out.printf("4. Iterative-deepening depth-first\n");
        System.out.printf("5. Greedy Search\n");
        System.out.printf("6. A* Search\n");
        System.out.printf("0. Quit\n");
        System.out.printf("Make your selection:  ");
    }

    public static int getChoice()
    /* gets user input for choice in form of integer; returns 9 if input mismatch */
    {
        Scanner myscanner = new Scanner(System.in);
        int choice = 9;

        try
        {
            choice = myscanner.nextInt();
        }
        catch(InputMismatchException ex)
        {
            choice = 9;
        }

        return choice;
    }

    public static void getPath(City current)
    /* prints pathway from Arad to Bucharest by working backwards from Bucharest*/
    {
        boolean done = false;
        String path = "Bucharest";
        current = current.cameFrom;    /* starts at City before Bucharest  */

        while(!done)
        {
            if(current.getName().equals("Arad"))
            {
                System.out.printf("\nPath: Arad => %s\n", path);
                done = true;
            }
            else
            {
                path = current.getName() + " => " + path;
                current = current.cameFrom;
            }
        }
    }
}
