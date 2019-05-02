package Project_4;
/*

Project 4
Parts of the red black tree. Go to Project_4 to see what this does when run
Or scroll down and read through it. Up to you!
*/

public class RedBlackTree
{
    //looked it up. Lot of examples call this actually a sentinal node, as well as root
    //it's in the book
    private final RBTreeNode root = new RBTreeNode(-1);
    private RBTreeNode parent;

    //is needed so functions can be called outside of
    public RBTreeNode getParent()
    {return this.parent;}

    //lets print this tree!
    public void printTree(RBTreeNode node)
    {
        //we've got empty
        if (node == null)
            return;
        printTree(node.left);
        //we don't wanna grab that sentinal node, as it doesn't truly "exist"
        if(node.element != -1)
        {
            if(node.isRed == true)
                System.out.print("*");
            System.out.print(node.element+" ");
        }
        printTree(node.right);
    }

    // goes to find the node and see if we have
    public boolean contains(int k, RBTreeNode node)
    {
        //makes node to look for
        RBTreeNode findNode = new RBTreeNode(k);
        //we have a empty tree
        if (parent == null)
        {return false;}

        //need to go left
        if (findNode.element < node.element)
        {
            if (node.left != root)
            {return contains(k, node.left);}
        }
        //need to go right
        else if (findNode.element > node.element)
        {
            if (node.right != root)
            {return contains(k, node.right);}
        }
        //hey we've found it!
        else if (findNode.element == node.element)
        {return true;}

        //we've tried out best, but cannot find
        return false;
   }

    //inserts the node. Fix tree group called by each time one is added
    //to make sure everything is nice and proper
    public void insert(int k)
    {
        //make node to insert
        RBTreeNode node = new RBTreeNode(k);

        RBTreeNode temp = parent;

        //lets make sure we don't have a duplicate
        if(contains(k, parent) ==false)
        {
            //we're starting at nothing
            if (parent == null)
            {
                parent = node;
                node.isRed = false;
                node.parent = root;
            }
            // we're not at nothing
            else
            {
                node.isRed = true;
                while (true)
                {
                    //if it's smaller, stick it below
                    if (node.element < temp.element)
                    {
                        if (temp.left == root)
                        {
                            temp.left = node;
                            node.parent = temp;
                            break;
                        }
                        else
                        {temp = temp.left;}
                    }
                    //if it's bigger, stick it above
                    else if (node.element >= temp.element)
                    {
                        if (temp.right == root)
                        {
                            temp.right = node;
                            node.parent = temp;
                            break;
                        }
                        else
                        {temp = temp.right;}
                    }
                }
                //Go fix the tree up. It might need it
                fixTree(node);
            }
        }
    }

    //This group of methods fixes the tree so that it's nice and proper
    //Fixes the tree to maintain red and black nodes
    private void fixTree(RBTreeNode node)
    {
        //dealing with reds
        while (node.parent.isRed == true)
        {
            //we need to look to uncle
            RBTreeNode uncle = root;
            //set up to go rotate right if we can
            if (node.parent == node.parent.parent.left)
            {
                uncle = node.parent.parent.right;

                //if uncle is red, fix that
                if (uncle != root && uncle.isRed == true)
                {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.right)
                {
                    //Double rotation needed
                    node = node.parent;
                    rotateLeft(node);
                }
                node.parent.isRed = false;
                node.parent.parent.isRed = true;

                //time to rotate right
                rotateRight(node.parent.parent);
            }
            //set up to go left, if we can
            else
            {
                uncle = node.parent.parent.left;
                //fix uncle if needed
                if (uncle != root && uncle.isRed == true)
                {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.left)
                {
                    //Double rotation needed
                    node = node.parent;
                    rotateRight(node);
                }
                node.parent.isRed = false;
                node.parent.parent.isRed = true;

                //rotates left to fix
                rotateLeft(node.parent.parent);
            }
        }
        //default case because picky java. Just lazily blacks a node
        parent.isRed = false;
    }
    //we need to rotate this whole thing left
    private void rotateLeft(RBTreeNode node)
    {
        //don't need to rotate parent
        if (node.parent != root)
        {
            //checks what can be rotated and does set up
            if (node == node.parent.left)
            {node.parent.left = node.right;}
            else
            {node.parent.right = node.right;}

            node.right.parent = node.parent;
            node.parent = node.right;

            if (node.right.left != root)
            {node.right.left.parent = node;}

            node.right = node.right.left;
            node.parent.left = node;
        }
        //need to rotate parent
        else
        {
            RBTreeNode right = parent.right;
            parent.right = right.left;
            right.left.parent = parent;
            parent.parent = right;
            right.left = parent;
            right.parent = root;
            parent = right;
       }
    }
    //rotates right
    private void rotateRight(RBTreeNode node)
    {
        //rotate where we're at
        if (node.parent != root)
        {
            //check what can be rotated and does set up
            if (node == node.parent.left)
            {node.parent.left = node.left;}
            else
            {node.parent.right = node.left;}

            node.left.parent = node.parent;
            node.parent = node.left;

            if (node.left.right != root)
            {node.left.right.parent = node;}

            node.left = node.left.right;
            node.parent.right = node;
        }
        //rotate parent
        else
        {
            RBTreeNode left = parent.left;
            parent.left = parent.left.right;
            left.right.parent = parent;
            parent.parent = left;
            left.right = parent;
            left.parent = root;
            parent = left;
        }
    }



    //This is the node
    private class RBTreeNode
    {
        int element;
        boolean isRed;
        RBTreeNode left, right, parent;

        RBTreeNode(int element)
        {this.element = element;this.left = root;this.right=root;this.parent = root; this.isRed = false;}

    }
}
