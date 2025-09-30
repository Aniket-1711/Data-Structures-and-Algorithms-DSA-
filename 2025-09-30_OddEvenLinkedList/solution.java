/*
===================================================================================
                        LEETCODE: ODD EVEN LINKED LIST
===================================================================================

PROBLEM STATEMENT:
-----------------
Given the head of a singly linked list, group all the nodes with odd indices 
together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain 
as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Explanation: The odd nodes (1st, 3rd, 5th) are grouped together followed by 
even nodes (2nd, 4th).

Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
Explanation: The odd nodes (1st, 3rd, 5th, 7th) are grouped together followed by 
even nodes (2nd, 4th, 6th).

Constraints:
• The number of nodes in the linked list is in the range [0, 10^4].
• -10^6 <= Node.val <= 10^6

===================================================================================
                                SUBMITTED CODE
===================================================================================
*/

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
    public ListNode oddEvenList(ListNode head) {
        // Edge case: if list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Initialize pointers for odd and even lists
        ListNode odd = head;              // First node (odd)
        ListNode even = head.next;        // Second node (even)
        ListNode evenHead = even;         // Save the head of even list
        
        // Traverse and rearrange nodes
        while (even != null && even.next != null) {
            // Link current odd node to next odd node
            odd.next = even.next;
            odd = odd.next;
            
            // Link current even node to next even node
            even.next = odd.next;
            even = even.next;
        }
        
        // Connect the odd list to the even list
        odd.next = evenHead;
        
        return head;
    }
}

/*
===================================================================================
                            DETAILED EXPLANATION
===================================================================================

APPROACH:
---------
This problem requires us to rearrange a linked list such that all odd-indexed 
nodes come before all even-indexed nodes, while maintaining their relative order.

The key insight is to use two pointers - one for odd nodes and one for even nodes.
We traverse the list once, separating odd and even nodes into two separate chains,
then connect them at the end.

STEP-BY-STEP ALGORITHM:
----------------------
1. Handle edge cases (empty list or single node)
2. Initialize three pointers:
   - odd: points to the current odd node (starts at head)
   - even: points to the current even node (starts at head.next)
   - evenHead: saves the head of the even list (head.next)

3. Traverse the list while even and even.next are not null:
   a. Connect odd node to the next odd node (odd.next = even.next)
   b. Move odd pointer forward
   c. Connect even node to the next even node (even.next = odd.next)
   d. Move even pointer forward

4. After the loop, connect the end of odd list to the head of even list
5. Return the original head (which is now the head of rearranged list)

EXAMPLE WALKTHROUGH:
-------------------
Input: [1,2,3,4,5]

Initial state:
  odd → 1, even → 2, evenHead → 2
  1 → 2 → 3 → 4 → 5

Iteration 1:
  odd.next = 3  →  1 → 3
  odd = 3
  even.next = 4  →  2 → 4
  even = 4

Iteration 2:
  odd.next = 5  →  1 → 3 → 5
  odd = 5
  even.next = null  →  2 → 4 → null
  even = null (loop ends)

Final connection:
  odd.next = evenHead  →  1 → 3 → 5 → 2 → 4 → null

Output: [1,3,5,2,4]

TIME COMPLEXITY:
---------------
O(n) where n is the number of nodes in the linked list.
- We traverse the entire list exactly once
- Each node is visited and processed only once

SPACE COMPLEXITY:
----------------
O(1) - Constant extra space
- We only use a fixed number of pointers (odd, even, evenHead)
- No additional data structures are created
- The rearrangement is done in-place

KEY POINTS:
----------
1. We maintain two separate chains (odd and even) during traversal
2. The relative order within each chain is preserved automatically
3. We save the head of the even list at the beginning (evenHead)
4. The condition (even != null && even.next != null) ensures we don't get 
   NullPointerException
5. At the end, we simply connect the odd list to the even list

EDGE CASES HANDLED:
------------------
1. Empty list (head == null): Return null
2. Single node (head.next == null): Return head (already in correct order)
3. Two nodes: The while loop won't execute, odd.next = evenHead works correctly
4. Odd number of nodes: Loop terminates when even.next is null
5. Even number of nodes: Loop terminates when even is null

ALTERNATIVE APPROACHES:
----------------------
1. Using extra space: Create two separate lists and merge (O(n) space)
2. Array-based: Convert to array, rearrange, convert back (O(n) space)
3. Recursive approach: Possible but less efficient and harder to understand

The current approach is optimal as it achieves O(n) time and O(1) space,
meeting the problem's requirements perfectly.

===================================================================================
*/
