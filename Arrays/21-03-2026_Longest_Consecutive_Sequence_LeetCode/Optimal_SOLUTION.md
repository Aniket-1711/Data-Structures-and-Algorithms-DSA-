# 🚀 Longest Consecutive Sequence (Optimal HashSet Approach)

## 📌 Problem

Given an unsorted array of integers, find the length of the longest sequence of consecutive numbers.

👉 Example:

```
Input: [100,4,200,1,3,2]
Output: 4
Explanation: [1,2,3,4]
```

---

## 🧠 Approach Used: HashSet (Optimal O(n))

### 💡 Idea

* Store all elements in a HashSet for O(1) lookup
* Only start counting when the current element is the **start of a sequence**
* A number is a start if `(num - 1)` is NOT present

---

## ⚙️ Steps

1. If array is empty → return `0`
2. Insert all elements into a `HashSet`
3. Traverse through set:

   * If `(num - 1)` is NOT present → start a new sequence
   * Keep checking `(num + 1)` and count streak
4. Track maximum streak

---

## 🧾 Code

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;

        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        int streak=1,maxStreak=1;

        for(int i:set){
            int ele=i;

            // start only if it's the beginning of sequence
            if(!set.contains(ele-1)){
                ele=ele+1;
                streak=1;

                while(set.contains(ele)){
                    streak++;
                    ele++;
                }

                maxStreak=Math.max(streak, maxStreak);
            }
        }

        return maxStreak;
    }
}
```

---

## ⏱️ Complexity

| Type  | Complexity |
| ----- | ---------- |
| Time  | O(n)       |
| Space | O(n)       |

---

## 🔥 Key Insight

👉 We only start counting when we find the **first element of a sequence**

Example:

```
Set = [1,2,3,4]
Start only at 1 (because 0 not present)
```

This avoids unnecessary repeated work and ensures O(n) time.

---

## ⚠️ Important Points

* HashSet gives O(1) lookup
* Avoid counting from every element (optimization trick)
* Works even with duplicates (set removes them)

---

## 🧩 When to Use

* When O(n) time is required
* Best solution for this problem

---

## 📌 Summary

✔ Optimal solution (O(n))
✔ Efficient using HashSet
✔ Smart trick: start only from sequence beginnings

---

