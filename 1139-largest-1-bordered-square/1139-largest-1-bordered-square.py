class Solution:
    def largest1BorderedSquare(self, grid: List[List[int]]) -> int:
        self.__grid = grid
        h = len(grid)
        w = len(grid[0])
        
        oneCnt = 0
        for y in range(h):
            for x in range(w):
                if grid[y][x] == 0:
                    continue
                oneCnt += 1
        if oneCnt == 0:
            return 0
        
        maxSide = min(h, w)
        result = 0
        isFind = False
        for side in range(maxSide, 1, -1):
            for upperY in range(h - side + 1):
                for leftX in range(w - side + 1):
                    if not self.checkSquare(upperY, leftX, side):
                        continue
                    return side ** 2
        
        return 1
    
    def checkSquare(self, y, x, side):
        return (self.checkWidth(y, x, side) 
                and self.checkWidth(y + side - 1, x, side) 
                and self.checkHeight(y, x, side) 
                and self.checkHeight(y, x + side - 1, side))
    
    def checkWidth(self, y, x, side):
        grid = self.__grid
        for t in range(side):
            if not grid[y][x + t] == 1:
                return False
        return True
    
    def checkHeight(self, y, x, side):
        grid = self.__grid
        for t in range(side):
            if not grid[y + t][x] == 1:
                return False
        return True