package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;
import fileVisitors.treeBuilder.TreeBuilder;

public class PopulateVisitor implements VisitorI
{
    private FileProcessor file;
	
   /**
    * This is the constructor of the PopulateVisitor
    * class. This constructor takes in a FileProcessor
    * object to read from in order to populate the Tree.
    *
    * @param FileProcessor - file to be read from
    * @return - nothing to be returned.
    */
    public PopulateVisitor(FileProcessor fp)
    {
        MyLogger.writeMessage("PopulateVisitor constructor called", 4);
	file = fp;
    }

   /**
    * This is the implementation if the visit method
    * of the VisitorI interface for the PopulateVisitor
    * class.
    *
    * @param TreeBuilder - tree to visit
    * @return void - nothing to return
    */
    public TreeBuilder visit(TreeBuilder tree)
    {
	String currLine = file.readLine();
	while(currLine != null)
	{
	    processLine(currLine, tree);
	    currLine = file.readLine();
	}
	return tree;
    }

   /**
    * This method processes a line from the input file
    * and inserts each word in the line into the tree.
    *
    * @param String - line to process
    * @param Tree - tree to insert into
    */
    private void processLine(String line, TreeBuilder tree)
    {
	String[] words = line.split(" ");
	for(int i=0; i<words.length; i++)
	{
	    tree.addWord(words[i]);
	}
    }
}
