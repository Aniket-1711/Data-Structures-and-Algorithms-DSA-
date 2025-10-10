# 🧩 Delete Node in a BST

### 📘 Problem Statement
You are given the root of a **Binary Search Tree (BST)** and an integer **key**.  
Your task is to **delete the node** with the given key and **return the updated root** of the BST.

The deletion process is divided into two steps:
1. **Search** for the node with the given key.
2. **Delete** the node and rearrange the tree while maintaining BST properties.

---

### 🧠 Example 1
**Input:**  
`root = [5,3,6,2,4,null,7], key = 3`  

**Output:**  
`[5,4,6,2,null,null,7]`

**Explanation:**  
We delete node `3`. The tree can be rearranged as either:
- `[5,4,6,2,null,null,7]` ✅  
- `[5,2,6,null,4,null,7]` ✅  
Both are valid BSTs.

---

### 🧠 Example 2
**Input:**  
`root = [5,3,6,2,4,null,7], key = 0`  
**Output:**  
`[5,3,6,2,4,null,7]`  
**Explanation:**  
Since `0` is not in the tree, no change is made.

---

### 🧠 Example 3
**Input:**  
`root = [], key = 0`  
**Output:**  
`[]`

---

### ⚙️ Constraints
- Number of nodes: `0 ≤ n ≤ 10⁴`  
- Each node has a **unique** value.  
- BST is **valid**.  
- `-10⁵ ≤ Node.val, key ≤ 10⁵`

---

### 💡 Approach

The deletion operation in a BST depends on **three cases**:

1. **Node not found:**  
   If `root == null`, just return `null`.

2. **Key smaller or greater than root:**  
   - If `key < root.val` → go to **left subtree**.  
   - If `key > root.val` → go to **right subtree**.  

3. **Key found (root.val == key):**  
   - **Case 1:** Node has **no children** → return `null`.  
   - **Case 2:** Node has **one child** → return that child.  
   - **Case 3:** Node has **two children** →  
     - Find **inorder successor** (smallest node in right subtree).  
     - Replace current node’s value with successor’s value.  
     - Delete the successor from the right subtree recursively.

---

### 🧩 Code Implementation (Java)

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } 
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } 
        else {
            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;

            // Case 3: Two children
            root.val = findInorderSucc(root.right);
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    // Helper to find the inorder successor
    public int findInorderSucc(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
```
## 🧩 Time and Space Complexity
| Operation | Complexity | Explanation                                                                      |
| --------- | ---------- | -------------------------------------------------------------------------------- |
| **Time**  | `O(h)`     | Each recursive step goes down one level; in the worst case, `h = height of BST`. |
| **Space** | `O(h)`     | Recursive call stack proportional to tree height.                                |
## 🌱 Tips

- In a balanced BST, height h = log(n) → efficient deletion.

- In a skewed BST, height h = n → deletion may be slow.
