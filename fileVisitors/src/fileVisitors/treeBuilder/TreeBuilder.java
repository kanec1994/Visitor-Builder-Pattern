package fileVisitors.treeBuilder;

import fileVisitors.visitor.VisitorI;
import fileVisitors.util.MyLogger;
import fileVisitors.store.Results;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class TreeBuilder {
    private Node head;
    private ArrayList<Node> nodes;

    private Results results;

   /**
    * Default constructor. Sets head to null and creates the arraylist
    * that contains all the nodes, for use in counting and printing
    */
    public TreeBuilder(Results r)
    {
	MyLogger.writeMessage("TreeBuilder constructor called", 4);
	head = null;
	nodes = new ArrayList<Node>();
	results = r;
    }

   /**
    * Public function for adding a word. If list is empty,
    * head is instantiated.  If head is already created, it calls
    * the recursive addWordWrap(String, Node) function.
    *
    * @param String - word to be inserted to the tree
    */
    public void addWord(String word)
    {
	if(head == null)
	{
	    head = new Node(word);
	}
	else
	{
	    addWordWrap(word, head);
	}
    }

   /**
    * Private wrapper function for addWord(String).
    * Searches the BST as normal. If a word isnt found, a node
    * is created and its word is set there, along with its parent.
    * If a node exists with this word, its number is incremented.
    *
    * Runs with a complexity of O(log(N)), as BST trees do.
    *
    * @param String - word to be searched for
    * @param Node - current node to be searched
    */
    private void addWordWrap(String word, Node node)
    {
	int compare = word.compareTo(node.getWord());
        if(compare > 0)
	{
	    //Right side
	    if(node != null && node.hasRight()) {
		addWordWrap(word, node.getRight());
	    }
	    else
	    {
		Node n = new Node(word, node);
		node.setRight(n);
            }
	}
	else if(compare < 0)
        {
	    //Left side
	    if(node != null && node.hasLeft()) {
		addWordWrap(word, node.getLeft());
	    }
	    else
	    {
		Node n = new Node(word, node);
		node.setLeft(n);
            }
	}
    }

   /**
    * This method calls the capPalindromes method in order to
    * capitalize all palindromes which exist in the tree.
    *
    * @return void - nothing to return
    */
    public void findPalindromes()
    {
	capPalindromes(head);
    }

   /**
    * This method searches the tree and checks if the words are
    * palindromes. If they are, it will capitalize it.
    *
    * NOTE: that according to assignment guidelines, palindromes 
    *       of length 3 or less WILL NOT be capitalized.
    *
    * @param Node - current node to check
    */
    private void capPalindromes(Node n)
    {
	if(n.getWord().length() > 3 && isPalindrome(n.getWord()))
	{
	    MyLogger.writeMessage("Palindrome found", 2);
	    String capWord = n.getWord().toUpperCase();
	    n.setWord(capWord);
	}
	if(n.hasLeft())
	{
	    capPalindromes(n.getLeft());
	}
	if(n.hasRight())
	{
	    capPalindromes(n.getRight());
	}
    }

   /**
    * This method determines if the word is a palindrome.
    *
    * @param String - word to check
    * @return boolean - result
    */
    private boolean isPalindrome(String s)
    {
	return s.equals(new StringBuilder(s).reverse().toString());
    }
	
   /**
    * This function calls the editPrimes function to edit all strings
    * in the tree of prime length according to the assignment details.
    *
    * @return void
    */
    public void findPrimes()
    {
        editPrimes(head);
    }

   /**
    * This function traverses the tree searching for words of prime
    * length. If a word is prime, the function will add "-PRIME" to
    * the end of the word.
    *
    * @param Node - current node to check
    * @return void - nothing to return
    */
    private void editPrimes(Node n)
    {
	if(n.hasLeft())
	{
	    editPrimes(n.getLeft());
	}
	if(isPrime(n.getWord()))
	{
	    MyLogger.writeMessage("Prime number found", 1);
	    n.setWord(n.getWord() + "-PRIME");
	}
	if(n.hasRight())
	{
	    editPrimes(n.getRight());
	}
    }

   /**
    * This function returns true if the length of the string
    * is prime, false otherwise.
    *
    * @param String - string to check
    * @return boolean - whether or not length of String is prime
    */
    private boolean isPrime(String s)
    {
	int len = s.length();
	for(int i=2; i < len; i++)
	{
	    if(len%i==0)
		return false;
	}
	return true;
    }

   /**
    * This method calls the printWrapper method to print the tree in
    * alphanumeric order.
    *
    * @return void - nothing to return
    */
    public void printTree()
    {
	printWrapper(head);
	results.printResults();
    }

   /**
    * This is the method which will print the tree in alphanumeric order.
    *
    * @param Node - current node of the tree
    */
    private void printWrapper(Node n)
    {
	if(n.hasLeft())
	{
	    printWrapper(n.getLeft());
	}
	results.storeNewResult(n.getWord());
	if(n.hasRight())
	{
	    printWrapper(n.getRight());
	}
    }
	
   /**
    * This is the implementation of the accept method of the Visitor
    * Pattern used to call the visit method of whoever is visiting
    * and edit the tree.
    *
    * @param Visitor - class visiting the tree
    */
    public void accept(VisitorI visitor)
    {
	MyLogger.writeMessage("Visitor accepted", 3);
	visitor.visit(this);
    }
}
