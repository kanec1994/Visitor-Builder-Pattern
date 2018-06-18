import fileVisitors.treeBuilder.TreeBuilder;
import fileVisitors.visitor.VisitorI;
import fileVisitors.visitor.PopulateVisitor;
import fileVisitors.visitor.PalindromeHighlight;
import fileVisitors.visitor.PrimeLength;
import fileVisitors.visitor.PrintTree;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;
import fileVisitors.store.Results;

public class Driver
{
    public static void main(String[] args)
    {
        if(args.length == 3)
	{
	    //Process input
	    FileProcessor inputTxt = new FileProcessor(args[0]);
	    Results outputTxt = new Results(args[1]);
	    MyLogger.setDebugValue(Integer.parseInt(args[2]));

	    //Create the elements
	    TreeBuilder tree = new TreeBuilder(outputTxt);

	    //Create the visitors
	    VisitorI populateVisitor = new PopulateVisitor(inputTxt);
	    VisitorI palindromeHighlight = new PalindromeHighlight();
	    VisitorI primeLength = new PrimeLength();
	    VisitorI printTree = new PrintTree();

	    //Visit the elements
	    tree.accept(populateVisitor);
	    tree.accept(palindromeHighlight);
	    tree.accept(primeLength);
	    tree.accept(printTree);

	    //Close files
	    inputTxt.close();
	    outputTxt.close();
	}
	else
	{
	    System.err.println("Incorrect number of arguments");
	}
    }
}
