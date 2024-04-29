import math

class Solution:
    def longestSquareStreak(self, nums: List[int]) -> int:
        self.numSet = set(nums)
        self.memo = {num: -1 for num in nums}
        result = max([self.dp(num) for num in nums])
        return -1 if result < 2 else result

    def dp(self, num):
        if self.memo[num] != -1:
            return self.memo[num]

        tmp = math.sqrt(num)
        intTmp = int(tmp)
        if intTmp != tmp or (intTmp not in self.numSet):
            self.memo[num] = 1
            return self.memo[num]

        self.memo[num] = 1 + self.dp(intTmp)
        return self.memo[num]