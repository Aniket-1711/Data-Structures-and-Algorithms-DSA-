# ♟️ N-Queens II — README

## 🧠 Problem Overview

The **N-Queens II** problem asks us to place **N queens** on an **N×N chessboard** such that **no two queens attack each other**, just like the classic N‑Queens problem.

But here’s the difference:

> ✅ **We only need to return the *number* of valid arrangements**, not the boards themselves.

---

## 🎯 Objective

Given an integer `n`, return **how many distinct solutions** exist for placing `n` queens.

### Example

#### **Input:**

```
n = 4
```

#### **Output:**

```
2
```

👉 There are exactly **2 ways** to place 4 queens safely.

---

## 🔍 Key Concepts

* Backtracking ♻️
* Queen placement safety ✅
* No two queens can share:

  * Row
  * Column
  * Diagonal

We use recursion to try placing queens row‑by‑row and **count** each valid configuration.

---

## 📌 Java Solution Code

```java
class Solution {
    public static int gcount = 0;

    public int totalNQueens(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        nQueens(board, n, 0);
        int count = gcount;
        gcount = 0; // reset for next function call
        return count;
    }

    public void nQueens(char board[][], int n, int row) {
        if (row == n) {
            gcount++;
            return; 
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                nQueens(board, n, row + 1);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    public boolean isSafe(char board[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}
```

---

## 💡 Intuition

* You place queens one row at a time
* If a spot is safe, continue
* If you reach the last row → **one solution found 🎉**
* Instead of storing boards, just **increment a counter**

---

## 📈 Time & Space Complexity

| Category | Complexity                 |
| -------- | -------------------------- |
| Time     | `O(N!)` (same as N‑Queens) |
| Space    | `O(N^2)` (board space)     |

---

