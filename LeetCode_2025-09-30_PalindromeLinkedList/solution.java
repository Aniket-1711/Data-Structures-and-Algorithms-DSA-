/*
====================================================================================
LEETCODE PROBLEM: 234. Palindrome Linked List
====================================================================================

Problem Statement:
------------------
Given the head of a singly linked list, return true if it is a palindrome 
or false otherwise.

A palindrome is a sequence that reads the same forward and backward.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Constraints:
- The number of nodes in the list is in the range [1, 10^5].
- 0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?

====================================================================================
SOLUTION CODE
====================================================================================
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
    public boolean isPalindrome(ListNode head) {
        // Edge case: if list is empty or has only one node, it's a palindrome
        if (head == null || head.next == null) {
            return true;
        }
        
        // Step 1: Find the middle of the linked list using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the linked list
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;
        
        // Step 3: Compare both halves
        ListNode secondHalfCopy = secondHalf; // Keep a copy to restore later (optional)
        boolean isPalin = true;
        
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        // Step 4 (Optional): Restore the list by reversing the second half again
        // reverseList(secondHalfCopy);
        
        return isPalin;
    }
    
    // Helper method to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
    }
}

/*
====================================================================================
DETAILED EXPLANATION
====================================================================================

APPROACH: Two-Pointer + Reverse Second Half
--------------------------------------------

The solution uses the following strategy:

1. FIND THE MIDDLE:
   - Use the slow and fast pointer technique
   - Slow pointer moves one step at a time
   - Fast pointer moves two steps at a time
   - When fast reaches the end, slow will be at the middle
   - This works for both odd and even length lists

2. REVERSE THE SECOND HALF:
   - Starting from the middle (slow pointer), reverse the rest of the list
   - Use the standard linked list reversal technique
   - Keep track of prev, curr, and next pointers
   - This modifies the original list structure

3. COMPARE BOTH HALVES:
   - Compare nodes from the start and from the reversed second half
   - If any values don't match, it's not a palindrome
   - Continue until we've checked all nodes in the second half

4. OPTIONAL RESTORATION:
   - We can reverse the second half again to restore the original list
   - This is commented out in the code but can be enabled if needed

EDGE CASES HANDLED:
------------------
1. Empty list (null): Returns true
2. Single node: Returns true (a single element is always a palindrome)
3. Two nodes with same value: Returns true
4. Two nodes with different values: Returns false
5. Odd length lists: Middle element doesn't need to be compared twice
6. Even length lists: Both halves are equal in size

COMPLEXITY ANALYSIS:
-------------------

Time Complexity: O(n)
- Finding the middle: O(n/2) ≈ O(n)
- Reversing second half: O(n/2) ≈ O(n)
- Comparing both halves: O(n/2) ≈ O(n)
- Total: O(n) - Linear time complexity

Space Complexity: O(1)
- Only using a constant amount of extra space
- No additional data structures used
- All operations performed in-place
- Meets the follow-up requirement of O(1) space

WHY THIS APPROACH?
------------------
1. Optimal Space: Uses O(1) space as required by the follow-up
2. Efficient: Single pass to find middle, single pass to reverse, single pass to compare
3. In-place: Doesn't require creating a copy of the list
4. Clean Code: Easy to understand and maintain

ALTERNATIVE APPROACHES:
----------------------
1. Using Stack: Store first half in stack, compare with second half
   - Time: O(n), Space: O(n)
   - Easier to implement but uses extra space

2. Using ArrayList/Array: Convert list to array, use two pointers
   - Time: O(n), Space: O(n)
   - Simple but violates space constraint

3. Recursive Approach: Use recursion to compare from both ends
   - Time: O(n), Space: O(n) due to recursion stack
   - Elegant but uses stack space

The chosen approach (reverse second half) is optimal because it achieves:
- O(n) time complexity
- O(1) space complexity
- Meets all problem requirements including the follow-up challenge

====================================================================================
KEY LEARNINGS:
====================================================================================
1. Slow-fast pointer technique is powerful for finding middle of linked list
2. In-place reversal of linked list is a fundamental operation
3. Sometimes modifying the data structure temporarily is acceptable
4. Breaking down complex problems into smaller steps makes them manageable
5. Understanding trade-offs between time and space complexity is crucial
*/
