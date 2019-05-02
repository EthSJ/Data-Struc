package Project_2;
/*

Project 2
This is the very genericy linked list. It'll have magazine get plugged into it.
Set up to go Linked List ---contains an object--> Node --Contains an object --> magazine
This means Linked list works with nodes ONLY. Nodes work with magazines (or other) ONLY!
Linked List CANNOT work with magazines (or other)
*/

public class LinkedList<AnyType extends IDedObject>
{
    //head node. Name is a running joke on a misspelling.
    private Node<AnyType> noodle;

    //empty list. Also just empties because it can.
    public LinkedList()
    {makeEmpty();}

    //empties out the linked list. Yay for Java junk collector
    public void makeEmpty()
    {noodle = null;}

    //searches for the ID
    public AnyType findID(int ID)
    {
        Node searchNode = noodle;

        boolean found = false;

        //nothing in list!
        if (searchNode == null)
        {return null;}
        //oh hey! Found a match at the first start of list!
        else if (searchNode.getID() == ID)
        {return (AnyType)searchNode;}
        //Ok, now we gotta go looking
        else
        {
            while(searchNode != null && !found)
            {
                if(searchNode.getID() == ID)
                {found = true;}
                else
                {
                    searchNode = searchNode.next;
                    found = false;
                }
            }
        }
        //found it. Give back a thing.
        if(found == true)
        {return (AnyType)searchNode;}
        //Not here!
        else
        {return null;}
    }

    //inserts at the front
    public boolean insertAtFront(Node<AnyType> node)
    {
        //empty list
        if (noodle == null)
        {
            noodle = node;
            return true;
        }
        //Go look for it and if nothing found add it in.
        else if(findID(node.getID())== null)
        {
            Node temp = noodle;
            noodle = node;
            noodle.next = temp;

            return true;
        }
        //otherwise default here
        else
            return false;
    }

    // delete and return the record at the front of the list or return null if the list is empty
    public AnyType deleteFromFront()
    {
        //Nothing here
        if (noodle == null)
            return null;
        //Something is there!
        else
        {
            Node temp = noodle;
            noodle = noodle.next;
            return (AnyType)temp;
        }
    }


    // find and delete the record with the given ID or returns null if it isn’t found
    public AnyType delete(int ID)
    {
        //lead node is nothing
        if (noodle== null)
            System.out.println("Empty list!");
        //lead node matches ID.
        else if ((Integer)noodle.getID() == ID)
        {
            Node temp = noodle;
            noodle = noodle.next;
        }
        //Go look through the list for it.
        else
        {
            Node p1 = noodle;
            while (p1.next != null)
            {
                if ((Integer)p1.next.getID() == ID)
                {
                    Node temp = p1.next;
                    p1.next = p1.next.next;
                    return (AnyType)temp;
                }
                p1 = p1.next;
            }
        }
        return null;
    }


    // print all elements in the order they appear in the linked list. if list is empty print appropriate message.
    //Calling this print will individually call each nodes' which call each magazines.
    //Pretty sure there's a, "we heard you like print statements" joke in here somewhere
    public void printAllRecords()
    {
        System.out.println();
        //Keeps noodle (head) where it is.
        Node ptr = noodle;
        //We ain't found sh- nothing. It's an empty list
        if(ptr==null)
        {System.out.println("Empty list!");}
        //Go along list printing.
        else
        {
            while (ptr != null)
            {
                ptr.printID();
                ptr = ptr.next;
                System.out.println();
            }
        }
    }




    //This is the node part of the linked list
    //creates the node. Could use without, but just mostly here because
    //I am used to having a node in there.
    public static class Node<AnyType extends IDedObject> implements IDedObject
    {
        private Object object;
        public Node<AnyType> next;

        public Node(Object object, Node<AnyType> next )
        {this.object = object; this.next = next;}

        //returns the ID.
        //Used only with magazine.
        public int getID()
        {
            Magazine thingy = (Magazine)this.object;
            return thingy.getID();
        }


        //prints the ID.
        //Used only with magazine.
        public void printID()
        {
            Magazine thingy = (Magazine)this.object;
            thingy.printID();
        }
    }
}
