#  Trapping Rain Water 💧

## Problem Statement 📝

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

### Examples 🌧️

**Example 1:**

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: 
The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
6 units of rain water (blue section) are trapped. 💦
```

**Example 2:**

```
Input: height = [4,2,0,3,2,5]
Output: 9 💧
```

### Constraints ⚠️

* `n == height.length`
* `1 <= n <= 2 * 10^4`
* `0 <= height[i] <= 10^5`

---

## Optimal Approach (Two Pointers) 🏹

We can solve this problem in **O(n) time** and **O(1) extra space** using the **two-pointer technique**.

### Intuition 💡

* The amount of water trapped at an index depends on the **maximum height to its left** and **maximum height to its right**.
* Water trapped at index `i` = `min(max_left[i], max_right[i]) - height[i]`.
* Instead of precomputing `max_left` and `max_right` arrays (which uses extra space), we can use **two pointers** (`i` from left, `j` from right) and **track left and right maxima** dynamically.

---

### Algorithm 🛠️

1. Initialize two pointers: `i = 0` (left) and `j = n-1` (right).
2. Initialize `lmax = 0` and `rmax = 0` to track maximum heights.
3. Initialize `ans = 0` to store trapped water.
4. While `i < j`:

   * Update `lmax = max(lmax, height[i])`
   * Update `rmax = max(rmax, height[j])`
   * If `lmax < rmax`:

     * Water trapped at `i` = `lmax - height[i]` 💦
     * Move `i` forward (`i++`)
   * Else:

     * Water trapped at `j` = `rmax - height[j]` 💦
     * Move `j` backward (`j--`)
5. Return `ans`. ✅

---

### Java Code 💻

```java
class Solution {
    public int trap(int[] height) {
        int lmax = 0, rmax = 0;
        int i = 0, j = height.length - 1;
        int ans = 0;

        while(i < j) {
            lmax = Math.max(lmax, height[i]);
            rmax = Math.max(rmax, height[j]);

            if(lmax < rmax) {
                ans += lmax - height[i]; // trapped water 💦
                i++;
            } else {
                ans += rmax - height[j]; // trapped water 💦
                j--;
            }
        }
        return ans;
    }
}
```

---

### Dry Run Example 🔍

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]

 i=0, j=11, lmax=0, rmax=1 -> lmax<rmax -> ans+=0-0=0, i=1
 i=1, j=11, lmax=1, rmax=1 -> lmax>=rmax -> ans+=1-1=0, j=10
 i=1, j=10, lmax=1, rmax=2 -> lmax<rmax -> ans+=1-1=0, i=2
 i=2, j=10, lmax=1, rmax=2 -> lmax<rmax -> ans+=1-0=1 💦, i=3
 ...
Final ans = 6 💧
```

---

### Complexity Analysis 📊

* **Time Complexity:** O(n) — each element is processed at most once.
* **Space Complexity:** O(1) — only constant extra space is used.

---

### Key Takeaways ✅

* Two-pointer technique can **replace extra space arrays** for left and right maxima.
* Always compare `lmax` and `rmax` to decide which pointer to move.
* Optimal for both **time and space** in trapping rain water problems.

## Why Two-Pointer Approach Works 💡

1. **Key Observation:**

   * At any index, the water that can be trapped depends on the **smaller of the current left max (`lmax`) and right max (`rmax`)**. 💧
   * Why? Because water cannot exceed the shorter boundary; otherwise, it would overflow.

2. **Approach with Two Pointers:**

   * Maintain **two pointers**: `left` starting at 0 and `right` starting at `n-1`.
   * Also maintain `lmax` and `rmax` — the tallest bars seen so far from left and right.

3. **Loop Logic (`while left < right`):**

   * Update `lmax = max(lmax, height[left])` and `rmax = max(rmax, height[right])`.
   * Determine the **smaller boundary**: `min(lmax, rmax)`.
   * **If `lmax < rmax`:**

     * Left boundary is the limiting factor.
     * Water trapped = `lmax - height[left]` 💦
     * Increment `left++`.
   * **Else:**

     * Right boundary is the limiting factor.
     * Water trapped = `rmax - height[right]` 💦
     * Decrement `right--`.

4. **Why It’s Correct:**

   * By always moving the pointer at the **smaller boundary**, we guarantee the trapped water is calculated correctly.
   * The other side (larger boundary) will never limit the water because it’s taller.


