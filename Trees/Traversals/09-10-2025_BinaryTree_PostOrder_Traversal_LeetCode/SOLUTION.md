
---

## 🟢 **3️⃣ Binary Tree Postorder Traversal — README.md**

```markdown
# 🌴 Binary Tree Postorder Traversal

## 📝 Problem Statement
Given the root of a binary tree, return the postorder traversal of its nodes' values.

Postorder traversal means visiting nodes in the order:
➡️ **Left Subtree → Right Subtree → Root**

---

## 💡 Example

### Example 1
**Input:** `root = [1, null, 2, 3]`  
**Output:** `[3, 2, 1]`

### Example 2
**Input:** `root = [1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9]`  
**Output:** `[4, 6, 7, 5, 2, 9, 8, 3, 1]`

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
In **postorder traversal**, we follow this order:
1. Traverse the left subtree.
2. Traverse the right subtree.
3. Visit (store) the root node.

---

## 💻 Code Implementation (Java)
```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderTrav(root, list);
        return list;
    }

    public void postOrderTrav(TreeNode root, List<Integer> list) {
        if (root == null) return;

        postOrderTrav(root.left, list);
        postOrderTrav(root.right, list);
        list.add(root.val);
    }
}
```
## ⏱️ Complexity

- Time Complexity: O(n)

- Space Complexity: O(n) (recursive stack)
