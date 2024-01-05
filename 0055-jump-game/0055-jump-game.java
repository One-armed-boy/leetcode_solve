class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        
        queue.add(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int currIdx = queue.poll();
            
            for (int hop = 1; hop <= nums[currIdx]; hop++) {
                int nextIdx = currIdx + hop;
                // System.out.println(nextIdx);
                
                if (nextIdx >= nums.length || visited[nextIdx]) {
                    continue;
                }
                
                if (nextIdx == nums.length - 1) {
                    return true;
                }
                
                queue.add(nextIdx);   
                visited[nextIdx] = true;
            }
        }
        
        return false;
    }
}