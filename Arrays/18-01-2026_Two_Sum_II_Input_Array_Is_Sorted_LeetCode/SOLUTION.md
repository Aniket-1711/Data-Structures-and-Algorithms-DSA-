# 🔢 Two Sum II - Input Array Is Sorted

This problem is about finding two numbers in a **sorted array** whose sum is equal to a given target.

---

## 🧠 Problem Statement

You are given:

* A sorted integer array `numbers` (1-indexed)
* An integer `target`

Find two different indices `index1` and `index2` such that:

```
numbers[index1] + numbers[index2] = target
```

Return the answer as:

```
[index1, index2]
```

Conditions:

* `1 <= index1 < index2 <= numbers.length`
* Only one solution exists
* Do not use extra space (constant space)

---

## ⚡ Approach: Two Pointer Technique

Because the array is already sorted, we can use two pointers:

* `i` → start of the array
* `j` → end of the array

### Steps:

1. Add `numbers[i] + numbers[j]`
2. If sum == target → return indices
3. If sum < target → move `i` right
4. If sum > target → move `j` left

This works in **O(n)** time and **O(1)** space.

---

## 💻 Java Code

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if (sum == target) {
                return new int[]{i + 1, j + 1}; // 1-based index
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1, -1};
    }
}
```

---

## 📊 Example

Input:

```
numbers = [2,7,11,15], target = 9
```

Output:

```
[1, 2]
```

Explanation:

```
2 + 7 = 9
```

---

## 🏁 Summary

* Uses two pointers
* Works only because array is sorted
* Time: O(n)
* Space: O(1)
* Very efficient and clean solution 🚀
