from collections import deque

class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        graph = {i:set() for i in range(numCourses)}
        for prerequisite in prerequisites:
            a, b = prerequisite
            graph[a].add(b)
        
        return [self.canGo(numCourses, graph, a, b) for a, b in queries]

    def canGo(self, n, graph, start, end) -> bool: 
        if end in graph[start]:
            return True

        queue = deque([start])
        visited = [False for i in range(n)]
        visited[start] = True

        while len(queue):
            currNode = queue.popleft()

            for nextNode in graph[currNode]:
                if visited[nextNode] == False:
                    graph[start].add(nextNode)
                    queue.append(nextNode)
                    visited[nextNode] = True
        return end in graph[start]