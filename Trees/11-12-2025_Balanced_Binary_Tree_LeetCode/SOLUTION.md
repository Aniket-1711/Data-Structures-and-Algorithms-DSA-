# 🌳 Balanced Binary Tree

This problem checks whether a binary tree is **height-balanced**.
A tree is height-balanced when, for every node, the height difference between its left and right subtree is **not more than 1**.

---

## ✅ Problem Summary

You are given the root of a binary tree.
Return **true** if the tree is balanced, else return **false**.

A tree is balanced when:

* Left subtree height and right subtree height differ by **≤ 1**.
* Both subtrees are also balanced.

---

## 💡 Key Idea

Use a **recursive height function**:

* If any subtree is unbalanced, return **-1** immediately.
* Otherwise, return the height of the current subtree.

Finally, if the height function returns **-1** for the whole tree, it means the tree is **not balanced**.

This avoids repeated height calculations and makes the solution efficient.

---

## 🧠 Algorithm Steps

1. If the node is null → height is 0.
2. Recursively compute left and right subtree heights.
3. If either subtree returned -1 → not balanced.
4. If height difference > 1 → not balanced.
5. Otherwise → return `max(left, right) + 1`.

---

## 🧪 Example

### Input:

```
[3, 9, 20, null, null, 15, 7]
```

### Output:

```
true
```

This tree is balanced.

---

## 🧾 Java Code

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        if (left == -1) return -1;

        int right = height(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time:** O(n)
* **Space:** O(h), where h is tree height (recursive stack)

---

## 🎯 Final Notes

This solution is optimal because it checks balance **during** height computation, preventing extra passes over the tree.

