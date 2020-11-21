import Chapters1to3.Maman11;
import Chapters6to8.MaxHeap;

public class Program {
    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = {1,4,5,7,8,12,23,4,14};
        MaxHeap heap = new MaxHeap(arr);
        int[] sortedArr = heap.getHeapSortedArray();

        for(int i = 0; i< sortedArr.length; i++) {
            System.out.print(sortedArr[i] + "   ");
        }

    }
}
