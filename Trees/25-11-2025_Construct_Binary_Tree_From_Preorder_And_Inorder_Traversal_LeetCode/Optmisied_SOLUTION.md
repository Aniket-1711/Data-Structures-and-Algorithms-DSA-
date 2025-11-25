# 🌳 Construct Binary Tree Using Preorder & Inorder (Optimized using HashMap)

## ⚡ Problem Overview

Reconstruct a binary tree using:

* **Preorder traversal** → gives the order of roots
* **Inorder traversal** → divides tree into left and right subtrees

This version uses a **HashMap** for O(1) searching of inorder indices.

---

## 🚀 Why Use HashMap?

Normally, searching for the root inside the inorder array takes **O(n)** time.
Doing this for all nodes results in **O(n²)** time.

Using a HashMap:

* Each value of inorder → stored with its index
* Lookup becomes **O(1)**
* Total time reduces to **O(n)**

---

## 🧠 Key Idea

1. First element of preorder → root
2. Use HashMap to find root index in inorder in constant time
3. Build left subtree from `left → rootIndex - 1`
4. Build right subtree from `rootIndex + 1 → right`
5. Use a global `index` to move through preorder

---

## 🛠️ Java Implementation (Optimized)

```java
class Solution {
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int c = 0;
        for (int i : inorder) {
            map.put(i, c++);
        }
        return bTree(preorder, inorder, 0, inorder.length - 1, map);
    }

    public TreeNode bTree(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map) {
        if (left > right) return null;

        TreeNode root = new TreeNode(preorder[index]);
        int rootIndex = map.get(preorder[index]);
        index++;

        root.left = bTree(preorder, inorder, left, rootIndex - 1, map);
        root.right = bTree(preorder, inorder, rootIndex + 1, right, map);

        return root;
    }
}
```

---

## 🔍 Time & Space Complexity

### **Time Complexity: O(n)**

* Each node is processed once
* HashMap provides O(1) root lookup

### **Space Complexity: O(n)**

* HashMap stores inorder indices
* Recursion stack

---

## 🌟 Example

### Input

```
preorder = [3, 9, 20, 15, 7]
inorder  = [9, 3, 15, 20, 7]
```

### Output Tree

```
        3
       / \
      9  20
        /  \
       15   7
```

---

## 🎯 Summary

* HashMap makes searching fast
* Preorder selects root
* Inorder splits subtree regions
* Recursion builds complete tree efficiently

