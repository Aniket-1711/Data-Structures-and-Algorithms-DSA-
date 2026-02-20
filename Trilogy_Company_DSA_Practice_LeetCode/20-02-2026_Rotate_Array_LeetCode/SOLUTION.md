# 🔄 189. Rotate Array

## 📌 Problem Statement

Given an integer array `nums`, rotate the array to the **right by k steps**, where `k` is non‑negative.

---

## 🧠 Example

### Example 1

```
Input:  nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
```

### Example 2

```
Input:  nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
```

---

## 🚀 Approach Used (Reversal Algorithm)

Instead of rotating one by one (which is slow), we use **array reversal technique**.

### 🔹 Key Idea

1. Reverse first part
2. Reverse second part
3. Reverse entire array

This gives rotated array in **O(n)** time and **O(1)** space.

---

## ⚙️ Steps Explained

Let:

```
n = nums.length
k = k % n
```

To rotate right:

```
k = n - (k % n)
```

Then:

1️⃣ Reverse from index `0` to `k-1`
2️⃣ Reverse from index `k` to `n-1`
3️⃣ Reverse from index `0` to `n-1`

---

## 💻 Java Code

```java
class Solution {
    public void reverseArr(int arr[], int startIndex, int stopIndex){
        while(startIndex < stopIndex){
            int temp = arr[startIndex];
            arr[startIndex++] = arr[stopIndex];
            arr[stopIndex--] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = n - (k % n);

        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, n - 1);
        reverseArr(nums, 0, n - 1);
    }
}
```

---

## ⏱ Time Complexity

```
O(n)
```

(Each element is reversed constant number of times)

## 📦 Space Complexity

```
O(1)
```

(No extra array used — in-place rotation)

---

## 🎯 Why This Is Best?

✅ In-place solution
✅ Constant extra space
✅ Faster than shifting one by one

---

## 🧩 Other Possible Approaches

🔹 Using extra array (O(n) space)
🔹 Rotating one by one (O(n × k))
🔹 Using cyclic replacements

---

### ⭐ Final Note

Reversal technique is the most asked and most optimal solution for this problem.
