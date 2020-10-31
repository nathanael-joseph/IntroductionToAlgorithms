package Chapter1;

public class BinaryAddition {
    /*
    A and B are int arrays, both of length n, containing only 0s and 1s.
    We consider A[n-1], B[n-1], and C[n-1] to be the least important bits.

    The function must return an int array C, of length n+1, s.t. C is the binary value of A + B.
     */
    public static int[] Add(int[] A, int[] B)
    {
        int n = A.length;
        int[] C = new int[n+1];
        int i = n-1;
        int carry = 0;
        while (i > 0)
        {
            C[i+1] = (A[i] + B[i] + carry) % 2;
            carry = (A[i] + B[i] + carry) > 1 ? 1 : 0;
            i--;
        }
        C[i] = carry;

        return C;
    }
}
