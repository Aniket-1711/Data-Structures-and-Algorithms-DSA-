# 🎮 Find the Score Difference in a Game

## 📝 Problem Overview

You are given an integer array `nums`.

* `nums[i]` represents points scored in the **i-th game**.
* There are **two players**:

  * Player 1 (initially active)
  * Player 2 (initially inactive)

The goal is to calculate:

> **Score Difference = Player1 Score − Player2 Score**

---

## 🔁 Game Rules

For every game `i`, follow these rules **in order**:

1️⃣ If `nums[i]` is **odd** → swap active and inactive players.

2️⃣ If it is the **6th game** (index 5, 11, 17, ...) → swap players again.

3️⃣ The **active player** earns `nums[i]` points.

---

## 🧠 Important Logic Understanding

* Swapping happens **before adding points**.
* In the 6th game, swapping can happen **twice**:

  * Once if number is odd
  * Once because it is the 6th game
* Two swaps cancel each other.

---

## 💻 Java Implementation

```java
class Solution {
    public int scoreDifference(int[] nums) {
        int s1 = 0, s2 = 0;
        boolean flag = false; // false -> Player1 active, true -> Player2 active

        for(int i = 0; i < nums.length; i++) {

            // Rule 1: Swap if number is odd
            if(nums[i] % 2 != 0) {
                flag = !flag;
            }

            // Rule 2: Swap every 6th game
            if((i + 1) % 6 == 0) {
                flag = !flag;
            }

            // Active player gains points
            if(flag) {
                s2 += nums[i];
            } else {
                s1 += nums[i];
            }
        }

        return s1 - s2;
    }
}
```

---

## 🔍 Example

### Input:

```
nums = [2,4,2,1,2,1]
```

### Execution Summary:

| Game | Value | Swap?     | Active Player | Score Update |
| ---- | ----- | --------- | ------------- | ------------ |
| 0    | 2     | No        | P1            | P1 = 2       |
| 1    | 4     | No        | P1            | P1 = 6       |
| 2    | 2     | No        | P1            | P1 = 8       |
| 3    | 1     | Yes       | P2            | P2 = 1       |
| 4    | 2     | No        | P2            | P2 = 3       |
| 5    | 1     | Yes + Yes | P2            | P2 = 4       |

### Final:

```
Player1 = 8
Player2 = 4
Score Difference = 4
```

---

## ⏱ Time & Space Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

---

## ✅ Key Takeaways

✔ Players do not alternate normally.

✔ Swapping depends on conditions.

✔ Order of rules matters.

✔ Double swap cancels effect.

---

