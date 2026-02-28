# 📌 3852. Smallest Pair With Different Frequencies

## 🧠 Problem Statement

Given an integer array `nums`, find a pair `[x, y]` such that:

* `x < y`
* `x` and `y` have **different frequencies** in the array

### 🎯 Selection Rules

1. Choose the pair with the **smallest possible `x`**.
2. If multiple pairs have the same `x`, choose the one with the **smallest possible `y`**.
3. If no valid pair exists, return `[-1, -1]`.

---

## 📝 Approach

### 1️⃣ Sort the Array

Sorting helps to:

* Easily get the smallest value
* Ensure we check pairs in increasing order

### 2️⃣ Count Frequencies

Use a `HashMap<Integer, Integer>` to store:

```
Number → Frequency
```

### 3️⃣ Find Smallest Valid Pair

* Take the smallest number `min`
* Traverse the array
* Check for first number `i` such that:

  * `i > min`
  * `frequency(i) != frequency(min)`

Return `[min, i]`

If no such pair exists → return `[-1, -1]`

---

## 💻 Java Code

```java
class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        // Count frequencies
        for (int i : nums) {
            if (i < min) {
                min = i;
            }

            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        // Find valid pair
        for (int i : nums) {
            if (i > min && map.get(i) != map.get(min)) {
                return new int[]{min, i};
            }
        }

        return new int[]{-1, -1};
    }
}
```

---

## ⏱ Time & Space Complexity

* **Time Complexity:** `O(n log n)` → due to sorting
* **Space Complexity:** `O(n)` → for HashMap

---

## ✅ Example

Input:

```
[1,1,2,2,3,4]
```

Frequencies:

```
1 → 2
2 → 2
3 → 1
4 → 1
```

Smallest valid pair:

```
[1, 3]
```

---

## 🚀 Key Concepts Used

* Sorting
* HashMap (Frequency counting)
* Greedy selection

---

✨ Clean and simple logic — first fix smallest `x`, then find smallest valid `y`.
