class Solution {
    public int trailingZeroes(int n) {
        if (n==0) {
            return 0;
        }
        int result = 0;
        for (int k = 1; k <=n; k++) {
            result += checkFive(k);
        }
        return result;
    }
    
    private int checkFive(int num) {
        int result = 0;
        while (num % 5 == 0) {
            num = (int) (num / 5);
            result ++;
        }
        return result;
    }
}
