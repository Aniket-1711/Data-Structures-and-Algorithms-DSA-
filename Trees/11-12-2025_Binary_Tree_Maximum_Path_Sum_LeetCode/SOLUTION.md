# 🌲 Binary Tree Maximum Path Sum

This problem finds the **maximum path sum** in a binary tree.
A path can start and end at **any** node and must follow connected edges.
Nodes cannot repeat in a path.

---

## ✅ Problem Summary

You are given the root of a binary tree.
Return the **maximum sum** of any non-empty path.

A path can:

* Go through the root or not.
* Go from left → parent → right.
* Be just a single node.

---

## 💡 Key Idea

For each node, two values matter:

1️⃣ **Path sum to return upward** → used by parent
This must be a *single-branch* path (either left + node or right + node).

2️⃣ **Path sum through the node** → candidate for global max
This can include **left + node + right**.

We compute both using recursion.

---

## 🧠 Algorithm Logic

### For each node:

* Compute `leftSum` from left child.
* Compute `rightSum` from right child.

Ignore negative contributions using:

```
Math.max(0, sum)
```

This prevents negative paths from reducing total.

### Update global maximum:

```
ans = max(ans, node.val + leftSum + rightSum)
```

This captures the best path **passing through** this node.

### Return value:

```
return node.val + max(leftSum, rightSum)
```

This continues the best single-branch path upward.

---

## 🧪 Example

### Input:

```
[-10, 9, 20, null, null, 15, 7]
```

### Output:

```
42
```

Path: **15 → 20 → 7**.

---

## 🧾 Java Code

```java
class Solution {
    public static int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        int temp = ans;
        ans = Integer.MIN_VALUE; // reset for safety
        return temp;
    }

    public int maxSum(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max(0, maxSum(root.left));
        int rightSum = Math.max(0, maxSum(root.right));

        ans = Math.max(ans, root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time:** O(n) — visit each node once.
* **Space:** O(h) — recursion stack height.

---

## 🎯 Final Notes

This approach smartly splits the path into:

* **one branch returned upward**, and
* **full path considered for max sum**.

This ensures the maximum path is always captured.

