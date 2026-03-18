# 🪑 Minimum Number of Moves to Seat Everyone

## 📌 Problem Summary

You are given two arrays:

* `seats[]` → positions of seats
* `students[]` → positions of students

Each move allows a student to move **+1 or -1**.

👉 Goal: Move every student to a seat such that:

* Each seat has exactly one student
* Total moves are **minimum**

---

## 💡 Key Idea (Greedy)

To minimize total moves:

> ✅ Always match the **closest student to the closest seat**

This is achieved by:

* Sorting both arrays
* Matching elements index by index

---

## 🧠 Approach

1. Sort `seats`
2. Sort `students`
3. Loop through arrays:

   * Add `|seats[i] - students[i]|` to result
4. Return total moves

---

## ✅ Java Implementation

```java
import java.util.*;

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int moves = 0;

        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }

        return moves;
    }
}
```

---

## 🔍 Example

```
Input:
seats = [3,1,5]
students = [2,7,4]

Sorted:
seats    = [1,3,5]
students = [2,4,7]

Moves:
|1-2| = 1
|3-4| = 1
|5-7| = 2

Total Moves = 4
```

---

## ⏱ Complexity

| Operation | Complexity |
| --------- | ---------- |
| Sorting   | O(n log n) |
| Loop      | O(n)       |
| Total     | O(n log n) |

---

## 🚀 Key Takeaway

👉 When matching two groups to minimize distance:

> 🔥 **Sort both arrays and pair them greedily**

---

## 🧩 Bonus Insight (Optimization)

Since values are small (1 ≤ value ≤ 100), we can also use:

* Counting sort / frequency array
* Achieve **O(n)** time

---

## 🏁 Conclusion

* Simple greedy problem
* Sorting ensures optimal pairing
* Very important pattern for interviews

---

