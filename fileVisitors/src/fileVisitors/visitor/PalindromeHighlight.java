package fileVisitors.visitor;

import fileVisitors.treeBuilder.TreeBuilder;
import fileVisitors.util.MyLogger;

public class PalindromeHighlight implements VisitorI
{
   /**
    * Default constructor for PalindromeHighlight class
    */
    public PalindromeHighlight()
    {
        MyLogger.writeMessage("PalindromeHighlight constructor class called", 4);
    }
	
   /**
    * This is the implementation of the visit method
    * of the VisitorI interface for the PalindromeHightlight
    * class. This method takes the tree from the previous
    * visitor PopulateVisitor and modifies all the palindromes
    * in the tree.
    *
    * @param TreeBuilder - tree to be modified
    * @return void - nothing is returned
    */
    public TreeBuilder visit(TreeBuilder tree)
    {
	tree.findPalindromes();
	return tree;
    }
}
