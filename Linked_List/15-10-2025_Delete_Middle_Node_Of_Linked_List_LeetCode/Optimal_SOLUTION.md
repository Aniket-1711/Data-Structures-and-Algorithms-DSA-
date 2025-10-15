# 📝 Delete the Middle Node of a Linked List

## 📌 Problem Statement

You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list. 🔗

* The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing.
* For n = 1, 2, 3, 4, 5, the middle nodes are 0, 1, 1, 2, 2 respectively.

### Examples

**Example 1:**

```
Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
```

**Example 2:**

```
Input: head = [1,2,3,4]
Output: [1,2,4]
```

**Example 3:**

```
Input: head = [2,1]
Output: [2]
```

### 📏 Constraints

* The number of nodes in the list is in the range [1, 10^5].
* 1 <= Node.val <= 10^5

### 💡 Approach

1. Use the **two-pointer technique** (slow and fast pointers). 🐢🐇
2. Move `slow` one step and `fast` two steps at a time.
3. Keep track of the previous node to `slow` as `prev`. ⏮️
4. When `fast` reaches the end, `slow` will be at the middle.
5. Remove the middle node by updating `prev.next = slow.next`. ✂️

---

## 💻 Code

```java
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
        if(head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
        slow.next = null;

        return head;
    }
}
```

### ⏱️ Time and Space Complexity

* **Time Complexity:** O(n) 🕒 (single traversal)
* **Space Complexity:** O(1) 📦 (constant space)

### 📝 Notes

* Works for edge cases, e.g., list of size 1. ✅
* Uses efficient single-pass approach with two pointers. 🔀
