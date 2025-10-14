# 🌳 Search in a Binary Search Tree (BST)

**Difficulty:** 🟢 Easy

---

## 📜 Problem Statement

You are given the **root** of a Binary Search Tree (BST) and an integer `val`.

🔍 Find the node in the BST such that the node's value equals `val` and **return the subtree** rooted at that node.
If no such node exists, return `null`.

---

## 💡 Intuition

In a **Binary Search Tree (BST)**, every node follows this rule:

* All values in the left subtree are **smaller** than the node’s value.
* All values in the right subtree are **greater** than the node’s value.

This property allows us to efficiently search for a value by deciding whether to go **left** or **right** at each step.



---

## 🪜 Algorithm (Step-by-Step)

1. 🧩 Start from the root node.
2. If the root is `null`, return `null` (value not found).
3. If `root.val == val`, you’ve found the node → return it.
4. If `val` is **greater** than `root.val`, search in the **right subtree**.
5. If `val` is **smaller** than `root.val`, search in the **left subtree**.

➡️ Continue until the node is found or until you reach `null`.



---

## 💻 Java Implementation

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
    public TreeNode searchBST(TreeNode root, int val) {
        // 🌳 Base Case: If root is null, value not found
        if (root == null) return null;

        // ✅ If the value matches, return this node
        if (root.val == val) return root;

        // 🔁 If value is greater, search in right subtree
        if (root.val < val) return searchBST(root.right, val);

        // 🔁 If value is smaller, search in left subtree
        return searchBST(root.left, val);
    }
}
```

✅ **Time Complexity:** O(h), where *h* is the height of the tree
✅ **Space Complexity:** O(h) (recursive stack) or O(1) for iterative approach



---

## 🧠 Example Walkthrough

### Example 1

**Input:**
`root = [4,2,7,1,3]`, `val = 2`

**Step-by-step:**

* Start at 4 → 2 < 4 → go left.
* Now at 2 → value matches → return node 2 (with subtree [2,1,3]).

**Output:** `[2,1,3]`

🌿 **Tree visualization:**

```
      4
     / \
    2   7
   / \
  1   3
```

---

### Example 2

**Input:**
`root = [4,2,7,1,3]`, `val = 5`

**Step-by-step:**

* Start at 4 → 5 > 4 → go right.
* Now at 7 → 5 < 7 → go left → `null` → not found.

**Output:** `[]` (null)

---

## ⚙️ Edge Cases

| Case                | Description                 | Expected Output         |
| ------------------- | --------------------------- | ----------------------- |
| 🌱 Smallest tree    | `root = [1]`, `val = 1`     | `[1]`                   |
| ❌ Value not present | `root = [2,1,3]`, `val = 5` | `[]`                    |
| 🧩 Deep value       | Search in deeper subtree    | returns correct subtree |

---

## 🔁 Iterative Version (Alternative)

```java
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
```

🧮 Same complexity — uses constant space! 🚀

---

## 🧩 Complexity Analysis

| Type      | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| Recursive | O(h)            | O(h)             |
| Iterative | O(h)            | O(1)             |

Where `h` = height of the BST.

In a balanced tree, `h = log(n)`. In a skewed tree, `h = n`.

---

## 💬 Interview Tip

🗣️ When explaining to an interviewer, say:

> "Since it’s a BST, I can decide to go left or right depending on whether the value is smaller or larger than the current node. This gives me O(h) time complexity."

---

## 🧾 Summary Table

| Concept     | Explanation                                                  |
| ----------- | ------------------------------------------------------------ |
| 🎯 Problem  | Find node with given value in BST                            |
| 🧠 Approach | Compare value → move left or right                           |
| ⚙️ Logic    | If equal → return node; if smaller → left; if larger → right |
| ⏱️ Time     | O(h)                                                         |
| 💾 Space    | O(h) recursive / O(1) iterative                              |

---

## 📚 Reference

This is a classic LeetCode problem — **#700: Search in a Binary Search Tree** 🌳

---


