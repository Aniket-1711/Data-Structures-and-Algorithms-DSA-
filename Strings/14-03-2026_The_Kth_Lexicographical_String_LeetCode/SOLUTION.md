# 🌈 K-th Lexicographical Happy String

## 📌 Problem

Given two integers **n** and **k**, find the **k-th lexicographically smallest happy string** of length `n`.

A **happy string**:

* Uses only characters **a, b, c**
* No two adjacent characters are the same

If there are fewer than `k` happy strings, return an **empty string**.

---

## ✨ Key Observation

For a happy string:

* First character → **3 choices** (`a`, `b`, `c`)
* Every next character → **2 choices** (cannot repeat previous)

Total happy strings:

```
3 * 2^(n-1)
```

---

## 🧠 Core Idea (Greedy + Counting)

Instead of generating **all strings**, directly **build the k-th string**.

At every position:

1. Try characters in lexicographical order → `a`, `b`, `c`
2. Skip characters equal to the previous character
3. Count how many strings start with that prefix
4. If `k` is larger than that count → skip those strings
5. Otherwise choose that character

This lets the algorithm **jump over blocks of strings**.

---

## 📊 Example

Input

```
n = 3
k = 9
```

All happy strings:

```
aba
abc
aca
acb
bab
bac
bca
bcb
cab
cac
cba
cbc
```

The **9th string** → `cab`

---

## ⚙️ Algorithm Steps

1. Compute total happy strings

```
3 * 2^(n-1)
```

2. If `k` is greater than total → return `""`

3. For each position in the string

* Determine how many strings each character block represents
* Iterate characters `a`, `b`, `c`
* Skip invalid characters (same as previous)
* Reduce `k` when skipping blocks
* Choose the correct character

4. Continue until length `n` is built

---

## 💻 Java Implementation

```java
class Solution {

    public String getHappyString(int n, int k) {

        int total = 3 * (1 << (n - 1));
        if (k > total) return "";

        StringBuilder result = new StringBuilder();
        char prev = '#';

        for (int i = 0; i < n; i++) {

            int remaining = n - i - 1;
            int blockSize = 1 << remaining;

            for (char ch : new char[]{'a','b','c'}) {

                if (ch == prev) continue;

                if (k > blockSize) {
                    k -= blockSize;
                } else {
                    result.append(ch);
                    prev = ch;
                    break;
                }
            }
        }

        return result.toString();
    }
}
```

---

## ⏱ Complexity

| Type  | Complexity |
| ----- | ---------- |
| Time  | **O(n)**   |
| Space | **O(1)**   |

No recursion and no need to generate all strings.

---

## 🧩 Pattern Used

This problem uses a common technique:

**Lexicographical Block Skipping**

Used in problems like:

* K-th permutation
* K-th binary string
* K-th lexicographic combination

The idea is to **count how many results start with a prefix and skip entire groups**.

---

## 🚀 Summary

* Happy string → no adjacent equal characters
* Total count → `3 * 2^(n-1)`
* Build answer greedily
* Skip blocks of strings using counting

Efficient and avoids generating unnecessary combinations.
