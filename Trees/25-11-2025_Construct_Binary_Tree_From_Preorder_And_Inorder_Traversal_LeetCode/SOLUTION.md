# 🌳 Construct Binary Tree from Preorder & Inorder Traversal

## 📌 Problem Overview

Given two arrays:

* **preorder** → preorder traversal of a binary tree
* **inorder** → inorder traversal of the same binary tree

Reconstruct the original binary tree.

### ✔️ Constraints

* `1 <= preorder.length <= 3000`
* `preorder.length == inorder.length`
* All values are **unique**
* Both traversals correspond to a valid binary tree

---

## 🧠 Key Idea

* The **first element of preorder** is always the **root**.
* In the **inorder array**, everything **left of root** belongs to the **left subtree**, and everything **right of root** belongs to the **right subtree**.
* Use a global `index` to track current root from preorder.

---

## 🛠️ Java Implementation

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
    int index = 0; // Pointer for preorder array

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode(preorder[index]);
        int position = search(inorder, preorder[index]);
        index++;

        root.left = build(preorder, inorder, left, position - 1);
        root.right = build(preorder, inorder, position + 1, right);

        return root;
    }

    public int search(int[] inorder, int value) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == value) return i;
        }
        return -1;
    }
}
```

---

## 🔍 Time & Space Complexity

### **Time Complexity:** `O(n^2)`

Since each search is linear.

### **Space Complexity:** `O(n)`

Due to recursion stack.

📝 *Can be improved to O(n) using a hashmap for searching.*

---

## 🌟 Example

### Input

```
preorder = [3,9,20,15,7]
inorder  = [9,3,15,20,7]
```

### Output Tree

```
        3
       / \
      9  20
        /  \
       15   7
```

---

## 🚀 Optimization Tip

Use a **HashMap** to store `{value → inorder index}` for O(1) lookup.

---

## 🎯 Summary

* Preorder gives the **root order**.
* Inorder splits tree into **left** and **right**.
* Build recursively using global preorder index.

