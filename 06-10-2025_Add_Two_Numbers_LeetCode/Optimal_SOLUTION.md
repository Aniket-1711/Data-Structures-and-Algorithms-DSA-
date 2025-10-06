# 💫 Add Two Numbers 

### 🧩 Problem Statement
You are given two **non-empty linked lists** representing two non-negative integers.  
The digits are stored in **reverse order**, and each of their nodes contains a **single digit**.  
Add the two numbers and return the **sum as a linked list**.

You may assume the two numbers **do not contain any leading zero**, except the number 0 itself.

---

### 💡 Example 1
**Input:**  
`l1 = [2,4,3]`, `l2 = [5,6,4]`

**Output:**  
`[7,0,8]`

**Explanation:**  
Digits represent numbers 342 and 465.  
**342 + 465 = 807**, which in reverse order is `[7,0,8]`.

---

### 💡 Example 2
**Input:**  
`l1 = [0]`, `l2 = [0]`  
**Output:**  
`[0]`

---

### 💡 Example 3
**Input:**  
`l1 = [9,9,9,9,9,9,9]`, `l2 = [9,9,9,9]`  
**Output:**  
`[8,9,9,9,0,0,0,1]`

---

### ⚙️ Constraints
- The number of nodes in each linked list is in the range **[1, 100]**
- `0 <= Node.val <= 9`
- The list represents a number without leading zeros.

---

## 🧠 Intuition
We add two numbers **digit by digit**, just like addition on paper ✏️  
But since the digits are stored in **reverse order**, we can start from the **head of both lists** and move forward.

We also maintain a **carry** that adds to the next digit sum.

---

## 🔍 Approach

1. Create a **dummy node** (`dummy`) to store the result list.  
2. Maintain a **pointer (`curr`)** to build the result and a **carry variable** initialized to 0.  
3. Traverse both lists simultaneously:
   - Take values `a` and `b` from the current nodes of `l1` and `l2` (or 0 if any list ends).
   - Calculate `sum = a + b + carry`.
   - Update `carry = sum / 10`.
   - Create a new node with value `sum % 10` and attach it to the result.
4. Move `l1` and `l2` to their next nodes.
5. After traversal, if `carry` is not 0, add a final node with `carry`.

---

## 🧾 Code Implementation (Java)

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;

            int sum = a + b + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}
```
## 🧮 Example Dry Run
**Input:**

l1 = [2,4,3], l2 = [5,6,4]
| Step | a | b | carry (in) | sum | carry (out) | New Node |
| ---- | - | - | ---------- | --- | ----------- | -------- |
| 1    | 2 | 5 | 0          | 7   | 0           | 7        |
| 2    | 4 | 6 | 0          | 10  | 1           | 0        |
| 3    | 3 | 4 | 1          | 8   | 0           | 8        |

✅ **Final Linked List: [7, 0, 8]**

## 🕒 Time & Space Complexity
| Complexity   | Explanation                                               |
| ------------ | --------------------------------------------------------- |
| ⏱️ **Time**  | O(max(m, n)) — We traverse both lists once.               |
| 🧠 **Space** | O(max(m, n)) — The result list stores one node per digit. |

## 🧑‍💻 Output Visualization

**Input:**
l1 = 2 → 4 → 3
l2 = 5 → 6 → 4

**Process:**
```
  3 4 2
+ 4 6 5
---------
  8 0 7
```
**Output (in reverse):**
7 → 0 → 8
