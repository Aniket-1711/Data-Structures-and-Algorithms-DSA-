# 🔄 Transformed Array (LeetCode 3379)

## 📌 Problem Summary

You are given an integer array `nums` that works like a **circular array**.

You must create a new array `result` of the same size using these rules:

* ➡️ If `nums[i] > 0` → move `nums[i]` steps **right**
* ⬅️ If `nums[i] < 0` → move `abs(nums[i])` steps **left**
* ⏸️ If `nums[i] == 0` → keep `0`

After moving, store the **value** at the landed index in `result[i]`.

---

## 🔁 Circular Array Rule

* Moving right from last index → wraps to start
* Moving left from index `0` → wraps to end

Modulo (`%`) helps keep indices in range.

---

## 🧠 Key Idea

For any index `i`:

```
newIndex = (i + nums[i]) % n
```

To handle negative values safely:

```
newIndex = (i + nums[i] % n + n) % n
```

---

## ✅ Java Solution

```java
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[i] = nums[(i + nums[i]) % n];
            }
            else if (nums[i] == 0) {
                ans[i] = 0;
            }
            else {
                ans[i] = nums[(i + nums[i] % n + n) % n];
            }
        }
        return ans;
    }
}
```

---

## 🧪 Example

### Input

```
nums = [-1, 4, -1]
```

### Output

```
[-1, -1, 4]
```

---

## ⏱️ Complexity

* **Time:** O(n)
* **Space:** O(n)

---

## ⭐ Notes

* Modulo is very important for circular movement
* Always fix negative indices using `+ n` before `% n`

