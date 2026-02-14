# 📈 Best Time to Buy and Sell Stock (LeetCode 121)

## 🧠 Problem Summary

You are given an array `prices` where each element represents the stock price on a given day.

* You can **buy once** and **sell once**.
* You must **buy before you sell**.
* Goal: **maximize profit**.
* If no profit is possible, return `0`.

---

## ✅ Example

### Example 1

```
Input:  [7,1,5,3,6,4]
Output: 5
```

**Explanation:** Buy at price `1` and sell at price `6` → Profit = `5`

### Example 2

```
Input:  [7,6,4,3,1]
Output: 0
```

**Explanation:** Prices only go down, so no profit.

---

## 💡 Approach Used (Right Max Array)

1. Create an array `rightMax[]` to store the **maximum price to the right** of each day.
2. Traverse from **right to left** and fill `rightMax`.
3. Traverse from **left to right** and calculate profit:

   ```
   profit = rightMax[i] - prices[i]
   ```
4. Keep track of the **maximum profit**.

---

## 🧪 Dry Run

For `prices = [7,1,5,3,6,4]`

| Day | Price | Right Max | Profit |
| --- | ----- | --------- | ------ |
| 0   | 7     | 6         | -1     |
| 1   | 1     | 6         | 5 ✅    |
| 2   | 5     | 6         | 1      |
| 3   | 3     | 6         | 3      |
| 4   | 6     | 6         | 0      |
| 5   | 4     | 4         | 0      |

**Max Profit = 5**

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)` (extra `rightMax` array)

---

## 🧩 Java Solution

```java
class Solution {
    public int maxProfit(int[] prices) {
        int rightMax[] = new int[prices.length];
        int max = Integer.MIN_VALUE;
        int ans = 0;

        // Fill rightMax array
        for (int i = prices.length - 1; i >= 0; i--) {
            rightMax[i] = Math.max(max, prices[i]);
            max = Math.max(max, prices[i]);
        }

        // Calculate maximum profit
        for (int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, rightMax[i] - prices[i]);
        }

        return ans;
    }
}
```

---

## 📝 Notes

* This solution is beginner-friendly and easy to understand.
* There is also a **more optimized O(1) space** solution using minimum price tracking.
