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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        var len = 0;
        var headForLen = head;

        while (headForLen != null) {
            len++;
            headForLen = headForLen.next;
        }

        if (len == 0) {
            return head;
        }

        var realK = k % len;

        if (realK == 0) {
            return head;
        }

        var nodeList = new ListNode[len];
        var headForList = head;
        for (int idx = 0; idx < len; idx++) {
            nodeList[idx] = headForList;
            headForList = headForList.next;
        }

        var currLastNode = nodeList[len - 1];
        var nextFirstNode = nodeList[len - realK];
        var nextLastNode = nodeList[len - realK - 1];

        currLastNode.next = head;
        nextLastNode.next = null;

        return nextFirstNode;
    }
}