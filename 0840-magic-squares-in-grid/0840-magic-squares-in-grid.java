class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        // row: 높이, col: 밑변
        int row = grid.length;
        int col = grid[0].length;
        if (row < 3 || col < 3) {
            return 0;
        }
        int result = 0;
        for (int y = 0; y <= row - 3; y++) {
            for (int x = 0; x <= col - 3; x++) {
                if (isMagicSquare(grid, y, x)) {
                    result += 1;
                }
            }
        }
        return result;
    }
    
    private boolean isMagicSquare(int[][] grid, int y, int x) {
        if (isIncludeOneToNine(grid, y, x) == false) {
            return false;
        }
        int sumForCompare = sum(grid[y][x], grid[y+1][x+1], grid[y+2][x+2]);
        if (sumForCompare != sum(grid[y+2][x], grid[y+1][x+1], grid[y][x+2])) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (sumForCompare != sum(grid[y+i][x], grid[y+i][x+1], grid[y+i][x+2])) {
                return false;
            }
            if (sumForCompare != sum(grid[y][x+i], grid[y+1][x+i], grid[y+2][x+i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isIncludeOneToNine(int[][] grid, int y, int x) {
        boolean[] isIncludes = new boolean[9];
        for (int dy = 0; dy < 3; dy++) {
            for (int dx = 0; dx < 3; dx++) {
                int num = grid[y+dy][x+dx];
                if (num > 9 || num < 1) {
                    return false;
                }
                isIncludes[num - 1] = true;
            }
        }

        for (boolean isInclude: isIncludes) {
            if (isInclude == false) {
                return false;
            }
        }
        return true;
    }

    private int sum(int ...nums) {
        return Arrays.stream(nums).sum();
    }
}