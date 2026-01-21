# 🧮 Find the Difference of Two Arrays (LeetCode 2215)

## 📌 Problem

Given two integer arrays `nums1` and `nums2`, return a list `answer` such that:

* `answer[0]` contains all **distinct** numbers in `nums1` but **not** in `nums2`
* `answer[1]` contains all **distinct** numbers in `nums2` but **not** in `nums1`

Order does not matter.

---

## 💡 Approach

Use **HashSet** because:

* It stores only unique elements
* Set difference is easy and fast

Steps:

1. Put elements of `nums1` into `set1`
2. Put elements of `nums2` into `set2`
3. Find `set1 - set2` and `set2 - set1`
4. Convert them into lists and return

---

## 🧑‍💻 Java Code

```java
import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int x : nums1) set1.add(x);
        for (int x : nums2) set2.add(x);
        
        List<Integer> onlyInNums1 = new ArrayList<>();
        List<Integer> onlyInNums2 = new ArrayList<>();
        
        for (int x : set1) {
            if (!set2.contains(x)) onlyInNums1.add(x);
        }
        
        for (int x : set2) {
            if (!set1.contains(x)) onlyInNums2.add(x);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(onlyInNums1);
        result.add(onlyInNums2);
        
        return result;
    }
}
```

---

## 🔍 Example

Input:

```
nums1 = [1,2,3]
nums2 = [2,4,6]
```

Output:

```
[[1,3],[4,6]]
```

---

## 🚀 Key Points

* `HashSet` removes duplicates automatically
* `contains()` is O(1)
* Time Complexity: **O(n + m)**
* Space Complexity: **O(n + m)**

---

