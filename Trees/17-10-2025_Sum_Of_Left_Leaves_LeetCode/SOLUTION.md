# 🌿 Sum of Left Leaves

## 🧩 Problem Description

Given the **root** of a binary tree, return the **sum of all left leaves**.

A **leaf** is a node with **no children**.
A **left leaf** is a leaf that is the **left child** of another node.

---

## 🧠 Example 1

**Input:**

```
root = [3,9,20,null,null,15,7]
```

**Output:**

```
24
```

**Explanation:**
There are two left leaves in the binary tree:

* `9` (left child of `3`)
* `15` (left child of `20`)

Sum = 9 + 15 = **24**

---

## 🌳 Example 2

**Input:**

```
root = [1]
```

**Output:**

```
0
```

**Explanation:**
There are no left leaves in this tree.

---

## ⚙️ Constraints

* The number of nodes in the tree is in the range `[1, 1000]`.
* `-1000 <= Node.val <= 1000`

---

## 🧮 Approach

1. Traverse the binary tree recursively.
2. For every node:

   * Check if its **left child** is a **leaf node** (`left.left == null && left.right == null`).
   * If yes, add that value to the total sum.
3. Recurse on both left and right subtrees to explore the entire tree.
4. Return the accumulated sum.

---

## 💻 Code Implementation (Java)

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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;   // base case

        // if root is a single node (no children), no left leaf exists
        if (root.left == null && root.right == null) return 0;

        return inOrder(root);
    }

    public int inOrder(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;

        // check if left child is a leaf
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        // recursively traverse left and right subtrees
        sum += inOrder(root.left);
        sum += inOrder(root.right);

        return sum;
    }
}
```

---

## 🧾 Example Dry Run

### Input Tree:

```
    3
   / \
  9  20
    /  \
   15   7
```

| Step | Node | Action                           | Sum |
| ---- | ---- | -------------------------------- | --- |
| 1    | 3    | left child (9) is leaf → add 9   | 9   |
| 2    | 20   | left child (15) is leaf → add 15 | 24  |
| 3    | 7    | no left leaf                     | 24  |

✅ **Final Answer: 24**

---

## 🧠 Key Points

* Only add **left** leaf values.
* Recursion helps in simplifying tree traversal.
* If `root == null`, immediately return `0`.

---

## 🏁 Output Verification

| Input                                   | Output | Explanation         |
| --------------------------------------- | ------ | ------------------- |
| `[3,9,20,null,null,15,7]`               | `24`   | Left leaves = 9, 15 |
| `[1]`                                   | `0`    | No left leaves      |
| `[0,2,4,1,null,3,-1,5,1,null,6,null,8]` | `11`   | (2 + 3 + 6)         |

---

## 💬 Conclusion

This problem is a classic example of **tree traversal using recursion**, where careful condition checking helps isolate **specific node types** (left leaves).
By understanding the structure of a binary tree and applying simple recursive logic, we can efficiently solve this problem in **O(N)** time complexity.

---

