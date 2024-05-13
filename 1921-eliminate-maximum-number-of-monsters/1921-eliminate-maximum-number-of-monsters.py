class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        n = len(dist)

        enterTimes = [dist[i] / speed[i] for i in range(n)]
        enterTimes.sort()

        answer = 1
        for idx in range(1, n):
            if idx >= enterTimes[idx] and enterTimes[idx] - enterTimes[idx - 1] < 1:
                return answer
            answer += 1
        return answer