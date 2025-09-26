/*
=====================================
🚀 MIDDLE OF THE LINKED LIST PROBLEM
=====================================

📝 PROBLEM DESCRIPTION:
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

💡 APPROACH - TWO POINTER TECHNIQUE (FAST & SLOW POINTERS):
This solution uses the famous "Tortoise and Hare" algorithm:
- Fast pointer moves 2 steps at a time
- Slow pointer moves 1 step at a time
- When fast pointer reaches the end, slow pointer will be at the middle

⏰ TIME COMPLEXITY: O(n) - Single pass through the linked list
💾 SPACE COMPLEXITY: O(1) - Only using two pointer variables

🔍 EDGE CASES HANDLED:
1. Single node list: Returns the single node
2. Two node list: Returns the second node
3. Odd number of nodes: Returns the exact middle
4. Even number of nodes: Returns the second middle node
5. Null input: Not possible as per problem constraints

📊 EXAMPLES:
- [1,2,3,4,5] → Returns node with value 3
- [1,2,3,4,5,6] → Returns node with value 4 (second middle)
- [1] → Returns node with value 1
- [1,2] → Returns node with value 2

✨ WHY THIS WORKS:
- In a list of length n, middle is at position n/2 (0-indexed)
- Fast pointer covers 2×k steps, slow pointer covers k steps
- When fast reaches end (2×k = n), slow is at position k = n/2
- This gives us the middle position directly!

=====================================
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
    /**
     * 🎯 MAIN SOLUTION METHOD
     * Finds the middle node using two-pointer technique
     * 
     * @param head The head of the singly linked list
     * @return The middle node (or second middle if even number of nodes)
     */
    public ListNode middleNode(ListNode head) {
        // 🐢 Slow pointer - moves one step at a time
        ListNode slow = head;
        
        // 🐇 Fast pointer - moves two steps at a time  
        ListNode fast = head;
        
        // 🔄 MAIN LOOP: Continue until fast pointer reaches end
        // Condition: fast != null handles odd length lists
        // Condition: fast.next != null handles even length lists
        while (fast != null && fast.next != null) {
            // Move fast pointer 2 steps ahead
            fast = fast.next.next;
            
            // Move slow pointer 1 step ahead
            slow = slow.next;
        }
        
        // 🎉 When loop ends, slow pointer is at the middle!
        return slow;
    }
}

/*
=====================================
📈 STEP-BY-STEP EXECUTION EXAMPLE:
=====================================

For list: [1,2,3,4,5]

Initial: slow=1, fast=1
Step 1:  slow=2, fast=3  (fast moved 1→2→3, slow moved 1→2)
Step 2:  slow=3, fast=5  (fast moved 3→4→5, slow moved 2→3)
Step 3:  fast.next=null, loop ends
Result:  slow=3 (middle node) ✅

For list: [1,2,3,4,5,6]

Initial: slow=1, fast=1
Step 1:  slow=2, fast=3  (fast moved 1→2→3, slow moved 1→2)
Step 2:  slow=3, fast=5  (fast moved 3→4→5, slow moved 2→3)
Step 3:  slow=4, fast=null (fast moved 5→6→null, slow moved 3→4)
Result:  slow=4 (second middle node) ✅

=====================================
🧠 KEY INSIGHTS:
=====================================

1. 📏 DISTANCE RELATIONSHIP:
   - When fast travels distance 2k, slow travels distance k
   - For list of length n, when fast reaches end: 2k = n → k = n/2
   - So slow is at position n/2, which is exactly the middle!

2. 🎯 EVEN vs ODD LENGTH:
   - Odd length (n=5): Middle at index 2, slow stops at index 2 ✅
   - Even length (n=6): Two middles at index 2,3. Slow stops at index 3 ✅
   - This automatically gives us the "second middle" for even lengths!

3. ⚡ EFFICIENCY:
   - No need to count list length first (saves one extra pass)
   - No additional data structures needed
   - Works in a single pass with constant space

4. 🛡️ ROBUST DESIGN:
   - Handles all edge cases naturally
   - No special conditions needed for different list lengths
   - The loop condition handles both odd and even lengths elegantly

=====================================
*/
