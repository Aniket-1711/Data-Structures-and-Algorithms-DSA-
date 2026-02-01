# 🧩 Divide an Array Into Subarrays With Minimum Cost I

## 📌 Problem Summary

You are given an integer array `nums`.

* You must divide the array into **3 disjoint contiguous subarrays**.
* The **cost** of a subarray is the **first element** of that subarray.
* Your goal is to **minimize the total cost** (sum of first elements of all 3 subarrays).

---

## 🔍 Key Observations

* The array must be split into **exactly 3 parts**.
* Each part must be **continuous**.
* Since the cost is the **first element**, we want the **smallest possible starting values**.

---

## 💡 Strategy

1. The **first subarray** always starts at index `0`, so `nums[0]` is always included.
2. To minimize total cost:

   * Choose the **two smallest possible values** from the remaining elements as starts of the other two subarrays.
3. Sorting helps find the smallest values efficiently.

---

## ⚙️ Approach

* Copy the array and sort it.
* Handle the special case when the array length is exactly 3.
* Otherwise:

  * If `nums[0]` is not among the two smallest values, add it with the two smallest.
  * Else, add the three smallest values.

---

## 🧪 Examples

### Example 1

```
nums = [1,2,3,12]
```

Best split: `[1] [2] [3,12]`

✅ Cost = `1 + 2 + 3 = 6`

---

### Example 2

```
nums = [5,4,3]
```

Only possible split: `[5] [4] [3]`

✅ Cost = `12`

---

### Example 3

```
nums = [10,3,1,1]
```

Best split: `[10,3] [1] [1]`

✅ Cost = `12`

---

## 🧠 Time & Space Complexity

* **Time Complexity:** `O(n log n)` (due to sorting)
* **Space Complexity:** `O(n)` (extra array)

---

## 🧾 Java Solution

```java
class Solution {
    public int minimumCost(int[] nums) {
        int b[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            b[i] = nums[i];
        }

        if(nums.length == 3){
            return b[0] + b[1] + b[2];
        }

        Arrays.sort(b);
        if(nums[0] != b[0] && nums[0] != b[1]){
            return nums[0] + b[0] + b[1];
        }
        return b[0] + b[1] + b[2];
    }
}
```

---

## ✅ Final Note

This solution works efficiently within the given constraints and uses a simple greedy idea combined with sorting to achieve the minimum cost. 🎯
