# 🌳 1022. Sum of Root To Leaf Binary Numbers

## 📌 Problem Statement

Given a binary tree where each node contains either **0** or **1**, every root-to-leaf path forms a binary number.

Return the **sum of all binary numbers** formed from root to every leaf.

---

## 🧠 Key Idea

Instead of storing the full binary string, we:

* Build the number while traversing.
* Shift the current number left (`<< 1`) to make space.
* Add the current node value using bitwise OR (`|`).

### 🔁 Formula Used

```
current = (current << 1) | node.val
```

This works because:

* `<< 1` → multiplies by 2 (binary shift)
* `| node.val` → adds current bit

---

## 🚀 Approach (DFS)

1. Start from root with `current = 0`.
2. Traverse using DFS.
3. Update number at each step.
4. If leaf node → return the built number.
5. Return sum of left and right subtree.

---

## 💻 Java Implementation

```java
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int current){
        if(root == null){
            return 0;
        }

        current = (current << 1) | root.val;

        if(root.left == null && root.right == null){
            return current;
        }

        return helper(root.left, current) + helper(root.right, current);
    }
}
```

---

## 🧩 Example

Input:

```
        1
       / \
      0   1
     / \ / \
    0  1 0  1
```

Binary Paths:

* 100 → 4
* 101 → 5
* 110 → 6
* 111 → 7

Total Sum = **22**

---

## ⏱ Time & Space Complexity

* **Time:** O(N)
* **Space:** O(H)
  (H = height of tree due to recursion stack)

---

## ✨ Why This Is Efficient

* No string building
* No binary-to-decimal conversion later
* Single traversal
* Clean bit manipulation

---

## 🏁 Final Notes

* Works for up to 1000 nodes.
* Result guaranteed to fit in 32-bit integer.
* Classic example of combining Trees + Bit Manipulation.

---
