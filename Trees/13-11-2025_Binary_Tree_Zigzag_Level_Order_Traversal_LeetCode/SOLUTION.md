# Binary Tree Zigzag Level Order Traversal

## 📌 Problem Description

Given the **root of a binary tree**, return its **zigzag level order traversal**.

Zigzag traversal means:

* First level → **left to right**
* Second level → **right to left**
* Third level → **left to right**
* And so on (alternating).

This pattern continues for all levels.

---

## ✅ Example

### **Input:**

```
[3,9,20,null,null,15,7]
```

### **Output:**

```
[[3], [20, 9], [15, 7]]
```

---

## 🎯 Approach / Intuition

1. Perform a **level order traversal** using a queue.
2. Track the direction using a boolean `leftToRight`.
3. For each level:

   * If `leftToRight` is **true**, insert normally.
   * If `false`, insert each value at index **0** (reverse insertion).
4. Flip the direction after each level.
5. Add the `level` list to the final `result`.

This ensures the zigzag pattern.

---

## 💡 Time & Space Complexity

| Type      | Complexity                    |
| --------- | ----------------------------- |
| **Time**  | O(N), we visit each node once |
| **Space** | O(N), queue + result storage  |

---

## 🧾 Java Code Implementation

```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (leftToRight) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val); // reverse insertion
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight; // flip direction
        }
        return result;
    }
}
```

---

## ✔ Summary

* Use BFS for level-order traversal.
* Use a boolean flag to alternate direction.
* Insert values at normal position or index 0 depending on direction.
* Efficient and simple approach.

---
