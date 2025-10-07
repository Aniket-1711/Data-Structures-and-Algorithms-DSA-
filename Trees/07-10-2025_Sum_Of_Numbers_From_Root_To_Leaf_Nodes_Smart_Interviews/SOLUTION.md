# 🌳 Sum of Numbers from Root to Leaf Paths

### 🧩 Problem Description  
Given an array of **unique integers**, construct a **Binary Search Tree (BST)** and find the **sum of all numbers formed from root to every leaf path**.  

Each path from the root to a leaf represents a number formed by concatenating the node values along that path.

Since the output can be very large, print the **sum modulo 1000000007**.

---

### 🧠 Example Explanation  

#### Example 1
**Input:**  
1 2 3 4 5

**BST Structure:**  
```

1
 \
  2
   \
    3
     \
      4
       \
        5
```
**Root-to-leaf path:** `1 → 2 → 3 → 4 → 5`  
Formed number = **12345**  
✅ **Output = 12345**

---

#### Example 2
**Input:**  
3 2 4 1 5

**BST Structure:**  
```
    3
   / \
  2   4
 /     \
 1       5
```

**Paths and Numbers Formed:**  
- 3 → 2 → 1 → **321**  
- 3 → 4 → 5 → **345**  

**Total Sum = 321 + 345 = 666**  
✅ **Output = 666**

---

### 🧮 Approach  

1. **BST Construction:**  
   - Insert nodes one by one to maintain BST property:
     - If `x < root.data`, insert in **left subtree**  
     - If `x > root.data`, insert in **right subtree**

2. **Path Formation:**  
   - Perform **DFS (Depth-First Search)** from root to every leaf.
   - Keep track of the number formed by concatenating node values.

3. **Sum Calculation:**  
   - For each path, calculate its numeric value.
   - Sum up all numbers and take the result **mod 1e9+7**.

4. **Handling Large Numbers:**  
   - Use modular arithmetic at every step:
     ```
     newVal = (oldVal * powerOf10 + currentNodeValue) % 1000000007
     ```
   - `powerOf10` adjusts based on the number of digits in the current node value.

---

### 🧩 Dry Run (Example 3)
**Input:**  
4 5 15 2 1 7 17


**BST Structure:**  

```
    4
   / \
  2   5
 /     \
1       15
       /  \
      7    17

```


**Paths:**  
- 4 → 2 → 1 → **421**  
- 4 → 5 → 15 → 7 → **45157**  
- 4 → 5 → 15 → 17 → **451517**  

**Sum = 421 + 45157 + 451517 = 497095**  
✅ **Output = 497095**

---

### 💻 Java Implementation

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            BST tree = new BST();
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                tree.insert(sc.nextInt());
            }

            System.out.println(tree.sOD(tree.root));
        }
    }
}

class BST {
    public static final long m = 1000000007L;
    Node root;

    public void insert(int x) {
        root = insertNode(root, x);
    }

    public Node insertNode(Node root, int x) {
        if (root == null) return new Node(x);
        if (x < root.data) root.left = insertNode(root.left, x);
        else if (x > root.data) root.right = insertNode(root.right, x);
        return root;
    }

    public long sOD(Node root) {
        if (root == null) return 0;
        return solve(root, 0);
    }

    public long solve(Node root, long val) {
        if (root == null) return 0;

        int digits = String.valueOf(root.data).length();
        long powerOf10 = 1;
        for (int i = 0; i < digits; i++) {
            powerOf10 = (powerOf10 * 10) % m;
        }

        long res = (((val % m) * powerOf10) % m + (root.data % m)) % m;

        if (root.left == null && root.right == null)
            return res;

        return (solve(root.left, res) + solve(root.right, res)) % m;
    }
}

class Node {
    int data;
    Node right, left;

    public Node(int data) {
        this.data = data;
        this.right = this.left = null;
    }
}
```
## 🧾 Time & Space Complexity
| Operation     | Complexity                                                    |
| ------------- | ------------------------------------------------------------- |
| BST Insertion | **O(N log N)** (avg) / **O(N²)** (worst case for skewed tree) |
| DFS Traversal | **O(N)**                                                      |
| Space         | **O(H)** (where H = height of tree)                           |

## 🏁 Key Takeaways

✅ Construct BST using insertion order
✅ Use DFS to traverse root-to-leaf paths
✅ Use modular arithmetic to prevent overflow
✅ Handle multi-digit node values properly
## ✨ Example Output
Input:
```
3
5
1 2 3 4 5
5
3 2 4 1 5
7
4 5 15 2 1 7 17
```

Output:
```
12345
666
497095
```
