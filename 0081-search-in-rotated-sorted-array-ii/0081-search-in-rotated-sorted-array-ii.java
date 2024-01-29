class Solution {
    public boolean search(int[] nums, int target) {
        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] == target) {
                return true;
            }
        }
        return false;
    }
}