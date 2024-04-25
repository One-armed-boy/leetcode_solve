class Solution:
    def maxWidthOfVerticalArea(self, points: List[List[int]]) -> int:
        xSet = set([x for x, y in points])
        xSortedArr = sorted(list(xSet))
        return max([0] + [xSortedArr[i] - xSortedArr[i - 1] for i in range(1, len(xSortedArr))])