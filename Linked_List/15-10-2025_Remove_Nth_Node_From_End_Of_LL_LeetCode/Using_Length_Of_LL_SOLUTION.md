# 📝 Remove Nth Node From End of List

## 📌 Problem Statement

Given the head of a linked list, remove the nth node from the end of the list and return its head. 🔗

### Examples

**Example 1:**

```
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
```

**Example 2:**

```
Input: head = [1], n = 1
Output: []
```

**Example 3:**

```
Input: head = [1,2], n = 1
Output: [1]
```

### 📏 Constraints

* The number of nodes in the list is `sz`.
* 1 <= sz <= 30
* 0 <= Node.val <= 100
* 1 <= n <= sz

### 💡 Approach

1. First, **find the length** of the linked list. 🧮
2. Calculate the **position from the start** of the node to remove: `index = length - n`. 🎯
3. Traverse the list again to reach that node and **remove it**. ✂️

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = findLength(head);

        if (n == length) {
            return head.next;
        }

        ListNode temp = head;
        ListNode prev = null;
        int index = length - n;

        while (index-- > 0) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;
        temp.next = null;

        return head;
    }

    public int findLength(ListNode head) {
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}
```

### ⏱️ Time and Space Complexity

* **Time Complexity:** O(2 * sz) → O(sz) (two traversals) 🕒
* **Space Complexity:** O(1) (constant extra space) 📦

---

### 📝 Notes

* Works for all edge cases, including removing the first node. ✅
* Can be optimized to **one-pass** using the two-pointer technique. 🔀
