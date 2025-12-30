# 🌧️ Minimum Falling Path Sum (LeetCode 931)

## 🧩 Problem Statement

You are given an **n x n** integer matrix.

A **falling path**:

* Starts from **any element in the first row**
* Moves to the next row
* Can go:

  * ⬇️ directly down
  * ↙️ diagonally left
  * ↘️ diagonally right

Your task is to **find the minimum possible sum** of any falling path from top to bottom.

---

## 📥 Example 1

```
Input:
matrix = [[2,1,3],
          [6,5,4],
          [7,8,9]]

Output: 13
```

## 📥 Example 2

```
Input:
matrix = [[-19,57],
          [-40,-5]]

Output: -59
```

---

## 💡 Approach (Dynamic Programming)

We use **Dynamic Programming** to solve this efficiently.

### 🔹 Idea

* Create a `dp` matrix of same size
* `dp[i][j]` stores the **minimum falling path sum to reach cell (i, j)**

### 🔹 Steps

1. **Base Case**:

   * First row has no previous row
   * So, copy first row of `matrix` into `dp`

2. **Transition**:

   * For each cell `(i, j)`:

     * We can come from:

       * top `(i-1, j)`
       * top-left `(i-1, j-1)`
       * top-right `(i-1, j+1)`
     * Take the **minimum** of valid ones

3. **Answer**:

   * Minimum value in the **last row of dp**

---

## 🧠 DP Formula

```
dp[i][j] = matrix[i][j] + min(
    dp[i-1][j],
    dp[i-1][j-1],
    dp[i-1][j+1]
)
```

(Handle boundaries carefully)

---

## 🧪 Time & Space Complexity

* ⏱️ Time: **O(n²)**
* 🧠 Space: **O(n²)**

---

## ✅ Java Solution

```java
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // Base case: first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = dp[i - 1][j];
                int leftDiag = j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int rightDiag = j + 1 < n ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(leftDiag, rightDiag));
            }
        }

        // Find minimum in last row
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }
}
```

---

## 🎯 Key Takeaways

* This is a **classic DP grid problem**
* Always define **dp meaning clearly**
* Final answer may not be at one fixed index

