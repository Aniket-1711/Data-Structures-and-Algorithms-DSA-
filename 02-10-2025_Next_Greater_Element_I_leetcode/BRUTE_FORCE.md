# 🔢 LeetCode 496: Next Greater Element I  

## 📌 Problem Statement  
The **next greater element** of some element `x` in an array is the **first greater element that is to the right of x** in the same array.  

You are given two **distinct 0-indexed integer arrays** `nums1` and `nums2`, where `nums1` is a subset of `nums2`.  

For each `0 <= i < nums1.length`, find the index `j` such that `nums1[i] == nums2[j]` and determine the **next greater element** of `nums2[j]` in `nums2`. If there is no next greater element, then the answer is **-1**.  

Return an array `ans` of length `nums1.length` such that `ans[i]` is the next greater element as described above.  

---

## 🧩 Example 1  

**Input:**  
nums1 = [4,1,2], nums2 = [1,3,4,2]

**Output:**  
[-1,3,-1]


**Explanation:**  
- `4` → No next greater element in `nums2` → `-1`  
- `1` → Next greater element is `3` → `3`  
- `2` → No next greater element → `-1`  

---

## 🧩 Example 2  

**Input:**  
nums1 = [2,4], nums2 = [1,2,3,4]

**Output:**  
[3,-1]


**Explanation:**  
- `2` → Next greater element is `3` → `3`  
- `4` → No next greater element → `-1`  

---

## 📏 Constraints  

- `1 <= nums1.length <= nums2.length <= 1000`  
- `0 <= nums1[i], nums2[i] <= 10^4`  
- All integers in `nums1` and `nums2` are **unique**.  
- All integers of `nums1` also appear in `nums2`.  

---

## 💡 Brute Force Approach (Your Code)  

### 🔑 Idea  
- For each element in `nums1`, locate its index in `nums2`.  
- From that index, move **rightward** in `nums2` until:  
  - You find a greater element → store it.  
  - Or no greater element exists → store `-1`.  

### ⏱ Complexity  
- **Time Complexity:** `O(n1 * n2)` (nested loops).  
- **Space Complexity:** `O(1)` (ignoring output).  

---

## 📝 Code (Brute Force Solution)  

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int index = nums2.length; 
            boolean flag = false;

            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    index = j;  // Found index of nums1[i] in nums2
                }
                if (j > index) {
                    if (nums2[j] > nums1[i]) {
                        ans[i] = nums2[j];
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}


