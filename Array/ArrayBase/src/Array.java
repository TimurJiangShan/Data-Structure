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

        if(size == data.length) {
            throw new IllegalArgumentException("AddLast failed");
        }
        data[size] = e;
        size++;
    }
}
