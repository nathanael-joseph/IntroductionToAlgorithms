import Chapters1to3.MergeSort;

public class Program {
    public static void main(String[] args) {
        System.out.println("hello world");

        int[] A = {4,5,8,6,5,8,2,12,46};
        MergeSort.Sort(A);
        for(int n : A)
            System.out.print(n + " ");
    }
}
