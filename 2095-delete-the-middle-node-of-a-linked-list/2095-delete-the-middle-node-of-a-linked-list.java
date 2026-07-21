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
    public ListNode deleteMiddle(ListNode head) {
        ListNode n = head;
        int i = 0;

        while (n != null) {
            i++;
            n = n.next;
        }

        if (i == 1)
            return null;

        int y = i / 2 - 1;
         ListNode nn = head;

        while(y != 0){
            nn = nn.next;
            y--;
        }

        nn.next = nn.next.next;

        return head;
    }
}