# 🧺 Longest Subarray With At Most Two Distinct Integers

## 📌 Problem Statement

Given an array of positive integers, find the **length of the longest subarray** that contains **at most two distinct integers**.

---

## 🧠 Approach Used

### 🚀 Sliding Window + HashMap

We use:

* Two pointers → `left` and `right`
* A `HashMap` to store frequency of elements inside the window

### 🔁 Steps

1. Expand the window using `right` pointer.
2. Add element to HashMap and update its frequency.
3. If distinct elements > 2:

   * Shrink window from `left`
   * Decrease frequency
   * Remove element if frequency becomes 0
4. Update maximum length.

---

## 💻 Java Implementation

```java
import java.util.*;

class Solution {
    public int totalElements(int[] arr) {
        int left = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);

                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
```

---

## 📊 Example

### Input

```
[3, 1, 2, 2, 2, 2]
```

### Output

```
5
```

### Explanation

Longest valid subarray:

```
[1, 2, 2, 2, 2]
```

---

## ⏱ Time Complexity

**O(n)**
Each element is added and removed at most once.

## 📦 Space Complexity

**O(1)**
(HashMap stores at most 2 distinct elements)

---

## 🎯 Key Concept

Whenever a problem says:

* "Longest subarray"
* "At most K distinct elements"

👉 Think **Sliding Window + HashMap**

---

## ✅ Pattern Category

Two Pointer / Sliding Window Pattern
