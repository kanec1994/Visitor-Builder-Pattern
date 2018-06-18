package fileVisitors.visitor;

import fileVisitors.treeBuilder.TreeBuilder;
import fileVisitors.util.MyLogger;

public class PrintTree implements VisitorI
{
   /**
    * Default constructor for the PrintTree class
    */
    public PrintTree()
    {
        MyLogger.writeMessage("PrintTree constructor called", 4);
    }
	
   /**
    * This is the implementation of the visit method
    * of the VisitorI interface for the PrintTree class.
    * This method takes a TreeBuilder object as an element
    * and prints the trees distinct words in an alphaNumeric
    * (ascending) order to an output file.
    *
    * @param TreeBuilder - tree to print
    * @return void - nothing to return
    */
    public TreeBuilder visit(TreeBuilder tree)
    {
	tree.printTree();
	return tree;
    }
}
