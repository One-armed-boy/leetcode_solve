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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);
        int targetIdx = size - n;
        
        if (targetIdx == 0) {
            return head.next;
        }
        
        ListNode[] nodeArr = new ListNode[size];
        
        ListNode nextHead = head;
        for (int i = 0; i < size; i++) {
            nodeArr[i] = nextHead;
            nextHead = nextHead.next;
        }
        
        nodeArr[targetIdx - 1].next = targetIdx + 1 >= size ? null : nodeArr[targetIdx + 1];
        
        return head;
    }
    
    private int getSize(ListNode head) {
        ListNode nextHead = head.next;
        int size = 1;
        while (nextHead != null) {
            nextHead = nextHead.next;
            size++;
        }
        return size;
    }
}