import Chapter1.MergeSort;

import java.util.Scanner;

public class Program {
    public static void main(String[] args)
    {
        System.out.println("hello world!");
        Scanner scanner = new Scanner(System.in);

        int[] A = {4,5,12,8,9,3,2};
        MergeSort.Sort(A);

        for(int number : A)
            System.out.print(number + " ");
        scanner.nextLine();


    }
}
