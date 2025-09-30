/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode p1 = head;
        ListNode p2 = null;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                p2 = fast;
                break;
            }
        }
        
        if(fast != null){
            while(p1 != p2 && (p1 != null && p2 != null && p1.next != null && p2.next != null) ){
                p1 = p1.next;
                p2 = p2.next;
            }
            
            if(p1 == p2){
                return p1;
            }
        }
        
        return null;
    }
}
