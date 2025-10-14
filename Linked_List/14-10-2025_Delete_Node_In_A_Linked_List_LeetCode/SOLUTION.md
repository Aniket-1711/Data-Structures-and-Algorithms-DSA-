# 🧩 Delete Node in a Linked List

**Difficulty:** 🟡 Medium

---

## 📜 Problem Statement

You are given a singly-linked list `head` and **a node `node` to be deleted**. You are **not** given access to the head of the list — only the node that must be removed. All values in the linked list are unique and it is guaranteed that the given `node` is **not** the last node.

When we say "delete the node" we mean:

* ❌ The value of the given `node` should no longer appear in the linked list.
* 📉 The number of nodes in the linked list should decrease by one.
* 🔁 The order of nodes before and after the deleted node should remain the same.

**Constraints**

* `2 <= number of nodes <= 1000`
* `-1000 <= Node.val <= 1000`
* All node values are unique.
* The given `node` is in the list and is not the tail node.

---

## 💡 Examples

**Example 1**

➡️ **Input:** `head = [4,5,1,9]`, `node = 5`

➡️ **Output:** `[4,1,9]`

🧠 **Explanation:** After deleting the node with value `5`, the list becomes `4 -> 1 -> 9`.

---

**Example 2**

➡️ **Input:** `head = [4,5,1,9]`, `node = 1`

➡️ **Output:** `[4,5,9]`

🧠 **Explanation:** After deleting the node with value `1`, the list becomes `4 -> 5 -> 9`.

---

## 🧠 Key Idea / Intuition (Beginner Friendly)

We cannot access the node *before* the node to delete (no head, no previous pointer). But we can modify the given node itself! The trick is to **copy the value from its next node into the given node**, then skip the next node by changing pointers. So effectively we overwrite the current node with the next node, then remove the next node.

Think of it like: you have nodes `A -> B -> C` and you are given `B`. To remove `B` without access to `A`, copy `C`'s value into `B` and then make `B.next = C.next`. Now the list looks like `A -> C` — functionally, the node with `B`'s original value is gone.

⚙️ **Time Complexity:** O(1)
🧮 **Space Complexity:** O(1)



---

## 🪜 Algorithm (Step-by-step)

1. 🧩 Let `next = node.next` (we know `next != null`).
2. ✏️ Copy `node.val = next.val`.
3. 🔗 Set `node.next = next.next`.
4. 🧹 (Optional) Clear `next.next = null` to help with garbage collection.

After these steps the list is updated and the target value is removed.



---

## 💻 Correct Java Implementation

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // 🧩 Copy value from next node
        node.val = node.next.val;
        // 🔗 Skip the next node
        node.next = node.next.next;
    }
}
```

✅ **Time Complexity:** O(1)
✅ **Space Complexity:** O(1)



---

## 🔍 Why the Simple Approach Works

We can’t actually remove the given node object (no previous node access), but the **linked list is defined by the sequence of values** you traverse starting at `head`. By copying the next node’s value into the current node and then skipping the next node, the sequence looks as if the target node was deleted.

💡 So, functionally, the node is deleted even if it still exists in memory.

---

## ⚠️ Why Your Code Works but is Suboptimal

Your version iteratively shifts values from each next node until reaching the tail, then removes the tail. While this works, it visits every node after the deleted one, leading to **O(k)** complexity (worst-case O(n)).

The improved version only touches one node pair, giving **O(1)** efficiency. 🚀

---

## 🧪 Edge Cases & Notes

* 🚫 The given `node` will never be `null` and never the last node.
* 🧾 All node values are unique, so duplicates aren’t a problem.
* 🧹 For cleaner GC, you can set `removed.next = null` after deletion.

---

## 🔁 Follow-ups / Variations

* If you were given the `head` and `value`, you’d need to traverse from head (O(n)).
* For a **doubly linked list**, deletion is direct using both previous and next pointers.

---

## 🧩 Test Cases

| Input           | Node | Output        |
| --------------- | ---- | ------------- |
| `[1,2]`         | `1`  | `[2]`         |
| `[4,5,1,9]`     | `5`  | `[4,1,9]`     |
| `[4,5,1,9]`     | `1`  | `[4,5,9]`     |
| `[0,1,2,3,4,5]` | `3`  | `[0,1,2,4,5]` |

---

## 🎯 Interview Tip

🗣️ Say: “I’ll copy the value from the next node into the current node and bypass the next node — this logically deletes it in O(1) time.” Then write the 2-line code.

---

## 🧾 Summary

| Concept           | Explanation                          |
| ----------------- | ------------------------------------ |
| 🔢 Operation      | Copy next node’s value & bypass it   |
| ⏱️ Time           | O(1)                                 |
| 💾 Space          | O(1)                                 |
| ⚙️ Works Because  | We modify pointers & values directly |
| ⚠️ Common Mistake | Iterating till end unnecessarily     |

---


## 📚 Reference

This is a classic LeetCode problem — **#237 Delete Node in a Linked List**.

---

