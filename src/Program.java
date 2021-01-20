
import Chapters12to14.*;
import Chapters12to14.BinarySearchTree.TreeNode;

public class Program {

    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = {11,4,19,13,5,7,8,1,12,23,4,14};

        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();


        for(int i = 0; i< arr.length; i++) {
           tree.insert(arr[i]);
        }

        System.out.println("In Order tree walk:");
        tree.inOrderTreeWalk(x -> System.out.println(x));
        System.out.println("BF tree walk:");
        tree.breadthFirstTreeWalk(x -> System.out.println(x));

        TreeNode<Integer> node = tree.findFirst(8);

        System.out.println("node found contains: " + node.toString());
        System.out.println("node's successor is: " + tree.getSuccessor(node));
        System.out.println("node's predecessor is: " + tree.getPredecessor(node));

        node = tree.findFirst(1);

        System.out.println("node found contains: " + node.toString());
        System.out.println("node's successor is: " + tree.getSuccessor(node));
        System.out.println("node's predecessor is: " + tree.getPredecessor(node));

        node = tree.findFirst(23);

        System.out.println("node found contains: " + node.toString());
        System.out.println("node's successor is: " + tree.getSuccessor(node));
        System.out.println("node's predecessor is: " + tree.getPredecessor(node));

        node = tree.findFirst(4);

        System.out.println("node found contains: " + node.toString());
        System.out.println("node's successor is: " + tree.getSuccessor(node));
        System.out.println("node's predecessor is: " + tree.getPredecessor(node));

        node = tree.findFirst(13);
        tree.remove(node);
        tree.breadthFirstTreeWalk(x -> System.out.println(x));
        
        System.out.println("----------------------------");
        node = tree.findFirst(8);
        tree.remove(node);
        tree.breadthFirstTreeWalk(x -> System.out.println(x));

        System.out.println("----------------------------");
        node = tree.findFirst(11);
        tree.remove(node);
        tree.breadthFirstTreeWalk(x -> System.out.println(x));

        System.out.println("End");
    }
}
