# 🌳 Binary Tree Inorder Traversal

## 📝 Problem Statement
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Inorder traversal means visiting nodes in the order:
➡️ **Left Subtree → Root → Right Subtree**

---

## 💡 Example

### Example 1
**Input:** `root = [1, null, 2, 3]`  
**Output:** `[1, 3, 2]`

### Example 2
**Input:** `root = [1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9]`  
**Output:** `[4, 2, 6, 5, 7, 1, 3, 9, 8]`

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
We use **recursion** to perform inorder traversal:
1. Traverse the left subtree.
2. Visit (store) the root node.
3. Traverse the right subtree.

---

## 💻 Code Implementation (Java)
```java
class Solution {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTrav(root, list);
        return list;
    }

    public void inOrderTrav(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inOrderTrav(root.left, list);
        list.add(root.val);
        inOrderTrav(root.right, list);
    }
}
```
## ⏱️ Complexity

- Time Complexity: O(n)

- Space Complexity: O(n) (recursive stack)
