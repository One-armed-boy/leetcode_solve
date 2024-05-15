class Solution:
    def canSortArray(self, nums: List[int]) -> bool:
        expandNums = [(num, self.countBit(num)) for num in nums]

        # [비트 수, 최소, 최대]
        summary = []

        for i in range(len(nums)):
            num, bitCount = expandNums[i]
            if len(summary) == 0 or summary[-1][0] != bitCount:
                summary.append([bitCount, num, num])
                continue
            summary[-1][1] = min(summary[-1][1], num)
            summary[-1][2] = max(summary[-1][2], num)

        for i in range(len(summary) - 1):
            if summary[i][2] > summary[i + 1][1]:
                return False
        return True
    
    def countBit(self, num):
        return bin(num)[2:].count("1")