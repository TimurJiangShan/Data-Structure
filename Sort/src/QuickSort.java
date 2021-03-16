public class QuickSort {
    public void sortIntegers(int[] A){
        if(A == null || A.length == 0) {
            return;
        }

        quickSort(A, 0, A.length-1);

    }

    private void quickSort(int[] A, int start, int end){
        if (start >= end) {
            return;
        }

        /*
        * 1. left和right, if the statement is left < right rather than left <= right,
        * the scenario will be:
        * quickSort(A,0,1) {
        *   ...
        *   quickSort(0,0);
        *   quickSort(0,1);
        * }
        * the final result is stackoverflow
        *
        * 2. The pivot is the value, not the index(Pivot的是值，不是index，因为交换后值会变)
        *
        * 3. 左边右边要尽可能的均分，比如：数组A全部都是1
        * if A[left] <= pivot, 最后还是死循环
        * */
        int left = start, right = end;
        int pivot = A[(start + end)/2];
        while (left <= right) {
            while(left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if(left <= right) {
                int temp = A[right];
                A[right] = A[left];
                A[left] = temp;
                left++;
                right--;
            }
        }

        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}

