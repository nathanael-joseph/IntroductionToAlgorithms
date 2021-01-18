package Chapters9to11;


public class LinkedQueue<T> {

    private class Node<Q> {
        private Q _data;
        private Node<Q> _next;
        private Node() {}
        private Node(Q q) {
            _data = q;
        }
    }

    private Node<T> _head;
    private Node<T> _tail;
    private long _length;

    public LinkedQueue() {
    }

    public void Enqueue(T t) {
        Node<T> node = new Node<T>(t);
        if (_length > 0) {
            _tail._next = node;
            _tail = node;
        } else {
            _head = node;
            _tail = _head;
        }
        _length++;
    }

    public T Dequeue() {
        if(_length > 0) {
            T t = _head._data;
            _head = _head._next;
            _length--;
            if(_length == 0) {
                _tail = null;
            }
            return t;
        }       
        throw new NullPointerException("'Dequeue cannot be called on an empty queue");
    }

    public long getLength() {
        return _length;
    }

    public boolean isEmpty() {
        return (_head == null);
    }

}
