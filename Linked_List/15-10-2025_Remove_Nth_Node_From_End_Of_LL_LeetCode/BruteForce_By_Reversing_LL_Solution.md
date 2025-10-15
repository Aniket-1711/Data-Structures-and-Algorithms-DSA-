# 🔄 Remove Nth Node From End of List (Using Reverse Linked List)

## 📌 Problem Statement

Given the head of a linked list, remove the nth node from the end of the list and return its head. 🔗

### Approach

This solution uses **reversing the linked list** to simplify removal:

1. **Reverse** the linked list. 🔁
2. Traverse to the `n`th node (from the new head) and **remove it**. ✂️
3. **Reverse** the linked list again to restore original order. 🔄

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
        ListNode revHead = reverseLL(head);
        
        if(n == 1){
            revHead = revHead.next;
        } else {
            ListNode temp = revHead;
            ListNode prev = null;
            while(n-- > 1){
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            temp.next = null;
        }
        
        return reverseLL(revHead);
    }

    public ListNode reverseLL(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode revHead = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return revHead;
    }
}
```

### ⏱️ Time and Space Complexity

* **Time Complexity:** O(sz) for first reverse + O(n) to remove + O(sz) for second reverse → O(sz) overall 🕒
* **Space Complexity:** O(sz) due to recursion stack in `reverseLL` 📦

### 📝 Notes

* Works for all edge cases, including removing the first node. ✅
* This approach is intuitive but **less efficient** than the one-pass two-pointer method because of recursion stack. ⚠️
