# 📌 Minimum Absolute Difference (LeetCode 1200)

## 🧠 Problem Statement

You are given an array of **distinct integers** `arr`.
Your task is to find **all pairs** `[a, b]` such that:

* `a` and `b` are elements of `arr`
* `a < b`
* `b - a` is the **minimum absolute difference** among all possible pairs

Return the list of such pairs in **ascending order** (pair-wise order).

---

## 🔍 Approach

1. **Sort** the array.
2. Find the **minimum difference** between all adjacent elements.
3. Traverse again and collect all pairs whose difference equals this minimum.

---

## 💻 Java Code

```java
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for(int i = 1; i < arr.length; i++){
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i - 1] == minDiff){
                answer.add(List.of(arr[i - 1], arr[i]));
            }
        }
        return answer;
    }
}
```

---

## 📘 Examples

### Example 1

**Input:** `[4, 2, 1, 3]`
**Output:** `[[1,2], [2,3], [3,4]]`

### Example 2

**Input:** `[1, 3, 6, 10, 15]`
**Output:** `[[1,3]]`

### Example 3

**Input:** `[3, 8, -10, 23, 19, -4, -14, 27]`
**Output:** `[[-14,-10], [19,23], [23,27]]`

---

## ⏱ Time & Space Complexity

* **Time:** O(N log N) due to sorting
* **Space:** O(N) for storing the result Otherwise [ O(1) as it's question requirement to store and return the answer ]

---

✨ This method works efficiently even for large arrays (up to 10⁵ elements).
