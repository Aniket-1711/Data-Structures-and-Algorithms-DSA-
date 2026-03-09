# 📦 Minimum Capacity Box

## 🧩 Problem

Given an integer array `capacity` where `capacity[i]` represents the capacity of the *i-th box*, and an integer `itemSize` representing the size of an item.

A box can store the item if:

```
capacity[i] >= itemSize
```

The goal is to **find the index of the box with the smallest capacity that can store the item**.

### Rules

* If multiple boxes have the same minimum valid capacity, return the **smallest index**.
* If **no box can store the item**, return `-1`.

---

## 💡 Approach

1. Initialize:

   * `minCap` to `Integer.MAX_VALUE` to track the minimum valid capacity.
   * `index` to `-1` to store the answer.

2. Traverse through the `capacity` array.

3. For every box:

   * Check if it can store the item:

   ```
   capacity[i] >= itemSize
   ```

4. If it can store the item:

   * Compare its capacity with the current `minCap`.
   * If it is smaller, update:

     * `minCap`
     * `index`

5. After checking all boxes, return `index`.

---

## ☕ Java Implementation

```java
class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int minCap = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] >= itemSize) {
                if (capacity[i] < minCap) {
                    index = i;
                    minCap = capacity[i];
                }
            }
        }

        return index;
    }
}
```

---

## 🔍 Example

### Input

```
capacity = [1,5,3,7]
itemSize = 3
```

### Valid Boxes

```
5, 3, 7
```

The **minimum capacity** that can store the item is **3**, which is at **index 2**.

### Output

```
2
```

---

## ⏱ Time Complexity

```
O(n)
```

The array is scanned once.

---

## 📦 Space Complexity

```
O(1)
```

Only a few variables are used.

---

## ✅ Key Idea

Traverse the array, keep track of the **smallest capacity that is still large enough to store the item**, and return its index.
