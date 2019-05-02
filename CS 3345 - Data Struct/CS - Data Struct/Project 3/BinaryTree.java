package Project_3;
/*

Project 3
This is a binary tree. Bask in it's glorious. . . Uhh, glory!
The main ends up using this. Hop over there to see more. Or scroll down to see
what specific functions and what have you, this contains
*/

class BinaryTree
{   //The node head/root
    private TreeNode root;

    //The constructors. 1)Default 2)Provide node
    BinaryTree()
    {root = null;}
    BinaryTree(TreeNode n)
    {this.root = n;}

    //get and set for root
    TreeNode getRoot()
    {return root;}
    void setRoot(TreeNode n)
    {this.root = n;}


    //count because have to have 2 returns. count all returns all, del returns deleted nodes
    public int[] count(TreeNode n)
    {
        int count1=0;
        int[] arr = new int[2];
        arr[0] = countAll(n);
        arr[1]= countDel(n, count1);
        return arr;
    }
    //Calculates the number of ALL nodes
    private int countAll(TreeNode n)
    {
        if(n ==null)
            return 0;
        return 1 + countAll(n.getLeft()) + countAll(n.getRight());
    }
    //counts number of deleted nodes
    private int countDel(TreeNode n,int count)
    {
        if(n==null)
            return 0;
        if(n.getDel() == true)
            count += 1;
        if(n.getLeft() != null)
            count = countDel(n.getLeft(),count);
        if(n.getRight() !=null)
            count = countDel(n.getRight(),count);

        return count;
    }


    //calculates the height
    public int height(TreeNode n)
    {
        if (n == null)
            return 0;
        else
            return 1+Math.max(height(n.getLeft()),height(n.getRight()));
    }

    //Is it in there? This is the public search function
    public boolean contains(TreeNode n, int find)
    {
        Boolean found=false;
        //if it cannot be found
        if (n == null)
            found= false;
        //found it and it's not deleted
        if(n.getKey()== find && n.getDel()== false)
            found= true;
        else if(n.getKey() == find && n.getDel()== true)
            found= false;
        //if left isn't null, move there to find it
        if (n.getLeft() != null && n.getKey() > find)
            found = contains(n.getLeft(),find);
        //if right isn't null, move there to find it
        else if (n.getRight() != null && n.getKey() < find)
            found = contains(n.getRight(),find);
        //return the result
        return found;

    }


    //Find min and find max respectively
    public int findMin(TreeNode n, int val)
    {
        //check if we're deleted otherwise we're new max
        if (n == null)
            val= 0;
        //Have to make sure we can't move right
        if(n.getDel() == true && n.getRight() == null)
            return val;
        else
            val = n.getKey();

        //if left isn't null, move lower
        if (n.getLeft() != null)
            val= findMin(n.getLeft(), val);

        //so we're on a deleted but we could actually have a lowest right winner
        else if(n.getRight() != null && n.getLeft() == null)
            val = findMin(n.getRight(), val);

        //return the result
        return val;
    }
    public int findMax(TreeNode n, int val)
    {
        //check if we're deleted otherwise we're new max
        if (n == null)
            val= 0;
        //have to make sure we can't move left
        if(n.getDel() == true && n.getLeft() == null)
            return val;
        else
            val = n.getKey();

        //if right isn't null, move there to find it
        if (n.getRight() != null)
            val= findMax(n.getRight(), val);

        //checks left too
        else if(n.getLeft() != null && n.getRight() == null)
            val = findMax(n.getLeft(), val);

        //return the result
        return val;
    }

    //The Insert "Function" (Broken in three parts. think of as one)
    //Need to find a node? This locates a node. (Private only)
    private boolean locate (TreeNode n, int find)
    {
        //if it cannot be found
        if (n == null)
            return false;
        //if we found it, but is deleted. Now is not!
        if(n.getKey()== find && n.getDel()== true)
        {
            n.setDel(false);
            return true;
        }
        //found it regularly
        else if (n.getKey() == find)
            return true;
        //if left isn't null, move there to find it
        if (n.getLeft() != null)
            locate(n.getLeft(),find);
        //if right isn't null, move there to find it
        if (n.getRight() != null)
            locate(n.getRight(),find);
        //return the result
        return false;
    }
    //inserts a node into the list. This is the accessable call.
    public void insertNode(int key ,boolean deleted)
    {
        if(locate(root,key) == false)
            this.root = insertNode(this.root, new TreeNode(key, deleted));
        else
            System.out.println("Already in list!");
    }
    //goes with insertNode. This part is nonaccessable
    //places the node in the right spot
    private TreeNode insertNode(TreeNode currentParent, TreeNode newNode)
    {
        //node I'm at is null
        if (currentParent == null)
        {
            return newNode;
        }
        //we need to go right!
        else if (newNode.getKey() > currentParent.getKey())
        {
            currentParent.setRight(insertNode(currentParent.getRight(), newNode));
        }
        //we need to move left!
        else if (newNode.getKey() < currentParent.getKey())
        {
            currentParent.setLeft(insertNode(currentParent.getLeft(), newNode));
        }
        //return where we're at
        return currentParent;
    }



    //the Delete "Function" (broken in two parts. think of as one)
    //access to delete
    public void delete(int toDelete)
    {
      root = delete(root, toDelete);
    }
    //the part that actually deletes. Not accessable
    private TreeNode delete(TreeNode p, int toDelete)
    {
      //cannot find
      if (p == null)
          System.out.println("Cannot find the number "+toDelete);
      else
          //move left
        if (p.getKey() > toDelete)
            p.setLeft(delete (p.getLeft(), toDelete));
        //move right and then search lefts of the right as needed
        else
            if (p.getKey()  < toDelete)
                p.setRight(delete (p.getRight(), toDelete));
            else
            {
                p.setDel(true);
            }
      return p;
   }


    //prints out the binary tree
    public void print(TreeNode n)
    {
        //if node null, do nothing.
        if (n == null)
           return;
        //otherwise, print out the value.
        else
        {
            //print left
            print(n.getLeft());

            //print my value
            if(n.getDel() == true)
                System.out.print("*"+n.getKey()+" ");
            else
                System.out.print(n.getKey()+" ");

            //prints left and right nodes.
            print(n.getRight());
        }
    }




    private class TreeNode
    {   //left point, right pointer, value is holds.
        private TreeNode leftChild;
        private TreeNode rightChild;
        private int key;
        private boolean deleted;

        //Default node(with junk) and actual used node
        TreeNode()
        {leftChild = rightChild= null; key = -1024;}
        //makes a something node.
        TreeNode(int key, boolean deleted)
        {this.key=key;this.deleted=deleted;leftChild = rightChild= null;}


        //get and set left pointers
        TreeNode getLeft()
        {return leftChild;}
        void setLeft(TreeNode n)
        {leftChild = n;}

        //get and set right pointers
        TreeNode getRight()
        {return rightChild;}
        void setRight(TreeNode n)
        {rightChild = n;}

        //get and set deleted
        boolean getDel()
        {return deleted;}
        void setDel(boolean deleted)
        {this.deleted = deleted;}

        //get and set values (key)
        int getKey()
        {return key;}
        void setKey(int key)
        {this.key = key;}
    }

}
