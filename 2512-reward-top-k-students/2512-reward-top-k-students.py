import heapq

class Solution:
    def topStudents(self, positive_feedback: List[str], negative_feedback: List[str], report: List[str], student_id: List[int], k: int) -> List[int]:
        n = len(student_id)
        self.positiveFeedback = set(positive_feedback)
        self.negativeFeedback = set(negative_feedback)
        # (score, - id)
        pQueue = []

        for idx in range(n):
            student = student_id[idx]
            reportWords = report[idx].split(" ")
            score = 0
            for word in reportWords:
                if self.isPositive(word):
                    score += 3
                elif self.isNegative(word):
                    score -= 1

            if len(pQueue) < k:
                heapq.heappush(pQueue, (score, -student))
            else:
                head = heapq.heappop(pQueue)
                if (score > head[0]) or (score == head[0] and student < -head[1]):
                    heapq.heappush(pQueue, (score, -student))
                else:
                    heapq.heappush(pQueue, head)
        
        result = [0 for i in range(k)]
        idx = k - 1
        while len(pQueue) > 0:
            head = heapq.heappop(pQueue)
            result[idx] = - head[1]
            idx -= 1
        return result

    def isPositive(self, reportWord):
        return reportWord in self.positiveFeedback
    def isNegative(self, reportWord):
        return reportWord in self.negativeFeedback