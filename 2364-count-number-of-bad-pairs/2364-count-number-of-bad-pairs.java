class Solution {
    public long countBadPairs(int[] nums) {
        long result = combi(nums.length);
        HashMap<Integer, Integer> map = new HashMap<>();
        // 0 : 2 -> 1
        // 1 : 1 -> 0
        // 4 : 1 -> 0
        // 4C2 = 6
        // 6 - 1
        // 4, 0, 1, 0
        for (int i = 0; i < nums.length; i++) {
            var num =  nums[i] - i;
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.replace(num, map.get(num) + 1);
        }

        for (var value: map.values()) {
            if (value <= 1) {
                continue;
            }
            result -= combi(value);
        }

        return result;
    }

    private long combi(long num) {
        return (long) (num * (num - 1)) / 2;
    }
}