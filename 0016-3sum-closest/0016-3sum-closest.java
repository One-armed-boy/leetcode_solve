class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 500 X 500 X 500 = 125 * 10^6 ~= 10^8
        int n = nums.length;
        int minGap = Integer.MAX_VALUE;
        int result = 0;
        for (int a = 0; a < n - 2; a++) {
            for (int b = a + 1; b < n - 1; b++) {
                for (int c = b + 1; c < n; c++) {
                    int sumOfThree = nums[a] + nums[b] + nums[c];
                    int gap = Math.abs(target - sumOfThree);
                    if (minGap <= gap) {
                        continue;
                    }
                    minGap = gap;
                    result = sumOfThree;
                }
            }
        }
        return result;
    }
}