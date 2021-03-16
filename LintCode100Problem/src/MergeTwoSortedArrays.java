public class MergeTwoSortedArrays {
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if(A == null || B == null) return null;
        int[] result = new int[A.length+B.length];
        int i = 0, j = 0, t= 0;
        while(i <= A.length-1 && j <= B.length-1){
            if(A[i] <= B[j]) {
                result[t] = A[i];
                t++;
                i++;
            } else {
                result[t] = B[j];
                t++;
                j++;
            }
        }

        if(i >= A.length) {
            while(j < B.length) {
                result[t++] = B[j++];
            }
        }

        if(j >= B.length){
            while(i < A.length){
                result[t++] = A[i++];
            }
        }

        return result;
    }
}
