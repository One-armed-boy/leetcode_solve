class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<int[]> eventQ = new PriorityQueue<>((a,b)->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else if (a[0] < b[0]) {
                return -1;
            } else {
                return 1;
            }
        });
        
        for (int friendIdx = 0; friendIdx < times.length; friendIdx++) {
            int[] event = times[friendIdx];
            int arrival = event[0];
            int leave = event[1];
            
            // [이벤트 발생 시간, 도착 떠남 여부, 친구 번호]
            // 도착 떠남 여부: 0 -> 떠남, 1 -> 도착
            eventQ.offer(new int[] {leave, 0, friendIdx});
            eventQ.offer(new int[] {arrival, 1, friendIdx});
        }
        
        PriorityQueue<Integer> chairQ = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) { chairQ.offer(i); }
        
        HashMap<Integer, Integer> sitMap = new HashMap<>();
        
        int result = 0;
        
        while (!eventQ.isEmpty()) {
            int[] event = eventQ.poll();
            int eventTime = event[0];
            boolean isArrival = event[1] != 0;
            int friend = event[2];
            
            if (isArrival) {
                int nextChair = chairQ.poll();
                if (targetFriend == friend) {
                    result = nextChair;
                    break;
                }
                sitMap.put(friend, nextChair);
            } else {
                int chair = sitMap.get(friend);
                chairQ.offer(chair);
                sitMap.remove(friend);
            }
            
        }
        
        return result;
    }
}