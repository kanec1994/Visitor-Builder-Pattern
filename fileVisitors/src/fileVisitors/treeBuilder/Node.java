package fileVisitors.treeBuilder;

import fileVisitors.util.MyLogger;

class Node {
    private String word;

    private Node left;
    private Node right;
    private Node parent;

   /**
    * Constructor for the Node class. Its purpose is to
    * hold the words that we are counting/deleting from.
    *
    * @param String - word to be contained within node
    */
    public Node(String w)
    {
	MyLogger.writeMessage("Node constructor called", 4);
	this.word = w;
	this.left = null;
	this.right = null;
	this.parent = null;
    }

   /**
    * Constructor for Node class. Same as main, but also accepts
    * a parent node. Calls Node(String) constructor
    *
    * @param String - word to be contained
    * @param Node - parent node of this current node
    */
    public Node(String w, Node p)
    {
	this(w);
	this.parent = p;
    }

   /**
    * Check for right child node.
    *
    * @return state of right child node
    */
    public boolean hasRight()
    {
	return right != null;
    }

   /**
    * Gets the right child node
    * 
    * @return right child node, null if not set.
    */
    public Node getRight()
    {
	return right;
    }

   /** 
    * Sets the right child node.
    *
    * @param Node - right node to be set.
    */
    public void setRight(Node r)
    {
	this.right = r;
    }

   /**
    * Check for left child node.
    *
    * @return state of left child node
    */
    public boolean hasLeft()
    {
	return left != null;
    }

   /** 
    * Gets the left child node
    * 
    * @return left child node, null if not set.
    */
    public Node getLeft()
    {
	return left;
    }

   /**
    * Sets the left child node.
    *
    * @param Node - left node to be set.
    */
    public void setLeft(Node l)
    {
	this.left = l;
    }

   /**
    *  Check for parent child node.
    *
    *  @return state of parent child node
    */
    public boolean hasParent()
    {
	return parent != null;
    }

   /** 
    * Gets the parent child node
    * 
    * @return parent child node, null if not set.
    */
    public Node getParent()
    {
	return parent;
    }

   /** 
    * Sets the parent child node.
    *
    * @param Node - parent node to be set.
    */
    public void setParent(Node p)
    {
	this.parent = p;
    }

   /**
    * Returns the word this node contains
    * 
    * @return the word this node contains
    */
    public String getWord()
    {
	return this.word;
    }

   /**
    * Sets the word at the current node
    *
    * @param String - word to set
    */
    public void setWord(String str)
    {
	word = str;
    }
}
