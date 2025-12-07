# 🔁 Sort Integers by Binary Reflection

## 📌 Problem Statement

You are given an integer array **nums**.

The **binary reflection** of a number is found by:

1. Converting the number to binary
2. Reversing the binary digits (ignore leading zeros)
3. Converting the reversed binary back to decimal

Your task is to **sort the array in ascending order based on binary reflection**.

* If two numbers have the same reflection, the **smaller original number comes first**.

---

## ✅ Examples

### Example 1

**Input:**

```
nums = [4, 5, 4]
```

**Binary Reflections:**

* 4 → 100 → 001 → 1
* 5 → 101 → 101 → 5
* 4 → 100 → 001 → 1

**Output:**

```
[4, 4, 5]
```

---

### Example 2

**Input:**

```
nums = [3, 6, 5, 8]
```

**Binary Reflections:**

* 3 → 11 → 11 → 3
* 6 → 110 → 011 → 3
* 5 → 101 → 101 → 5
* 8 → 1000 → 0001 → 1

**Output:**

```
[8, 3, 6, 5]
```

---

## ⚙️ Constraints

* `1 <= nums.length <= 100`
* `1 <= nums[i] <= 10^9`

---

## 🧠 Approach (Simple)

1. Convert the primitive `int[]` to `Integer[]` to use a custom comparator.
2. For each number:

   * Convert to binary string
   * Reverse the string
   * Convert it back to decimal (this is the reflection)
3. Sort using:

   * First: binary reflection value
   * Second: original number (if reflections are same)
4. Convert back to `int[]` and return.

---

## 💻 Java Code

```java
class Solution {
    public int[] sortByReflection(int[] nums) {
        Integer ar[] = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ar[i] = nums[i];
        }

        Arrays.sort(ar, (a, b) -> {
            int refa = reflection(a);
            int refb = reflection(b);

            if (refa != refb) {
                return refa - refb;
            }
            return a - b;
        });

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = ar[i];
        }
        return result;
    }

    public int reflection(int n) {
        String s = Integer.toBinaryString(n);
        String reversed = new StringBuilder(s).reverse().toString();
        return Integer.parseInt(reversed, 2);
    }
}
```

---

## 🚀 Key Points

* Uses custom sorting with comparator ✅
* Handles tie using original number ✅
* Clean and readable logic ✅

---

🎯 **Time Complexity:** `O(n log n)`
🎯 **Space Complexity:** `O(n)`

---


