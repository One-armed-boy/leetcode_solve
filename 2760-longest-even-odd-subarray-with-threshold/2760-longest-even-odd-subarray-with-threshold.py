class Solution:
    def longestAlternatingSubarray(self, nums: List[int], threshold: int) -> int:
        n = len(nums)

        l = 0
        r = 0
        result = 0

        while l <= r and l < n and r < n:
            if self.isOdd(nums[l]) or nums[l] > threshold:
                l += 1
                r = l
                continue
            result = max(result, r - l + 1)
            if r + 1 >= n:
                break
            if self.isOdd(nums[r]) == self.isOdd(nums[r + 1]):
                l += 1
                r = l
                continue
            if nums[r + 1] > threshold:
                l += 2
                r = l
                continue
            r += 1

        return result
    
    def isOdd(self, num):
        return num % 2 != 0