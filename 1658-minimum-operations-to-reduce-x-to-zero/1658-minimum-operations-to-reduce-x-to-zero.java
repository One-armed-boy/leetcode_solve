class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        
        if (sum == x) {
            return nums.length;
        }
        
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        // 이후 반복문의 조건식에서 배열의 시작부터 이어지는 부분합의 크기가 필요한 경우 
        // 이에 대한 길이 계산용으로 필요
        prefixSumMap.put(0, -1);
        int prefixSum = 0;
        
        int res = -1;
        
        for (int idx = 0; idx < nums.length; idx++) {
            prefixSum += nums[idx];
            if (prefixSumMap.containsKey(prefixSum - sum + x)) {
                res = Math.max(res, idx - prefixSumMap.get(prefixSum - sum + x));   
            }
            prefixSumMap.put(prefixSum, idx);
        }
        
        return res == -1 ? -1 : nums.length - res;
    }
}