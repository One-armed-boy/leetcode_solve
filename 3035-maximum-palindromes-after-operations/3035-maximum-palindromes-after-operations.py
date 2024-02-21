import heapq

class Solution(object):
    def maxPalindromesAfterOperations(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        word_map = {}
        for word in words:
            for char in word:
                if (char not in word_map):
                    word_map[char] = 0
                word_map[char] += 1

        pairs = 0
        for word in word_map:
            pairs += word_map[word] // 2
        
        result = 0
        sizes = sorted([len(word) for word in words])
        for size in sizes:
            using_pair = size // 2
            if pairs < using_pair:
                return result
            result += 1
            pairs -= using_pair

        return result
        