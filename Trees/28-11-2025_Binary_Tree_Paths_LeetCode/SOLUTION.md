# 🌳 Binary Tree Paths — Clean & Clear Explanation

## ✨ Problem Overview

Given the **root of a binary tree**, the task is to return **all possible root-to-leaf paths**. A **leaf node** is a node that has **no children**.

Each path should be represented as a string using the format:

```
value1->value2->value3
```

---

## 📌 Example 1

**Input:** `[1, 2, 3, null, 5]`

Representation:

```
    1
   / \
  2   3
   \
    5
```

**Output:**

```
["1->2->5", "1->3"]
```

---

## 📌 Example 2

**Input:** `[1]`

**Output:**

```
["1"]
```

---

## 🧠 Key Idea

To solve this, use **Depth-First Search (DFS)**:

* Start from the root.
* Keep building the path string.
* When a **leaf node** is reached, store the complete path.

This is a recursive problem because at each node you repeat the same logic for its left and right children.

---

## 🧩 Java Code (Clean & Simple)

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        String currentPath = Integer.toString(root.val);
        buildPath(root, currentPath, paths);
        return paths;
    }

    public void buildPath(TreeNode root, String currentPath, List<String> paths) {
        // If the node is a leaf, add the path
        if (root.left == null && root.right == null) {
            paths.add(currentPath);
            return;
        }

        // Go to the left child
        if (root.left != null) {
            buildPath(root.left, currentPath + "->" + root.left.val, paths);
        }

        // Go to the right child
        if (root.right != null) {
            buildPath(root.right, currentPath + "->" + root.right.val, paths);
        }
    }
}
```

---

## 🚀 How the Code Works

### ✔️ Step 1: Start from root

Convert its value to a string and begin the path.

### ✔️ Step 2: Recursively explore

Add `->childValue` as you go deeper.

### ✔️ Step 3: Stop at leaf nodes

When no left and right child exists, record the final path.

This ensures **all** root-to-leaf paths are collected.

---

## 📝 Notes

* The solution uses DFS.
* Time complexity: **O(N × H)** (N = nodes, H = height of tree).
* Works for all binary trees with up to 100 nodes.

---

