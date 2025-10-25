# 🏦 Leetcode Bank - Money Calculation

## 📖 Problem Statement

Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

* He starts by putting in **$1 on Monday**, the first day.
* Every day from Tuesday to Sunday, he will put in **$1 more than the day before**.
* On every subsequent Monday, he will put in **$1 more than the previous Monday**.

Given `n`, return the total amount of money he will have in the Leetcode bank at the end of the `n`th day.

## 🔹 Examples

**Example 1:**

```
Input: n = 4
Output: 10
Explanation: 1 + 2 + 3 + 4 = 10
```

**Example 2:**

```
Input: n = 10
Output: 37
Explanation: (1+2+3+4+5+6+7) + (2+3+4) = 37
```

**Example 3:**

```
Input: n = 20
Output: 96
Explanation: (1+2+3+4+5+6+7) + (2+3+4+5+6+7+8) + (3+4+5+6+7+8) = 96
```

## ✅ Constraints

* 1 <= n <= 1000

## 💻 Java Solution

```java
class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int total = 0;

        // Total from complete weeks
        total += weeks * 28; // base 28 per week
        total += 7 * (weeks * (weeks - 1)) / 2; // extra due to increasing Monday start

        // Add remaining days of the next week
        int start = weeks + 1;
        for (int i = 0; i < days; i++) {
            total += start + i;
        }

        return total;
    }
}
```

## 🔍 Explanation

1. **Complete weeks calculation**

   * Each week has a base sum of `28` (1+2+...+7)
   * Every next week starts with Monday increased by 1, so we add `7 * (weeks * (weeks - 1))/2`

2. **Remaining days calculation**

   * Calculate starting value for the next incomplete week: `start = weeks + 1`
   * Sum up remaining days using `for` loop

3. **Return the total** 💰

## ⚡ Complexity

* **Time Complexity:** O(days % 7) → small loop max 6 iterations
* **Space Complexity:** O(1) → constant space

