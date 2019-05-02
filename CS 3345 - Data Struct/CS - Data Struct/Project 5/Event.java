package Project_5;
/*

Project 5
This is kind of the "node" for the min heap. This is what'll fill each slot.
well, one of the following 3 will, anyways
*/

public class Event
{
    double timeOfEvent;

    protected static class Arrival extends Event
    {
        //not sure what this was supposed to be
        Arrival classvariable;
        //the time.
        double timeOfEvent;

        //get and set time
        double getTime()
        {return timeOfEvent;}
        void setTime(double time)
        {this.timeOfEvent = time;}


        //the print
        void print()
        {
            System.out.print("Arrival Event at time ");
            System.out.format("%.2f%n", timeOfEvent);
        }

    }
    protected static class EndOfService extends Event
    {
        //not sure what this was supposed to be
        EndOfService classvariable;
        //the time.
        double timeOfEvent;

        //get and set time
        double getTime()
        {return timeOfEvent;}
        void setTime(double time)
        {this.timeOfEvent = time;}

        //the print
        void print()
        {
            System.out.print("EndOfService Event at time ");
            System.out.format("%.2f%n", timeOfEvent);
        }
    }
    protected static class Termination extends Event
    {
        //not sure what this was supposed to be
        Termination classvariable;
        //the time.
        double timeOfEvent;

        //get and set time
        double getTime()
        {return timeOfEvent;}
        void setTime(double time)
        {this.timeOfEvent = time;}

        //the print
        void print()
        {
            System.out.print("Termination Event at time ");
            System.out.format("%.2f%n", timeOfEvent);
        }
    }
}
