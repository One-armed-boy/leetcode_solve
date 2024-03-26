class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dy = [1, 0, -1, 0]
        dx = [0, 1, 0, -1]
        curr = [0, 0, 0]
        for order in instructions:
            if order == "G":
                curr[0] = curr[0] + dy[curr[2]]
                curr[1] = curr[1] + dx[curr[2]]
            elif order == "L":
                curr[2] = (curr[2] - 1) % 4
            else:
                curr[2] = (curr[2] + 1) % 4
        
        if (curr[0] == 0 and curr[1] == 0) or curr[2] != 0:
            return True
        return False
        