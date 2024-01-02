class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        PriorityQueue<List<Integer>> pQueue = new PriorityQueue<>(
            (a,b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1))
        );
        
        for (int idx1 = 0; idx1 < Math.min(nums1.length, k); idx1++) {
            pQueue.offer(
                    List.of(nums1[idx1], nums2[0], 0)
                );
        }
        
        while (result.size() < k && !pQueue.isEmpty()) {
            List<Integer> tmp = pQueue.poll();
            result.add(List.of(tmp.get(0), tmp.get(1)));
            
            int nextNum2Idx = tmp.get(2) + 1;
            if (nextNum2Idx < nums2.length) {
                pQueue.offer(
                    List.of(tmp.get(0), nums2[nextNum2Idx], nextNum2Idx)
                );
            }
        }
        
        return result;
    }
}