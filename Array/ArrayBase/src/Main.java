public class Main {
    public static void main(String[] args){

        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 10; i ++) {
            arr.addList(i);
        }
        // println(arr) 就会调用自己写的那个toString() 方法
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);
    }
}