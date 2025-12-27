# 🧮 Matrix Diagonal Sum

## 📘 Problem Statement

Given a **square matrix** `mat`, return the **sum of its diagonals**.

Include:

* ✅ All elements from the **primary diagonal**
* ✅ All elements from the **secondary diagonal**
* ❌ Do **not double count** the middle element if the matrix size is odd

---

## 🔍 Understanding Diagonals

### Primary Diagonal

Elements where:

```
row index == column index
```

Example: `mat[0][0]`, `mat[1][1]`, `mat[2][2]`

### Secondary Diagonal

Elements where:

```
column index = n - 1 - row index
```

Example: `mat[0][n-1]`, `mat[1][n-2]`

---

## ✨ Key Idea

* Traverse the matrix **once** using a loop
* Add both diagonal elements for each row
* If `n` is **odd**, subtract the center element once (it was added twice)

---

## 💡 Algorithm

1. Initialize two variables:

   * `mainDiagonalSum`
   * `otherDiagonalSum`
2. Loop from `i = 0` to `n-1`
3. Add:

   * `mat[i][i]` to main diagonal
   * `mat[i][n-1-i]` to secondary diagonal
4. If `n` is odd:

   * Subtract the center element once
5. Return total sum

---

## 🧑‍💻 Code (Java)

```java
class Solution {
    public int diagonalSum(int[][] mat) {
        int mainDiagonalSum = 0;
        int otherDiagonalSum = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            mainDiagonalSum += mat[i][i];
            otherDiagonalSum += mat[i][n - 1 - i];
        }

        // If n is odd, subtract the center element once
        if (n % 2 != 0) {
            otherDiagonalSum -= mat[n / 2][n / 2];
        }

        return mainDiagonalSum + otherDiagonalSum;
    }
}
```

---

## 🧪 Example

Input:

```
[[1,2,3],
 [4,5,6],
 [7,8,9]]
```

Calculation:

* Primary: `1 + 5 + 9 = 15`
* Secondary: `3 + 5 + 7 = 15`
* Center `5` counted twice → subtract once

✅ Output:

```
25
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)`

---

## ✅ Summary

* Simple one-pass solution
* Handles odd and even matrices correctly
* No extra space used

🎉 Efficient and clean approach!
