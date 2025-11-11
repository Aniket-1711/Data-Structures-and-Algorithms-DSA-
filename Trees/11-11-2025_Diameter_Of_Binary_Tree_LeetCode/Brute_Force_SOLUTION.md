# 🌳 Diameter of Binary Tree

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

### ⚙️ Constraints

* The number of nodes in the tree is in the range **[1, 10⁴]**.
* Node values are between **-100 and 100**.

---

### 🧠 Intuition

The **diameter** of a binary tree can be thought of as the **longest distance between any two leaf nodes**. The path can pass through the root, but it doesn’t have to.

To find the diameter, for **every node**, we calculate:

1. **Height of left subtree**
2. **Height of right subtree**
3. **Sum of both heights**, which gives us the **diameter through that node**.

We then take the **maximum** of:

* Diameter of the left subtree
* Diameter of the right subtree
* Diameter passing through the current node

---

### 🧾 Code Implementation (Brute Force Approach)

```java
class Solution {

    // note that the diameter is always the maximum no of edges between any 2 leaf nodes

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftDia = diameterOfBinaryTree(root.left); // diameter of the left subtree
        int rightDia = diameterOfBinaryTree(root.right); // diameter of the right subtree
        int currDia = height(root.left) + height(root.right); // diameter including the current root

        return Math.max(currDia, Math.max(leftDia, rightDia)); // maximum of all three
    }

    // helper function to calculate height of the tree
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
```

---

### 🧮 Step-by-Step Explanation

1. **Base Case:**

   * If the current node is `null`, we return `0` because it doesn’t contribute to the height or diameter.

2. **Recursive Calls:**

   * Compute the **diameter** of the left subtree → `leftDia`
   * Compute the **diameter** of the right subtree → `rightDia`
   * Compute the **height** of left and right subtrees, add them to get `currDia`

3. **Combine Results:**

   * The diameter at this node could be the **sum of heights of its left and right children**.
   * We take the **maximum** of `currDia`, `leftDia`, and `rightDia` to ensure we don’t miss the longest one.

4. **Return Result:**

   * The recursion unwinds, and the **maximum diameter** found in the entire tree is returned.

---

### 🧭 Example Walkthrough

Let’s take this tree:

```
        1
       / \
      2   3
     / \
    4   5
```

* Height(4) = 1, Height(5) = 1  → Diameter through node 2 = 1 + 1 = **2**
* Height(2) = 2, Height(3) = 1  → Diameter through node 1 = 2 + 1 = **3**
* Maximum diameter = **3** ✅

---

### ⏱️ Time Complexity

* **O(N²)** — For each node, we compute the height recursively, which again traverses subtrees.

### 💾 Space Complexity

* **O(H)** — Recursive call stack where `H` is the height of the tree.

---

### 🎯 Key Takeaways

* The **diameter** is the **sum of the heights** of the left and right subtrees for each node.
* This **brute force** solution recomputes heights repeatedly, leading to **O(N²)** complexity.
* Optimization is possible using a **single DFS traversal** — we'll explore that next time! 🚀

---

### 🌟 Summary

| Concept              | Description                                                      |
| :------------------- | :--------------------------------------------------------------- |
| **Goal**             | Find the longest path between any two nodes                      |
| **Approach**         | Recursively calculate left & right subtree diameters and heights |
| **Time Complexity**  | O(N²)                                                            |
| **Space Complexity** | O(H)                                                             |

---
