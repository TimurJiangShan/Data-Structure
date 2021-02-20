import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        int N = 50000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);

        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);


        SortTestHelper.testSort("MergeSort", arr3);

        System.out.println();
    }
}
