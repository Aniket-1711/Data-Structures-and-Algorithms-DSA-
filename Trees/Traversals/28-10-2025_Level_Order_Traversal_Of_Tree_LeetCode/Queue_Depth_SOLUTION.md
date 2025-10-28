# 🌳 **Binary Tree Level Order Traversal**

---

### 📘 **Problem Statement**

Given the **root** of a binary tree, return the **level order traversal** of its nodes' values — that means visiting nodes **level by level**, from **left to right**.

---

### 💻 **Java Solution (Using Pair & Depth)**

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<Pair> queue=new ArrayDeque<>();
        queue.add(new Pair(root, 0));
        int depth=0;
        List<List<Integer>> sol=new ArrayList<>();
        if(root==null) return sol;
        List<Integer> list=new ArrayList<>();

        while(!queue.isEmpty()){
            Pair temp=queue.poll();
            if(temp.depth!=depth){
                sol.add(list);
                list=new ArrayList<>();
                System.out.println();
                depth=temp.depth;
            }

            if(temp.node!=null)
            list.add(temp.node.val);

            if(temp.node!=null && temp.node.left!=null) queue.add(new Pair(temp.node.left, temp.depth+1));
            if(temp.node!=null && temp.node.right!=null) queue.add(new Pair(temp.node.right, temp.depth+1));

            if(temp.node!=null){
            System.out.print(temp.node.val+" ");
            }
        }
            sol.add(list);  //adding the last level
        return sol;
    }
}

class Pair{
    TreeNode node;
    int depth;

    public Pair(TreeNode node, int depth){
        this.node=node;
        this.depth=depth;
    } 
}


```

---

### 🧠 **Explanation (Step-by-Step)**

1. ✅ **Pair class** stores each node with its depth.
2. 🧺 **Queue** is used to perform level-wise traversal (BFS).
3. 🔁 Each time the depth changes, add the collected nodes of that level to `sol`.
4. 🧱 Create a new list for the next level to avoid clearing issues.
5. 📋 Finally, return the list of lists representing each level.

---

### 🕒 **Complexity Analysis**

* **Time Complexity:** `O(N)` — each node is processed once.
* **Space Complexity:** `O(N)` — for the queue and result lists.

---

### 🌈 **Example Visualization**

For this tree:

```
        3
       / \
      9   20
          / \
         15  7
```

➡️ Traversal order → 3 → 9 → 20 → 15 → 7
➡️ Grouped by levels → [[3], [9, 20], [15, 7]]

---

✨ **Result:** Your solution correctly performs level order traversal using BFS and depth tracking! 🚀
