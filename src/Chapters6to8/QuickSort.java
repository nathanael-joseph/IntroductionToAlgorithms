package Chapters6to8;

public class QuickSort {
    public static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length-1);
    }

    private static int[] quickSort(int[] arr, int p, int r) {
        if( p < r )
        {
            int q = partition(arr, p, r);
            quickSort(arr, p, q-1);
            quickSort(arr, q+1, r);
        }
        return arr;
    }
    private static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p-1;
        for(int j = p; j < r; j++) {
            if(arr[j] <= x)
            {
                i++;
                if( i != j)
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        i++;
        if( i  != r)
        {
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
        return i;
    }
}
