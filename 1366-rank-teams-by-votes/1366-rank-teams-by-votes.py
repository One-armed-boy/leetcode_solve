import heapq

class Solution:
    def rankTeams(self, votes: List[str]) -> str:
        # 한 사람이 투표하는 개수
        n = len(votes[0])
        voteMap = {}

        for vote in votes:
            for rank in range(n):
                team = vote[rank]
                if team not in voteMap:
                    voteMap[team] = [0 for i in range(n)]
                voteMap[team][rank] -= 1

        maxHeap = []

        for team in voteMap:
            heapq.heappush(maxHeap, voteMap[team] + [team])
        
        result = ""

        while len(maxHeap) > 0:
            tmp = heapq.heappop(maxHeap)
            team = tmp[-1]
            result += team
        return result