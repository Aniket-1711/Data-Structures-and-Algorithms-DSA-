# 🧮 Unique Number of Occurrences — README

## 📘 Problem Summary

Given an array of integers, the task is to determine whether **each number appears a unique number of times**. If no two numbers share the same frequency, return **true**, otherwise **false**.

---

## ✅ Example

### Input:

```
[1, 2, 2, 1, 1, 3]
```

### Output:

```
true
```

### Explanation:

* `1` appears **3 times**
* `2` appears **2 times**
* `3` appears **1 time**

All counts are different → ✔️ **Unique occurrences**

---

## 🧠 Approach

1. Count how many times each number appears using a dictionary.
2. Store all the occurrence counts in a set.
3. If the number of keys in the dictionary equals the number of values in the set, all occurrences are unique.

---

## 🧾 Python Code

```python
class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        d = {}
        for i in arr:
            d.update({i: arr.count(i)})
        s = set()
        for j in d.values():
            s.add(j)
        if len(d) != len(s):
            return False
        else:
            return True
```

---

## ⚙️ Time Complexity

* `arr.count(i)` runs in **O(n)** each time
* Loop runs **n** times
* Total time complexity: **O(n²)** ❗ (Can be optimized)

---

## 🚀 Optimized Approach (Recommended)

Use a frequency dictionary without repeated counting.

```python
class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        freq = {}
        for n in arr:
            freq[n] = freq.get(n, 0) + 1
        return len(freq.values()) == len(set(freq.values()))
```

🔹 This reduces complexity to **O(n)**.

---

## 🎯 Final Notes

* Use sets to easily check for duplicates.
* Avoid using `arr.count()` inside loops when possible.

