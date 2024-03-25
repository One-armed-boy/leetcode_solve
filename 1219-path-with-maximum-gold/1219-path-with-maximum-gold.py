class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])

        result = 0

        for y in range(n):
            for x in range(m):
                searcher = DfsSearcher(grid)
                result = max(result, searcher.dfs(y, x))

        return result
    
class DfsSearcher:
        def __init__(self, grid):
            self.__n = len(grid)
            self.__m = len(grid[0])
            self.__grid = grid
            self.__dx = [0, 0, 1, -1]
            self.__dy = [1, -1, 0 , 0]

        def dfs(self, y, x):
            if self.__grid[y][x] == 0:
                return 0
            tmp = self.__grid[y][x]
            self.__grid[y][x] = 0 
            maxValue = 0
            for i in range(4):
                nextY = y + self.__dy[i]
                nextX = x + self.__dx[i]
                if (0 <= nextY < self.__n and 0 <= nextX < self.__m and self.__grid[nextY][nextX] > 0):
                    maxValue = max(maxValue, self.dfs(nextY, nextX))
                
            self.__grid[y][x] = tmp
            return tmp + maxValue
            


