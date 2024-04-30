# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        self.nodeSet = set()
        self.parentMap = {}
        self.travelTreeNode(root, None, start)

        heap = deque([])
        heap.append((0, self.startNode))
        self.nodeSet.remove(self.startNode.val)

        result = 0
        while heap:
            minute, node = heap.popleft()
            result = minute

            nextNodes = [node.left, node.right]
            if node.val in self.parentMap:
                nextNodes.append(self.parentMap[node.val])
            for nextNode in nextNodes:
                if nextNode is not None and nextNode.val in self.nodeSet:
                    heap.append((minute + 1, nextNode))
                    self.nodeSet.remove(nextNode.val)
        return result

    
    def travelTreeNode(self, node, parent, start):
        if node is None:
            return
        self.nodeSet.add(node.val)
        if node.val == start:
            self.startNode = node
        if parent is not None:
            self.parentMap[node.val] = parent
        self.travelTreeNode(node.left, node, start)
        self.travelTreeNode(node.right, node, start)
    
