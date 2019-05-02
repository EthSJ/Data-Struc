package Project_6;
/*

Project 6
gives various methods to help run and the quicksort method itself.
it helps keep it all clean and tidy in the main
*/
import java.util.*;
import java.io.*;

public class quick_methods
{
    static Random random = new Random();
    static int randomNum;

    //resets sort back to unsorted so can be quicksorted again.
    public static void reset(int[] arr, int[] arr1)
    {
        //sets sort back
        for(int i=0;i<arr.length;i++)
            arr1[i] = arr[i];
    }

    //fills in array with random numbers
    public static void fill(int size, int[] array)
    {
        //go through each and give it a random number
        for(int i=0;i<size;i++)
        {
            randomNum = random.nextInt((1000 - 0) + 1) + 0;
            array[i] = randomNum;
        }
    }

    //prints out to the file what the array looks like
    public static void print(PrintWriter out, int[] array)
    {
        //print unsorted array
        out.print("Array = {");
        for(int i=0;i<array.length;i++)
        {
            out.print(array[i]);
            //formating
            if(i != array.length -1)
                out.print(", ");
        }
        out.println("}");
    }

    //quicksort
    public static void quicksort(int[] array, int left, int right, int choice)
    {
        //it's sorted
        if(left >= right)
            return;

        final int range = right - left + 1;
        int pivot;

        //pick the choice of sort
        //1 grabs left most one
        if(choice ==1)
            pivot=left;
        //two is a random number
        else if(choice==2)
        {
            randomNum = random.nextInt((right - left) + 1) + left;
            pivot= randomNum;
        }
        //three is a median of a random bunch of 3
        else if(choice ==3)
        {
            int median=0;
            for(int k=0;k<3;k++)
            {
                randomNum = random.nextInt((right - left) + 1) + left;
                median += randomNum;
            }
            pivot= (median/3);
        }
        //this is the book method of right in the middle
        else
            pivot= (left+(right-left)/2);

        //partition it up!
        int newPivot = partition(array, left, right, pivot);

        //does quicksort
        quicksort(array, left, newPivot - 1, choice);
        quicksort(array, newPivot + 1, right, choice);


    }

    //partitions it. also returns the new pivot point needed by quicksort
    private static int partition(int[] arr, int left, int right, int pivot)
    {

        //set the pivot value
        int pivotVal = arr[pivot];

        // temporarily move the pivot value out of the way.
        swapArrayVals(arr, pivot, right);

        //more partitioning
        int storeIndex = left;
        for(int i = left; i <= (right - 1); i++)
        {
            if(arr[i] < pivotVal) {
                swapArrayVals(arr, i, storeIndex);
                storeIndex++;
            }
        }
        //partition the last bit
        swapArrayVals(arr, storeIndex, right);

        //return what will be the new pivot point
        return storeIndex;
    }

    //swap around things
    private static void swapArrayVals(int[] arr, int low, int high)
    {
        int from = arr[low];
        int to = arr[high];
        arr[low] = to;
        arr[high] = from;
    }
}
