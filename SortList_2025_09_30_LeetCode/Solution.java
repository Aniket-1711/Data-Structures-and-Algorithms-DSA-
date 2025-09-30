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
 * LeetCode Problem: Sort List
 * 
 * Solution using Merge Sort algorithm for linked lists
 * Runtime: 9 ms (beats 96.36% of Java submissions)
 * Memory: 57.3 MB
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(log n) - recursion stack
 */
class Solution {
    
    /**
     * Main function to sort the linked list
     * Uses merge sort (divide and conquer) approach
     * 
     * @param head - head of the linked list to be sorted
     * @return head of the sorted linked list
     */
    public ListNode sortList(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Find the middle of the linked list
        ListNode h = head;
        ListNode mid = findMid(head);
        
        // Step 2: Split the list into two halves
        ListNode h1 = mid.next;
        mid.next = null;  // Break the link to create two separate lists
        
        // Step 3: Recursively sort both halves
        h = sortList(h);
        h1 = sortList(h1);
        
        // Step 4: Merge the sorted halves
        return merge(h, h1);
    }
    
    /**
     * Finds the middle node of the linked list using slow-fast pointer technique
     * 
     * @param head - head of the linked list
     * @return the middle node (for even length, returns first middle)
     */
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;  // Start fast from next to get first middle for even length
        
        // Move slow by 1 and fast by 2 until fast reaches end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    /**
     * Merges two sorted linked lists into one sorted list
     * 
     * @param head1 - head of first sorted list
     * @param head2 - head of second sorted list
     * @return head of the merged sorted list
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        // Handle edge cases
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1 == null && head2 == null) {
            return null;
        }
        
        // Create a dummy node to simplify merge logic
        ListNode dummy = new ListNode(-1);
        ListNode dumHead = dummy;
        
        // Merge nodes by comparing values
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
        }
        
        // Attach remaining nodes (at most one list will have remaining nodes)
        if (head1 != null) {
            dummy.next = head1;
        } else {
            dummy.next = head2;
        }
        
        return dumHead.next;  // Return head of merged list (skip dummy)
    }
}
