import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    /*
    * 给出一个包含大小写字母的字符串。求出由这些字母构成的最长的回文串的长度是多少。
      数据是大小写敏感的，也就是说，"Aa" 并不会被认为是一个回文串。
      *
      *
      * 逆向思维无需计数 用集合来玩对对碰，遇到一对就消除，
      * 最后集合只剩下落单的 原字符串中剔除落单的数量就全是成双成对的
      * 唯一需要注意的是，回文有两种模式，xxxaxxx和xxxaaxxx，
      * 第二种情况不用多说 判断是否是第一种情况就看有没有落单的，
      * 有的话就取一个放进成双成对的里面
    * */
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }

        int remove = set.size();
        if (remove > 0) {
            remove -= 1;
        }

        return s.length() - remove;

    }
}

// a,
// a,b
// a,b,c
// a,b,c
// a,b,d,
// a,b

// remove = 2;
// remove : 1
//
