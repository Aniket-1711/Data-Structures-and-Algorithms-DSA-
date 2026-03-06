# 👑 Leaders in an Array

## 📌 Problem

Given an integer array `arr`, an element is called a **leader** if it is **greater than or equal to all elements to its right**.

The **rightmost element** is always a leader because there are no elements after it.

Return all leaders in the **same order as they appear in the array**.

---

## Example

### Input

```
arr = [10, 22, 12, 3, 0, 6]
```

### Output

```
22 12 6
```

### Explanation

* `6` → last element → leader
* `12` → greater than `3, 0, 6`
* `22` → greater than `12, 3, 0, 6`

---

# 🚀 Approach 1: Right-to-Left Traversal (ArrayList)

## 💡 Idea

Traverse the array **from right to left** while keeping track of the **maximum element seen so far**.

If the current element is **greater than the maximum**, it becomes a **leader**.

---

## 🧠 Algorithm

1. Start from the **last element**.
2. Keep a variable `max` to store the **largest element seen so far**.
3. Add the last element to the result because it is always a leader.
4. Move from **right to left**:

   * If `nums[i] > max`

     * Add it to the result.
     * Update `max`.
5. Reverse the result list because leaders were collected **from right to left**.

---

## Code (ArrayList Approach)

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        if(nums.length == 0) return ans;

        int max = nums[nums.length - 1];
        ans.add(max);

        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] > max){
                ans.add(nums[i]);
                max = nums[i];
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}
```

---

## ⏱ Complexity

Time Complexity

```
O(N)
```

Space Complexity

```
O(N)
```

---

# 🚀 Approach 2: Monotonic Stack

## 💡 Idea

Use a **monotonic decreasing stack**.

We traverse the array **from right to left** and push elements onto the stack **only if they are greater than the current top**.

This ensures the stack always contains **leaders in decreasing order**.

---

## 🧠 Algorithm

1. Create an empty stack.
2. Traverse the array **from right to left**.
3. For each element:

   * If the stack is empty → push element.
   * If element > stack top → push element.
4. After traversal, stack contains all leaders.
5. Reverse them to get the correct order.

---

## Code (Monotonic Stack Approach)

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> leaders(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        for(int i = nums.length - 1; i >= 0; i--){

            if(stack.isEmpty() || nums[i] > stack.peek()){
                stack.push(nums[i]);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }

        return ans;
    }
}
```

---

## ⏱ Complexity

Time Complexity

```
O(N)
```

Space Complexity

```
O(N)
```

---

# ⚡ Key Concepts

* Right-to-left traversal
* Tracking maximum element
* Monotonic stack pattern
* Efficient single-pass solutions

---

# 🏆 Summary

| Approach        | Idea                        | Extra Data Structure |
| --------------- | --------------------------- | -------------------- |
| ArrayList       | Track maximum from right    | ArrayList            |
| Monotonic Stack | Maintain decreasing leaders | Stack                |

Both approaches efficiently find **leaders in linear time**.
