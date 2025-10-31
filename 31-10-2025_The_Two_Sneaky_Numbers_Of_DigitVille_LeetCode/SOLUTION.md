# The Two Sneaky Numbers of Digitville 🕵️‍♂️🔢

## Problem (in simple words)

A list `nums` should contain every integer from `0` to `n-1` exactly once, but two numbers each appear **twice**, so the list length is `n + 2`. Your job is to find those two repeated numbers and return them in any order.

> Example: `nums = [0,1,1,0]` → answer: `[0,1]`

---


## Intuition (beginner → pro)

**Beginner view:**

* We need to detect numbers appearing twice. The easiest way is to count how many times each number appears.
* Use a map (`HashMap`) to count—when count becomes 2, record that number.

**Pro view (faster / constant space):**

* Because numbers are in range `0..n-1` and exactly two numbers repeat, we can use XOR math and a partitioning trick (similar to "find two single numbers in an array") to get both repeated numbers in `O(n)` time and `O(1)` extra space.

---

## Approach 1 — HashMap (easy, clear)

1. Create a map from integer → frequency.
2. Traverse `nums`:

   * If `map` already contains the number, it's one of the sneaky numbers → add to result list.
   * Otherwise put it into `map` with count 1.
3. Return the two recorded numbers.

**Time:** O(n).

**Space:** O(n) (because of the map).

**Java code (improved, safe):**

```java
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        int idx = 0;
        for (int x : nums) {
            int cnt = map.getOrDefault(x, 0) + 1;
            map.put(x, cnt);
            if (cnt == 2) {          // when count becomes 2, record it
                if (idx < 2) result[idx++] = x;
            }
        }
        return result;
    }
}
```

> Note: added `getOrDefault`, and a guard `if (idx < 2)` to be robust if input violated constraints.

---

## Approach 2 — XOR trick (O(1) extra space) ⚡

This is a bit more advanced but still safe when input guarantees exactly two repeated numbers.

Idea outline:

1. XOR all numbers in `nums` and also XOR with `0..n-1`. Because every non-repeated number cancels out, the final XOR equals `a ^ b` where `a` and `b` are the two repeated numbers.
2. Find a set bit in `a ^ b` (lowest set bit). Use it to partition numbers into two groups and XOR within each group to isolate `a` and `b` separately.

**Time:** O(n)

**Space:** O(1)

**Java sketch:**

```java
public int[] getSneakyNumbersXOR(int[] nums, int n) {
    // n is the intended size (nums.length == n + 2)
    int xor = 0;
    for (int x : nums) xor ^= x;
    for (int i = 0; i < n; i++) xor ^= i;   // now xor = a ^ b

    int diffBit = xor & -xor; // lowest set bit
    int a = 0, b = 0;

    for (int x : nums) {
        if ((x & diffBit) == 0) a ^= x;
        else b ^= x;
    }
    for (int i = 0; i < n; i++) {
        if ((i & diffBit) == 0) a ^= i;
        else b ^= i;
    }

    return new int[]{a, b};
}
```

---

## Complexity summary

* HashMap approach: Time O(n), Space O(n)
* XOR approach: Time O(n), Space O(1)

---

## Edge cases and tests

* Minimum n = 2 (nums.length = 4) — works with both methods.
* Validate your input only if you expect malformed input. The given constraints guarantee exactly two repeated numbers and values in range.

**Example tests to try:**

* `[0,1,1,0]` → `[0,1]`
* `[0,3,2,1,3,2]` → `[2,3]`
* `[7,1,5,4,3,4,6,0,9,5,8,2]` → `[4,5]`

---
