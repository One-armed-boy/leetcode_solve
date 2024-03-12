import heapq

class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        maxHeap = []
        minHeap = []

        for idx in range(len(nums)):
            heapq.heappush(maxHeap, (-nums[idx], idx))

        for _ in range(k):
            minusValue, idx = heapq.heappop(maxHeap)
            heapq.heappush(minHeap, (idx, -minusValue))
        
        result = []
        while len(minHeap):
            idx, value = heapq.heappop(minHeap)
            result.append(value)
        return result
