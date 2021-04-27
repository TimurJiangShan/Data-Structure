public class AlphabeticStringCalculation {
    public int Kstart(String aString) {
        int[] arr = new int[26];
        for (char c : aString.toCharArray()) {
            arr[c - 'a']++;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            max = Math.max(max, i);
        }

        int res = 0;
        for (int i = max; i > 0; i--) {
            int n = map.getOrDefault(i, 0);
            if (n > 1) {
                res += n - 1;
                int next = i - 1;
                int nextNum = n - 1;
                map.put(next, map.getOrDefault(next, 0) + nextNum);
            }
        }

        return res;
    }

}

