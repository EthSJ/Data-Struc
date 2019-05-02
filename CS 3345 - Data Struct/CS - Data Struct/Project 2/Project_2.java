package Project_2;
/*

Project 2
This is the part that drives everything and tests it all out.
Creates a linked list and has the user create, delete, find, or other such things to magazines
*/
import java.util.*;

public class Project_2
{
    public static void main(String[] args)
    {
        //variables. N is input (should be int), valid check.
        //count is used in output to help format.
        String N="";
        boolean valid= false, quit = false;
        LinkedList<Magazine> linky = new LinkedList();

        //scanner and initial prompt to get input
        Scanner scanny = new Scanner(System.in);
        //I will have valid input or so help me!
        do
        {
            System.out.println("Select one of the following options. ");
            System.out.println("1. Make Empty - Empty any list used.");
            System.out.println("2. Find ID - Finds and displays a magazine");
            System.out.println("3. Insert at Front - *Caution only works with truly new magazines*");
            System.out.println("4. Delete From Front - Shows and deletes the first item.");
            System.out.println("5. Delete ID - Shows and deletes an ID.");
            System.out.println("6. Print All - Does what it says.");
            System.out.println("7. Quit");
            System.out.print("Enter your option: ");
            //Housekeeping!
            valid = false;
            N = "";

            //Time for input and the whole thing now!
            N = scanny.nextLine();
            switch(N)
            {
                //make the list empty
                case "1": linky.makeEmpty();
                    break;
                //Find and display an ID
                case "2":
                {
                    //prompt for id, get int, and then clean anything left
                    System.out.print("Finding ID: ");
                    int k =0;
                    while(!valid)
                    {
                        try
                        {   //try out getting input and seeing if it's an int
                            k = Integer.parseInt(scanny.nextLine());
                            //It's an int.
                            if(k>0 || k==0 || k<0)
                              valid=true;
                            //It's not an int.
                            else
                                System.out.print("Err; need an integer. Try again: ");
                        }
                        //you tried, but it's not an int.
                        catch(NumberFormatException ex)
                        {System.out.print("Err; need an integer. Try again: ");}
                    }
                    System.out.println();
                    //generic the object we're given. VERY IMPORTANT
                    Object found = linky.findID(k);
                    //Can't find!
                    if(found == null)
                        System.out.println("ID not found.");
                    else
                    {
                        //convert the mystery object into a node that can be read.
                        LinkedList.Node output= (LinkedList.Node)found;
                        output.printID();
                    }
                }
                    break;
                //Insert at the front of the list
                case "3":
                {
                    //gets ID
                    System.out.print("Give an ID: ");
                    int n =0;
                    while(!valid)
                    {
                        try
                        {   //try out getting input and seeing if it's an int
                            n = Integer.parseInt(scanny.nextLine());
                            //It's an int.
                            if(n>0 || n==0 || n<0)
                              valid=true;
                            //It's not an int.
                            else
                                System.out.print("Err; need an integer. Try again: ");
                        }
                        //you tried, but it's not an int.
                        catch(NumberFormatException ex)
                        {System.out.print("Err; need an integer. Try again: ");}
                    }
                    //gets magazine name
                    System.out.print("Give a magazine name: ");
                    String name = scanny.nextLine();
                    //gets publisher name
                    System.out.print("Give a publisher name: ");
                    String publisher = scanny.nextLine();
                    //make us a new magazine node in the list
                    LinkedList.Node<Magazine> insert = new LinkedList.Node(new Magazine(n, name, publisher),null);

                    //We were able to add or weren't
                    if(linky.insertAtFront(insert) == true)
                    {System.out.println("Magazine added!");}
                    else
                        System.out.println("Already exists!");

                }
                    break;
                //deletes from the front of the list
                case "4":
                {
                    //mystery object
                    Object deleted = linky.deleteFromFront();
                    if(deleted != null)
                    {
                        //Creates a node out of our deleted mystery object so it can be identified
                        LinkedList.Node rDeleted = (LinkedList.Node)deleted;
                        rDeleted.printID();
                        System.out.println("Deleted!");
                    }
                    else
                        System.out.println("Cannot delete from front");
                }
                    break;
                //delete a specific ID after displaying it
                case "5":
                {
                    System.out.print("Give an ID: ");
                    int n =0;
                    while(!valid)
                    {
                        try
                        {   //try out getting input and seeing if it's an int
                            n = Integer.parseInt(scanny.nextLine());
                            //It's an int.
                            if(n>0 || n==0 || n<0)
                              valid=true;
                            //It's not an int.
                            else
                                System.out.print("Err; need an integer. Try again: ");
                        }
                        //you tried, but it's not an int.
                        catch(NumberFormatException ex)
                        {System.out.print("Err; need an integer. Try again: ");}
                    }
                    //creates us a typeless mystery object
                    Object found = linky.findID(n);
                    //Can't find!
                    if(found == null)
                        System.out.println("ID not found.");
                    else
                    {
                        //convert the mystery object into a node that can be read.
                        LinkedList.Node output= (LinkedList.Node)found;
                        System.out.println();
                        //prints out what we found, then deletes it
                        output.printID();
                        linky.delete(n);
                        System.out.println("Deleted!");
                    }


                }
                    break;
                //print all
                case "6": linky.printAllRecords();
                    break;
                //quitter
                case "7": quit = true;
                    break;
                default: System.out.println("Not an option");
                    break;
            }

            System.out.println();
        }while (quit != true);
    }
}

