# 🚴‍♂️ Highest Altitude 

## 📘 Problem Summary

You start at altitude **0**. You are given an array `gain` where each element tells how much altitude is gained or lost when moving from one point to the next.

Your task is to find the **highest altitude** reached at any point during the trip.

---

## 🧠 Key Idea

* Start at altitude **0**.
* Keep adding each gain value to your current altitude.
* Track the **maximum altitude** reached during the process.

This is basically computing **prefix sums** and taking the maximum.

---

## 🔍 Example Walkthrough

### Example 1

Input: `[-5, 1, 5, 0, -7]`

Altitudes become:

```
Start: 0
0 + (-5) = -5
-5 + 1 = -4
-4 + 5 = 1
1 + 0 = 1
1 + (-7) = -6
```

Highest altitude = **1**

### Example 2

Input: `[-4, -3, -2, -1, 4, 3, 2]`
Altitudes remain ≤ 0 → highest = **0**

---

## 🧾 Java Code

```java
class Solution {
    public int largestAltitude(int[] gain) {
        int prefix[] = new int[gain.length];
        int index = 0, sum = 0, max = 0;

        // Build prefix sums
        for (int i : gain) {
            sum += i;
            prefix[index++] = sum;
        }

        // Find max altitude
        for (int i : prefix) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }
}
```

---

## ✅ Final Notes

* Highest altitude includes the starting point (0).
* Prefix sum method is simple and efficient.
* Works even if all gains are negative.

