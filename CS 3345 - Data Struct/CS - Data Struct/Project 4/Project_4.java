package Project_4;
/*

Project 4
This is the part that drives everything and tests it all out.
Creates a red-black tree and has the user create, find, or other.
*/
import java.util.*;


class Project_4
{
    public static void main(String[] args)
    {
        //variables
        Boolean valid = true;
        String input;
        Scanner scanny = new Scanner(System.in);

        //set up tree
        RedBlackTree leafy = new RedBlackTree();

        //Command list
        System.out.println("Red Black Trees");
        System.out.println("   1.\tInsert");
        System.out.println("   2.\tContains");
        System.out.println("   3.\tPrint");
        System.out.println("   4.\tQuit");

        //loop through commands until user is finished
        while(valid)
        {
            System.out.print("Your Option: ");
            input = scanny.nextLine();

            //match commands
            switch(input)
            {
                case "1":
                {
                    boolean good = false;
                    System.out.print("Enter Element: ");

                    //work until you have a usable number
                    int k =0;
                    while(!good)
                    {
                        try
                        {   //try out getting input and seeing if it's an int
                            k = Integer.parseInt(scanny.nextLine());
                            //It's an int.
                            if(k>0)
                              good=true;
                            //It's not an int.
                            else
                                System.out.print("Err; need an integer. Try again: ");
                        }
                        //you tried, but it's not an int.
                        catch(NumberFormatException ex)
                        {System.out.print("Err; need an integer. Try again: ");}
                    }
                    //insert number
                    leafy.insert(k);
                }
                    break;
                case "2":
                {
                    System.out.print("Contains Which: ");
                    boolean good = false;
                    //go until you have a usable value
                    int k =0;
                    while(!good)
                    {
                        try
                        {   //try out getting input and seeing if it's an int
                            k = Integer.parseInt(scanny.nextLine());
                            //It's an int.
                            if(k>0)
                              good=true;
                            //It's not an int.
                            else
                                System.out.print("Err; need an integer. Try again: ");
                        }
                        //you tried, but it's not an int.
                        catch(NumberFormatException ex)
                        {System.out.print("Err; need an integer. Try again: ");}
                    }
                    //Depending on if it is in there, display the proper message
                    if(leafy.contains(k, leafy.getParent())==true)
                        System.out.println("I found it!\n");
                    else
                        System.out.println("I can't find!\n");
                }
                    break;
                case "3":
                {//let go print this tree out!
                    leafy.printTree(leafy.getParent());
                    System.out.println();
                    break;
                }
                case "4":
                    //quit button
                    valid = false;
                    break;
                default:
                    //so you entered a thing, and I dunno what it is
                    System.out.println("Code Not Recognized");
            }
        }
    }
}
