import Chapters1to3.Maman11;
import Chapters6to8.MaxHeap;
import Chapters6to8.QuickSort;

public class Program {
    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = {11,4,19,13,5,7,8,1,12,23,4,14};
        MaxHeap heap = new MaxHeap(arr);
        int[] sortedArr = heap.getHeapSortedArray();

        for(int i = 0; i< sortedArr.length; i++) {
            System.out.print(sortedArr[i] + "   ");
        }
        sortedArr = QuickSort.QuickSort(arr);

        for(int i = 0; i< sortedArr.length; i++) {
            System.out.print(sortedArr[i] + "   ");
        }
    }
}
