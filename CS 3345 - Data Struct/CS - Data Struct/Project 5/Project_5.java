package Project_5;
/*

Project 5
this creates and lets the user use a minHeap
*/
import java.util.*;

class Project_5
{
    public static void main(String[] args)
    {
        //variables
        Boolean valid = true, cantInsert=true;
        String input;
        Scanner scanny = new Scanner(System.in);

        //empty ol' heap
        minHeap heapy = new minHeap();

        //some base events to use
        Event.Arrival Arrival = new Event.Arrival();
        Event.EndOfService eos = new Event.EndOfService();
        Event.Termination Term = new Event.Termination();


        //Command list
        System.out.println("Min Heap");
        System.out.println("   1.\tAdd Event");
        System.out.println("   2.\tInsert");
        System.out.println("   3.\tPrintArray");
        System.out.println("   4.\tConstruct Heap");
        System.out.println("   5.\tDelete Min");
        System.out.println("   6.\tQuit");

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
                    //need to check if heap's made
                    if(cantInsert == true)
                    {
                        System.out.print("Event Type: ");
                        input= scanny.nextLine();

                        boolean good = false;
                        System.out.print("Time: ");

                        //work until you have a usable number
                        double k =0;
                        while(!good)
                        {
                            try
                            {   //try out getting input and seeing if it's an int
                                k = Double.parseDouble(scanny.nextLine());
                                //It's an int.
                                if(k>0)
                                  good=true;
                                //It's Arrivalt an int.
                                else
                                    System.out.print("Err; need an double. Try again: ");
                            }
                            //you tried, but it's an int.
                            catch(NumberFormatException ex)
                            {System.out.print("Err; need an double. Try again: ");}
                        }
                        //insert arrival
                        if(input.equals("Arrival") || input.equals("arrival"))
                        {
                            Arrival.setTime(k);
                            heapy.add(Arrival);
                            Arrival= new Event.Arrival();
                        }
                        //EoS insert
                        else if(input.equals("EndOfService") || input.equals("endofservice"))
                        {
                            eos.setTime(k);
                            heapy.add(eos);
                            eos= new Event.EndOfService();
                        }
                        //lazily calling it a termination otherwise
                        else
                        {
                            Term.setTime(k);
                            heapy.add(Term);
                            Term= new Event.Termination();
                        }
                        System.out.println("");
                    }
                    else
                        System.out.println("Can't do that. Use Insert\n");
                }
                    break;
                case "2":
                {
                    //need to chekc heap made status
                    if(cantInsert == false)
                    {
                        System.out.print("Event Type: ");
                        input= scanny.next();
                        scanny.nextLine();
                        boolean good = false;
                        System.out.print("Time: ");

                        //work until you have a usable number
                        double k =0;
                        while(!good)
                        {
                            try
                            {   //try out getting input and seeing if it's an int
                                k = Double.parseDouble(scanny.nextLine());
                                //It's an int.
                                if(k>0)
                                  good=true;
                                //It's Arrivalt an int.
                                else
                                    System.out.print("Err; need an double. Try again: ");
                            }
                            //you tried, but it's Arrivalt an int.
                            catch(NumberFormatException ex)
                            {System.out.print("Err; need an double. Try again: ");}
                        }
                        //insert arrival
                        if(input.equals("Arrival") || input.equals("arrival"))
                        {
                            Arrival.setTime(k);
                            heapy.insert(Arrival);
                            Arrival= new Event.Arrival();
                        }
                        //end of service
                        else if(input.equals("EndOfService") || input.equals("endofservice"))
                        {
                            eos.setTime(k);
                            heapy.insert(eos);
                            eos= new Event.EndOfService();
                        }
                        //lazily calling it a termination otherwise
                        else
                        {
                            Term.setTime(k);
                            heapy.insert(Term);
                            Term= new Event.Termination();
                        }
                        System.out.println();
                    }
                    else
                        System.out.println("Can't do that. Use add\n");
                }
                    break;
                case "3":
                {//let go print this heap/preheap out!
                    heapy.print();
                    System.out.println("\n");
                }
                    break;
                case "4":
                {
                    //builds the heap, flags it made, and reports it
                    heapy.buildheap();
                    cantInsert=false;
                    System.out.println("Heap made.\n");

                }
                    break;
                case "5":
                {
                    //checks to make sure heap's made first
                    if(cantInsert == false)
                    {
                        System.out.println("Minimum Deleted!");

                        //3 way check of what type of event I got to report
                        Object o= heapy.removeMin();
                        if(o instanceof Event.Arrival)
                        {
                            Event.Arrival temp = (Event.Arrival)o;
                            temp.print();
                            System.out.println("");
                        }
                        if(o instanceof Event.EndOfService)
                        {
                            Event.EndOfService temp = (Event.EndOfService)o;
                            temp.print();
                            System.out.println("");
                        }
                        if(o instanceof Event.Termination)
                        {
                            Event.Termination temp = (Event.Termination)o;
                            temp.print();
                            System.out.println("");
                        }
                    }
                    else
                        System.out.println("Psst, try building the heap first");

                }
                    break;
                case "6":
                    //quit button
                    System.out.println("Quitting!");
                    valid = false;
                    break;
                //if you don't get this one, read Hitchhiker's Guide. It's a joke. For fun.
                case "42":
                    System.out.println("What do you get when you multiply six by nine?\n");
                    break;
                default:
                    //so you entered a thing, and I dunno what it is
                    System.out.println("Code Not Recognized\n");
            }
        }
    }
}
