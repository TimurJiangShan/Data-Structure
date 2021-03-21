public class TwoSum {
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























