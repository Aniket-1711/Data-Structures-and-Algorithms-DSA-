# 📌 Merge Intervals

## 🧩 Problem Statement

Given a list of intervals, merge all overlapping intervals and return a list of non-overlapping intervals.

---

## 📥 Input

An array of intervals:

```
[[start1, end1], [start2, end2], ...]
```

## 📤 Output

Merged intervals such that no intervals overlap.

---

## 💡 Approach

### 1️⃣ Sort Intervals

* Sort intervals based on **starting time**.

### 2️⃣ Traverse and Merge

* Keep a `prev` interval.
* For each interval:

  * If overlapping → merge
  * Else → add previous to result

---

## 🔥 Overlap Condition

```
current.start <= prev.end
```

---

## ⚙️ Code

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            return Integer.compare(a[0], b[0]);
        });

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                merged.add(prev);
                prev = intervals[i];
            }
        }

        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }
}
```

---

## 🧪 Example

### Input

```
[[1,3],[2,6],[8,10],[15,18]]
```

### Output

```
[[1,6],[8,10],[15,18]]
```

---

## ⏱️ Complexity

| Type  | Complexity |
| ----- | ---------- |
| Time  | O(n log n) |
| Space | O(n)       |

---

## 🚀 Key Points

* Sorting is **mandatory**
* Always compare with **last merged interval**
* Overlap depends on **end of previous**

---

## 🧠 Pattern

👉 Greedy + Sorting

---

## ✅ Summary

* Sort intervals
* Merge overlapping ones
* Store result

---

