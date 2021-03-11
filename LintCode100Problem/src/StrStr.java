public class StrStr {
    public int strStr(String source, String target) {
        if (source == null || target == null)
            return -1;

        for (int i = 0; i < source.length() - target.length() + 1;i++) {
            int j = 0; // 在这里定义j，后面的for循环里面的j会覆盖这个j吗？？
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i+j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }

        return -1;
    }

}
