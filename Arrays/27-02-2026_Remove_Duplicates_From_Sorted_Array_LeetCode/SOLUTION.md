# 🧹 Remove Duplicates from Sorted Array

## 📌 Problem Statement

Given a **sorted integer array**, remove duplicates **in-place** such that each unique element appears only once.

* Keep the relative order same.
* Return the number of unique elements `k`.
* First `k` elements of array should contain unique values.
* Elements after `k` can be ignored.

---

## 🧠 Approach Used

This solution uses a **HashSet** to track unique elements.

### 🔎 Steps:

1. Create a `HashSet` to store seen elements.
2. Maintain an `index` pointer starting from 0.
3. Traverse the array:

   * If element is not in set:

     * Place it at `nums[index]`
     * Add it to set
     * Increment `index`
4. Return `index` as the count of unique elements.

---

## 💻 Java Code

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int index = 0;
        
        for (int i : nums) {
            if (!set.contains(i)) {
                nums[index++] = i;
                set.add(i);
            }
        }
        return index;
    }
}
```

---

## ⏱ Time & Space Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(n) (because of HashSet)

---

## ⚠️ Important Note

Since the array is already **sorted**, this problem can be solved with **O(1) extra space** using the Two Pointer technique.

This current solution works correctly but does not use the optimal space approach.

---

## ✅ Example

### Input

```
[0,0,1,1,1,2,2,3,3,4]
```

### Output

```
k = 5
nums = [0,1,2,3,4,_,_,_,_,_]
```

---

✨ Problem Level: Easy
📚 Platform: LeetCode
