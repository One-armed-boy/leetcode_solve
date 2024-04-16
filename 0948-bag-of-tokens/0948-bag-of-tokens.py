from collections import deque
class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        curScore = 0
        maxScore = 0
        
        dQ = deque(sorted(tokens))
        
        if len(dQ) == 0:
            return maxScore

        minToken = dQ[0]
        maxToken = dQ[-1]
        
        while len(dQ) > 0 and (curScore > 0 or power >= dQ[0]):
            if power >= dQ[0]:
                curScore += 1
                maxScore = max(maxScore, curScore)
                power -= dQ.popleft()
            
            if curScore > 0 and len(dQ) > 0 and power < dQ[0]:
                curScore -= 1
                maxScore = max(maxScore, curScore)
                power += dQ.pop()
                
            
        
        return maxScore
        