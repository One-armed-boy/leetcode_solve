import itertools

class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        resultSet = set()
        for leng in range(1, len(tiles) + 1):
            tmp = itertools.permutations(tiles, leng)
            for e in tmp:
                resultSet.add("".join(e))
        # print(resultSet)
        return len(resultSet)