import java.util.Arrays;

public class MergeSort {
    // 我们的算法类不允许产生任何实例
    private MergeSort(){}

    public void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr, 0 , n-1);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private void sort(Comparable[] arr, int l, int r) {

        int mid = (l+r) / 2;
        sort(arr, 0, mid);
        sort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    private void merge(Comparable[] arr, int l, int mid, int r){
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if(i > mid) {
                // 说明i合并了， 把 j的数组直接拷贝到arr里面
                arr[k] = aux[j-l];
                j++;
            } else if(j > r) {
                // 说明j的数组合并完了，开始直接把i的数组拷贝到arr里面
                arr[k] = aux[i-l];
                i++;
            } else if(aux[i-l].compareTo(aux[j-l]) < 0) {
                arr[k] = aux[i-l];
                i++;
            } else {
                arr[k] = aux[j-l];
                j++;
            }
        }

    }
    // 测试MergeSort2
    public static void main(String[] args) {

        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("MergeSort", arr);

        return;
    }
}
