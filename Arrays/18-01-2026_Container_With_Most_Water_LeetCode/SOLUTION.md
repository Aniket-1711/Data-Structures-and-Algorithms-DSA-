# 🪣 Container With Most Water

This problem is about finding two vertical lines that can hold the **maximum amount of water** between them.

---

## 🧠 Problem Statement

You are given an array `height` where:

* Each element represents the height of a vertical line.
* The index represents the x-coordinate.

You need to choose two lines such that:

```
Area = min(height[left], height[right]) * (right - left)
```

Return the **maximum area** possible.

You cannot tilt the container.

---

## ⚡ Approach: Two Pointer Technique

Because checking all pairs is slow, we use two pointers:

* `i` → start of the array
* `j` → end of the array

### Steps:

1. Calculate area using `min(height[i], height[j]) * (j - i)`
2. Update maximum area
3. Move the pointer with smaller height (to try a bigger height)
4. Repeat until `i < j`

This works in:

* Time: **O(n)**
* Space: **O(1)**

---

## 💻 Java Code

```java
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxAns = 0;

        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxAns = Math.max(area, maxAns);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxAns;
    }
}
```

---

## 📊 Example

Input:

```
height = [1,8,6,2,5,4,8,3,7]
```

Output:

```
49
```

Explanation:
The best container is between heights 8 and 7 with width 7.

---

## 🏁 Summary

* Use two pointers from both ends
* Always move the smaller height pointer
* Find max area in one pass
* Efficient and clean solution 🚀
