# 🌳 Maximum Level Sum of a Binary Tree (LeetCode 1161)

## 📌 Problem Statement

You are given the root of a **binary tree**.

* The root is at **level 1**
* Its children are at **level 2**, and so on

👉 Your task is to **find the smallest level number** that has the **maximum sum of node values**.

---

## 🔍 Key Observations

* Each level has multiple nodes
* We must calculate **sum level by level**
* If two levels have the same maximum sum 👉 **return the smaller level number**

---

## 💡 Approach (Level Order Traversal)

We use **BFS (Breadth First Search)** using a queue.

### Steps:

1. Push the root with level `1` into the queue
2. Traverse nodes level by level
3. Keep adding node values to a `sum` for the current level
4. When the level changes:

   * Compare `sum` with `maxSum`
   * Update answer if `sum` is greater
5. After traversal, **check the last level sum**

---

## 🧠 Why This Works

* BFS guarantees **level-wise traversal**
* Updating answer only when `sum > maxSum` ensures:

  * Maximum sum is chosen
  * Smallest level is automatically preserved

---

## 🧪 Example

```
Input: [1,7,0,7,-8,null,null]

Level 1 → 1
Level 2 → 7 + 0 = 7  ✅
Level 3 → 7 + (-8) = -1

Output: 2
```

---

## ✅ Final Code (Java)

```java
class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(root, 1));

        int level = 1;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int ans = 1;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (level != temp.level) {
                if (sum > maxSum) {
                    maxSum = sum;
                    ans = level;
                }
                level = temp.level;
                sum = 0;
            }

            sum += temp.root.val;

            if (temp.root.left != null)
                queue.add(new Node(temp.root.left, temp.level + 1));
            if (temp.root.right != null)
                queue.add(new Node(temp.root.right, temp.level + 1));
        }

        // handle last level
        if (sum > maxSum) {
            ans = level;
        }

        return ans;
    }
}

class Node {
    TreeNode root;
    int level;

    public Node(TreeNode root, int level) {
        this.root = root;
        this.level = level;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)` (queue)

---

## 🎯 Final Notes

* Handles negative values correctly
* Ensures smallest level is returned on ties
* Clean BFS-based solution

✨ Problem solved efficiently!
