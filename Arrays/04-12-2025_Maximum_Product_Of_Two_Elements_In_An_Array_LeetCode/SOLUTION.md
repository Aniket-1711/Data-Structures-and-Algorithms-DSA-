# Maximum Product of Two Elements in an Array 🚀

This problem asks us to choose two **different indices** from an array and return the maximum value of:

```
(nums[i] - 1) * (nums[j] - 1)
```

## 🧠 Key Idea

To get the maximum product, we should always pick the **two largest numbers** in the array. Subtract 1 from each, then multiply.

## ✅ Efficient Approach (O(n))

We scan the array once and keep track of:

* The **largest** number
* The **second largest** number

Then we apply the formula.

## 💡 Java Code

```java
class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0;    // largest
        int max2 = 0;    // second largest

        for (int n : nums) {
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}
```

## 📌 Example

**Input:** `[3,4,5,2]`
**Largest:** 5
**Second Largest:** 4
**Output:** `(5-1) * (4-1) = 4 * 3 = 12`

## 🎯 Final Notes

* Works efficiently without sorting
* Handles all valid constraints
* Perfect for interviews!
