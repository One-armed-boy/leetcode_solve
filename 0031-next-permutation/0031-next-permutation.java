class Solution {
    public void nextPermutation(int[] nums) {
        int baseIdx = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                baseIdx = i-1;
                break;
            }
        }
        
        if (baseIdx == -1) {
            Arrays.sort(nums);
            return;
        }
        
        int swapTargetIdx = baseIdx;
        int minMaxValueAfterBaseIdx = 101;
        
        
        for (int i = baseIdx + 1; i < nums.length; i++) {
            if (nums[baseIdx] < nums[i] && nums[i] < minMaxValueAfterBaseIdx) {
                swapTargetIdx = i;
                minMaxValueAfterBaseIdx = nums[i];
            }
        }
        swap(nums, baseIdx, swapTargetIdx);
        Arrays.sort(nums, baseIdx+1, nums.length);
    }
    
    private void swap(int[] nums, int idxA, int idxB) {
        int a = nums[idxA];
        int b = nums[idxB];
        nums[idxA] = b;
        nums[idxB] = a;
    }
}