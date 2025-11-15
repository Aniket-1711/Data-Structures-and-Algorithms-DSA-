# ♞ Knight Tour Configuration 

This document explains the **recursive knight-tour validation approach** used to determine whether a given `n × n` grid represents a valid knight tour.

## 📌 Problem Overview

### **Constraints**

* `n == grid.length == grid[i].length`
* `3 <= n <= 7`
* `0 <= grid[r][c] < n*n`
* All values in the grid are **unique**

These constraints ensure the grid always contains a complete permutation of numbers from `0` to `n*n - 1`.

### **Input Format**

A single `n × n` integer matrix.

### **Output Format**

* `true` → the grid represents a valid knight tour

* `false` → the grid does not represent a valid knight tour
  A knight must visit every cell of an `n × n` chessboard **exactly once**, starting at position `(0,0)` and following legal knight moves. The board is represented as a grid where:

* Each cell contains a unique integer from `0` to `n*n - 1`.

* The number inside a cell represents the **visit order**.

* `0` indicates the first step, `1` indicates the second step, and so on.

The task is to verify whether the grid forms a valid knight tour.

---

## ♘ Knight Movement

A knight moves in an **L-shape**, with exactly eight possible transitions:

```
(-1, -2), (-1, +2),
(+1, -2), (+1, +2),
(-2, -1), (-2, +1),
(+2, -1), (+2, +1)
```

Each move consists of two steps in one direction and one step in the perpendicular direction.

---

## 🔍 Core Idea of the Recursive Validation

The board is validated by a function that takes:

* Current position `(row, col)`
* Expected step number `target`
* Grid size `n`

At each step:

### ✔️ 1. Boundary and Value Check

The current cell must:

* Be inside the grid
* Contain the expected step number

If not, the path is invalid.

### ✔️ 2. Completion Check

If `target == n*n - 1`, all cells have been validated, meaning the tour is correct.

### ✔️ 3. Knight Move Exploration

All eight possible knight moves are attempted to find the next expected number (`target + 1`).
If any recursive branch succeeds, the tour is valid.

This forms a depth-first search over possible knight paths, but the use of exact expected step numbers ensures the search is highly constrained and efficient.

---

## 💻 Recursive Implementation

```java
class Solution {
    public boolean checkValidGrid(int[][] grid) {
        return isValid(grid, 0, 0, 0, grid.length);
    }

    private boolean isValid(int[][] grid, int row, int col, int target, int n) {
        if (row < 0 || col < 0 || row >= n || col >= n || grid[row][col] != target) {
            return false;
        }

        if (target == n * n - 1) {
            return true;
        }

        return
            isValid(grid, row - 1, col - 2, target + 1, n) ||
            isValid(grid, row - 1, col + 2, target + 1, n) ||
            isValid(grid, row + 1, col - 2, target + 1, n) ||
            isValid(grid, row + 1, col + 2, target + 1, n) ||
            isValid(grid, row - 2, col - 1, target + 1, n) ||
            isValid(grid, row - 2, col + 1, target + 1, n) ||
            isValid(grid, row + 2, col - 1, target + 1, n) ||
            isValid(grid, row + 2, col + 1, target + 1, n);
    }
}
```

The code above reflects the generalized recursive knight tour validation algorithm.

---

# 🧪 Example 1 — Valid Grid

### **Input**

```
[[0,11,16,5,20],
 [17,4,19,10,15],
 [12,1,8,21,6],
 [3,18,23,14,9],
 [24,13,2,7,22]]
```

### **Output**

```
true
```

```
┌────┬────┬────┬────┬────┐
│ 0  │ 11 │ 16 │ 5  │ 20 │
├────┼────┼────┼────┼────┤
│ 17 │ 4  │ 19 │ 10 │ 15 │
├────┼────┼────┼────┼────┤
│ 12 │ 1  │ 8  │ 21 │ 6  │
├────┼────┼────┼────┼────┤
│ 3  │ 18 │ 23 │ 14 │ 9  │
├────┼────┼────┼────┼────┤
│ 24 │ 13 │ 2  │ 7  │ 22 │
└────┴────┴────┴────┴────┘
```

This configuration matches legal knight transitions for every consecutive step.

---

# 🧪 Example 2 — Invalid Grid 

### **Input**

```
[[0,3,6],
 [5,8,1],
 [2,7,4]]
```

### **Output**

```
false
```

```
┌────┬────┬────┐
│ 0  │ 3  │ 6  │
├────┼────┼────┤
│ 5  │ 8  │ 1  │
├────┼────┼────┤
│ 2  │ 7  │ 4  │
└────┴────┴────┘
```

Here, the transition from step `6 → 7` cannot be performed using a legal knight move, making the configuration invalid.

---

# ⏱️ Time Complexity

### Worst Case: **O(8^(n*n))**

Due to branching across 8 knight moves.

### Practical Case:

The strict requirement that the cell must match the exact expected number at every step prunes almost all invalid branches immediately.

Effective complexity is close to **O(n²)** for the allowed board sizes.

---

# 🧾 Space Complexity

### **O(n²)** (maximum recursion depth)

Since a valid knight tour visits every cell exactly once.

---

# 🎯 Final Summary

* The algorithm recursively follows the required numerical order.
* Validity depends on matching the target number and following legal knight moves.
* The grid is accepted only if the entire sequence from `0` to `n*n - 1` is reachable.
* Tables show full visual clarity of example configurations.

---

