import java.util.HashMap;

public class TwoSum {
    // Key记录target - number[i], Value是i
    // 如果number[j] 存在于Map中，就返回[i, j]
    public int[] twoSum(int[] numbers, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < numbers.length; i++){
            if(map.get(numbers[i]) != null) {
                int[] result = { map.get(numbers[i]), i };
                return result;
            }

            map.put(target - numbers[i], i);
        }

        int[] result = {};
        return result;
    }
}
