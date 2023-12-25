class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        
        int[] memo = new int[s.length() + 1];
        memo[0] = 1;
        memo[1] = 1;
        
        for (int idx = 1; idx < s.length(); idx++) {
            int twoLenNum = Integer.parseInt(s.substring(idx - 1, idx + 1));
            memo[idx + 1] = (s.charAt(idx) != '0' ? memo[idx] : 0) 
                + (twoLenNum <= 26 && twoLenNum >= 10 ? memo[idx - 1] : 0);
        }
        
        return memo[s.length()];
    }
    
}