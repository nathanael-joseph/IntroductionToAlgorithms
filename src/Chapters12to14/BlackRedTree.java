package Chapters12to14;

public class BlackRedTree<T extends Comparable<T>> 
extends BinarySearchTree<T> {

    public static class BlackRedNode<Q extends Comparable<Q>>
    extends TreeNode<Q> {
        protected BlackRedNode(Q q) {
            super(q);
            _isRed = true;
        }      
        protected boolean _isRed;
    }

    

}
