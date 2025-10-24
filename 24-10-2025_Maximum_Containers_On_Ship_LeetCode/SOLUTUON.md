## ⛵ Maximum Containers on a Ship

**Difficulty:** Easy
**Topic:** Greedy / Math
**Companies:** 💼 Amazon | 💼 Microsoft | 💼 Google

---

### 🔎 Problem Description

You are given a positive integer `n` representing an `n x n` cargo deck on a ship. Each cell on the deck can hold **one container** with a weight of exactly `w`.

However, the **total weight** of all containers, if loaded onto the deck, must not exceed the ship's **maximum weight capacity**, `maxWeight`.

Your task is to return the **maximum number of containers** that can be loaded onto the ship.

---

### 🖊️ Example 1:

```text
Input: n = 2, w = 3, maxWeight = 15
Output: 4
```

**Explanation:**
The deck has `2 x 2 = 4` cells.
Each container weighs `3`.
Total weight = `4 * 3 = 12`, which does not exceed `15`.
Hence, **4 containers** can be loaded.

---

### 🖊️ Example 2:

```text
Input: n = 3, w = 5, maxWeight = 20
Output: 4
```

**Explanation:**
The deck has `3 x 3 = 9` cells.
Each container weighs `5`.
If we load all, total = `9 * 5 = 45`, which exceeds `20`.
The maximum number that fits: `4 * 5 = 20`.
So, **4 containers** can be loaded.

---

### 📈 Constraints

```
1 <= n <= 1000
1 <= w <= 1000
1 <= maxWeight <= 10^9
```

---

### 📝 Approach

1. Calculate total cells = `n * n`.
2. If `total_cells * w <= maxWeight`, return all cells (load all containers).
3. Otherwise, iterate from `n*n - 1` down to `1` and check the highest possible number `i` such that `i * w <= maxWeight`.

---

### 💡 Optimized Insight

Instead of looping, you can directly compute:

```java
int maxContainers = Math.min(n * n, maxWeight / w);
```

This gives the same result in **O(1)** time.

---

### 👨‍💻 Java Code

```java
class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        if (n * n * w <= maxWeight) {
            return n * n;
        } else {
            for (int i = n * n - 1; i > 0; i--) {
                if (i * w <= maxWeight) {
                    return i;
                }
            }
        }
        return 0;
    }
}
```

---

### 🚀 Optimized Version

```java
class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(n * n, maxWeight / w);
    }
}
```

---

### 💡 Key Takeaway

The optimized solution avoids looping and works efficiently even for large inputs, thanks to simple integer division.

