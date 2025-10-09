
---

## 🟢 **2️⃣ Binary Tree Preorder Traversal — README.md**

```markdown
# 🌲 Binary Tree Preorder Traversal

## 📝 Problem Statement
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Preorder traversal means visiting nodes in the order:
➡️ **Root → Left Subtree → Right Subtree**

---

## 💡 Example

### Example 1
**Input:** `root = [1, null, 2, 3]`  
**Output:** `[1, 2, 3]`

### Example 2
**Input:** `root = [1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9]`  
**Output:** `[1, 2, 4, 5, 6, 7, 3, 8, 9]`

### Example 3
**Input:** `root = []`  
**Output:** `[]`

### Example 4
**Input:** `root = [1]`  
**Output:** `[1]`

---

## ⚙️ Constraints
- Number of nodes: `0 ≤ n ≤ 100`
- Node values: `-100 ≤ Node.val ≤ 100`

---

## 🚀 Approach
In **preorder traversal**, we follow this order:
1. Visit (store) the root node.
2. Traverse the left subtree.
3. Traverse the right subtree.

---

## 💻 Code Implementation (Java)
```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderTrav(root, list);
        return list;
    }

    public void preOrderTrav(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        preOrderTrav(root.left, list);
        preOrderTrav(root.right, list);
    }
}
```
## ⏱️ Complexity

- Time Complexity: O(n)

- Space Complexity: O(n) (recursive stack)
