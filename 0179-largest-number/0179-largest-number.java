class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pQueue = new PriorityQueue<>((a, b)->{
            String c = a + b;
            String d = b + a;
            return d.compareTo(c);
        });
        
        for (int num : nums) {
            pQueue.offer(Integer.toString(num));
        }
        
        String result = "";
        
        while (!pQueue.isEmpty()) {
            String numStr = pQueue.poll();
            result += numStr;
        }
        
        return result.charAt(0) == '0' ? "0" : result;
    }
}