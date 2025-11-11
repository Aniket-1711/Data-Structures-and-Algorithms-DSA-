# 🌲 Diameter of Binary Tree — Optimized Solution

### 💡 Problem Statement

Given the **root** of a binary tree, return the **length of the diameter** of the tree.

> The **diameter** of a binary tree is the **length of the longest path** between any two nodes in the tree. This path may or may not pass through the root.

🔹 The length of a path between two nodes is represented by the **number of edges** between them.

---

### 🧩 Example

#### Example 1

```
Input: root = [1,2,3,4,5]
Output: 3
```

**Explanation:** The longest path is `[4 → 2 → 1 → 3]` or `[5 → 2 → 1 → 3]`. Both have **3 edges**.

#### Example 2

```
Input: root = [1,2]
Output: 1
```

**Explanation:** The path `[1 → 2]` has **1 edge**.

---

### 🧠 Optimized Approach — One Pass (DFS)

In the **brute force** approach, we calculated the **height** for every node separately, leading to **O(N²)** complexity. To fix that, we can compute both **height** and **diameter** in a **single traversal (DFS)**.

Here’s the key idea:

* Perform a **post-order traversal** of the tree.
* For each node:

  * Recursively calculate the **height of left and right subtrees**.
  * Use these heights to calculate the **diameter passing through the current node**.
  * Update the global **maximum diameter** if this is the largest so far.

By combining these two computations, we ensure **each node is processed only once**.

---

### 🧾 Code Implementation (Optimized Solution)

```java
class Solution {
    public static int ans = 0;

    // note that the diameter is always the maximum no of edges between any 2 leaf nodes

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        int res = ans;
        ans = 0; // reset for safety in multiple calls
        return res;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        ans = Math.max(ans, leftHeight + rightHeight); // update global diameter

        return Math.max(leftHeight, rightHeight) + 1; // return height
    }
}
```

---

### 🧮 Step-by-Step Explanation

1. **Global Variable `ans`**

   * Keeps track of the **maximum diameter** encountered so far.

2. **Recursive Function `height()`**

   * Returns the height of the current subtree.
   * During the process, it also updates `ans` with the **sum of left and right heights**.

3. **Combining Results Efficiently**

   * Unlike the brute force approach, we no longer calculate height separately for each node multiple times.
   * Every recursive call gives both **height** and **diameter contribution** in one go.

4. **Returning Final Diameter**

   * Once the entire recursion completes, the global variable `ans` holds the **maximum diameter**.

---

### 🧭 Example Walkthrough

Let’s use the same tree:

```
        1
       / \
      2   3
     / \
    4   5
```

* At node 4: height = 1, diameter = 0
* At node 5: height = 1, diameter = 0
* At node 2: height = 2, diameter = 2 (via 4 → 2 → 5)
* At node 3: height = 1, diameter = 2 (unchanged)
* At node 1: height = 3, diameter = 3 (via 4 → 2 → 1 → 3)

✅ **Final Diameter = 3**

---

### ⏱️ Time & Space Complexity

| Metric    | Complexity | Explanation                                           |
| :-------- | :--------- | :---------------------------------------------------- |
| **Time**  | **O(N)**   | Each node is visited exactly once.                    |
| **Space** | **O(H)**   | Recursive stack, where *H* is the height of the tree. |

---

### 🎯 Key Takeaways

* This version eliminates redundant height calculations. 🧩
* We use a **single DFS traversal** to compute both height and diameter. 🌲
* The use of a **global variable** simplifies diameter tracking.

---

### 🌟 Summary

| Concept              | Description                                       |
| :------------------- | :------------------------------------------------ |
| **Goal**             | Find the longest path between any two nodes       |
| **Approach**         | DFS with combined height and diameter calculation |
| **Time Complexity**  | O(N)                                              |
| **Space Complexity** | O(H)                                              |

---

### 🏁 Conclusion

This **optimized approach** is elegant and efficient. It uses recursion smartly to track both **height** and **diameter** simultaneously, reducing time from **O(N²)** to **O(N)**. 🚀🌿

---

