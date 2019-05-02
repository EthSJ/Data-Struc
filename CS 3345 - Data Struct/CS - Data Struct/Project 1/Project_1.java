/*

Project 1
This project uses the Sieve of Eratosthenes method to compute all primes less then N.
That is takes sqrt of input to stop at, finds prime, prints that number, crosses out all multiples
Then it will print out all primes up to the non-sqrt input.
*/
import java.util.*;

public class Project_1
{
    public static void main(String[] args)
    {
        //variables. N is input (should be int), valid check.
        //count is used in output to help format.
        int N=0, count=0;
        boolean valid= false;

        //scanner and initial prompt to get input
        Scanner scanny = new Scanner(System.in);
        System.out.print("Give me an integer to find all the prime numbers up to: ");


        //I will have valid input or so help me!
        while(!valid)
        {
            try
            {   //try out getting input and seeing if it's an int
                N = Integer.parseInt(scanny.nextLine());
                //if it's greater than 1, it's valid. 1 is a special case.
                if(N>1)
                  valid=true;
                //less than 1. Try again.
                else
                    System.out.print("Err; need an integer greater than 1.\n Please try again: ");
            }
            //you tried, but it's not an int.
            catch(NumberFormatException ex)
            {System.out.print("Err; need an integer greater than 1.\n Please try again: ");}
        }

        //gets a nice sqrt ready for calculation in the loop + prime number array
        //is faster than calcing sqrt each time.
        //Also sets up boolean array for crossing out primes (index = prime number)
        int n = (int) Math.ceil(Math.sqrt(N));
        boolean[] prime = new boolean[N + 1];

        //Gets ready to start printing the primes (which will be i, for a while)
        System.out.println("\nYour primes are as follows: ");
        //goes from i(2) to sqrt(N)
        for (int i = 2; i <= n; i++)
        {
            //if it's not prime number
            if (!prime[i])
            {
                  //print out the i and gives a lil help with format loop at end.
                  System.out.print(i + " ");
                  count++;
                  //loop through all multiples and cross out.
                  for (int k = i * i; k <= N; k += i)
                        prime[k] = true;
            }
        }

        //remaining trues MUST be primes. Time to just print it out.
        //Starts from ceiling(sqrt(N)) + 1. Ex: sqrt25 = 5. Above ends there, need to be 6
        //go through and print from sqrt to rest of numbers not marked out
        for (int i = n+1; i <= N; i++)
            if (!prime[i])
                //following adds readability
                //if count hits 10 (technically 9) adds a break and resets
                if(count == 9)
                {
                    count=0;
                    System.out.println(i+ " ");
                }
                //else print as a line and increase count.
                else
                {
                    System.out.print(i + " ");
                    count++;
                }
        //again, readability formatting.
        System.out.println();
    }
}
