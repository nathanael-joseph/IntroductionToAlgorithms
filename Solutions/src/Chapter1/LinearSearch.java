package Chapter1;

public class LinearSearch {
    public static int Search(int[] A, int v)
    {
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] == v) {
                return i;
            }
        }

        return -1;
    }

    /*
    Loop Invariant
    For every iteration i, there exists no k < i such that A[i] = v.
    This is trivial for the first iteration.
    At any given iteration, if A[i] = v, the function ends and the value of i is returned.
    T.f. if the return statement on line 13 is reached, there exists no value i < A.length
    s.t. A[i] = v, and so the function is correct.

     */
}

