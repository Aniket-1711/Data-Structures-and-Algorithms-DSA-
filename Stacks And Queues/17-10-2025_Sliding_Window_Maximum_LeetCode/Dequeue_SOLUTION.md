# 🪟 Sliding Window Maximum

### 💡 Problem Statement

Given an array of integers `nums`, there is a **sliding window** of size `k` moving from the left to the right of the array. You can only see `k` numbers in the window. Each time the window moves right by one position.

Return an array containing the **maximum value** in each window.

---

### 🧩 Example

**Input:**
`nums = [1,3,-1,-3,5,3,6,7], k = 3`

**Output:**
`[3,3,5,5,6,7]`

**Explanation:**

```
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```

---

### ⚙️ Approach

This problem can be efficiently solved using a **Deque (Double Ended Queue)** to maintain potential maximum elements of the current window.

#### 🔸 Steps:

1. **Iterate through the array:**

   * For each index `i`, remove indices from the **back** of the deque while the current element `nums[i]` is greater than or equal to `nums[deque.last]`.
   * Add the current index to the deque.
2. **Remove elements out of the current window:**

   * If the front index is out of the window (`i - k`), remove it from the front.
3. **Record the maximum:**

   * The element at `nums[deque.first]` is the maximum for the current window.

This ensures each element is added and removed **at most once**, giving an **O(n)** time complexity.

---

### 🧠 Code Implementation

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ar[] = new int[nums.length - k + 1];
        int index = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // Process first window
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        ar[index++] = nums[queue.getFirst()];

        // Process the rest of the windows
        for (int i = k; i < nums.length; i++) {
            if (queue.getFirst() == i - k) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            ar[index++] = nums[queue.getFirst()];
        }
        return ar;
    }
}
```

---

### ⏱️ Time and Space Complexity

* **Time Complexity:** O(n) — each element is processed once.
* **Space Complexity:** O(k) — for storing indices in the deque.

---

### 🧮 Example Walkthrough

**nums = [1,3,-1,-3,5,3,6,7], k = 3**

| Step | Window    | Deque (Indices) | Deque (Values) | Max |
| ---- | --------- | --------------- | -------------- | --- |
| 1    | [1,3,-1]  | [1,2]           | [3,-1]         | 3   |
| 2    | [3,-1,-3] | [1,2,3]         | [3,-1,-3]      | 3   |
| 3    | [-1,-3,5] | [4]             | [5]            | 5   |
| 4    | [-3,5,3]  | [4,5]           | [5,3]          | 5   |
| 5    | [5,3,6]   | [6]             | [6]            | 6   |
| 6    | [3,6,7]   | [7]             | [7]            | 7   |

---

### 🧾 Summary

✅ Efficient **O(n)** solution using deque.
✅ Removes smaller elements before adding a new one.
✅ Maintains only potential maximums for the window.

---

✨ **Tip:** Deques are perfect for problems requiring both-end access — especially in sliding window or monotonic queue problems.
