# 🌳 Level Order Traversal of a Binary Search Tree (BST)

## 📘 Problem Statement

Given an array of **unique elements**, your task is to:
1. **Construct a Binary Search Tree (BST)** using these elements (in the given order).
2. **Print the Level Order Traversal** of the constructed BST — i.e., print the nodes **level by level**, from top to bottom.

Each test case should output levels on **separate lines**, and outputs of different test cases should be separated by an **extra newline**.

---

## 🧠 Understanding the Problem

### 🏷️ Binary Search Tree Property
For every node in a BST:
- All elements in its **left subtree** are **smaller** than the node.
- All elements in its **right subtree** are **greater** than the node.

### 🌀 Level Order Traversal
This traversal prints nodes **level by level**, using a **queue** (Breadth-First Search).

For example, consider this BST:
```
      3
     / \
    2   4
   /     \
  1       5
```

**Level Order Output:**
```
3
2 4
1 5
```

---

## 🧩 Input Format

- T → Number of test cases
- N → Number of nodes in the BST
- A1 A2 A3 ... AN → N unique integers (values to insert into the BST)

 
---

## 📤 Output Format

For each test case:
- Print nodes **level by level** (each level on a new line).
- Separate outputs of different test cases with **one extra newline**.

---

## ⚙️ Constraints

| Constraint | Description |
|-------------|-------------|
| 1 ≤ T ≤ 1000 | Number of test cases |
| 1 ≤ N ≤ 1000 | Number of nodes per test |
| 0 ≤ A[i] ≤ 10000 | Value range of each node |

---

## 🧮 Example

### **Input**
```
3
5
1 2 3 4 5
5
3 2 4 1 5
7
4 5 15 0 1 7 17
``` 

### **Output**

```
1
2
3
4
5

3
2 4
1 5

4
0 5
1 15
7 17
```


---

## 💡 Approach

1. **Construct the BST**
   - Insert each element from the input array into the BST one by one.
   - For insertion:
     - If the value is smaller than the current node → go **left**.
     - If the value is greater → go **right**.

2. **Perform Level Order Traversal**
   - Use a **Queue** to perform **Breadth-First Search (BFS)**.
   - Each queue element stores the node and its **depth level**.
   - Print a newline whenever the depth changes.

3. **Repeat** for all test cases and ensure an empty line separates each test case output.

---

## 🧑‍💻 Java Implementation

```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            Tree tree = new Tree();
            int size = sc.nextInt();

            for (int i = 0; i < size; i++) {
                tree.insert(sc.nextInt());
            }

            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(tree.root, 0));

            int depth = 0;
            while (!queue.isEmpty()) {
                Pair x = queue.poll();

                // Print a new line when we move to the next depth level
                if (depth != x.depth) {
                    System.out.println();
                    depth = x.depth;
                }

                // Add left and right child nodes (if they exist)
                if (x.node.left != null) queue.offer(new Pair(x.node.left, x.depth + 1));
                if (x.node.right != null) queue.offer(new Pair(x.node.right, x.depth + 1));

                // Print the current node
                System.out.print(x.node.data + " ");
            }

            // Print an extra newline between test cases
            System.out.println();
        }
    }
}

class Pair {
    Node node;
    int depth;

    public Pair(Node node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class Tree {
    Node root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }
}
```

## 🧾 Dry Run Example

Let’s dry run for:
`A = [3, 2, 4, 1, 5]`
**Step 1 — Construct BST:**
```
      3
     / \
    2   4
   /     \
  1       5
```
**Step 2 — Level Order Traversal:**

- Level 0 → 3

- Level 1 → 2 4

- Level 2 → 1 5

✅ Output:
```
3
2 4
1 5
```
## 🧩 Time & Space Complexity
| Operation             | Complexity                               |
| --------------------- | ---------------------------------------- |
| BST Insertion         | O(N²) (worst case), O(N log N) (average) |
| Level Order Traversal | O(N)                                     |
| Overall per Test Case | O(N log N) (average)                     |
| Space Complexity      | O(N)                                     |

## 🏁 Summary

**✅ Concepts Used:**

- Binary Search Tree Construction

- Breadth-First Search (BFS) / Level Order Traversal

- Queue Data Structure

**✅ Output Formatting:**

- Each level → new line

- Each test case → separated by one blank line

**✅ Language: Java ☕**
## 🌟 Sample Output Visualization
```
Input:
1
7
4 5 15 0 1 7 17

BST Structure:
          4
        /   \
       0     5
        \      \
         1      15
               /  \
              7    17

Level Order Output:
4
0 5
1 15
7 17
```
