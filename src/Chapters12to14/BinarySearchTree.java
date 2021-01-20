package Chapters12to14;

import java.util.function.Consumer;

import Chapters9to11.LinkedQueue;

public class BinarySearchTree<T extends Comparable<T>> {
    // Tree node class -------------------------------------------------------
    public static class TreeNode<Q extends Comparable<Q>> {
        protected Q _data;
        protected TreeNode<Q> _parent;
        protected TreeNode<Q> _leftChild;
        protected TreeNode<Q> _rightChild;
        // prevent null nodes.
        protected TreeNode(Q q) {
            if(q == null) {
                throw new IllegalArgumentException("cannot create TreeNode for null.");
            }
            _data = q;
        }

        @Override
        public String toString() {
            return _data.toString();
        }
    }
    //------------------------------------------------------------------------
    
    // Properties ------------------------------------------------------------
    protected TreeNode<T> _head;
    //------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------
    public BinarySearchTree() {
    }
    
    public BinarySearchTree(T head) {
        _head = new TreeNode<T>(head);
    }
    //------------------------------------------------------------------------

    // Tree walking methods --------------------------------------------------
    public void preOrderTreeWalk(Consumer<T> consumer) {
        preOrderTreeWalk(consumer, _head);
    }
    // recursive pre-order tree walk.
    protected void preOrderTreeWalk(Consumer<T> consumer, TreeNode<T> node) {
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
    protected void inOrderTreeWalk(Consumer<T> consumer, TreeNode<T> node) {
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
    protected void postOrderTreeWalk(Consumer<T> consumer, TreeNode<T> node) {
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
    protected void breadthFirstTreeWalk(Consumer<T> consumer, LinkedQueue<TreeNode<T>> queue) {
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
    protected TreeNode<T> getMinimum(TreeNode<T> head) {
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
    protected TreeNode<T> getMaximum(TreeNode<T> head) {
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

    // returns null if node is maximum.
    public TreeNode<T> getSuccessor(TreeNode<T> node) {

        // null check.
        if(node == null) {
            throw new IllegalArgumentException("argument 'node' cannot be null");
        }

        TreeNode<T> successor = null;

        // node has right child.
        if (node._rightChild != null) {
            return getMinimum(node._rightChild);
        } 

        // node is head and has no right child -> node is maximum.
        if (node._parent == null) {
            
            return null;
        }

        // node is left child -> parent is successor.
        if (node._parent._leftChild == node) {
            return node._parent;
        }

        // node is right child.
        while(node._parent != null) {
            if(node._parent._leftChild == node) {
                return node._parent;
            }
            node = node._parent;
        }

        return successor;
    }

    // returns null if node is minimum
    public TreeNode<T> getPredecessor(TreeNode<T> node) {
        // null check.
        if(node == null) {
            throw new IllegalArgumentException("argument 'node' cannot be null");
        }

        TreeNode<T> predecessor = null;
        
        // node has left child.
        if(node._leftChild != null) {
            return getMaximum(node._leftChild);
        }

        // node is head and has no left child -> node is minimum.  
        if(node._parent == null) {
            return null;
        }

        // node is right child -> parent is predecessor.
        if(node._parent._rightChild == node) {
            return node._parent;
        }

        // node is left child
        while (node._parent != null) {
            if(node._parent._rightChild == node) {
                return node._parent;
            }
            node = node._parent;
        }

        return predecessor;
    }
    //------------------------------------------------------------------------
    
    // insert, findFirst, remove ----------------------------------------------
    
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
    // returns null if no t is found.
    public TreeNode<T> findFirst(T t) {
        if(t == null) {
            throw new IllegalArgumentException("argument 't' cannot be null");
        }

        TreeNode<T> node = _head;
        TreeNode<T> found = null;
        while(node != null) {
            if(t.compareTo(node._data) == 0) {
                return node;
            }
            if(t.compareTo(node._data) > 0) {
                node = node._rightChild;
            }
            if(t.compareTo(node._data) < 0) {
                node = node._leftChild;
            }
        }
        return found;
    }
    
    public void remove(TreeNode<T> node) {
        // node is leaf.
        if(node._leftChild == null && node._rightChild == null) {
            // node is head
            if(node == _head) {
                _head = null;
                return;
            }
            // node is left child
            if(node._parent._leftChild == node) {
                node._parent._leftChild = null;
                return;
            }
            // node is right child
            if(node._parent._rightChild == node) {
                node._parent._rightChild = null;
                return;
            }
        }
        // node has only left child
        if(node._leftChild != null && node._rightChild == null) {
            // node is head
            if(node == _head) {
                _head = node._leftChild;
                _head._parent = null;
                return;
            }
            // node is left child
            if(node._parent._leftChild == node) {
                node._parent._leftChild = node._leftChild;
                node._leftChild._parent = node._parent;
                return;
            }
            // node is reight child
            if(node._parent._rightChild == node) {
                node._parent._rightChild = node._leftChild;
                node._leftChild._parent = node._parent;
                return;
            }
        }
        // node has only right child
        if(node._leftChild == null && node._rightChild != null)  {
            // node is head
            if(node == _head) {
                _head = node._rightChild;
                _head._parent = null;
                return;
            }
            // node is left child
            if(node._parent._leftChild == node) {
                node._parent._leftChild = node._rightChild;
                node._rightChild._parent = node._parent;
                return;
            }
            // node is reight child
            if(node._parent._rightChild == node) {
                node._parent._rightChild = node._rightChild;
                node._rightChild._parent = node._parent;
                return;
            }
        }
        // node has two children
        TreeNode<T> successor = getSuccessor(node);
        remove(successor);
        node._data = successor._data;
    }

    //------------------------------------------------------------------------
}


