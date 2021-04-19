public class NumberofSubstringswithAllZeroes {
    public int stringCount(String str) {

        int answer = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count += 1;
            }else {
                answer += (1 + count) * count / 2;
                count = 0;
            }
        }
        if (count != 0) {
            answer += (1 + count) * count / 2;
        }

        return answer;
    }
}
