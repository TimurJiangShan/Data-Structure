public class Fibonacci {
    /*
    * 将计算出的结果存储下来，在计算到指定值的时候，先判断这个值是否已经计算过，若没有，才进行计算，
    * 否则读取已经存储下来的值。这样就把一个指数级复杂度变成了线性复杂度，代价是空间复杂度从常数级上升至线性级。
    * 时间复杂度为O(n)，空间复杂度为O(n)。
    * */
    int dfs(int n, int[] fib){
        if(fib[n] != -1) {
            return fib[n];
        }

        if(n <= 2) {
            fib[n] = n-1;
            return fib[n];
        }

        fib[n] = dfs(n-1, fib) + dfs(n-2, fib);
        return fib[n];
    }

    public int fibonacci(int n){
        int[] result = new int[n+1];
        for(int i = 0; i < n+1; i++){
            result[i] = -1;
        }

        dfs(n,result);

        return result[n];
    }

}
