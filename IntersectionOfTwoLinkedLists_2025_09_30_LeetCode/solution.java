/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;
        int len1 = 0, len2 = 0;
        
        while(temp1 != null){
            len1++;
            temp1 = temp1.next;
        }
        
        while(temp2 != null){
            len2++;
            temp2 = temp2.next;
        }
        
        int diff = Math.abs(len1 - len2);
        System.out.println(len1 + " " + len2 + " " + diff);
        
        ListNode a = headA, b = headB;
        
        if(len1 < len2){
            while(diff-- > 0){
                b = b.next; 
            }
        }
        else if(len2 < len1){
            // temp1=headA;
            while(diff-- > 0){
                a = a.next;
            }
        }
        
        System.out.println(a.val + " " + b.val);
        
        while(a != null && b != null){
            if(a == b){
                return a;
            }
            a = a.next;
            b = b.next;
        }
        
        return null;
    }
}
