public class Array {

    private int[] data;
    private int size;

    /**
     * @param capacity
     * */
    public Array(int capacity) {
        data = new int[capacity];
    }

    // No para
    public Array(){
        this(10);
    }

    /**
     * Get current number of elements
     * */
    public int getSize(){
        return size;
    }

    /**
     * Get Maximum number of array
     * */
    public int getCapacity(){
        return data.length;
    }

    /**
     * Null Check
     * */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Add new element in the last position
     * */
    public void addList(int e) {

        add(size, e);
    }

    /**
     * Add new element in the first position
     * */

    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * Add new element in a specific position
     * */

    public void add(int index, int e) {

        if(index == data.length) {
            throw new IllegalArgumentException("Add failed, array is full");
        }

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed, index should > 0 and < size");
        }

        for (int i = size; i > index; i--){
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;



    }
}
