# ⚡ Max XOR Subarray of Size K

## 📌 Problem

Given an integer array `arr[]` and a number `k`, find the **maximum XOR value of any subarray of size `k`**.

A **subarray** is a **contiguous part** of the array.

Return the **maximum XOR** among all subarrays of length `k`.

---

## 🧠 Approach – Sliding Window

Since the **subarray size is fixed (`k`)**, we can use the **Sliding Window technique**.

### Idea

1️⃣ Compute the XOR of the **first `k` elements**.

2️⃣ Store it as the initial **maximum XOR**.

3️⃣ Slide the window one element at a time:

* Remove the element leaving the window.
* Add the new element entering the window.

Because XOR has a useful property:

```id="xq8b9v"
a ^ a = 0
```

So when we XOR again with the same element, it **removes its effect**.

---

## 🔹 Sliding Window Update

When the window moves:

Remove the outgoing element

```id="w2l8az"
xor ^= arr[i - k]
```

Add the new incoming element

```id="jqv2b1"
xor ^= arr[i]
```

Update the maximum XOR.

---

## 💻 Java Implementation

```java id="wpfq8o"
class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {

        int maxXor = 0;
        int xor = 0;

        // XOR of first window
        for(int i = 0; i < k; i++){
            xor ^= arr[i];
        }

        maxXor = Math.max(maxXor, xor);

        // Slide the window
        for(int i = k; i < arr.length; i++){
            xor ^= arr[i - k]; // remove outgoing element
            xor ^= arr[i];     // add incoming element

            maxXor = Math.max(maxXor, xor);
        }

        return maxXor;
    }
}
```

---

## ⏱️ Complexity Analysis

**Time Complexity**

```id="y5m7n3"
O(n)
```

We traverse the array only once.

**Space Complexity**

```id="b3h2m1"
O(1)
```

Only a few variables are used.

---

## 📊 Example

### Input

```id="t3c2x9"
arr = [2, 5, 8, 1, 1, 3]
k = 3
```

### Subarrays of size 3

```id="s2p8j4"
[2,5,8] → 2 ^ 5 ^ 8 = 15
[5,8,1] → 12
[8,1,1] → 8
[1,1,3] → 3
```

### Output

```id="q1o8r5"
15
```

---

## ✅ Key Points

* Uses **Sliding Window technique**.
* Works because XOR can **add and remove elements efficiently**.
* Only **one traversal of the array** is needed.
* Very efficient for **large arrays (up to 10⁶ elements)**.
