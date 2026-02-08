# 🧮 Product of Array Except Self (LeetCode 238)

## 📌 Problem Statement

Given an integer array `nums`, return an array `answer` such that:

```
answer[i] = product of all elements of nums except nums[i]
```

### ⚠️ Conditions

* Do **not** use division
* Time complexity must be **O(n)**
* Extra space should be **O(1)** (output array not counted)

---

## 🧠 Core Idea (Prefix & Suffix Products)

For each index:

```
product except self = product of all elements on left × product of all elements on right
```

We calculate this in **two passes**:

1. Left to right → store prefix product
2. Right to left → multiply suffix product

No division, no extra arrays ✅

---

## 🛠️ Algorithm Steps

1. Create result array `ans`
2. Initialize `leftProduct = 1`
3. Traverse from left:

   * Store `leftProduct` in `ans[i]`
   * Update `leftProduct *= nums[i]`
4. Initialize `rightProduct = 1`
5. Traverse from right:

   * Multiply `ans[i]` with `rightProduct`
   * Update `rightProduct *= nums[i]`
6. Return `ans`

---

## 💻 Java Code

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];
        int leftProduct = 1, rightProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            ans[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return ans;
    }
}
```

---

## 📊 Example Walkthrough

### Input:

```
[1, 2, 3, 4]
```

### Prefix pass result:

```
[1, 1, 2, 6]
```

### After suffix multiplication:

```
[24, 12, 8, 6]
```

---

## ⏱️ Complexity Analysis

* **Time:** `O(n)`
* **Extra Space:** `O(1)` (output array excluded)

---

## ⭐ Key Points

* No division used
* Handles zero values correctly
* Very common **interview problem**
* Clean and optimal solution

---

