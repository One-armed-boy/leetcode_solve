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
    String rootToStart = "";
    String rootToDest = "";
    public String getDirections(TreeNode root, int startValue, int destValue) {
        findWayRootTo(startValue, destValue, root);

        int mergeIdx = 0;
        
        for (int idx = 0; idx < Math.min(rootToStart.length(), rootToDest.length()); idx++) {
            if (rootToStart.charAt(idx)!=rootToDest.charAt(idx)) {
                break;
            }
            mergeIdx = idx+1;
        }
        
        return "U".repeat(rootToStart.length() - mergeIdx) + rootToDest.substring(mergeIdx);
    }
    
    private void findWayRootTo(int startValue, int DestValue, TreeNode root) {
        Queue<TravelNode> queue = new LinkedList<>();
        queue.add(new TravelNode(root, ""));
        int targetCount = 2;
        while (!queue.isEmpty() || targetCount > 0) {
            TravelNode headOfQueue = queue.poll();
            TreeNode node = headOfQueue.node;
            
            if (node.val == startValue) {
                rootToStart = headOfQueue.route;
                targetCount--;
            }
            
            if (node.val == DestValue) {
                rootToDest = headOfQueue.route;
                targetCount--;
            }
            
            if (targetCount <= 0) {
                break;
            }
            
            if (node.left != null) {
                queue.add(new TravelNode(node.left, headOfQueue.route + "L"));
            }
                          
            if (node.right != null) {
                queue.add(new TravelNode(node.right, headOfQueue.route + "R"));   
            }
        }
    }
    
    class TravelNode {
        public TreeNode node;
        public String route;
        public TravelNode(TreeNode node, String route) {
            this.node = node;
            this.route = route;
        }
    }
}