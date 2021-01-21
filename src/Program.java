
import Chapters12to14.*;
import Chapters12to14.BinarySearchTree.TreeNode;

public class Program {

    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = {11,4,19,13,5,7,8,1,12,23,4,14};

        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();


        for(int i = 0; i< arr.length; i++) {
           tree.insert(arr[i]);
        }

        System.out.println("In Order tree walk:");
        tree.inOrderTreeWalk(x -> System.out.println(x));
        System.out.println("BF tree walk:");
        tree.breadthFirstTreeWalk(x -> System.out.println(x));


        System.out.println("End");
    }
}
