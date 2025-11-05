# ♟️ N-Queens Problem — README

## 🧠 Problem Overview

The **N-Queens puzzle** is a famous backtracking problem where we must place **N queens** on an **N×N chessboard** in such a way that **no two queens threaten each other**.

✅ Queens cannot share the same:

* Row
* Column
* Diagonal

---

## 🎯 Objective

Given an integer `n`, return **all unique valid configurations** for placing `n` queens on the board.
Each configuration is represented using:

* `'Q'` → Queen 👑
* `'.'` → Empty cell

---

## 🚀 Example (n = 4)

There are **2 valid solutions** for `n = 4`.

### ✅ Output Example:

```
[
 [".Q..","...Q","Q...","..Q."],
 ["..Q.","Q...","...Q",".Q.."]
]
```

---

## 🎨 Visual Chessboard Representation

### ✅ Solution 1

```
. Q . .
. . . Q
Q . . .
. . Q .
```

### ✅ Solution 2

```
. . Q .
Q . . .
. . . Q
. Q . .
```

---

### 🖼️ Board View with Emojis

#### Solution 1

|    |    |    |    |
| -- | -- | -- | -- |
| ⬜  | 👑 | ⬜  | ⬜  |
| ⬜  | ⬜  | ⬜  | 👑 |
| 👑 | ⬜  | ⬜  | ⬜  |
| ⬜  | ⬜  | 👑 | ⬜  |

#### Solution 2

|    |    |    |    |
| -- | -- | -- | -- |
| ⬜  | ⬜  | 👑 | ⬜  |
| 👑 | ⬜  | ⬜  | ⬜  |
| ⬜  | ⬜  | ⬜  | 👑 |
| ⬜  | 👑 | ⬜  | ⬜  |

> 👑 = Queen, ⬜ = Empty tile

---

## 💡 Approach Summary

This problem is solved using **Backtracking**:

1. Place a queen on a safe cell
2. Move to the next row
3. If no safe cell, backtrack
4. Continue until all queens are placed

Your solution checks:

* Column safety
* Upper-left diagonal
* Upper-right diagonal

---

## 🧩 Time & Space Complexity

| Complexity Type  | Value            |
| ---------------- | ---------------- |
| Time Complexity  | `O(N!)`          |
| Space Complexity | `O(N^2)` (board) |

---

## 📌 Java Solution Code

```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        nQueens(board, n, result, 0);
        return result;
    }

    public void nQueens(char[][] board, int n, List<List<String>> list, int row) {
        if (row == n) {
            List<String> l = new ArrayList<>();
            for (char[] r : board) {
                l.add(new String(r));
            }
            list.add(l);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                nQueens(board, n, list, row + 1);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int column) {
        for (int i = 0; i < row; i++) {
            if (board[i][column] == 'Q') return false;
        }

        for (int i = row, j = column; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
```


