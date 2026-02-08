# 🧩 First Missing Positive (LeetCode 41)

## 📌 Problem Statement

Given an **unsorted integer array** `nums`, find the **smallest positive integer** that is **missing** from the array.

### 🔒 Constraints

* Time Complexity must be **O(n)**
* Extra Space must be **O(1)**

---

## 🧠 Key Idea (Cyclic Sort Approach)

We try to place each number `x` at its **correct index** `x - 1`.

👉 Only numbers in the range **1 to n** (array length) matter.

Steps:

1. Traverse the array and swap elements until every valid number is at its correct position.
2. After rearranging, scan the array.
3. The first index `i` where `nums[i] != i + 1` gives the answer `i + 1`.
4. If all positions are correct, answer is `n + 1`.

---

## 🛠️ Algorithm Steps

1. Start from index `i = 0`
2. While `i < n`:

   * Calculate correct position: `nums[i] - 1`
   * Swap if:

     * number is positive
     * number is within range
     * number is not already at correct position
3. Otherwise move to next index
4. After sorting, loop again to find missing positive

---

## 💻 Java Code

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctSpot = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctSpot]) {
                int temp = nums[i];
                nums[i] = nums[correctSpot];
                nums[correctSpot] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }
}
```

---

## 📊 Example Walkthrough

### Input:

```
[3, 4, -1, 1]
```

After rearranging:

```
[1, -1, 3, 4]
```

Index `1` should contain `2` → Missing ✅

**Output:** `2`

---

## ⏱️ Complexity Analysis

* **Time:** `O(n)`
* **Space:** `O(1)` (in-place)

---

## ⭐ Key Takeaways

* Only numbers from `1` to `n` are useful
* Cyclic sort helps achieve constant space
* Very common **interview hard problem**

---

