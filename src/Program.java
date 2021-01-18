import Chapters1to3.Maman11;
import Chapters6to8.MaxHeap;
import Chapters6to8.QuickSort;
import Chapters12to14.*;

public class Program {

    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = {11,4,19,13,5,7,8,1,12,23,4,14};

        BinaryTree<Integer> tree = new BinaryTree<Integer>();


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
