package Chapters1to3;

public class InsertionSort {

    public static int[] Sort(int[] A)
    {
        for(int j = 1; j < A.length; j++)
        {
            int key  = A[j];
            int i = j-1;
            while (i >= 0 && key < A[i]) {
                A[i+1] = A[i];
                i--;
            }
            A[i+1] = key;
        }
        return A;
    }
    public static int[] SortDescending(int[] A)
    {
        for(int j = 1; j < A.length; j++)
        {
            int key  = A[j];
            int i = j-1;
            while (i >= 0 && key > A[i]) {
                A[i+1] = A[i];
                i--;
            }
            A[i+1] = key;
        }
        return A;
    }
     /*
        loop invariants:
        for each iteration of the "for" loop, the sub array A[0 to j-1] is sorted,
        and comprises of the elements A[0], ..., A[j-1].

        proof:
        initialization - on the first iteration, j = 1, and t.f. the sub array A[0 to j-1]
        comprises only of the element A[0]. T.f. the sub array is sorted.
        maintenance - suppose that before an iteration, the sub array A[0 to j-1] is sorted.
        the iteration will move all of the elements greater than the key ( = A[j] ) one index forward
        und then place the key in the gap remaining. thus, the subsequent sub array A[0 to j] is
        sorted.
        termination - the loop terminates when j = A.length, where the array A[0 to A.length - 1] is sorted.
        t.f. A is sorted when the loop terminates.
     */

}
