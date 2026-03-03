# 🔍 Contains Duplicate II

## 📌 Problem Statement

Given an integer array `nums` and an integer `k`, return **true** if there exist two distinct indices `i` and `j` such that:

* `nums[i] == nums[j]`
* `|i - j| <= k`

Otherwise, return **false**.

---

## 🧠 Approach Used

### 🚀 Sliding Window + HashSet

We maintain a sliding window of size **k**.

At any moment:

* The window contains at most the last `k` elements.
* If the current element already exists in the window → duplicate found within distance `k`.

---

## 🔁 Steps

1. Use a `HashSet` to store elements inside the window.
2. Traverse array using `right` pointer.
3. If element already exists in set → return `true`.
4. Add current element to set.
5. If window size becomes greater than `k`, remove the leftmost element.
6. Continue until end.

---

## 💻 Java Implementation

```java
import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            if (set.contains(nums[right])) {
                return true;
            }

            set.add(nums[right]);

            if (right - left >= k) {
                set.remove(nums[left]);
                left++;
            }
        }

        return false;
    }
}
```

---

## 📊 Example

### Input

```
nums = [1,2,3,1], k = 3
```

### Output

```
true
```

### Explanation

The two `1`s are 3 indices apart, which satisfies the condition.

---

## ⏱ Time Complexity

**O(n)**
Each element is added and removed at most once.

## 📦 Space Complexity

**O(k)**
The set stores at most `k` elements.

---

## 🎯 Key Pattern

Whenever a problem says:

* "Duplicate within range"
* "Index difference <= k"

👉 Think **Sliding Window + HashSet**

---

## ✅ Pattern Category

Sliding Window / Hashing
