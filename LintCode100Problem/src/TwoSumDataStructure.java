import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

	/*
	* // Version2
    public int twoSum6(int[] nums, int target) {
     if ( nums == null || nums.length < 2 ) {
        return 0;
    }

	int count = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for ( int i = 0; i < nums.length; i++ ) {
        map.put( nums[i], map.getOrDefault(nums[i], 0) +  1);
    }

    for ( int key : map.keySet() ) {
        int diff = target - key;
        if ( (diff == key && map.get(diff) > 1 )
            || ( diff != key && map.containsKey(diff) && key < diff)) {
            count++;
        }
    }
    return count;

    }
	*
	* */
	private List<Integer> list = null;
	private Map<Integer, Integer> map = null;
	public TwoSum(){
		list = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
	}

	public void add(int number){
		if(map.containsKey(number)){
			map.put(number, map.get(number)+1);
		} else {
			map.put(number,1);
			list.add(number);	
		}
	}

	public boolean find(int value){
		for(int i = 0; i < list.size(); i++){
			int num1 = list.get(i);
			int num2 = value - num1;
			if((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))){
				return true;
			}
		}
		return false;
	}
}























