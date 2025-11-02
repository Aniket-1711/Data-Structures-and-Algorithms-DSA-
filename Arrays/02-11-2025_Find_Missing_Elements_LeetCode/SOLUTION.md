# Find Missing Elements — README.md ✅

**Problem (Easy)**

You are given an integer array `nums` with **unique** integers. Originally `nums` contained every integer in a continuous range from `min` to `max`. Some integers may be missing now, but the smallest and largest values of the original range are still present in `nums`.

Return a **sorted list** of all missing integers in that range. If none are missing, return an empty list.

---

## Examples

**Example 1**

```
Input: nums = [1,4,2,5]
Output: [3]
```

**Example 2**

```
Input: nums = [7,8,6,9]
Output: []
```

**Example 3**

```
Input: nums = [5,1]
Output: [2,3,4]
```

---

## Subtopic 1 — Intuition / Problem Explanation 🧠

* Since the smallest and largest elements are present, the "full" range is from `min(nums)` to `max(nums)`.
* We need to list the integers in that full range that do not appear in `nums`.
* Because `nums` has unique elements, we only need a membership check (is this number present?) for each number in the range.


---

## Subtopic 2 — Approaches (beginner → pro) ⚙️

### Approach A — Sort + Set (simple, clear)

1. Sort `nums` (so we can quickly get `min` and `max` as `nums[0]` and `nums[nums.length-1]`).
2. Put all elements into a `HashSet<Integer>` for O(1) average membership checks.
3. Iterate from `min` to `max` and collect numbers not in the set.

**Pros:** easy to write and reason about. Works for general ranges.
**Cons:** Sorting costs `O(n log n)`.


### Approach B — Min/Max + Boolean/Counting array (optimised when range small)

1. Compute `min` and `max` with a single pass (O(n)).
2. If the range length (`max - min + 1`) is small (or known bounded), allocate a boolean array of that size.
3. Mark presence for each element, then scan boolean array to collect missing values.

**Pros:** O(n + range) time, no sorting, simpler constant factors when `range` is small (here constraints suggest `nums[i] <= 100`).
**Cons:** Extra space proportional to the range.


---

## Subtopic 3 — Java Implementation (clean, production-ready)

```java
import java.util.*;

public class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        // Edge cases
        if (nums == null || nums.length == 0) return Collections.emptyList();

        Arrays.sort(nums); // O(n log n)
        int min = nums[0];
        int max = nums[nums.length - 1];

        Set<Integer> present = new HashSet<>();
        for (int x : nums) present.add(x); // O(n)

        List<Integer> missing = new ArrayList<>();
        for (int v = min; v <= max; v++) {
            if (!present.contains(v)) missing.add(v);
        }
        return missing;
    }
}
```

---

## Subtopic 4 — Optimised Java version (no sort, uses boolean presence)

This version computes min and max first, then uses boolean array. Works very well here because of small constraints (values up to 100).

```java
import java.util.*;

public class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x < min) min = x;
            if (x > max) max = x;
        }

        int len = max - min + 1; // size of full range
        boolean[] seen = new boolean[len];
        for (int x : nums) seen[x - min] = true; // mark presence

        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (!seen[i]) missing.add(min + i);
        }
        return missing;
    }
}
```

---

## Complexity Summary

* **Sort + Set approach:**

  * Time: `O(n log n)` for sorting + `O(n)` for set/check = `O(n log n)` total.
  * Space: `O(n)` for the set and output.

* **Min/Max + boolean array approach:**

  * Time: `O(n + R)` where `R = max - min + 1`.
  * Space: `O(R)` for the boolean array. If `R` is small (≤ 100), this is cheap.
---

## Testing / Edge cases ✅

* `nums = [1,2]` → `[]` (no missing numbers inside range)
* `nums = [5,1]` → `[2,3,4]` (example)
* `nums = [1,100]` and other sparse ranges — check memory if using boolean array (here constraint limits help)
* `nums` already sorted or unsorted — both are handled by implementations above.

