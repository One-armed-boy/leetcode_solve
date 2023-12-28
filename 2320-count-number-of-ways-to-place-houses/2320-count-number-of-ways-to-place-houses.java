class Solution {
    public int countHousePlacements(int n) {
        long[][] memo = new long[2][n];
        memo[0][0] = 1;
        memo[1][0] = 1;
        
        for (int idx = 1; idx < n; idx++) {
            memo[0][idx] = modulo(memo[0][idx-1] + memo[1][idx-1]);
            memo[1][idx] = memo[0][idx-1];
        }
        
        long result = memo[0][n-1] + memo[1][n-1];
        
        return (int) modulo(result * result);
    }
    
    private long modulo(long num) {
        return num % ((int) 1e9 + 7);
    }
}