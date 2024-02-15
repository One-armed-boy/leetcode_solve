class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> a - b);

        for (var num: nums) {
            pQueue.offer(num);
        }

        for (int i = 0; i < k; i++) {
            var smallestNum = pQueue.poll();
            pQueue.offer(smallestNum + 1);
        }

        long result = 1L;
        int mod = 1000000007;
        
        while (!pQueue.isEmpty()) {
            result = (result * pQueue.poll()) % mod;
        }
        return (int)result;
    }
}