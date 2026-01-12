# 🧮 Least Number of Unique Integers After K Removals (LeetCode 1481)

## 📌 Problem Statement

Given an integer array `arr` and an integer `k`, remove exactly `k` elements such that the number of **unique integers** left in the array is **minimum**.

---

## 💡 Approach

1. Count frequency of each number using a HashMap.
2. Store all frequencies in an array.
3. Sort the frequency array in ascending order.
4. Greedily remove elements with the smallest frequency first.
5. Each full removal of a number reduces the count of unique integers by 1.

---

## ⏱ Time & Space Complexity

* **Time Complexity:** O(n log n)

  * HashMap building: O(n)
  * Sorting frequencies: O(n log n)
* **Space Complexity:** O(n)

  * For HashMap and frequency array

---

## 🧑‍💻 Java Implementation

```java
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Step 1: Frequency count
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // Step 2: Store frequencies
        int[] freq = new int[map.size()];
        int idx = 0;
        for (int f : map.values()) {
            freq[idx++] = f;
        }

        // Step 3: Sort frequencies
        Arrays.sort(freq);

        // Step 4: Remove smallest frequencies first
        int unique = freq.length;
        for (int f : freq) {
            if (k >= f) {
                k -= f;
                unique--;
            } else {
                break;
            }
        }

        return unique;
    }
}
```

---

## 📊 Example

Input:

```
arr = [4,3,1,1,3,3,2], k = 3
```

Output:

```
2
```

Explanation: Removing elements with least frequencies leaves only 2 unique numbers.

---

## 🏁 Conclusion

This greedy + sorting method ensures we always remove numbers with the smallest count first, giving the minimum possible number of unique integers after exactly `k` removals. 🎯
