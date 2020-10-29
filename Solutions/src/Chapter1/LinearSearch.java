package Chapter1;

public class LinearSearch {
    public int Search(int[] A, int v)
    {
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] == v) {
                return i;
            }
        }

        return -1;
    }
}

/*
Loop invariants

 */
