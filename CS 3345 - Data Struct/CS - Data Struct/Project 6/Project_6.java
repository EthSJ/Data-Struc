package Project_6;
/*

Project 6
Tests out the quicksorts and gives the times of each running.
*/
import java.util.*;
import java.io.*;

public class Project_6
{
    public static void main(String[] args) throws IOException
    {
        //variables
        int randomSize = -1;
        int[] array, sort;
        String input;
        long start, stop;
        PrintWriter unsortOut = new PrintWriter(new File("unsorted.txt"));
        PrintWriter sortOut = new PrintWriter(new File("sorted.txt"));
        Scanner scanny = new Scanner(System.in);


        //prompt for input
        System.out.print("Give the size of the array (greater than 0): ");

        //keep going with trying input until we break
        while(true)
        {
            try
            {
                input = scanny.nextLine();
                randomSize = Integer.parseInt(input);
            }
            //just catch
            catch(NumberFormatException ex)
            {}
            //if it's a good number, break
            //else try again.
            if(randomSize > 0)
                break;
            else
                System.out.print("Try again: ");
        }
        //sets array and sorted
        array = new int[randomSize];
        sort = new int[randomSize];

        //randomly fills the array from 0 to 1000
        quick_methods.fill(randomSize, array);
        //sets the array sort to mirror array
        quick_methods.reset(array, sort);
        //prints unsorted
        quick_methods.print(unsortOut, array);


        //This group is for 1st element as pivot
        //start time of
        start = System.nanoTime();
        //quicksorts
        quick_methods.quicksort(sort,0,sort.length-1,1);
        //stop time of
        stop = System.nanoTime();
        //print out the sorted.
        quick_methods.print(sortOut, sort);
        //print out start/stop time. Converts from nano to mili
        System.out.println("It took " + ((stop-start)/Math.pow(1000, 1))+" time to run in miliseconds for pivot as first element.");
        quick_methods.reset(array, sort);


        //this group is for random pivot
        //start time of
        start = System.nanoTime();
        //quicksorts
        quick_methods.quicksort(sort,0,sort.length-1,2);
        //stop time of
        stop = System.nanoTime();
        //print out the sorted.
        quick_methods.print(sortOut, sort);
        //print out start/stop time. Converts from nano to mili
        System.out.println("It took " + ((stop-start)/Math.pow(1000, 1))+" time to run in miliseconds for pivot as random element.");
        quick_methods.reset(array, sort);


        //this group is for median of random 3 pivot
        //start time of
        start = System.nanoTime();
        //quicksorts
        quick_methods.quicksort(sort,0,sort.length-1,3);
        //stop time of
        stop = System.nanoTime();
        //print out the sorted.
        quick_methods.print(sortOut, sort);
        //print out start/stop time. Converts from nano to mili
        System.out.println("It took " + ((stop-start)/Math.pow(1000, 1))+" time to run in miliseconds for pivot as median of 3 random elements.");
        quick_methods.reset(array, sort);

        //this group is a pivot of the book method
        //start time of
        start = System.nanoTime();
        //quicksorts
        quick_methods.quicksort(sort,0,sort.length-1,0);
        //stop time of
        stop = System.nanoTime();
        //print out the sorted.
        quick_methods.print(sortOut, sort);
        //print out start/stop time. Converts from nano to mili
        System.out.println("It took " + ((stop-start)/Math.pow(1000, 1))+" time to run in miliseconds for pivot as the middle.");
        quick_methods.reset(array, sort);

        //close up shop
        unsortOut.close();
        sortOut.close();
    }
}
