# 🚀 Count Substrings That Satisfy K-Constraint

## 🧠 Problem Summary

Given:

* A binary string `s`
* An integer `k`

A substring is valid if:

* Number of **0s ≤ k** OR
* Number of **1s ≤ k`

🎯 Goal: Count all such valid substrings

---

## 💡 Key Idea

We generate all substrings and check:

👉 If **either condition is satisfied**, we count it

---

## ⚙️ Approach (Brute Force - Optimal for constraints)

Since `n ≤ 50`, we can safely use **O(n²)**

### Steps:

1. Start from every index `i`
2. Expand substring till `j`
3. Maintain:

   * count of `0`
   * count of `1`
4. If:

   * `count0 ≤ k` OR `count1 ≤ k`
     → count++

---

## 💻 Java Implementation

```java
class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int zeros = 0, ones = 0;

            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '0') zeros++;
                else ones++;

                if (zeros <= k || ones <= k) {
                    count++;
                }
            }
        }

        return count;
    }
}
```

---

## 📊 Example Walkthrough

### Input:

```
s = "10101", k = 1
```

Valid substrings = 12

Invalid substrings:

* "1010"
* "10101"
* "0101"

---

## ⏱️ Complexity

* **Time:** O(n²)
* **Space:** O(1)

---

## 🧩 Why This Works

* Small constraints allow brute force
* We check both conditions efficiently using counters

---

## 🏁 Final Thoughts

* Simple counting problem
* Key is understanding **"OR condition"**
* No need for advanced techniques here
