package Chapters6to8;

import java.util.Arrays;

public class MaxHeap {
  private int[] _array;

  public MaxHeap() {
      _array = null;
  }
  public MaxHeap(int[] array) {
      _array = array.clone();
      _buildMaxHeap();
  }

  private int _parent(int i){
      return (i-1)/2;
  }
  private int _left(int i) {
      return 2*i + 1;
  }
  private int _right(int i) {
      return 2*i + 2;
  }

  private void _maxHeapify(int i) {
      int n = _array.length;
      int left = _left(i);
      int right = _right(i);
      int largest = i;
      if(left < n && _array[left] > _array[largest]) {
          largest = left;
      }
      if(right < n && _array[right] > _array[largest]) {
          largest = right;
      }
      if(largest != i )
      {
          int temp = _array[i];
          _array[i] = _array[largest];
          _array[largest] = temp;
          _maxHeapify(largest);
      }
  }

    private void _buildMaxHeap() {
      for(int i = _array.length/2 - 1; i >= 0; i--) {
          _maxHeapify(i);
      }
    }

    public int[] getHeapSortedArray()
    {
        int[] result = new int[_array.length];
        int[] originalArray = _array.clone();

        for(int i = _array.length - 1; i > -1; i--)
        {
            result[i] = _array[0];
            _array[0] = _array[i];
            _array = Arrays.copyOf(_array, i);
            _maxHeapify(0);
        }
        _array = originalArray;
        return result;
    }
}

