# 🔍 Search a 2D Matrix II

## 📌 Problem Summary

You are given an **m × n matrix** where:

* Each **row** is sorted in ascending order ➡️
* Each **column** is sorted in ascending order ⬇️

Your task is to check whether a given **target** value exists in the matrix.

---

## 💡 Efficient Idea

Start searching from the **top-right corner** of the matrix:

* If the current value is **equal** to target → ✅ Found
* If the current value is **greater** than target → move **left**
* If the current value is **less** than target → move **down**

This works because moving left decreases values and moving down increases values.

---

## 🧠 Algorithm Steps

1. Start at position `(0, lastColumn)`
2. Compare current value with target
3. Move left or down based on comparison
4. Stop when target is found or indices go out of bounds

---

## ⏱️ Time & Space Complexity

* **Time Complexity:** `O(m + n)`
* **Space Complexity:** `O(1)` (no extra space used)

---

## ✅ Java Solution

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        int i = 0, j = columns - 1;
        
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;      // move down
            } else {
                j--;      // move left
            }
        }
        return false;
    }
}
```

---

## 📊 Example

**Input:**

```
matrix = [[1,4,7,11,15],
          [2,5,8,12,19],
          [3,6,9,16,22],
          [10,13,14,17,24],
          [18,21,23,26,30]]

target = 5
```

**Output:**

```
true
```

---

## 🚀 Key Takeaway

Using the matrix's sorted property smartly avoids unnecessary searches and gives an efficient solution.

