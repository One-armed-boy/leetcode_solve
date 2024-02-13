class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return (long) nums[0] << k;
        }
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int idx = 1; idx < n; idx++) {
            prefix[idx] = prefix[idx - 1] | (long) nums[idx];
        }
        long[] suffix = new long[n];
        suffix[n - 1] = nums[n - 1];
        for (int idx = n - 2; idx > -1; idx--) {
            suffix[idx] = suffix[idx + 1] | (long) nums[idx];
        }

        long result = Math.max(prefix[n - 2] | ((long)nums[n - 1] << k), ((long)nums[0] << k) | suffix[1]);
        for (int idx = 1; idx < nums.length - 1; idx++) {
            result = Math.max(result, prefix[idx - 1] | ((long)nums[idx] << k) | suffix[idx + 1]);
        }

        return result;
    }
}