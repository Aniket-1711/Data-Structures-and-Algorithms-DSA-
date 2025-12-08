# ✅ Count Square Sum Triples

📌 **Problem ID:** 1925
📘 **Difficulty:** Easy

---

## 📖 Problem Statement

A **square triple (a, b, c)** is a set of integers such that:

```
a² + b² = c²
```

Given an integer **n**, count how many square triples exist where:

* `1 ≤ a, b, c ≤ n`
* Order matters → `(a, b, c)` and `(b, a, c)` are counted separately

---

## 🧠 Approach

✅ Use a **brute force** method because the constraint is small (`n ≤ 250`).

### Steps:

1. Loop `a` from `1` to `n`
2. Loop `b` from `1` to `n`
3. Calculate `sum = a² + b²`
4. Find `c = √sum`
5. If `c` is an integer **and** `c ≤ n`, count it as a valid triple

---

## 💻 Java Solution

```java
class Solution {
    public int countTriples(int n) {
        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int sum = a * a + b * b;
                int c = (int) Math.sqrt(sum);

                if (c * c == sum && c <= n) {
                    count++;
                }
            }
        }
        return count;
    }
}
```

---

## ✅ Examples

### Example 1

```
Input: n = 5
Output: 2
```

✔️ Valid triples: `(3,4,5)`, `(4,3,5)`

---

### Example 2

```
Input: n = 10
Output: 4
```

✔️ Valid triples:

* `(3,4,5)`
* `(4,3,5)`
* `(6,8,10)`
* `(8,6,10)`

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n²)`
* **Space Complexity:** `O(1)`

---

## 📝 Notes

* Uses `Math.sqrt()` to check perfect squares
* Order of `(a, b)` matters
* Works efficiently within given constraints

---

