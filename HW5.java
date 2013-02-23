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
                        break;
                case 2:
                        System.out.printf("A* Search\n");
                        System.out.printf("#########\n");
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
}
