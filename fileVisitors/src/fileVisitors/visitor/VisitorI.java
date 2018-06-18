package fileVisitors.visitor;

import fileVisitors.treeBuilder.TreeBuilder;

public interface VisitorI
{
   /**
    * This function will be implemented for all
    * visitors in this assignment as the only element
    * needed is the tree which we are modifying.
    *
    * @param TreeBuilder - tree which we are visiting
    * @return TreeBuilder - returns tree which was visited
    */
    public TreeBuilder visit(TreeBuilder tree);
}
