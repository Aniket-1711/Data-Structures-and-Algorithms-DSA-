# ✂️ Minimum Deletion Cost to Make All Characters Equal

## 📌 Problem Statement

You are given:

* A string **s** of length `n`
* An integer array **cost** of the same length, where `cost[i]` is the cost to delete `s[i]`

You can delete **any number of characters** (possibly none) such that:

* The final string is **non-empty**
* All remaining characters are **the same**

Return the **minimum total deletion cost** needed.

---

## 🧠 Key Idea

To make all characters equal, we must:

* **Choose one character** to keep (like `'a'`, `'b'`, `'c'`, etc.)
* **Delete all other characters**

For every **distinct character** in the string:

1. Assume this character will remain
2. Add the deletion cost of all other characters
3. Keep track of the minimum cost among all choices

---

## 🛠️ Approach

1. Use a `HashSet` to collect all **unique characters** from the string
2. For each unique character:

   * Traverse the string
   * Add deletion cost where characters are **not equal** to the chosen one
3. Return the **minimum cost** found

---

## 💻 Java Solution

```java
class Solution {
    public long minCost(String s, int[] cost) {
        HashSet<Character> set = new HashSet<>();
        
        // collect unique characters
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        
        long ans = Long.MAX_VALUE;
        
        // try keeping each character
        for (char ch : set) {
            ans = Math.min(ans, minCost(s, cost, ch));
        }
        
        return ans;
    }

    public long minCost(String s, int[] cost, char ch) {
        long ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ch) {
                ans += cost[i];
            }
        }
        
        return ans;
    }
}
```

---

## 📊 Example Walkthrough

### Example 1

**Input:**

```
s = "aabaac"
cost = [1,2,3,4,1,10]
```

If we keep `'c'`:

* Delete all other characters
* Cost = `1 + 2 + 3 + 4 + 1 = 11`

This is the **minimum possible cost**.

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n × k)`

  * `n` = length of string
  * `k` = number of unique characters (max 26)

* **Space Complexity:** `O(k)`

  * HashSet to store unique characters

---

## ✅ Important Notes

* Uses `long` to avoid overflow (cost values can be large)
* Guarantees non-empty result by keeping at least one character
* Simple brute-force over character choices

---
