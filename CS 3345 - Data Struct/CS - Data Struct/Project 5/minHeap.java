package Project_5;
/*

Project 5
Functions and all that that are required of a min heap.
except for isEmpty. That really isn't used by anything.
*/
import java.util.*;

public class minHeap<AnyType extends Comparable<? super AnyType>> extends Event
{
    //Heap array itself
    private Event[] Heap;
    //used before it is created to a heap. Makes life easier. ignored after Heap populated.
    private ArrayList<Event> preheap = new ArrayList<Event>(10);
    //the maximum size
    private int size;
    //the number of things in the heap
    private int n;

    //doesn't need to do anything right now.
    //build heap and add are where the magic happens.
    public minHeap()
    {}

    //The never used function
    public boolean isEmpty()
    {
        if(Heap == null)
            return true;
        return false;
    }

    //prints out the heap. For glory.
    public void print()
    {
        //bunch of temps
        Event.Arrival a;
        Event.EndOfService b;
        Event.Termination c;

        //Heap isn't much of anything let alone a heap. Forces creation. Redundant.
        if(Heap == null)
        {
            Heap = new Event[preheap.size()];
            Heap = preheap.toArray(Heap);
        }

        //actually the heap printer.
        for(int i=0;i<Heap.length;i++)
        {
            //item at index is an arrival
            if(Heap[i] instanceof Event.Arrival)
            {
                a= (Event.Arrival)Heap[i];
                System.out.print("Arrival:");
                System.out.format("%.2f", a.getTime());
                System.out.print("; ");
            }
            //item at index is an EoS
            if(Heap[i] instanceof Event.EndOfService)
            {
                b= (Event.EndOfService)Heap[i];
                System.out.print("EndOfService:");
                System.out.format("%.2f", b.getTime());
                System.out.print("; ");
            }
            //item at index is a termination
            if(Heap[i] instanceof Event.Termination)
            {
                c= (Event.Termination)Heap[i];
                System.out.print("Termination:");
                System.out.format("%.2f", c.getTime());
                System.out.print("; ");
            }
        }

    }

    //add to the preheap. This will get changed into the actual heap later.
    public void add(Event k)
    {preheap.add(k);}

    //builds the heap. Help funcs below
    public void buildheap()
    {
        //so the heap's empty at the momemnt.
        Heap = null;
        Heap = new Event[preheap.size()*2];
        Heap = preheap.toArray(Heap);

        //number of items is the size of preheap, max size is double for safety
        n = preheap.size();
        size = 2*preheap.size();
        //mins the heap
        for (int i=n/2-1; i>=0; i--)
            shiftdown(i);

    }
    //inserts into heap
    public void insert(Event val)
    {
        //current spot is the next available index (read end of)
        int curr = n++;
        //jam that value in there.
        Heap[curr] = val;
        // Now sift up until curr's parent's key > curr's key
        while ((curr != 0) && (compareTo(Heap[curr], Heap[parent(curr)]) < 0))
        {
            swap(Heap, curr, parent(curr));
            curr = parent(curr);
        }
    }
    //compareTo. Needed to be double instead of int for more precision. Not really override
    private double compareTo(Event g,Event h)
    {
        double dif, val1=0, val2=0;

        //2 of each to set as needed or Arrival1t even needed
        Event.Arrival Arrival1=null;
        Event.Arrival Arrival2=null;
        Event.EndOfService EoS1=null;
        Event.EndOfService EoS2=null;
        Event.Termination Term1=null;
        Event.Termination Term2=null;

        //arrival sets
        if(g instanceof Event.Arrival)
        {Arrival1 = (Event.Arrival)g; val1 =Arrival1.getTime();}
        if(h instanceof Event.Arrival)
        {Arrival2 = (Event.Arrival)h; val2 =Arrival2.getTime();}

        //EoS sets
        if(g instanceof Event.EndOfService)
        {EoS1 = (Event.EndOfService)g;val1 = EoS1.getTime();}
        if(h instanceof Event.EndOfService)
        {EoS2 = (Event.EndOfService)h; val2 = EoS2.getTime();}

        //Term sets
        if(g instanceof Event.Termination)
        {Term1 = (Event.Termination)g; val1 = Term1.getTime();}
        if(h instanceof Event.Termination)
        {Term2 = (Event.Termination)h; val2 = Term2.getTime();}

        //actually doing the work;
        dif = val1 - val2;
        return dif;
    }
    //helper function. Swaps items around.
    private static <AnyType> void swap(AnyType[] A, int p1, int p2)
    {
        AnyType temp = A[p1];
        A[p1] = A[p2];
        A[p2] = temp;
    }
    //Moves element into correct place
    private void shiftdown(int pos)
    {
        while (!isLeaf(pos))
        {
            int j = leftchild(pos);
            //moves j down
            if ((j<(n-1)) && (compareTo(Heap[j],Heap[j+1]) > 0))
                j++;
            if (compareTo(Heap[pos], Heap[j]) <= 0)
                return;
            swap(Heap, pos, j);
            //move down
            pos = j;
        }
    }
    //left position
    private int leftchild(int pos)
    {return 2*pos + 1;}
    //right position
    private int rightchild(int pos)
    {return 2*pos + 2;}
    //parent
    private int parent(int pos)
    {return (pos-1)/2;}
    //size of heap
    private int heapsize()
    {return n;}
    //are we at a leaf?
    private boolean isLeaf(int pos)
    { return (pos >= n/2) && (pos < n); }

    //removes min
    public Event removeMin()
    {
        try
        {
            //swap min with last
            swap(Heap, 0, --n);
            //fix up tree
            if (n != 0)
                shiftdown(0);
            //grab last item in heap.
            Event k = Heap[n];
            //replace last item in heap with nuffin'
            Heap[n]= new Event();
            return k;
        }
        //the sys.out pretty much says it.
        catch(ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("Just Kidding! It was an already empty heap");
            return null;
        }
    }
}
