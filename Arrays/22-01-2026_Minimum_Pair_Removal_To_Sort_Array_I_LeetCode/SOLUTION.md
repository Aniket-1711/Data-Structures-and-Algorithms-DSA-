# 🔢 Minimum Pair Removal to Sort Array I

## 🧩 Problem Statement

You are given an integer array `nums`. You can repeat this operation any number of times:

1. Find the **adjacent pair with the minimum sum**.
2. If many pairs have the same minimum sum, pick the **leftmost** one.
3. Replace that pair with their **sum**.

Your goal is to make the array **non-decreasing** (sorted in increasing order, allowing equals) using the **minimum number of operations**.

---

## 📌 Example

### Input

```
nums = [5, 2, 3, 1]
```

### Steps

* Minimum sum pair = (3,1) → Replace with 4 → `[5,2,4]`
* Minimum sum pair = (2,4) → Replace with 6 → `[5,6]`

Array is now sorted.

### Output

```
2
```

---

## 🛠️ Approach

1. Convert the array into a `List` for easy removal and update.
2. While the list is not sorted:

   * Find the adjacent pair with the minimum sum.
   * Replace the pair with their sum.
   * Increase the operation count.
3. Stop when the list becomes non-decreasing.

---

## ✅ Java Solution

```java
class Solution {
    public int minimumPairRemoval(int[] nums) {
        int count = 0;
        List<Integer> a = new ArrayList<>();
        for (int n : nums) a.add(n);

        while (!isSorted(a)) {
            int minSum = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < a.size() - 1; i++) {
                int sum = a.get(i) + a.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            int merged = a.get(index) + a.get(index + 1);
            a.remove(index + 1);
            a.set(index, merged);
            count++;
        }
        return count;
    }

    public boolean isSorted(List<Integer> a) {
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i) > a.get(i + 1)) return false;
        }
        return true;
    }
}
```

---

## ⏱️ Complexity

* **Time:** O(N³) (because of repeated scans and removals)
* **Space:** O(N) for the list

---

## 🎯 Key Idea

Always merge the **smallest adjacent sum** first until the array becomes sorted.
