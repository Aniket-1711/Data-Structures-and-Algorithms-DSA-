# 📊 Sort Array by Increasing Frequency

## 🧩 Problem

Given an integer array `nums`, sort the array based on:

1. **Increasing frequency** of elements.
2. If two elements have the **same frequency**, the **larger number should come first**.

Return the sorted array.

---

## 💡 Idea of the Approach

The solution works in three main steps:

### 1️⃣ Count Frequency

Use a **HashMap** to count how many times each number appears in the array.

Example:

```
Input: [1,1,2,2,2,3]

Frequency Map
1 → 2
2 → 3
3 → 1
```

---

### 2️⃣ Convert to Integer Array

Java's custom sorting using a comparator works easily with **objects**, so the `int[]` array is converted into `Integer[]`.

---

### 3️⃣ Custom Sorting

Use a **custom comparator** while sorting.

Sorting rules:

* If frequencies are **different** → smaller frequency first
* If frequencies are **equal** → larger value first

Comparator logic:

```
if(freq[a] == freq[b])
    return b - a
else
    return freq[a] - freq[b]
```

---

## 🧠 Example Walkthrough

```
Input
[1,1,2,2,2,3]
```

Frequency:

```
3 → 1
1 → 2
2 → 3
```

Sorted result:

```
[3,1,1,2,2,2]
```

---

## 💻 Java Implementation

```java
import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // count frequency
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        Integer[] arr = new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = nums[i];
        }

        Arrays.sort(arr,(a,b)->{
            if(map.get(a).equals(map.get(b))){
                return b-a;
            }
            return map.get(a)-map.get(b);
        });

        for(int i=0;i<nums.length;i++){
            nums[i] = arr[i];
        }

        return nums;
    }
}
```

---

## ⏱ Time & Space Complexity

**Time Complexity**

```
O(n log n)
```

Sorting dominates the runtime.

**Space Complexity**

```
O(n)
```

Used for the hashmap and temporary array.

---

## 🔑 Key Takeaways

✅ Use a **HashMap** to track frequency

✅ Use **custom comparator sorting**

✅ Apply **two sorting rules**:

* Frequency → ascending
* Value → descending

---
