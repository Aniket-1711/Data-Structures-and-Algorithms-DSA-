# 🔢 Sort Integers by The Number of 1 Bits (LeetCode 1356)

## 📌 Problem Statement

You are given an integer array `arr`. Sort the array in ascending order based on:

1. The number of `1`s in the binary representation of each number.
2. If two numbers have the same number of `1`s, sort them by their value (ascending).

---

## 💡 Approach (Bucket + Bit Count)

1. First sort the array normally so numbers with same bit count remain in ascending order.
2. Create buckets for bit counts from `0` to `32` (because integers have at most 32 bits).
3. For each number, count how many `1`s it has using bitwise operations.
4. Put the number in the bucket of its bit count.
5. Finally, collect numbers from bucket `0` to bucket `32` in order.

---

## ⏱ Time & Space Complexity

* **Time Complexity:** O(n log n)

  * Sorting the array: O(n log n)
  * Counting bits: O(32n) ≈ O(n)
* **Space Complexity:** O(n)

  * Buckets and result array

---

## 🧑‍💻 Java Implementation

```java
class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] ar = new int[n];
        
        // Step 1: Normal sort
        Arrays.sort(arr);

        // Step 2: Buckets for bit counts
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i <= 32; i++) {
            map.put(i, new ArrayList<>());
        }

        // Step 3: Count bits and group
        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            int count = 0;
            int temp = ele;

            while (ele > 0) {
                if ((ele & 1) == 1) count++;
                ele = ele >> 1;
            }

            map.get(count).add(temp);
        }

        // Step 4: Collect result
        int index = 0;
        for (int j = 0; j <= 32; j++) {
            for (int val : map.get(j)) {
                ar[index++] = val;
            }
        }

        return ar;
    }
}
```

---

## 📊 Example

Input:

```
[0,1,2,3,4,5,6,7,8]
```

Output:

```
[0,1,2,4,8,3,5,6,7]
```

---

## 🏁 Conclusion

This method uses **bit manipulation + bucket grouping** to sort numbers by the count of `1` bits, while keeping values in ascending order when bit counts are equal. Clean, fast, and interview‑friendly. 🚀
