class Solution:
    def maximumSubsequenceCount(self, text: str, pattern: str) -> int:
        pre, post = pattern
        if pre == post:
            cnt = 0
            for val in text:
                if val == pre:
                    cnt += 1
            return cnt * (cnt + 1) // 2
        
        preCntBeforePost = []

        cnt = 0
        for idx in range(len(text)):
            char = text[idx]
            if char == pre:
                cnt += 1
            elif char == post:
                preCntBeforePost.append(cnt)
        
        return max(sum([val + 1 for val in preCntBeforePost]), sum(preCntBeforePost + [cnt]))
    