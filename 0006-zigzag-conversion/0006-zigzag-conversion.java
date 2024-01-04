class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int num = 0;
        boolean isIncrease = true;
        for (int idx = 0; idx < s.length(); idx++) {
            pQueue.offer(new int[] {num, idx});
            // System.out.println(num);
            if (num == numRows - 1) {
                isIncrease = false;
            } else if (isIncrease == false && num == 0) {
                isIncrease = true;
            }
            
            num = isIncrease ? num + 1 : num - 1;
        }
        
        String result = "";
        
        while (!pQueue.isEmpty()) {
            int[] tmp = pQueue.poll();
            result += Character.toString(s.charAt(tmp[1]));
        }
        
        return result;
    }
}