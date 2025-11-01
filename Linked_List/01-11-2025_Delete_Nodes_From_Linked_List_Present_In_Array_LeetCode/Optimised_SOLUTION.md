# 🧩 Delete Nodes From Linked List Present in Array

## 🚀 Problem Overview

You are given an **array of integers** `nums` and the **head of a linked list**. Your task is to **remove all nodes** from the linked list that contain a value present in `nums`, and return the modified head.

---

## 🧠 Example

### ✅ Example 1

**Input:**
`nums = [1,2,3]`
`head = [1,2,3,4,5]`

**Output:**
`[4,5]`

**Explanation:**
Nodes with values `1`, `2`, and `3` are removed.

---

### ✅ Example 2

**Input:**
`nums = [1]`
`head = [1,2,1,2,1,2]`

**Output:**
`[2,2,2]`

**Explanation:**
All nodes containing `1` are deleted.

---

### ✅ Example 3

**Input:**
`nums = [5]`
`head = [1,2,3,4]`

**Output:**
`[1,2,3,4]`

**Explanation:**
No node has value `5`, so the list remains unchanged.

---

## 💡 Constraints

* `1 <= nums.length <= 10^5`
* `1 <= nums[i] <= 10^5`
* All elements in `nums` are **unique**.
* Number of nodes in the list: `[1, 10^5]`
* `1 <= Node.val <= 10^5`
* At least one node in the list will **not** be deleted.

---

## 🧮 Approach

1. Store all values from `nums` in a `HashSet` for **O(1)** lookup.
2. Remove leading nodes from the head while their values exist in the set.
3. Use two pointers — `prev` and `curr` — to traverse the list.
4. If `curr.val` exists in the set, skip that node using `prev.next = curr.next`.
5. Otherwise, move both pointers ahead.
6. Return the new head of the list.

---

## 🧑‍💻 Code Implementation (Java)

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
import java.util.*;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        // Remove nodes from the start if their value is in the set
        while (head != null && set.contains(head.val)) {
            head = head.next;
        }

        if (head == null) return null; // If all nodes were deleted

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
    }
}
```

---

## ⏱️ Complexity Analysis

| Operation            | Time Complexity | Space Complexity |
| -------------------- | --------------- | ---------------- |
| Build HashSet        | O(m)            | O(m)             |
| Traverse Linked List | O(n)            | O(1)             |
| **Total**            | **O(n + m)**    | **O(m)**         |

Where:

* `n` = number of nodes in the linked list.
* `m` = length of `nums` array.

---

## 🧾 Key Points

* Efficient **O(n + m)** solution using `HashSet`.
* Handles **multiple deletions at the start** of the list.
* No extra linked list created (in-place modification). ✅

---
