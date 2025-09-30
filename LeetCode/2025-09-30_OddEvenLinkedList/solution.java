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
    /**
     * LeetCode 328: Odd Even Linked List
     * 
     * Problem: Rearrange a linked list such that all odd-indexed nodes come before even-indexed nodes.
     * 
     * Approach: Two-Pointer Technique
     * - Maintain two separate chains: one for odd indices and one for even indices
     * - Traverse the list once, separating nodes into odd and even chains
     * - Connect the end of the odd chain to the head of the even chain
     * 
     * Time Complexity: O(n) - single pass through the list
     * Space Complexity: O(1) - only using constant extra space
     * 
     * @param head The head of the linked list
     * @return The reordered linked list with odd-indexed nodes first
     */
    public ListNode oddEvenList(ListNode head) {
        // Edge case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Initialize pointers
        ListNode odd = head;           // Points to current odd-positioned node
        ListNode even = head.next;     // Points to current even-positioned node
        ListNode evenHead = even;      // Save the head of even list to connect later
        
        // Traverse and separate odd and even nodes
        // Continue while there are even nodes to process
        while (even != null && even.next != null) {
            // Connect current odd node to next odd node (skip the even node)
            odd.next = even.next;
            odd = odd.next;  // Move odd pointer forward
            
            // Connect current even node to next even node (skip the odd node)
            even.next = odd.next;
            even = even.next;  // Move even pointer forward
        }
        
        // Connect the end of odd list to the head of even list
        odd.next = evenHead;
        
        return head;
    }
}

/**
 * Example walkthrough:
 * 
 * Input: 1 -> 2 -> 3 -> 4 -> 5
 * 
 * Initial state:
 * odd = 1, even = 2, evenHead = 2
 * 
 * Iteration 1:
 * odd.next = 3 (skip 2)
 * odd = 3
 * even.next = 4 (skip 3)
 * even = 4
 * List state: 1 -> 3, 2 -> 4, 5 unprocessed
 * 
 * Iteration 2:
 * odd.next = 5 (skip 4)
 * odd = 5
 * even.next = null (skip 5)
 * even = null
 * List state: 1 -> 3 -> 5, 2 -> 4 -> null
 * 
 * Final step:
 * odd.next = evenHead (connect 5 to 2)
 * Result: 1 -> 3 -> 5 -> 2 -> 4
 * 
 * Time Complexity Analysis:
 * - We visit each node exactly once in the while loop
 * - No nested loops or recursive calls
 * - Therefore, O(n) where n is the number of nodes
 * 
 * Space Complexity Analysis:
 * - We only use three pointers: odd, even, and evenHead
 * - No additional data structures are created
 * - Therefore, O(1) constant space
 * 
 * Edge Cases Handled:
 * 1. Empty list (head == null): Returns null immediately
 * 2. Single node (head.next == null): Returns head immediately
 * 3. Two nodes: Loop doesn't execute, connects odd to even, works correctly
 * 4. Odd number of nodes: Last node is odd, even becomes null naturally
 * 5. Even number of nodes: Last node is even, even.next becomes null naturally
 */
