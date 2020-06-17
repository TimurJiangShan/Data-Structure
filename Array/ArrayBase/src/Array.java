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
}
