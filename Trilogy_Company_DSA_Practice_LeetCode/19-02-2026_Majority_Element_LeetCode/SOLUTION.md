# 🧠 169. Majority Element

## 📌 Problem Statement

Given an integer array `nums` of size `n`, return the **majority element**.

The majority element is the element that appears **more than ⌊n / 2⌋ times**.

It is guaranteed that the majority element always exists.

---

## 🧪 Example

### Example 1

```
Input: nums = [3,2,3]
Output: 3
```

### Example 2

```
Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

---

## 🚀 Optimal Approach — Boyer–Moore Voting Algorithm

### 💡 Idea

If we cancel out different elements one by one, the majority element will always remain at the end because it appears more than half of the total size.

---

## 🔄 Algorithm Steps

1. Initialize:

   * `candidate = 0`
   * `count = 0`

2. Traverse the array:

   * If `count == 0`, set current element as candidate.
   * If element equals candidate → increment count.
   * Otherwise → decrement count.

3. Return the candidate.

---

## 💻 Java Implementation

```java
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
```

---

## 📊 Why It Works

* The majority element appears more than `n/2` times.
* Even after cancelling different elements, it cannot be fully removed.
* So the final remaining candidate is the majority element.

---

## ⏱ Complexity Analysis

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

✔ Linear time
✔ Constant space
✔ Most optimal solution

---

## 📝 Note

If the majority element was **not guaranteed**, a second pass would be required to verify the candidate’s frequency.

---

### ⭐ Key Takeaway

This is a classic interview problem that tests understanding of:

* Greedy logic
* Cancellation principle
* Space optimization

---

