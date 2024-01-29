class Solution {
    public int integerReplacement(int n) {
        HashMap<Long, Integer> memo = new HashMap<>();
        
        for (int i = 0; i < 33; i++) {
            memo.put((long)Math.pow(2, i), i);
        }

        return solve(memo, n);
    }
    
    private int solve(HashMap<Long, Integer> memo, long target) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int nextStep = target % 2 == 0 ? solve(memo, (int) target / 2) + 1: Math.min(solve(memo, target + 1), solve(memo, target - 1)) + 1;
        memo.put(target, nextStep);
        return memo.get(target);
    }
}
