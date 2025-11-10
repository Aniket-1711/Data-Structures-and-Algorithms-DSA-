# 🌳 Subtree of Another Tree (LeetCode)

## 🧩 Problem Description

Given the roots of two binary trees `root` and `subRoot`, return `true` if there is a subtree of `root` with the **same structure and node values** as `subRoot`, and `false` otherwise.

> A **subtree** of a binary tree is a tree that consists of a node in the tree and all of that node's descendants. The tree itself can also be considered as a subtree of itself.

---

## 🧠 Example

**Example 1:**

```text
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
```

**Example 2:**

```text
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
```

---

## ⚙️ Constraints

* The number of nodes in `root` is in the range [1, 2000].
* The number of nodes in `subRoot` is in the range [1, 1000].
* `-10^4 <= root.val, subRoot.val <= 10^4`

---

## 🪜 Prerequisite

Before attempting this problem, make sure you have solved:

👉 **[Identical Trees (LeetCode)](https://leetcode.com/problems/same-tree/)**

This problem is a direct extension of the Identical Tree problem. Understanding how to compare two trees for equality will make this problem much easier!

---

## 💡 Approach

1. **Base Case** – If either tree is `null`, return true only if both are `null`.
2. **Check for match** – If the current nodes of both trees have the same value, check if they are identical using a helper function.
3. **Recursive Step** – If not identical, recursively check the left and right subtrees of the main tree.

---

## 🧾 Code Implementation (Java)

```java
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == subRoot;
        }

        if (root.val == subRoot.val && isIdentical(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == subRoot;
        }

        return isIdentical(root.left, subRoot.left) &&
               isIdentical(root.right, subRoot.right) &&
               root.val == subRoot.val;
    }
}
```

---

## 🧩 Key Insight

✅ The `isIdentical()` function is reused from the **Identical Tree** problem.

✅ The main difference is that instead of comparing two fixed trees, we check **every node** of the main tree to see if it can be the root of a matching subtree.

---

## 🚀 Complexity Analysis

* **Time Complexity:** `O(m * n)` – For every node in `root`, we may compare it with all nodes in `subRoot`.
* **Space Complexity:** `O(h)` – Where `h` is the height of the tree (recursion stack).

---

## 🏁 Summary

| Concept             | Description                                      |
| ------------------- | ------------------------------------------------ |
| **Main Idea**       | Check if one tree exists as a subtree of another |
| **Helper Function** | `isIdentical()` to compare two trees             |
| **Base Problem**    | Identical Tree                                   |
| **Difficulty**      | Easy                                             |

---
