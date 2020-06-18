import java.util.Objects;

public class Array<E> {

    private E[] data;
    private int size;

    /**
     * @param capacity
     * */
    public Array(int capacity) {
        // 这里需要强制类型转换一下
        data = (E[])new Object[capacity];
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
     * Check whether the element e is in the data
     * */

    public boolean contains(E e){
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find the index of a specific element
     * */

    public int find(E e) {
        for(int i = 0; i < size; i++){
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Add new element in the last position
     * */
    public void addList(E e) {

        add(size, e);
    }

    /**
     * Add new element in the first position
     * */

    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * Remove a specific element and return it.
     * */

    public E remove(int index){
        if(index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Index should be valid");
        }

        E res = data[index];
        for (int i = index; i < size - 1; i++){
            data[i] = data[i+1];
        }
        size--;
        data[size] = null; // loitering objects != memory leak

        // 这里有均摊复杂度的考量
        if (size <= data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }

        return res;

    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        remove(find(e));
    }
    /**
     * Add new element in a specific position
     * */

    public void add(int index, E e) {



        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed, index should > 0 and < size");
        }

        if(size == data.length) {
            resize(2 * data.length);
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

    public E get(int index){
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Illegal index");
        }

        return data[index];
    }

    public void set(int index, E e) {
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

    private void resize(int newCapacity){
        E[] newData  = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
