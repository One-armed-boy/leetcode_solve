class Solution:
    def countAlternatingSubarrays(self, nums: List[int]) -> int:
        result = 0
        partialStart = 0

        n = len(nums)
        for idx in range(n):
            if idx > 0 and nums[idx] == nums[idx - 1]:
                result += self.oneToNSum(idx - partialStart)
                partialStart = idx

        result += self.oneToNSum(n - partialStart)

        return result

    def oneToNSum(self, n):
        return (n + 1) * n // 2