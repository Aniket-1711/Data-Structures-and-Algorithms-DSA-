# 🌳 Binary Tree Right Side View

## 📘 Problem Statement

Given the root of a binary tree, imagine standing on the **right side** of it. You have to return the **values of the nodes** you can see when looking from that side, ordered from **top to bottom**.

### 💡 Example

**Input:** `root = [1,2,3,null,5,null,4]`

**Output:** `[1, 3, 4]`

**Explanation:**
When viewed from the right side, the visible nodes are **1 → 3 → 4**.

---

## 🧠 Approach Explanation

We use **Breadth-First Search (BFS)** traversal (level order traversal) to explore the tree level by level. For each level, the **first node encountered from the right** side is added to the result.

### 🚀 Steps:

1. If the tree is empty (`root == null`), return an empty list.
2. Use a **queue** to perform BFS. Each element in the queue is a `Pair` of:

   * The current tree node.
   * Its **level** (or depth) in the tree.
3. Maintain a **HashSet** to record which levels are already visited.
4. Traverse the queue:

   * If a level hasn’t been visited before, add that node’s value to the result.
   * Enqueue the **right child first**, then the **left child** — ensuring rightmost nodes are visited first.
5. Continue until the queue is empty.

This ensures that for every level, the **first node processed** (since right is added first) is the one visible from the right side.

---

## 🧩 Code Implementation

```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0)); // 0 represents level

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (!set.contains(p.verticalHeight)) {
                set.add(p.verticalHeight);
                list.add(p.node.val);
            }

            // Right node added first so it's processed first
            if (p.node.right != null) {
                q.add(new Pair(p.node.right, p.verticalHeight + 1));
            }
            if (p.node.left != null) {
                q.add(new Pair(p.node.left, p.verticalHeight + 1));
            }
        }
        return list;
    }
}

class Pair {
    TreeNode node;
    int verticalHeight;

    public Pair(TreeNode node, int verticalHeight) {
        this.node = node;
        this.verticalHeight = verticalHeight;
    }
}
```

---

## 🧾 Example Walkthrough

### Example: `root = [1, 2, 3, null, 5, null, 4]`

**Level 0:** Node `1` → Rightmost visible
**Level 1:** Node `3` → Rightmost visible
**Level 2:** Node `4` → Rightmost visible

✅ Output: `[1, 3, 4]`

---

## 🧮 Complexity Analysis

| Type                | Complexity                                       |
| ------------------- | ------------------------------------------------ |
| ⏱️ Time Complexity  | **O(N)** — Each node is visited once             |
| 💾 Space Complexity | **O(N)** — Queue and HashSet store up to N nodes |

---

## 🧠 Key Points to Remember

* Always **process the right child first** in BFS for right-side view.
* Each level contributes **exactly one node** to the output.
* Using a **level counter** or `Pair` helps track the tree’s depth efficiently.

---

## ✨ Output Examples

| Input                        | Output      |
| ---------------------------- | ----------- |
| `[1,2,3,null,5,null,4]`      | `[1,3,4]`   |
| `[1,2,3,4,null,null,null,5]` | `[1,3,4,5]` |
| `[1,null,3]`                 | `[1,3]`     |
| `[]`                         | `[]`        |

---

## 🧠 Tip for Beginners

To understand BFS better:

* Think of a **queue** as a waiting line of nodes.
* Always **add children** of the current node at the end.
* For right-side view, **add right child before left**.

---

## 🌈 Summary

| Concept         | Description                           |
| --------------- | ------------------------------------- |
| Algorithm       | BFS (Level Order Traversal)           |
| Data Structures | Queue, HashSet, List                  |
| Focus           | First node per level (rightmost view) |
| Output          | List of visible nodes from right      |

---

⭐ **By mastering this pattern**, you can easily solve similar problems like:

* Left View of Binary Tree
* Top/Bottom View of Binary Tree
* Vertical Order Traversal 🌿
