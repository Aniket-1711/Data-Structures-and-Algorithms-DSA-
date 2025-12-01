# 🌳 Maximum Width of Binary Tree

## 📌 Problem Summary

Given the root of a binary tree, find the **maximum width** of the tree.

* The width of a level is the distance between the **leftmost** and **rightmost** non-null nodes.
* Null nodes that would appear in a *complete binary tree* structure are also counted.
* Return the maximum width among all levels.

---

## 🔍 How It Works

To calculate the width:

1. Do a **level-order traversal (BFS)**.
2. Give every node a **virtual index** like in a complete binary tree:

   * Left child → `2 * index + 1`
   * Right child → `2 * index + 2`
3. For each level:

   * Note the **first index** and **last index**.
   * Width = `lastIndex - firstIndex + 1`
4. Track the **maximum width**.

---

## 🧠 Example

For a tree like:

```
       1
     /   \
    3     2
   / \     \
  5   3     9
```

Width at the third level = `9 - 5 + 1 = 4`.

---

## 🧩 Java Solution

```java
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int maxWidth = 0;
        Deque<Pair> queue = new ArrayDeque<>();
        queue.push(new Pair(root, 0));

        while(!queue.isEmpty()){
            int n = queue.size();
            int startIndex = queue.getFirst().index;
            int endIndex = queue.getLast().index;

            maxWidth = Math.max(maxWidth, endIndex - startIndex + 1);

            while(n-- > 0){
                Pair temp = queue.poll();

                if(temp.node.left != null)
                    queue.add(new Pair(temp.node.left, 2 * temp.index + 1));

                if(temp.node.right != null)
                    queue.add(new Pair(temp.node.right, 2 * temp.index + 2));
            }
        }
        return maxWidth;
    }
}

class Pair{
    TreeNode node;
    int index;

    public Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}
```

---

## ✅ Key Points

* BFS is used to process level by level.
* Indexing makes it easy to calculate the width correctly.
* Works efficiently for up to 3000 nodes.

---

## 🏁 Output

The function returns the **maximum width** of the binary tree as an integer.

---

