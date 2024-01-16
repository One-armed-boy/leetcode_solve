class Solution {
    int[][] memo;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        memo = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int y = 0; y < obstacleGrid.length; y++) {
            for (int x = 0; x < obstacleGrid[0].length; x++) {
                memo[y][x] = -1;
            }
        }

        memo[0][0] = 1;
        
        return dp(obstacleGrid.length - 1, obstacleGrid[0].length - 1, obstacleGrid);
    }
    
    private int dp(int y, int x, int[][] obs) {
        if (obs[y][x] == 1) {
            memo[y][x] = 0;
            return memo[y][x];
        }
        
        if (y == 0 && x == 0) {
            return memo[0][0];
        }

        if (memo[y][x] != -1) {
            return memo[y][x];
        }
        
        if (y == 0) {
            memo[y][x] = dp(y, x - 1, obs);
            return memo[y][x];
        }
        
        if (x == 0) {
            memo[y][x] = dp(y - 1, x, obs);
            return memo[y][x];
        }
        
        memo[y][x] = dp(y - 1, x, obs) + dp(y, x - 1, obs);
        return memo[y][x];
    }
}