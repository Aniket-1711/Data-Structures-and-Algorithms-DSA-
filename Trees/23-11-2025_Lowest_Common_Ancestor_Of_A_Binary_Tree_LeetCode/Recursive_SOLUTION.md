# 🌳 Lowest Common Ancestor (LCA)

## 📘 Problem Description

Given a **binary tree**, find the **Lowest Common Ancestor (LCA)** of two nodes `p` and `q`.

👉 The **LCA** of two nodes is the *lowest* node that has both `p` and `q` in its subtree.
👉 A node **can be the ancestor of itself**.

---

## 🧠 Key Idea

We use **DFS + Recursion** to find:

* If `p` or `q` is found in the left subtree
* If `p` or `q` is found in the right subtree

### ✔️ Rules:

* If both left and right return non-null 👉 current node is LCA
* If one side is non-null 👉 that side contains the LCA
* If the node itself is `p` or `q` 👉 return it

---

## 🧩 Java Code

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root; // LCA found
        }
        return (left != null) ? left : right;
    }
}
```

---

## 📝 Example

### Input Tree:

```
        3
      /   \
     5     1
    / \   / \
   6   2 0   8
      / \
     7   4
```

* `p = 5`, `q = 1` → **LCA = 3**
* `p = 5`, `q = 4` → **LCA = 5** (node can be ancestor of itself)

---

## 🚀 Time & Space Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(h) (height of tree → recursion stack)

---
