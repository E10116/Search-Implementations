import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class HW5
{
    public static void main(String[] args)
    {
        map Romania = new map();

        System.out.println();

        loop(Romania);
    }

    public static void loop(map Romania)
    {
        int choice = 9;
        boolean quit = false;

        while(!quit)
        {
            printMenu();

            choice = getChoice();
            System.out.println();

            switch(choice)
            {
                case 1:
                        System.out.printf("Greedy Search\n");
                        System.out.printf("#############\n");
                        greedy(Romania);
                        break;
                case 2:
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

    public static void greedy(map Romania)
    {
        boolean done = false;
        city current = null;
        city lowestSLD = null;      /* most attractive heuristic city */
        int stepNum = 0;            /* counter for steps; used to break infinite loop */
        int numConnects = 0;
        int i = 0;

        current = Romania.Arad;

        while(!done)
        {
            System.out.printf("Step %d: Expanding %s\n", stepNum, current.getname());

            if(current.getname().equals("Bucharest"))
            {
                getPath(current);
                System.out.println();
                done = true;
            }
            else if(stepNum == 30)
            {
                System.out.printf("\nError: No solution found.\n\n");
                done = true;
            }
            else
            {
                numConnects = current.getconnections();

                for(i=0; i<numConnects; i++)
                {
                    System.out.printf("\t  SLD: %3d - %s\n", current.getcity(i).getSLD(), current.getcity(i).getname());

                    if((lowestSLD == null) || (current.getcity(i).getSLD() < lowestSLD.getSLD()))
                    {
                        lowestSLD = current.getcity(i);
                    }
                }

                lowestSLD.camefrom = current;
                current = lowestSLD;
                lowestSLD = null;
                System.out.printf("\t\tGoing to %s\n", current.getname());
                stepNum++;
            }
        }
    }

    public static void aStar(map Romania)
    {
        System.out.println("A* Search Here.");


    }

    public static void printMenu()
    {
        System.out.printf("Select the type of search:\n");
        System.out.printf("1. Greedy Search\n");
        System.out.printf("2. A* Search\n");
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

    public static void getPath(city current)
    /* prints pathway from Arad to Bucharest by working backwards from Bucharest*/
    {
        boolean done = false;
        String path = "Bucharest";
        current = current.camefrom;    /* starts at city before Bucharest  */

        while(!done)
        {
            if(current.getname().equals("Arad"))
            {
                System.out.printf("\nPath: Arad => %s\n", path);
                done = true;
            }
            else
            {
                path = current.getname() + " => " + path;
                current = current.camefrom;
            }
        }
    }
}
