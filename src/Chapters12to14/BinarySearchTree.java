package Chapters12to14;


public class BinarySearchTree<T extends Comparable<T>> {
    // tree node class.
    private class TreeNode<Q extends Comparable<Q>> {
        private Q _data;
        private TreeNode<Q> _parent;
        private TreeNode<Q> _leftChild;
        private TreeNode<Q> _rightChild;
    }

    private TreeNode<T> _head;

    public BinarySearchTree() {
        _head = new TreeNode<T>();
    }

    public BinarySearchTree(T t) {
        _head = new TreeNode<T>();
        _head._data = t;
    }

}


