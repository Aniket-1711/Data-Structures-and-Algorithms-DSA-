# 🍪 Assign Cookies — Greedy Approach

## 📌 Problem

Given two arrays:

* `g[i]` → greed factor of each child (minimum cookie size required)
* `s[j]` → size of each cookie

Each child can receive **at most one cookie**.

A child becomes **content** if:

```
cookie_size >= greed_factor
```

The goal is to **maximize the number of content children**.

---

## 💡 Key Idea (Greedy Strategy)

To satisfy the maximum number of children:

* Give the **smallest possible cookie** that satisfies a child.
* Always try to satisfy the **least greedy child first**.

Why this works:

If a large cookie is given to a child with small greed, it might prevent satisfying another child who actually needs that larger cookie.

---

## 🧠 Algorithm

1. Sort the greed array `g`.
2. Sort the cookie array `s`.
3. Use two pointers:

   * `i` → child index
   * `j` → cookie index
4. If cookie size satisfies the child:

   * Increase satisfied count
   * Move both pointers
5. Otherwise:

   * Move to the next cookie

---

## 🔄 Step-by-Step Example

### Input

```
g = [1,2,3]
s = [1,1]
```

### After Sorting

```
g = [1,2,3]
s = [1,1]
```

### Matching

| Child Greed | Cookie Size | Result      |
| ----------- | ----------- | ----------- |
| 1           | 1           | ✅ Satisfied |
| 2           | 1           | ❌ Too small |

Total satisfied children:

```
1
```

---

## ☕ Java Implementation

```java
import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < g.length && j < s.length) {

            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count;
    }
}
```

---

## ⏱ Time Complexity

| Operation             | Complexity   |
| --------------------- | ------------ |
| Sorting arrays        | `O(n log n)` |
| Two pointer traversal | `O(n + m)`   |

Overall complexity:

```
O(n log n)
```

---

## 🧩 Pattern Used

This problem uses the **Greedy Algorithm pattern**.

Greedy works here because:

* Local optimal choice → smallest cookie for smallest greed
* Leads to global optimal solution → maximum satisfied children

---

## 📚 Key Takeaways

* Sort both arrays to simplify matching
* Use **two pointers** for efficient traversal
* Greedy works when **local best decisions lead to global best results**

---

