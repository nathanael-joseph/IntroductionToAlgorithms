package Chapters12to14;

import java.util.function.Consumer;

import Chapters9to11.LinkedQueue;

public class BinaryTree<T extends Comparable<T>> {
    // Tree node class -------------------------------------------------------
    private class TreeNode<Q> {
        private Q _data;
        private TreeNode<Q> _parent;
        private TreeNode<Q> _leftChild;
        private TreeNode<Q> _rightChild;
        // prevent null nodes.
        private TreeNode(Q q) {
            if(q == null) {
                throw new IllegalArgumentException("cannot create TreeNode for null.");
            }
            _data = q;
        }
    }
    //------------------------------------------------------------------------
    
    // Properties ------------------------------------------------------------
    private TreeNode<T> _head;
    //------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------
    public BinaryTree() {
    }
    
    public BinaryTree(T head) {
        _head = new TreeNode<T>(head);
    }
    //------------------------------------------------------------------------

    // Tree walking methods --------------------------------------------------
    public void preOrderTreeWalk(Consumer<T> consumer) {
        preOrderTreeWalk(consumer, _head);
    }
    // recursive pre-order tree walk.
    private void preOrderTreeWalk(Consumer<T> consumer, TreeNode<T> node) {
        if(node != null) {
            consumer.accept(node._data);
            preOrderTreeWalk(consumer, node._leftChild);
            preOrderTreeWalk(consumer, node._rightChild);
        }
    }

    public void inOrderTreeWalk(Consumer<T> consumer) {
        inOrderTreeWalk(consumer, _head);
    }
    // recursive in order tree walk.
    private void inOrderTreeWalk(Consumer<T> consumer, TreeNode<T> node) {
        if(node != null) {
            inOrderTreeWalk(consumer, node._leftChild);
            consumer.accept(node._data);
            inOrderTreeWalk(consumer, node._rightChild);
        }
    }

    public void postOrderTreeWalk(Consumer<T> consumer) {
        postOrderTreeWalk(consumer, _head);
    }
    // recursive post order tree walk.
    private void postOrderTreeWalk(Consumer<T> consumer, TreeNode<T> node) {
        if(node != null) {
            postOrderTreeWalk(consumer, node._leftChild);
            postOrderTreeWalk(consumer, node._rightChild);
            consumer.accept(node._data);
        }
    }

    public void breadthFirstTreeWalk(Consumer<T> consumer) {
        LinkedQueue<TreeNode<T>> queue = new LinkedQueue<TreeNode<T>>();
        if(_head != null) {
            queue.Enqueue( _head);
        }
        breadthFirstTreeWalk(consumer, queue);
    }
    private void breadthFirstTreeWalk(Consumer<T> consumer, LinkedQueue<TreeNode<T>> queue) {
        while(!queue.isEmpty()) {
            TreeNode<T> node = queue.Dequeue();
            consumer.accept(node._data);
            if(node._leftChild != null) {
                queue.Enqueue(node._leftChild);
            }
            if(node._rightChild != null) {
                queue.Enqueue(node._rightChild);
            }
        }
    }
    //------------------------------------------------------------------------

    // min and max -----------------------------------------------------------
    public T getMinimum() {
        return getMinimum(_head)._data;
    }
    private TreeNode<T> getMinimum(TreeNode<T> head) {
        if(head == null) {
            return null;
        }
        TreeNode<T> node = head;
        while(node._leftChild != null) {
            node = node._leftChild;
        }
        return node;
    }

    public T getMaximum() {
        return getMaximum(_head)._data;
    }
    private TreeNode<T> getMaximum(TreeNode<T> head) {
        if(head == null) {
            return null;
        }
        TreeNode<T> node = head;
        while(node._leftChild != null) {
            node = node._leftChild;
        }
        return node;
    }
    //------------------------------------------------------------------------

    // successor and predecessor ---------------------------------------------

    // TODO 

    //------------------------------------------------------------------------
    
    // insert, contains, remove ----------------------------------------------
    
    public void insert(T t) {
        TreeNode<T> node = new TreeNode<T>(t);
        if(_head == null) {
            _head = node;
            return;
        }
        TreeNode<T> current = _head;
        TreeNode<T> next = _head;
        while (true) {
            if(t.compareTo(next._data) < 0 ) {
                current = next;
                next = next._leftChild;
                if(next == null) {
                    current._leftChild = node;
                    node._parent = current;
                    return;
                }
            } else if (t.compareTo(next._data) > 0) {
                current = next;
                next = next._rightChild;   
                if(next == null) {
                    current._rightChild = node;
                    node._parent = current;
                    return;
                }
            } else {
                // if they are equeal, node will be inserted as current._richchild
                node._rightChild = next._rightChild;
                next._rightChild = node;
                node._parent = next;
                return;
            }
        }
    }

    // TODO 

    //------------------------------------------------------------------------
}


