package fileVisitors.visitor;

import fileVisitors.treeBuilder.TreeBuilder;
import fileVisitors.util.MyLogger;

public class PrimeLength implements VisitorI
{
   /**
    * PrimeLength default constructor 
    */
    public PrimeLength()
    {
	MyLogger.writeMessage("PrimeLength constructor called", 4);
    }
	
   /**
    * This is the visit implementation of the VisitorI
    * interface for the PrimeLength class. This method
    * takes a TreeBuilder object modified by the previous
    * visitor PalindromeHighlight and modifies all words
    * that are of prime length and adds a "-PRIME" to the 
    * string.
    *
    * @param TreeBuilder - tree to modify
    * @return TreeBuilder - return modifed Tree
    */
    public TreeBuilder visit(TreeBuilder tree)
    {
	tree.findPrimes();
	return tree;
    }
}
