# Count Partitions with Even Sum Difference ✨

This README explains the problem **"Count Partitions with Even Sum Difference"** and the logic behind the Java solution.

---

## 📘 Problem Summary

You are given an array of integers. A **partition** is any index that splits the array into two non-empty parts:

* **Left part:** from index `0` to `i`
* **Right part:** from index `i+1` to `n-1`

You must count how many such partitions have an **even difference** between:

```
leftSum - rightSum
```

---

## 🧠 Key Idea

The difference `(leftSum - rightSum)` is **even** when both sums have:

* **same parity** (both even or both odd)

We use:

* A prefix sum array to quickly get `leftSum`
* Compute `rightSum` using total sum
* Check if difference is even

---

## 🧮 Example

For input:

```
[10, 10, 3, 7, 6]
```

Valid partitions = **4** 🎉

The 4 partitions are:

- [10], [10, 3, 7, 6] with a sum difference of 10 - 26 = -16, which is even.
- [10, 10], [3, 7, 6] with a sum difference of 20 - 16 = 4, which is even.
- [10, 10, 3], [7, 6] with a sum difference of 23 - 13 = 10, which is even.
- [10, 10, 3, 7], [6] with a sum difference of 30 - 6 = 24, which is even.

---

## 💻 Java Code

```java
class Solution {
    public int countPartitions(int[] nums) {
        int ar[] = new int[nums.length];
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            ar[i] = sum;
        }

        int count = 0;
        for(int i = 1; i < nums.length; i++){
            int leftSum = ar[i - 1];
            int rightSum = sum - leftSum;

            if((leftSum - rightSum) % 2 == 0){
                count++;
            }
        }
        return count;
    }
}
```

---

## ✅ Final Output

Return the total number of valid partitions.

This solution is efficient and works within constraints.

---

## 🚀 Complexity

* **Time:** O(n)
* **Space:** O(n) for prefix array

---

