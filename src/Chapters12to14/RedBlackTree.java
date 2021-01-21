package Chapters12to14;

public class RedBlackTree<T extends Comparable<T>> 
extends BinarySearchTree<T> {
    // black-red node class ------------------------------------------
    public static class RedBlackNode<Q extends Comparable<Q>>
    extends TreeNode<Q> {
        protected RedBlackNode(Q q) {
            super(q);
            _isRed = true;        
        }      
        protected boolean _isRed;
        protected RedBlackNode<Q> getLeftChild() {
            return (RedBlackNode<Q>)_leftChild;
        }
        protected RedBlackNode<Q> getRightChild() {
            return (RedBlackNode<Q>)_rightChild;
        }
        protected RedBlackNode<Q> getParent() {
            return (RedBlackNode<Q>)_parent;
        }
        @Override
        public String toString() {
            String colour = _isRed ? "Red" : "Black";
            return _data.toString() + " : " + colour;
        }
    }
    // ---------------------------------------------------------------

    // rotate left & right -------------------------------------------
    protected RedBlackNode<T> rotateLeft(RedBlackNode<T> node) {
        RedBlackNode<T> rightNode = node.getRightChild();
        RedBlackNode<T> parent = node.getParent();
        rightNode._parent = node.getParent();
        node._rightChild = rightNode.getLeftChild();
        if (node._rightChild != null ) {
            node._rightChild._parent = node;
        }     
        rightNode._leftChild = node;  
        node._parent = rightNode;
        // node had parent.
        if(parent != null)  {
            // node was left child
            if(parent._leftChild == node) {
                parent._leftChild = rightNode;
            } else {
                // node was right child
                parent._rightChild = rightNode;
            }
        } else {
            // node was head
            _head = rightNode;
        }
       return rightNode;
    }

    protected RedBlackNode<T> rotateRight(RedBlackNode<T> node) {
        RedBlackNode<T> leftNode = node.getLeftChild();
        RedBlackNode<T> parent = node.getParent();
        leftNode._parent = parent;
        node._leftChild = leftNode.getRightChild();
        if(node._leftChild != null) {
            node._leftChild._parent = node;
        }
        node._parent = leftNode;
        leftNode._rightChild = node;
        if(parent != null)  {
            // node was left child
            if(parent._leftChild == node) {
                parent._leftChild = leftNode;
            } else {
                // node was right child
                parent._rightChild = leftNode;
            }
        } else {
            // node was head
            _head = leftNode;
        }
        return leftNode;
    }
    // ---------------------------------------------------------------

    // insert & delete -----------------------------------------------
    @Override
    public RedBlackNode<T> insert(T t) {
        RedBlackNode<T> exists = (RedBlackNode<T>)findFirst(t);
        if (exists != null) {
            return exists;
        }
        RedBlackNode<T> node = new RedBlackNode<T>(t);
        insert(node);
        redBlackFixUp(node);
        return node;
    }

    protected void redBlackFixUp(RedBlackNode<T> node) {
        // this tree has no duplicates, so node must be a leaf.
        // if node is head then colour it black.
        if(node == _head) {
            node._isRed = false;
            return;
        }
        // node is child. a red node cannot have a red parent.
         while(node.getParent()._isRed) {
            RedBlackNode<T> parent = node.getParent();
            // if the parent is red, then it must have a parent.
            RedBlackNode<T> grandparent = parent.getParent();
            // if parent is left child, check right child *uncle* 
            if(grandparent.getLeftChild() == parent) {
                RedBlackNode<T> uncle = grandparent.getRightChild();
                // if uncle is black
                if(uncle == null || !uncle._isRed) {
                    // check whether or not there is a triangle
                    // between node, parent, and grandparent.
                    if (parent.getRightChild() == node) {
                        parent = rotateLeft(parent);
                    }
                    parent._isRed = false;
                    grandparent._isRed = true;
                    rotateRight(grandparent);
                }
                else {
                    // here uncle is red.
                    parent._isRed = false;
                    uncle._isRed = false;
                    grandparent._isRed = true;
                    node = grandparent;
                }
            }
            // if parent is right child, check left child *uncle* 
            if(grandparent._rightChild == parent) {
                RedBlackNode<T> uncle = grandparent.getLeftChild();
                // if uncle is black
                if(uncle == null || !uncle._isRed) {
                    // check whether or not there is a triangle
                    // between node, parent, and grandparent.
                    if (parent.getLeftChild() == node) {
                        parent = rotateRight(parent);
                    }
                    parent._isRed = false;
                    grandparent._isRed = true;
                    rotateLeft(grandparent);
                }
                else {
                    // here uncle is red.
                    parent._isRed = false;
                    uncle._isRed = false;
                    grandparent._isRed = true;
                    node = grandparent;
                }
            }

            if(node == _head) {
                node._isRed = false;
                return;
            }
        }
        return;
    }
    // ---------------------------------------------------------------
}
