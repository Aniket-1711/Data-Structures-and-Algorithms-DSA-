# 🔍 Special Positions in a Binary Matrix

## 📌 Problem

Given an `m x n` binary matrix `mat`, find the number of **special positions**.

A position `(i, j)` is called **special** if:

* `mat[i][j] == 1`
* All other elements in **row i** are `0`
* All other elements in **column j** are `0`

---

## 💡 Idea of the Approach

The idea is to check every cell in the matrix.

If a cell contains `1`, we verify whether:

* No other `1` exists in the same **row**
* No other `1` exists in the same **column**

If both conditions are satisfied, that position is a **special position**.

---

## 🧠 Algorithm

1. Initialize a variable `count = 0` to store the number of special positions.
2. Traverse the matrix using two loops (`i` for rows and `j` for columns).
3. If `mat[i][j] == 1`:

   * Assume the position is valid (`flag = true`).
4. Check the entire **row i**:

   * If another `1` exists in the row (except column `j`), set `flag = false`.
5. Check the entire **column j**:

   * If another `1` exists in the column (except row `i`), set `flag = false`.
6. If `flag` remains `true`, increment `count`.
7. Continue until the matrix traversal is complete.

---

## 🧾 Java Implementation

```java
class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        boolean flag = true;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){

                if(mat[i][j] == 1){
                    flag = true;

                    for(int k = 0; k < mat[0].length; k++){
                        if(j != k && mat[i][k] == 1){
                            flag = false;
                            break;
                        }
                    }

                    for(int k = 0; k < mat.length; k++){
                        if(i != k && mat[k][j] == 1){
                            flag = false;
                            break;
                        }
                    }

                    if(flag){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
```

---

## ⏱ Time Complexity

```
O(m * n * (m + n))
```

Explanation:

* Every cell is checked (`m * n`).
* For each `1`, the entire row and column may be scanned.

---

## 💾 Space Complexity

```
O(1)
```

No extra data structures are used.

---

## ✅ Example

Input:

```
mat = [
 [1,0,0],
 [0,1,0],
 [0,0,1]
]
```

Each `1` is the only `1` in its row and column.

Output:

```
3
```

---

## 📦 Key Takeaways

* Brute-force validation of row and column works well for small matrices.
* The approach is simple and easy to implement.
* Useful when constraints are small and space optimization is preferred.
