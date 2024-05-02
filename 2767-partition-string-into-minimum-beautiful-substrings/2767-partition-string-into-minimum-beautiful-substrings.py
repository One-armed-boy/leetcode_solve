import heapq

class Solution:
    def minimumBeautifulSubstrings(self, s: str) -> int:
        reserve = [self.numToBin(5**i) for i in range(7)]
        n = len(s)
        pQ = []
        for r in reserve:
            lenR = len(r)
            if lenR <= n and s[:lenR] == r:
                heapq.heappush(pQ, (1, r))

        while pQ:
            cnt, tmpStr = heapq.heappop(pQ)

            if s == tmpStr:
                return cnt
            
            for r in reserve:
                nextStr = tmpStr + r
                lenNextStr = len(nextStr)
                if lenNextStr <= n and s[:lenNextStr] == nextStr:
                    heapq.heappush(pQ, (cnt+1, nextStr))

        return -1
    
    def numToBin(self, num):
        return bin(num)[2:]