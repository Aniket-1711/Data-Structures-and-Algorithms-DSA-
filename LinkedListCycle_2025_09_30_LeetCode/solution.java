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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // approach if there is a cycle then slow will be ahead of fast, and at once instance as the loop further
        // continues, the slow and fast will point to the same point!
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
