# 🧩 Longest Common Subsequence (LCS)

## 📌 Problem Statement

Given two strings `text1` and `text2`, find the **length of their longest common subsequence**.

* A **subsequence** is formed by deleting some characters without changing order.
* The characters **do not need to be continuous**.
* If no common subsequence exists, return `0`.

---

## 🧠 Examples

### Example 1

```
Input:  text1 = "abcde", text2 = "ace"
Output: 3
```

Explanation: The LCS is `"ace"`

### Example 2

```
Input:  text1 = "abc", text2 = "abc"
Output: 3
```

Explanation: The LCS is `"abc"`

### Example 3

```
Input:  text1 = "abc", text2 = "def"
Output: 0
```

Explanation: No common subsequence exists.

---

## 🛠️ Approach (Dynamic Programming)

We use a **2D DP table** where:

* `dp[i][j]` = length of LCS between

  * first `i` characters of `text1`
  * first `j` characters of `text2`

### 🔁 Transition

* If characters match:

  ```
  dp[i][j] = 1 + dp[i-1][j-1]
  ```
* If characters do not match:

  ```
  dp[i][j] = max(dp[i-1][j], dp[i][j-1])
  ```

---

## 💻 Java Code

```java
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(m × n)`
* **Space Complexity:** `O(m × n)`

Where:

* `m` = length of `text1`
* `n` = length of `text2`

---

## ✅ Key Takeaways

* This is a **classic DP problem**.
* Always think in terms of **prefixes**.
* Very important for interviews and string DP concepts 🚀
