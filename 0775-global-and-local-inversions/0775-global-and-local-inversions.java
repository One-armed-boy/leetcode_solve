class Solution {
    public boolean isIdealPermutation(int[] nums) {
        // 배열 뒤에서부터 보면서 각 자리 기준 최소 값 기록한 뒤에 한번만 순회하면 확인 가능 -> O(N)
        var n = nums.length;
        var minList = new int[n];
        var min = n + 1;
        for (int idx = n - 1; idx > -1; idx--) {
            minList[idx] = Math.min(min, nums[idx]);
            min = minList[idx];
        }
        for (int idx = 0; idx < n - 2; idx++) {
            if (nums[idx] > minList[idx + 2]) {
                return false;
            }
        }
        return true;
    }
}