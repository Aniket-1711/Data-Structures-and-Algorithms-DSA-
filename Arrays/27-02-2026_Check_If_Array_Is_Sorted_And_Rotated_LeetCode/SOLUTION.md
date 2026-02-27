# 🔄 Check if Array Is Sorted and Rotated

## 📌 Problem Statement

Given an integer array `nums`, return **true** if:

* The array was originally sorted in **non-decreasing order**
* Then rotated some number of times (including 0)

Otherwise, return **false**.

Duplicates are allowed.

---

## 🧠 Idea Behind the Solution

A sorted and rotated array will have:

* At most **one drop point** (where `nums[i] > nums[i+1]`)

Example:

`[3,4,5,1,2]`

Drop happens at `5 > 1`

If:

* No drop → Already sorted ✅
* More than one drop → Not valid ❌
* Exactly one drop → Rotate back and check if sorted

---

## 🚀 Approach Used

### Step 1️⃣ Count Drop Points

Loop through array and count how many times:

```
nums[i] > nums[i+1]
```

* If count = 0 → return true
* If count > 1 → return false
* If count = 1 → rotate and verify

---

### Step 2️⃣ Rotate Array Back

Use reverse method:

1. Reverse first part
2. Reverse second part
3. Reverse whole array

---

### Step 3️⃣ Check if Sorted

After rotation, check again if array is sorted.

---

## 💻 Java Code

```java
class Solution {
    public boolean check(int[] nums) {
        int dropCount = 0, dropIndex = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                dropCount++;
                dropIndex = i;
            }
        }

        if (dropCount == 0) {
            return true;
        }

        if (dropCount > 1) {
            return false;
        }

        rotateArray(nums, dropIndex);
        return checkSortedNums(nums);
    }

    public void rotateArray(int nums[], int position) {
        position = position % nums.length;
        reverseArr(nums, 0, position);
        reverseArr(nums, position + 1, nums.length - 1);
        reverseArr(nums, 0, nums.length - 1);
    }

    public void reverseArr(int ar[], int startIndex, int stopIndex) {
        int first = startIndex, last = stopIndex;
        while (first < last) {
            int temp = ar[first];
            ar[first++] = ar[last];
            ar[last--] = temp;
        }
    }

    public boolean checkSortedNums(int ar[]) {
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] > ar[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
```

---

## ⏱ Time & Space Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

---

## ✅ Example

### Input

```
[3,4,5,1,2]
```

### Output

```
true
```

---

✨ Problem Level: Easy
📚 Platform: LeetCode
