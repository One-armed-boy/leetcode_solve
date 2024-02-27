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
    private int result;

    public int longestUnivaluePath(TreeNode root) {
        this.result = 0;
        travel(root);
        return this.result;
    }

    private void travel(TreeNode node) {
        if (node == null) {
            return;
        }
        var leftPathLenContinuosParent = travel(node.left, node.val);
        var rightPathLenContinuosParent = travel(node.right, node.val);
        updateMaxPath(leftPathLenContinuosParent, rightPathLenContinuosParent);
    }

    private int travel(TreeNode node, int parentValue) {
        if (node == null) {
            return 0;
        }
        var leftPathLenContinuosParent = travel(node.left, node.val);
        var rightPathLenContinuosParent = travel(node.right, node.val);
        updateMaxPath(leftPathLenContinuosParent, rightPathLenContinuosParent);

        if (node.val != parentValue) {
            return 0;
        }
        return Math.max(leftPathLenContinuosParent, rightPathLenContinuosParent) + 1;
    }

    private void updateMaxPath(int left, int right) {
        result = Math.max(result, left + right);
    }
}