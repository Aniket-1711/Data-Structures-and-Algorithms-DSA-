# 📌 Kth Largest Element in an Array (README)

This problem asks you to find the **kth largest element** in an array **without sorting**. We use a **Min-Heap of size k** to solve it efficiently.

---

## 🚀 Problem Summary

You are given:

* An array of integers `nums`
* A number `k`

You must return the **kth largest** element of `nums`.

👉 Largest means sorted in **descending order**, and you take the **kth** element.

Example:

```
nums = [3,2,1,5,6,4], k = 2
Output = 5
```

---

## 💡 Key Idea

Use a **Min-Heap** and keep only **k elements** inside it.

### Why a Min-Heap?

* The smallest element in the heap stays at the top.
* When the heap grows larger than `k`, remove the smallest.
* After processing all numbers, the top of the heap is the **kth largest**.

This avoids sorting the entire array.

---

## 🧠 Algorithm Steps

1. Create a **Min-Heap**.
2. Insert numbers from the array into the heap.
3. If heap size exceeds `k`, remove the smallest element.
4. The top of the heap now holds the **kth largest** element.

---

## 🧮 Time & Space Complexity

* **Time:** `O(n log k)`
* **Space:** `O(k)`

Efficient for large inputs.

---

## ✅ Java Code

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
```

---

## 🎯 Final Output

The returned value is the **kth largest element**, based on sorted order.

---

