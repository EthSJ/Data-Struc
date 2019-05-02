package Project_2;
/*

Project 2
This is the magazine class. It'll get moved into the linked list and such
*/

class Magazine implements IDedObject
{
    //the variables they hold
    private int magazineID;
    private String magazineName;
    private String publisherName;

    Magazine()
    {}
    Magazine(int ID, String name, String pName)
    {this.magazineID=ID; this.magazineName=name;this.publisherName=pName;}

    //returns the ID the magazine has. Overrides the interface. FOllowed by a set
    @Override
    public int getID()
    {return magazineID;}
    public void setID(int magazineID)
    {this.magazineID= magazineID;}

    //Prints out the ID
    @Override
    public void printID()
    {System.out.println("Magazine ID: "+magazineID+"\nMagazine Name: "+magazineName+"\nPublisher Name: "+publisherName);}

    public String getName()
    {return this.magazineName;}
    public void setName(String magazineName)
    {this.magazineName = magazineName;}

    public String getPublisher()
    {return this.publisherName;}
    public void setPublisher(String publisherName)
    {this.publisherName=publisherName;}
}
