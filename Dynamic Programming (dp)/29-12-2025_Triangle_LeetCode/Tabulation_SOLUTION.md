# 🔺 Triangle – Minimum Path Sum

## 🧩 Problem Statement

Given a **triangle array**, find the **minimum path sum from top to bottom**.

Rules:

* Start from the top element.
* At each step, you can move to **adjacent numbers** in the row below.

  * From index `i`, you can move to index `i` or `i + 1`.

---

## 📥 Example

### Input

```
triangle = [[2],
            [3,4],
            [6,5,7],
            [4,1,8,3]]
```

### Output

```
11
```

### Explanation

Minimum path:

```
2 → 3 → 5 → 1 = 11
```

---

## 💡 Approach (Dynamic Programming)

* Use a **2D DP array** where:

  * `dp[i][j]` stores the **minimum path sum** to reach position `(i, j)`.

### Key Observations

* First element of each row has **only one parent**.
* Last element of each row has **only one parent**.
* Middle elements have **two parents**, take the minimum.

---

## 🧠 Algorithm

1. Initialize a `dp` array with large values.
2. Set the top of the triangle as the base case.
3. Fill the DP table row by row:

   * First element → comes from directly above.
   * Last element → comes from top-left.
   * Middle elements → minimum of top and top-left.
4. The answer is the **minimum value in the last row**.

---

## 🧪 Java Implementation

```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int dp[][] = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = triangle.get(i).get(j)
                               + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans, dp[m - 1][i]);
        }

        return ans;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n²)`
* **Space Complexity:** `O(n²)`

---

## 🚀 Follow-up

This problem can also be solved using **O(n) extra space** by using a **1D DP array** and updating it from bottom to top.


