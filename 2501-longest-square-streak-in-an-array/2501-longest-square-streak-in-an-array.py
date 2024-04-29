import math

class Solution:
    def longestSquareStreak(self, nums: List[int]) -> int:
        self.numSet = set(nums)
        self.memo = {num: -1 for num in nums}
        nums.sort()
        result = max([self.dp(num) for num in nums])
        return -1 if result < 2 else result

    def dp(self, num):
        if self.memo[num] != -1:
            return self.memo[num]

        tmp = math.sqrt(num)
        if int(tmp) != tmp or (int(tmp) not in self.memo):
            self.memo[num] = 1
            return self.memo[num]

        self.memo[num] = 1 + self.dp(int(tmp))
        return self.memo[num]