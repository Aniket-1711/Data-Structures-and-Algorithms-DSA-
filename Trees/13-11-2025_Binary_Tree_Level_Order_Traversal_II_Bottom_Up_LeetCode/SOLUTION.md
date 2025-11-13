# Binary Tree Level Order Traversal II (Bottom-Up)

## 📌 Problem

Given the `root` of a binary tree, return the **bottom-up level order traversal** of its nodes' values — i.e., traverse the tree level by level from leaf to root, and within each level from left to right.

### Examples

**Example 1**

```
Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
```

**Example 2**

```
Input: root = [1]
Output: [[1]]
```

**Example 3**

```
Input: root = []
Output: []
```

---

## ✅ Intuition (simple)

Level-order traversal (top → bottom) is done with **BFS** using a queue. To return **bottom → top**, we can either:

1. Do normal BFS, collect each level in a list, and then **reverse** the final list of levels; or
2. Insert each completed level at the **front** of the result (i.e., `result.add(0, level)`) while doing BFS — this produces bottom-up order directly.

The second option is clean and avoids an explicit reverse step.



---

## 🧭 Approach (BFS, add levels at front)

1. If `root` is `null`, return an empty list.
2. Create a queue and add `root`.
3. While queue is not empty:

   * Determine `size = queue.size()` (nodes in current level).
   * Create a `level` list.
   * For `size` times: poll a node, add its value to `level`, and enqueue its left and right children (if not null).
   * Insert the `level` at index `0` of the `result` list: `result.add(0, level)`.
4. Return `result`.


---

## 💻 Java Implementation

```java
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            // Insert this level at the front to build bottom-up order
            result.add(0, level);
        }

        return result;
    }
}
```

---

## ⏱ Complexity

* **Time:** O(N) — each node is visited once.
* **Space:** O(N) — queue + result storage. In the worst case (complete tree), the last level may contain ~N/2 nodes.

---

## ⚠️ Edge Cases & Pitfalls

* `root == null` → return `[]`.
* Inserting at index `0` (`result.add(0, level)`) is O(k) for shifting, where k is current number of levels. Overall still O(N) because total shifted elements across all inserts ≤ N.
* Do not confuse this with a DFS approach; DFS needs tracking of depth and more bookkeeping.
* Using `Collections.reverse(result)` after BFS is a correct alternative; both are fine.

---

## 🧪 Example Walkthrough (Example 1)

Tree:

```
    3
   / \
  9  20
    /  \
   15   7
```

BFS levels (top → bottom):

* Level 1: [3]
* Level 2: [9, 20]
* Level 3: [15, 7]

Inserting at front each time gives:

* after level1: [[3]]
* after level2: [[9,20], [3]]
* after level3: [[15,7], [9,20], [3]]

Final output: `[[15,7],[9,20],[3]]`


---

## 🔁 Variations

* **Do BFS then reverse:** collect levels in order and call `Collections.reverse(result)` before returning.
* **DFS approach:** do depth-first traversal and add node values to lists indexed by depth, then reverse or build from max depth down — more work but useful if you already have a depth-tracking DFS.

---

## ✅ Quick Tips

* Use `ArrayDeque` for the queue — it's efficient.
* Use `List<Integer> level = new ArrayList<>(size)` to avoid resizing.
* If memory shifts from `add(0, ...)` worry you, use BFS + `Collections.reverse()` which does a single pass reverse.

---
