# 🚀 Maximum Product of Three Numbers

## 📌 Problem

Given an integer array `nums`, find **three numbers whose product is maximum** and return that product.

Constraints:

* `3 <= nums.length <= 10^4`
* `-1000 <= nums[i] <= 1000`

---

# 💡 Key Idea

The maximum product of three numbers can come from **two possible combinations**:

1️⃣ **Three largest numbers** in the array

Example:

```
[1,2,3,4]
Product = 4 × 3 × 2 = 24
```

2️⃣ **Two smallest numbers and the largest number**

Reason: multiplying two negative numbers results in a positive value.

Example:

```
[-10, -10, 5, 2]
Product = (-10) × (-10) × 5 = 500
```

---

# 🧠 Approach

### Step 1

Sort the array in ascending order.

### Step 2

Calculate two possible products:

```
product1 = nums[n-1] * nums[n-2] * nums[n-3]
product2 = nums[0] * nums[1] * nums[n-1]
```

### Step 3

Return the maximum of these two values.

```
answer = max(product1, product2)
```

---

# 🧾 Java Implementation

```java
import java.util.*;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int product1 = nums[n-1] * nums[n-2] * nums[n-3];
        int product2 = nums[0] * nums[1] * nums[n-1];

        return Math.max(product1, product2);
    }
}
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```
O(n log n)
```

Sorting the array dominates the runtime.

### Space Complexity

```
O(1)
```

No extra space is used apart from variables.

---

# 🔍 Example Walkthrough

Input:

```
nums = [-10, -10, 5, 2]
```

Sorted array:

```
[-10, -10, 2, 5]
```

Possible products:

```
product1 = 5 × 2 × (-10) = -100
product2 = (-10) × (-10) × 5 = 500
```

Result:

```
Maximum Product = 500
```

---

# ✅ Summary

✔ Maximum product can come from **three largest numbers**

✔ Or from **two smallest (negative) numbers and the largest number**

✔ Compare both possibilities and return the maximum

---

