import bisect

class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        charIdxs = {}

        for idx in range(len(s)):
            char = s[idx]
            if char not in charIdxs:
                charIdxs[char] = []
            charIdxs[char].append(idx)
        
        result = 0
        # print(charIdxs)
        for word in words:
            targetIdx = -1
            isSubSeq = True
            for char in word:
                if char not in charIdxs:
                    isSubSeq = False
                    break
                findIdx = bisect.bisect_left(charIdxs[char], targetIdx + 1)
                if findIdx >= len(charIdxs[char]):
                    isSubSeq = False
                    break
                nextIdx = charIdxs[char][findIdx]
                # print(targetIdx, findIdx, nextIdx)
                if nextIdx <= targetIdx:
                    isSubSeq = False
                    break
                targetIdx = nextIdx
            # print(isSubSeq, word)
            result += (1 if isSubSeq else 0)
        return result