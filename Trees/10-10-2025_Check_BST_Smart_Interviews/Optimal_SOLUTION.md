# Check BST (Binary Search Tree) ✅

## Problem Statement
Given a **binary tree** with **unique elements**, check whether it is a **Binary Search Tree (BST)**.  

The binary tree is provided as a **complete binary tree**, represented using an **array**.  
Assume the array is **1-indexed** for explanation, but in implementation, we use **0-indexed arrays**.  

For a node at index `i`:
- **Left child** → `2*i + 1`
- **Right child** → `2*i + 2`

---

## Input Format
- First line: `T` — number of test cases  
- For each test case:
  1. `N` — number of nodes in the tree  
  2. `N` integers — values of nodes in the complete binary tree  

### Output Format
For each test case, print:
- `"True"` if the tree is a BST  
- `"False"` otherwise  

---

## Constraints
- `1 <= T <= 1000`  
- `1 <= N <= 1000`  
- `0 <= ar[i] <= 10000`  

---

## Example

**Input**
```
5
11
92 10 963 5 334 928 973 2 9 263 860
9
156 153 6947 149 154 1761 7230 9 152
4
40 49 87 651
5
449 792 594 688 618
15
736 43 882 3 460 741 887 0 42 247 465 739 844 886 888
```


**Output**
```
False
True
False
False
True
```

---

## Approach / Solution

We use a **recursive range-based method** to verify the BST property:

1. **Tree Representation:**  
   - The tree is represented as an array.
   - For node at index `i`:  
     - Left child → `2*i + 1`  
     - Right child → `2*i + 2`  

2. **BST Property Validation:**  
   - Each node must satisfy:  
     ```
     min < node.val < max
     ```
     where `min` and `max` are the allowed value ranges passed recursively.  
   - For the **left child**, the new range is `(min, node.val)`.  
   - For the **right child**, the new range is `(node.val, max)`.  

3. **Recursion Base Case:**  
   - If the index exceeds the array length → return `true`.  
   - If a node value is `0` (empty) → return `true`.

4. **Recursive Step:**  
   - Check left subtree: `checkBst(left child, min, node.val)`  
   - Check right subtree: `checkBst(right child, node.val, max)`  
   - Return `true` if both subtrees are valid.

This ensures **all nodes satisfy BST rules** globally.

---

## Complexity Analysis

- **Time Complexity:** `O(N)` — each node is visited once.  
- **Space Complexity:** `O(H)` — recursion stack, where `H` is the height of the tree (`log N` for complete tree).

---

## Java Implementation

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            if (checkBst(ar, 0, n, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

    public static boolean checkBst(int ar[], int index, int n, int min, int max) {
        if (index >= n || ar[index] == 0) return true;
        if (ar[index] <= min || ar[index] >= max) return false;
        return checkBst(ar, index * 2 + 1, n, min, ar[index]) &&
               checkBst(ar, index * 2 + 2, n, ar[index], max);
    }
}
```
