# 🌲 Maximum Depth of Binary Tree

This repository contains the solution for the **LeetCode** problem **“Maximum Depth of Binary Tree”**.

---

## 🧩 Problem Statement

Given the **root of a binary tree**, return its **maximum depth**.

🖐 A binary tree's **maximum depth** is the number of nodes along the **longest path** from the root node down to the farthest leaf node.

---

### 🧠 Example 1

```
Input: root = [3,9,20,null,null,15,7]
Output: 3
```

🌿 The longest path is `3 → 20 → 7`, which has **3 nodes**.

---

### 🌱 Example 2

```
Input: root = [1,null,2]
Output: 2
```

🌳 The longest path is `1 → 2`, which has **2 nodes**.

---

## 🗏 Constraints

* The number of nodes in the tree is in the range **[0, 10⁴]**.
* Each node’s value satisfies **−100 ≤ Node.val ≤ 100**.

---

## 💡 Approach — Recursion (Depth-First Search 🌿)

We use a **recursive DFS approach** to calculate the depth of the binary tree.

### 🧩 Step-by-Step Explanation

1. **Base Case 🧱**

   * If the tree (or subtree) is empty → `root == null`
   * Then the depth = `0`

2. **Recursive Step 🔁**

   * If the current node is not null, the tree has at least **depth 1** (for the root node).
   * Recursively find:

     * `leftHeight = maxDepth(root.left)`
     * `rightHeight = maxDepth(root.right)`

3. **Combine Results 🧮**

   * Depth of current node =

     ```
     1 + Math.max(leftHeight, rightHeight)
     ```
   * (That “+1” counts the current node itself!)

4. **Return Value 🎯**

   * Each recursive call returns the **maximum depth** for that subtree.
   * The recursion continues until all null nodes return `0`, and results bubble up.

---

## 🧑‍💻 Java Solution

Here’s the complete and well-documented **Java code** for the solution:

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * Calculates the maximum depth of a binary tree using recursion.
     *
     * @param root The root node of the binary tree.
     * @return The maximum depth of the tree.
     */
    public int maxDepth(TreeNode root) {
        // 🌱 Base case: If the node is null, its depth is 0.
        if (root == null) {
            return 0;
        }

        // 🌿 Recursively find the depth of the left subtree.
        int leftHeight = maxDepth(root.left);

        // 🦃 Recursively find the depth of the right subtree.
        int rightHeight = maxDepth(root.right);

        // 🌳 Depth of current node = 1 (itself) + max depth of its children.
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
```

---

## 📞 Summary

| Concept              | Explanation                                       |
| -------------------- | ------------------------------------------------- |
| 🔍 Technique Used    | Depth-First Search (DFS)                          |
| 🧱 Base Case         | `root == null → return 0`                         |
| 🧮 Recursive Formula | `1 + max(leftDepth, rightDepth)`                  |
| ⏱️ Time Complexity   | **O(n)** (visits every node once)                 |
| 🧮 Space Complexity  | **O(h)** (height of tree, due to recursion stack) |

---

## 🌟 Intuition

Think of recursion like **climbing up and down branches** of the tree 🌲.
Each leaf node sends back `0`, and as recursion unwinds, each parent adds `+1` for itself — building the depth count all the way to the root!

---

## ✨ Final Thought

This problem beautifully demonstrates how **recursion mirrors tree structure** — each function call represents one node 🌿.
Once you understand this pattern, **many tree problems** become much easier! 💪
