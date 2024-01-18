/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Queue<QEl> queue = new LinkedList<>();
        insertNodeToQ(queue, root);
        
        var result = 0;
        
        while (!queue.isEmpty()) {
            var element = queue.poll();
            var currNode = element.currNode;
            var sum = element.sum;
            
            if (sum == targetSum) {
                result+=1;
            }

            var nextNodes = new TreeNode[] {currNode.left, currNode.right};
            
            for (var nextNode: nextNodes) {
                if (nextNode == null) {
                    continue;
                }
                var nextSum = sum + nextNode.val;
                queue.offer(new QEl(nextNode, nextSum));
            }
        }
        
        return result;
    }
    
    private void insertNodeToQ(Queue<QEl> queue, TreeNode currNode) {
        if (currNode == null) {
            return;
        }
        queue.offer(new QEl(currNode, currNode.val));
        insertNodeToQ(queue, currNode.left);
        insertNodeToQ(queue, currNode.right);
    }
    
    class QEl {
        TreeNode currNode;
        long sum;
        
        public QEl(TreeNode currNode, long sum) {
            this.currNode = currNode;
            this.sum = sum;
        }
    }
}