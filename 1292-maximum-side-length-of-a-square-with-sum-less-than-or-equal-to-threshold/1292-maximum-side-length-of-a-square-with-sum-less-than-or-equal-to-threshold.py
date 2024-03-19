class Solution:
    def maxSideLength(self, mat: List[List[int]], threshold: int) -> int:
        m = len(mat)
        n = len(mat[0])

        minElement = 10000 + 1
        for _ in range(m):
            minElement = min(minElement, min([mat[_][i] for i in range(n)]))
        
        if minElement > threshold:
            return 0
        
        maxSide = 1
        
        for y in range(m):
            if m < y + maxSide:
                break
            for x in range(n):
                if n < x + maxSide:
                    break
                currSide = maxSide
                currSum = 0
                while m >= y + currSide and n >= x + currSide:
                    currSum = self.squareSum(mat, x, y, currSide)
                    if currSum > threshold:
                        break
                    maxSide = max(maxSide, currSide)
                    currSide += 1

        return maxSide
    
    def squareSum(self, matrix, leftUpperX, leftUpperY, side):
        result = 0
        for y in range(side):
            result += sum(matrix[leftUpperY + y][leftUpperX: leftUpperX + side])
        return result
