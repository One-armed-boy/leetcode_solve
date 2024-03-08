class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        n = len(s)
        costs = [abs(ord(s[i]) - ord(t[i])) for i in range(n)]

        result = 0
        end = 0
        partSum = 0
        for start in range(n):
            while end < n and partSum + costs[end] <= maxCost:
                partSum += costs[end]
                end += 1
            result = max(result, end - start)
            partSum -= costs[start]
        return result
        