# ⚖️ Find the Smallest Balanced Index

## 🧩 Problem

Given an integer array `nums`.

An index `i` is called **balanced** if:

```
Sum of elements strictly to the left of i
=
Product of elements strictly to the right of i
```

### Special Rules

* If there are **no elements on the left**, the sum is `0`.
* If there are **no elements on the right**, the product is `1`.

The task is to **return the smallest balanced index**.

If no such index exists, return:

```
-1
```

---

## 💡 Approach

### 1️⃣ Prefix Sum

Create an array `prefixSum` where:

```
prefixSum[i] = sum of elements from 0 → i
```

This helps quickly get the **sum of elements to the left** of any index.

Example:

```
nums = [2,8,2,2,5]

prefixSum = [2,10,12,14,19]
```

Left sum at index `i`:

```
prefixSum[i-1]
```

---

### 2️⃣ Suffix Product

Create another array `postMul` where:

```
postMul[i] = product of elements from i → end
```

Example:

```
postMul = [320,160,20,10,5]
```

Right product at index `i`:

```
postMul[i+1]
```

---

### 3️⃣ Check Balanced Index

Loop through the array and check:

```
prefixSum[i-1] == postMul[i+1]
```

If true → index `i` is balanced.

Return the **first such index** because the problem asks for the **smallest balanced index**.

---

## ☕ Java Implementation

```java
class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int prefixSum[] = new int[nums.length];
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            prefixSum[i] = sum;
        }

        int postMul[] = new int[nums.length];
        int prod = 1;

        for(int i = nums.length - 1; i >= 0; i--){
            prod *= nums[i];
            postMul[i] = prod;
        }

        int index = -1;

        for(int i = 1; i < nums.length; i++){

            if(i == nums.length - 1){
                if(prefixSum[i - 1] == 1){
                    return i;
                }
            }
            else if(prefixSum[i - 1] == postMul[i + 1]){
                index = i;
                break;
            }
        }

        return index;
    }
}
```

---

## 🔍 Example

### Input

```
nums = [2,8,2,2,5]
```

### At index `2`

Left side:

```
2 + 8 = 10
```

Right side:

```
2 × 5 = 10
```

Since both are equal, **index 2 is balanced**.

### Output

```
2
```

---

## ⏱ Time Complexity

```
O(n)
```

* One pass for prefix sum
* One pass for suffix product
* One pass to check balanced index

---

## 📦 Space Complexity

```
O(n)
```

Two extra arrays are used:

* `prefixSum`
* `postMul`

---

## ✅ Key Idea

Precompute **left sums** and **right products** so each index can be checked in **constant time**.
