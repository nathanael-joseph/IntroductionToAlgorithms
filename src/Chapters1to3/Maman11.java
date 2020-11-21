package Chapters1to3;

public class Maman11 {
    public static void Sieve(int n) {
        int[] A = new int[n];
        A[0] = 0; A[1] = 0;
        for (int i = 2; i < n; i++) {
            A[i] = 1;
        }

        int mult = 2;
        for(int i = 2; i < n; i++) {
            if(A[i] == 1) {
                for (mult = 2; mult <= (n-1)/i; mult++) {
                    A[i*mult] = 0;
                }
            }
        }

        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}
