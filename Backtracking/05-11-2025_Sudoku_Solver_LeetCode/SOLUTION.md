# 🧩 Sudoku Solver (Backtracking) 

## 📘 Problem Overview

Sudoku is a 9x9 grid puzzle where each cell must contain a digit **1–9**, and the final grid must satisfy:

✔️ Each row has digits 1–9 exactly once

✔️ Each column has digits 1–9 exactly once

✔️ Each 3×3 sub‑grid has digits 1–9 exactly once

✔️ Empty cells are represented by `.`

This implementation uses **Backtracking**, a depth‑first search algorithm.

---

## 🧠 Key Idea

We fill the board **cell by cell**, trying digits `1–9`. If a digit fits the Sudoku rules:

* Place it
* Recursively try to fill the next cell
* If stuck, undo (backtrack) and try another digit

When we reach `row == 9`, the board is complete ✅

---

## ✅ Algorithm Strategy

| Step | Action                                                    |
| ---- | --------------------------------------------------------- |
| 1️⃣  | If `row == 9`, puzzle solved → return true                |
| 2️⃣  | Move to next cell (right). If column ends, go to next row |
| 3️⃣  | If cell is already filled, continue to next cell          |
| 4️⃣  | Try digits `1–9`                                          |
| 5️⃣  | If valid → place digit → recursively solve                |
| 6️⃣  | If recursion fails → undo (backtrack)                     |

---

## 💡 Checking Validity

Before placing a digit, we ensure:

* It is **not in the current row**
* It is **not in the current column**
* It is **not in the 3×3 box**

Only then the placement is valid ✅

---

## 🧾 Full Code (Same as Your Solution)

```java
class Solution {
    public void solveSudoku(char[][] board) {
        sudokuAns(board,0,0);
    }

    public boolean sudokuAns(char board[][], int row,int col){
        if(row==9){
            return true;
        }

        int nextRow=row;
        int nextCol=col+1;
        if(nextCol==9){
            nextRow=row+1;
            nextCol=0;
        }

        if(board[row][col]!='.'){
            return sudokuAns(board,nextRow,nextCol);
        }

        for(int i=1;i<10;i++){
           if(isValid(board, row, col, i)){
            //place the digit if it is valid to be placed in the grid (9*9)
                board[row][col]=(char)(i+'0');
                //if the next function call returns true then we need not backtrack directly return true;
                if(sudokuAns(board, nextRow, nextCol)){
                    return true;
                }
                //backtrack
                board[row][col]='.';
           }
        }
           return false;
    }

    public boolean isValid(char board[][], int row, int column, int num){
        for(int i=0;i<9;i++){
            if(board[row][i]==(char)(num+'0')){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][column]==(char)(num+'0')){
                return false;
            }
        }

        for(int i=(row/3)*3;i<(row/3)*3 + 3;i++){
            for(int j=(column/3)*3;j<(column/3)*3 + 3;j++){
                if(board[i][j]==(char)(num+'0')){
                    return false;
                }
            }
        }
        return true;
    }
}
```

---

## 🚀 Time & Space Complexity

| Metric | Complexity                              |
| ------ | --------------------------------------- |
| Time   | Worst case ~ O(9^(n)) (backtracking)    |
| Space  | O(1) (in‑place board) + recursion stack |

---


