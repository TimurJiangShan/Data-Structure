public class SubarraySumEquals {
    public int subarraySumEqualsKII(int[] nums, int k) {
        // write your code here
        int prefixSum = 0;
        int rt = Integer.MAX_VALUE;

        // prefixSum - index
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // 这一行和 21到24是可以替换的
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++)
        {
            prefixSum = prefixSum + nums[i];
            //if (prefixSum == k)
            //{
            //    rt = Math.min(rt, i+1);
            //}

            int tmp = prefixSum - k;
            if (map.containsKey(tmp))
            {
                int index = map.get(tmp) + 1;
                rt = Math.min(rt, i - index + 1);
            }

            // 因为要找最短的，并且是在循环nums，所以prefixSum一样的情况下，后面的总是会更短，所以anyway，更新或者插入新的prefixSum <->i 就对了
            map.put(prefixSum, i);
        }

        if (rt == Integer.MAX_VALUE)
        {
            return -1;
        }
        return rt;

    }
}
