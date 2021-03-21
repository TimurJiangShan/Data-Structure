public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */

    private ArrayList<Integer> arrayList;
    public TwoSum(){
        this.arrayList = new ArrayList<Integer>();
    }
    public void add(int number) {
        // write your code here
        arrayList.add(number);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */

    public boolean find(int value) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < this.arrayList.size(); i++){
            if(map.get(this.arrayList.get(i)) == null) {
                map.put(value - this.arrayList.get(i), i);
            } else {
                return true;
            }

        }
        return false;
    }
}