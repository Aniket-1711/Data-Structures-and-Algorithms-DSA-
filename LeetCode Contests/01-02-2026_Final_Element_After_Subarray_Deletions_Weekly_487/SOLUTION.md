# 🎯 Final Element After Subarray Deletions

## 📌 Problem Summary

You are given an integer array `nums`.

Two players **Alice** and **Bob** play a game:

* Alice plays first and wants to **maximize** the final remaining element.
* Bob plays next and wants to **minimize** the final remaining element.

### Rules

* In each turn, a player removes **any contiguous subarray** whose length is **strictly smaller** than the current array length.
* The remaining elements are concatenated.
* The game continues until **only one element remains**.

Your task is to return the **final remaining element**, assuming both players play optimally.

---

## 🧠 Key Observation (Most Important Part)

No matter how large the array is:

* Players can always remove elements **one by one**.
* The game effectively becomes a choice between the **first element** and the **last element**.

Why?

* Alice removes elements to push the game toward the **larger end value**.
* Bob removes elements to push the game toward the **smaller end value**.
* With optimal play, the middle elements **do not matter**.

👉 So the final result is simply:

```
max(nums[0], nums[n-1])
```

---

## 💡 Strategy

1. Look at the **first element** of the array.
2. Look at the **last element** of the array.
3. Return the **maximum** of the two.

---

## 🧪 Examples

### Example 1

```
nums = [1, 5, 2]
```

* Alice removes `[1]` → `[5, 2]`
* Bob removes `[5]` → `[2]`

✅ Final answer: `2`

---

### Example 2

```
nums = [3, 7]
```

* Alice removes `[3]`
* Only `[7]` remains

✅ Final answer: `7`

---

## 🧾 Java Solution

```java
class Solution {
    public int finalElement(int[] nums) {
        return Math.max(nums[0], nums[nums.length - 1]);
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(1)`
* **Space Complexity:** `O(1)`

---

## ✅ Final Notes

* No simulation required
* No game theory DP needed
* Simple observation leads to optimal solution 🚀

Perfect example of a trick problem where **thinking beats coding** ✨
