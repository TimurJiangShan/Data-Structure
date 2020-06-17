public class Array {

    private int[] data;
    private int size;

    /**
     * @param capacity
     * */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
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

        // 从后往前添加元素，
        for (int i = size; i > index; i--){
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;

    }

    /**
     * Get position of index element
     * */

    public int get(int index){
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Illegal index");
        }

        return data[index];
    }

    public void set(int index, int e) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Illegal index");
        }

        data[index] = e;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1) {
                res.append(", ");
            } else {
                res.append("]");
            }
        }
        return res.toString();
    }
}
