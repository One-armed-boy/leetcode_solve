class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        n = len(nums)
        nums.sort()

        stack = []
        result = 0
        for i in range(n):
            num = nums[i]
            if len(stack) == 0:
                stack.append(num)
                continue
            last = stack[-1]
            if num <= last:
                diff = last - num + 1
                num += diff
                result += diff
            stack.append(num)
        return result
        # 1 2 