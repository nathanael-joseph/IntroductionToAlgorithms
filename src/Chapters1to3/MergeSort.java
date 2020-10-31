package Chapters1to3;

public class MergeSort {
    public static void Sort(int[] A)
    {
        int q = A.length - 1;
        Sort(A, 0, q);
    }

    private static void Sort(int[] A, int p, int q)
    {
        if ( p == q)
            return;
        int leftLength = (q - p + 1) / 2;
        // sort left side
        Sort(A, p, p + leftLength - 1);
        // sort right side
        Sort(A, p + leftLength, q);

        Merge(A, p, p + leftLength - 1, q);

        return;
    }

    private static void Merge(int[] A, int p, int q, int r)
    {
        // p <= q < r
        int n1 = q - p + 1; // length of left array A[p to q]
        int n2 = r - q; // length of right array A[q+1 to r]

        int[] left = new int[n1];
        int[] right = new int[n2];

        // copy left and right sides of A to their own arrays.
        for ( int i = 0; i < n1; i++)
            left[i] = A[p+i];
        for ( int i = 0; i < n2; i++)
            right[i] = A[q + 1 + i];

        // li = left index, ri - right index, k main index for A.
        int li = 0; int ri =0;
        // merge loop
        for (int k = 0; k < n1 + n2; k++)
        {
            if (li < n1 && ri < n2)
            {
                if (left[li] <= right[ri])
                {
                    A[p + k] = left[li];
                    li++;
                }
                else
                {
                    A[p + k] = right[ri];
                    ri++;
                }
            }
            else if ( li < n1 )
            {
                A[p + k] = left[li];
                li++;
            }
            else
            {
                A[p + k] = right[ri];
                ri++;
            }
        }
    }

    /*
     Loop Invariant - Prior to each iteration of the merge lop, the sub array A[p ... p + k - 1]
     is sorted and contains the k-1 lowest numbers from left[0 ... n1 - 1] and  right[0 ... n2 - 1]

     Initialisation - before the first iteration, k = 0, and t.f. the sub array A[p ... p+k-1] is empty
     so it is sorted trivially, and contains 0 elements from left and right arrays.

     Maintenance - at iteration k, the lowest element between left[li] and right[ri] is the lowest
     element from left[0 ... n1 - 1] and  right[0 ... n2 - 1] still not copied to A[p ... p + k - 1].
     The element is copied and then the corresponding index is increased (either li or ri). so at the end of
     the iteration, A[p ... p+k] contains the k-1 lowest numbers from left[0 ... n1 - 1] and
      right[0 ... n2 - 1] in ascending order.

     Termination - the merge loop terminates when k = n1 + n2 + 1, so the sub array A[p ... p + k - 1]
     contains n1 + n2 elements from left and right arrays sorted in ascending order.

     */

}
