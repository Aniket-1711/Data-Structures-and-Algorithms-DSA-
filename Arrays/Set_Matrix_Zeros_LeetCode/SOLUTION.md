# 🔢 Set Matrix Zeroes

## 📌 Problem

Given an **m × n matrix**, if any element is `0`, set its **entire row and column** to `0`.

⚠️ The modification must be done **in-place**.

---

## 🧠 Idea Behind the Approach

Instead of immediately changing rows and columns when we see a `0`, we first **remember which rows and columns should become zero**.

We use two helper arrays:

* `rows[]` → keeps track of rows that must be set to zero
* `cols[]` → keeps track of columns that must be set to zero

### Steps

1. Traverse the matrix.
2. If `matrix[i][j] == 0`

   * mark `rows[i] = true`
   * mark `cols[j] = true`
3. Traverse the matrix again.
4. If `rows[i] == true` **or** `cols[j] == true`

   * set `matrix[i][j] = 0`

This avoids modifying the matrix while scanning.

---

## 💻 Java Implementation

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        // Step 1: Mark rows and columns
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // Step 2: Set matrix values to zero
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rows[i] || cols[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
```

---

## ⏱️ Complexity Analysis

**Time Complexity:**
`O(m × n)`

* We traverse the matrix **twice**.

**Space Complexity:**
`O(m + n)`

* Extra arrays to store row and column markers.

---

## 📊 Example

### Input

```
1 1 1
1 0 1
1 1 1
```

### Output

```
1 0 1
0 0 0
1 0 1
```

Explanation:

* The `0` at position `(1,1)` makes **row 1** and **column 1** zero.

---

## ✅ Key Points

* Avoid modifying matrix while detecting `0`s.
* Store affected rows and columns first.
* Then update the matrix in a second pass.

---

