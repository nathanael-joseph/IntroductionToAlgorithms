package Chapters6to8;

public class QuickSort {
    public static int[] QuickSort(int[] arr) {
        return _quickSort(arr, 0, arr.length-1);
    }

    private static int[] _quickSort(int[] arr, int p, int r) {
        if( p < r )
        {
            int q = _partition(arr, p, r);
            _quickSort(arr, p, q-1);
            _quickSort(arr, q+1, r);
        }
        return arr;
    }
    private static int _partition(int[] arr, int p, int r) {
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
