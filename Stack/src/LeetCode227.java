import java.util.*;

class LeetCode227 {
    private Stack<Integer> stk;
    // 记录算式中的数字
    private int num;
    // 记录 num 前的符号，初始化为 +
    private char sign;

    public LeetCode227(){
        stk = new Stack<Integer>() {
            @Override
            public int getSize() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void push(Integer integer) {

            }

            @Override
            public Integer pop() {
                return null;
            }

            @Override
            public Integer peek() {
                return null;
            }
        };
        num = 0;
        sign = '+';
    }

    public int calculate(String s) {
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是数字，连续读取到 num
            if(Character.isDigit(s.charAt(i))) {
                num = num * 10 + (c - '0');
            }

            // 如果不是数字，就是遇到了下一个符号，
            // 之前的数字和符号就要存进栈中
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1) {
                int prevNum = 0;
                switch(sign) {
                    case '+':
                        stk.push(num);
                        break;

                    case '-':
                        stk.push(-num);
                        break;

                    // 只要拿出前一个数字做对应运算即可    
                    case '*':
                        prevNum = stk.peek();
                        stk.pop();
                        num = prevNum * num;
                        stk.push(num);
                        break;

                    // 只要拿出前一个数字做对应运算即可
                    case '/':
                        prevNum = stk.peek();
                        stk.pop();
                        num = prevNum / num;
                        stk.push(num);
                        break;
                }

                // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }
        }

        // 将栈中所有结果求和就是答案
        int result = 0;
        while(!stk.isEmpty()) {
            result += stk.peek();
            stk.pop();
        }
        return result;
    }


}