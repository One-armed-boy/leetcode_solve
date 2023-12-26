class Solution {
    private boolean[][] visited;
    private String word;
    
    private final int[] dx = {0,0,1,-1};
    private final int[] dy = {1,-1,0,0};
    
    public boolean exist(char[][] board, String word) {
        int verticalLen = board.length;
        int horizontalLen = board[0].length;
        
        visited = new boolean[verticalLen][horizontalLen];
        this.word = word;
        
        for (int y = 0; y < verticalLen; y++) {
            for (int x = 0; x < horizontalLen; x++) {
                if (board[y][x] != word.charAt(0) || !isAvail(board, x, y, 0)) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
    
    private boolean isAvail(char[][] board, int x, int y, int wordIdx) {
        try {
            visited[y][x] = true;
            
            if (wordIdx >= word.length() - 1) {
            return true;
            }
            
            int verticalLen = board.length;
            int horizontalLen = board[0].length;
            
            return Stream.of(0,1,2,3).filter(i -> {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (
                    !(nextX >= 0 && nextX < horizontalLen 
                      && nextY >=0 && nextY < verticalLen 
                      && visited[nextY][nextX] == false 
                      && board[nextY][nextX] == word.charAt(wordIdx + 1))
                ) {
                    return false;
                }
                return isAvail(board, nextX, nextY, wordIdx + 1);
            }).count() > 0;
        } finally {
            visited[y][x] = false;
        }
    }
}