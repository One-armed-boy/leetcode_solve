/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private List<Integer> headList;
    private List<Integer> travelList;
    private boolean result;

    public boolean isSubPath(ListNode head, TreeNode root) {
        var headList = new ArrayList<Integer>();
        headList.add(head.val);
        while (head.next != null) {
            head = head.next;
            headList.add(head.val);
        }
        this.headList = headList;
        this.travelList = new ArrayList<Integer>();
        this.result = false;

        dfs(root);

        return this.result;
    }

    private void dfs(TreeNode curr) {
        if (result) {
            return;
        }
        if (curr == null || curr.val == 0) {
            return;
        }
        var val = curr.val;
        travelList.add(val);

        if (travelList.size() >= headList.size()) {
            if (match(headList, travelList)) {
                result = true;
                return;
            }
        }

        dfs(curr.left);
        dfs(curr.right);
        travelList.remove(travelList.size() - 1);
    }

    private boolean match(List<Integer> base, List<Integer> target) {
        var baseLen = base.size();
        var targetLen = target.size();
        for (int idx = 1; idx <= baseLen; idx++) {
            if (target.get(targetLen - idx) != base.get(baseLen - idx)) {
                return false;
            }
        }
        return true;
    }
}