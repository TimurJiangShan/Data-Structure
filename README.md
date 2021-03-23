# Data-Structure
**LeetCode**
* 常用数据结构以及复杂度
  
   O(1)	位运算	常数级复杂度，一般面试中不会有 <br/>
   O(logn)	二分法，倍增法，快速幂算法，辗转相除法 <br/>
   O(n)	枚举法，双指针算法，单调栈算法，KMP算法，Rabin Karp，Manacher's Algorithm	又称作线性时间复杂度 <br/>
   O(nlogn)	快速排序，归并排序，堆排序 <br/>
   O(n^2)	枚举法，动态规划，Dijkstra <br/>
   O(n^3)	枚举法，动态规划，Floyd <br/>
   O(2^n)	与组合有关的搜索问题 <br/>
   O(n!)	与排列有关的搜索问题 <br/>
  
* 递归一定会耗费的空间包括

1. 参数列表(参数有多少个字节，往下递归每一次就会开辟多少个字节用于存储)
2. Return的Value
3. 中间产生的局部变量
</br>
* 递归三要素
1. 函数接受什么样的参数，返回样的值，代表什么意思
2. 递归的拆解(一个大问题如何拆解为若干个小问题去解决)
3. 递归的出口(什么时候可以直接知道答案，不用再拆解，直接 return)

