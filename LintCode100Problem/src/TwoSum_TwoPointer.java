import java.util.Arrays;

public class TwoSum_TwoPointer {
    class Pair implements Comparable<Pair> {
        int number, index;
        @Override
        public int compareTo(Pair other) {
            return number - other.number;
        }

        public Pair(int number, int index){
            this.number = number;
            this.index = index;
        }
    }

    private Pair[] getSortedPairs(int[] numbers){
        Pair[] pairs = new Pair[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            pairs[i] = new Pair(numbers[i], i);
        }

        Arrays.sort(pairs);
        return pairs;
    }

    public int[] twoSum(int[] number, int target){
        int[] result = {-1, -1};
        if (number == null) {
            return result;
        }

        Pair[] pairs = getSortedPairs(number);
        int left = 0, right = number.length - 1;
        while (left < right) {
            if (pairs[left].number + pairs[right].number < target) {
                left++;
            } else if (pairs[left].number + pairs[right].number > target) {
                right--;
            } else {
                result[0] = Math.min(pairs[left].index, pairs[right].index);
                result[1] = Math.max(pairs[left].index, pairs[right].index);
                return result;
            }
        }

        return result;
    }
}
