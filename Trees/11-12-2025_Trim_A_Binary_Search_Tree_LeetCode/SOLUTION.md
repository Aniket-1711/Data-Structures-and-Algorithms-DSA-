# 🌳 Trim a Binary Search Tree

This problem requires trimming a **Binary Search Tree (BST)** so that all node values lie within a given range **[low, high]**.
The structure of the remaining nodes must stay the same.

---

## ✅ Problem Summary

Given:

* A BST root
* A range **low** and **high**

Return the BST after removing all nodes whose values fall **outside** the range.

The BST property helps us decide which part of the tree to keep or skip.

---

## 💡 Key Idea

Because this is a **BST**, we know:

* If `root.val < low` → everything in the left subtree is too small → **skip left**, go to **right**.
* If `root.val > high` → everything in the right subtree is too large → **skip right**, go to **left**.
* Otherwise, the node is valid → **trim both subtrees**.

This ensures the final tree remains a valid BST.

---

## 🧠 Algorithm Steps

1. If the node is null → return null.
2. If value < low → trimmed root must come from the **right subtree**.
3. If value > high → trimmed root must come from the **left subtree**.
4. If inside range → trim left and right.
5. Return the modified root.

---

## 🧪 Example

### Input:

```
root = [3,0,4,null,2,null,null,1]
low = 1
high = 3
```

### Output:

```
[3,2,null,1]
```

All nodes outside range [1,3] are removed.

---

## 🧾 Java Code

```java
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;

        if (root.val < low)
            return trimBST(root.right, low, high);

        if (root.val > high)
            return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, high, low);

        return root;
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time:** O(n) — each node checked once.
* **Space:** O(h) — recursion depth.

---

## 🎯 Final Notes

The BST properties make this trimming efficient.
Only necessary nodes are processed, and the structure remains valid.

