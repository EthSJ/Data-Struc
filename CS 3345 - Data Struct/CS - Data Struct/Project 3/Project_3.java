package Project_3;
/*

Project 3
This is the part that drives everything and tests it all out.
Creates a binary tree and has the user create, delete, find, or other.
*/
import java.util.*;


class Project_3
{
    public static void main(String[] args)
    {
        //variables
        Boolean valid = false;
        String input;
        Scanner scanny = new Scanner(System.in);

        //set up tree + redundancy
        BinaryTree leafy = new BinaryTree();
        leafy.setRoot(null);

            //Command list
        System.out.println("Binary Search Trees");
        System.out.println("   1.\tInsert");
        System.out.println("   2.\tDelete");
        System.out.println("   3.\tFind Max");
        System.out.println("   4.\tFind Min");
        System.out.println("   5.\tContains");
        System.out.println("   6.\tIn Order Tree Traversal");
        System.out.println("   7.\tHeight");
        System.out.println("   8.\tNo Of Nodes");
        System.out.println("   9.\tQuit");

        //loop through commands until user is finished
        while(!valid)
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
                            if(k>0 || k<100)
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
                    leafy.insertNode(k, false);
                    System.out.println("Element Inserted\n");
                }
                    break;
                case "2":
                {
                    boolean good = false;
                    System.out.print("Enter Element to Delete: ");
                    //work until you have a usable number
                    int k =0;
                    while(!good)
                    {
                        try
                        {   //try out getting input and seeing if it's an int
                            k = Integer.parseInt(scanny.nextLine());
                            //It's an int.
                            if(k>0 || k<100)
                              good=true;
                            //It's not an int.
                            else
                                System.out.print("Err; need an integer. Try again: ");
                        }
                        //you tried, but it's not an int.
                        catch(NumberFormatException ex)
                        {System.out.print("Err; need an integer. Try again: ");}
                    }
                    //delete the value
                    leafy.delete(k);
                    System.out.println("Element Deleted\n");
                }
                    break;
                case "3":
                {
                    //Just print out the max
                    System.out.println("Finding Max. . .");
                    System.out.println("The max value is "+leafy.findMax(leafy.getRoot(), 1)+"\n");
                }
                    break;
                case "4":
                {
                    //just print out the min
                    System.out.println("Finding Min. . .");
                    System.out.println("The min value is "+leafy.findMin(leafy.getRoot(), 1)+"\n");
                }
                    break;
                case "5":
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
                            if(k>0 || k<100)
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
                    if(leafy.contains(leafy.getRoot(),k) == true)
                        System.out.println("It does hold "+ k+ "\n");
                    else
                        System.out.println("It does not hold "+k+"\n");
                }
                    break;
                case "6":
                {
                    //simply print the tree in order (smallest -> largest)
                    System.out.println("Your Ordered tree is: ");
                    leafy.print(leafy.getRoot());
                    System.out.println("\n");
                }
                    break;
                case "7":
                {
                    //display what the height is. Account for node
                    System.out.print("The Height is ");
                    System.out.println((leafy.height(leafy.getRoot()) - 1)+"\n");
                }
                    break;
                case "8":
                {
                    //display the total nodes and deleted node number
                    int[] arr = leafy.count(leafy.getRoot());
                    System.out.println("The Number of Nodes is "+arr[0]);
                    System.out.println("The Number of Deleted Nodes is "+arr[1]+"\n");
                }
                    break;
                case "9":
                    //quit button
                    valid = true;
                    break;
                default:
                    //so you entered a thing, and I dunno what it is
                    System.out.println("Code Not Recognized");
            }
        }
    }
}


