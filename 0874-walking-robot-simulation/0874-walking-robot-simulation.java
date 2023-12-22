class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> obsSet = new HashSet<>();
        for (int[] obs:obstacles) {
            obsSet.add(Integer.toString(obs[0]) + "," + Integer.toString(obs[1]));
        }
        
        Robot robot = new Robot();
        
        for (int command: commands) {
            robot.move(command, obsSet);
        }
        
        return robot.maxUDist;
    }
    
    class Robot {
        public static final int[] dx = {0, 1, 0, -1};
        public static final int[] dy = {1, 0, -1, 0};
        private int directionStatus = 0;
        private int[] currPoint = new int[2];
        public int maxUDist = 0;
        
        public void move(int command, HashSet<String> obsSet) {
            if (command <= 0) {
                changeDirection(command);
            } else {
                go(command, obsSet);
            }
            
        }
        
        private void go(int dist, HashSet<String> obsSet) {
            for (int step = 1; step <= dist; step ++) {
                int nextX = currPoint[0] + Robot.dx[directionStatus];
                int nextY = currPoint[1] + Robot.dy[directionStatus];
                
                if (obsSet.contains(nextX + "," + nextY)) {
                    break;
                }
                currPoint[0] = nextX;
                currPoint[1] = nextY;
                maxUDist = Math.max(
                    maxUDist, 
                    currPoint[0] * currPoint[0] + currPoint[1] * currPoint[1]);
            }
        }
        
        private void changeDirection(int command) {
            if (command > 0) {
                return;
            }
            if (command == -1) {
                directionStatus = (directionStatus + 1) % 4;
            } else {
                directionStatus = (directionStatus != 0 ? directionStatus -1 : 3) % 4;
            }
        }
    }
}