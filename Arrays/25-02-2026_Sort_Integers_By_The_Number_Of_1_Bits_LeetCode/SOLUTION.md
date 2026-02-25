# 1356. Sort Integers by The Number of 1 Bits

## 📌 Problem Summary

You are given an integer array `arr`.

You must sort the array based on:

1. The number of **1 bits** in each integer's binary representation (ascending).
2. If two integers have the same number of 1 bits, sort them in **ascending numerical order**.

---

## ✅ Example

Input:

```
arr = [0,1,2,3,4,5,6,7,8]
```

Binary Representation:

```
0  -> 0      (0 bits)
1  -> 1      (1 bit)
2  -> 10     (1 bit)
3  -> 11     (2 bits)
4  -> 100    (1 bit)
5  -> 101    (2 bits)
6  -> 110    (2 bits)
7  -> 111    (3 bits)
8  -> 1000   (1 bit)
```

Sorted Output:

```
[0,1,2,4,8,3,5,6,7]
```

---

# 🧠 Approach Used

## Step 1: Sort the Array Normally

```java
Arrays.sort(arr);
```

Why?
Because if two numbers have the same number of 1 bits, they must be in ascending order.
Pre-sorting ensures this condition is automatically satisfied.

---

## Step 2: Use TreeMap

```java
TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
```

* Key → Number of 1 bits
* Value → List of integers with that bit count
* TreeMap keeps keys sorted automatically

---

## Step 3: Count Number of 1 Bits

```java
int getCount(int i) {
    int count = 0;
    while (i > 0) {
        if ((i & 1) == 1) {
            count++;
        }
        i = i >> 1;
    }
    return count;
}
```

### Explanation:

* `(i & 1)` checks if last bit is 1
* `i >> 1` right shifts the number

Time complexity per number = O(log n)

---

## Step 4: Store Numbers by Bit Count

```java
for (int i : arr) {
    int nbits = getCount(i);
    ArrayList<Integer> temp = map.getOrDefault(nbits, new ArrayList<>());
    temp.add(i);
    map.put(nbits, temp);
}
```

Example Map Structure:

```
0 → [0]
1 → [1,2,4,8]
2 → [3,5,6]
3 → [7]
```

---

## Step 5: Rebuild the Array

```java
int x = 0;
for (ArrayList<Integer> list : map.values()) {
    for (int num : list) {
        arr[x++] = num;
    }
}
```

Since TreeMap sorts keys automatically, final array is sorted by bit count.

---

# ⏱ Time Complexity

* Sorting → O(n log n)
* Counting bits → O(n log maxValue)
* TreeMap insertion → O(n log k)

Overall Complexity: **O(n log n)**

Since n ≤ 500 → Efficient.

---

# 🚀 Cleaner Interview Version

Java provides a built-in method:

```java
Integer.bitCount(x)
```

Optimized Solution:

```java
class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            int bitCompare = Integer.bitCount(a) - Integer.bitCount(b);
            if (bitCompare == 0) {
                return a - b;
            }
            return bitCompare;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
}
```

---

# 🎯 Key Learning Points

* Bit manipulation using `&` and `>>`
* TreeMap for automatic sorting of keys
* Custom comparator in Java
* Handling tie conditions in sorting

---

