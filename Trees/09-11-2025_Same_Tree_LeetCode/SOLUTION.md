# Same Tree 🌳

### Problem Explanation and Recursive Solution Breakdown ✨

---

## 1. The Goal 🏁

Given the roots of two binary trees `p` and `q`, we need to check whether the two trees are **the same**.

### Definition:

Two binary trees are considered the **same** if:

1. They are **structurally identical**, and
2. The corresponding nodes contain **the same values**.

---

## 2. Example Cases 🔢

### Example 1

**Input:** `p = [1,2,3]`, `q = [1,2,3]`

**Output:** `true`

**Explanation:** Both trees have identical structure and node values.

### Example 2

**Input:** `p = [1,2]`, `q = [1,null,2]`

**Output:** `false`

**Explanation:** The structure differs — the second tree has a right child instead of a left child.

### Example 3

**Input:** `p = [1,2,1]`, `q = [1,1,2]`

**Output:** `false`

**Explanation:** Node values differ even though the structures are the same.

---

## 3. Recursive Strategy 🔁

We use recursion to compare each node in the two trees.

### Key Steps:

1. **Base Case 1:** If both nodes are `null`, they are identical → return `true`.
2. **Base Case 2:** If only one node is `null`, trees differ → return `false`.
3. **Value Check:** If the current node values differ → return `false`.
4. **Recursive Case:** Recursively check the left and right subtrees.

If all conditions hold true, both trees are the same.

---

## 4. Implementation 🤝

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Case 1: Both are null → same
        if (p == null && q == null) {
            return true;
        }

        // Case 2: One is null → not same
        if (p == null || q == null) {
            return false;
        }

        // Case 3: Values differ → not same
        if (p.val != q.val) {
            return false;
        }

        // Case 4: Recursively check left and right subtrees
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        // Both subtrees must match
        return left && right;
    }
}
```

---

## 5. Visual Representation 🌲

For `p = [1,2,3]` and `q = [1,2,3]`:

```
Tree 1:        1                Tree 2:        1
              / \                              / \
             2   3                            2   3
```

Each corresponding node (1-1, 2-2, 3-3) matches perfectly → ✅ Same Tree.

---

## 6. Time and Space Complexity ⚙️

* **Time Complexity:** O(n) — Each node is visited once.
* **Space Complexity:** O(h) — Due to recursion stack, where *h* is the tree height.

---

### 🎯 Final Takeaway

* Compare nodes recursively.
* Check structural and value equality.
* Elegant, clean, and efficient recursive solution.
