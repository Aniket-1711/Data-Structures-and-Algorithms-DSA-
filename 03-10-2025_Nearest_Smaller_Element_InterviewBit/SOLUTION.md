# 🧩 Nearest Smaller Element

## 📖 Problem Statement
Given an array, find the **nearest smaller element G[i]** for every element A[i] in the array such that the element has an **index smaller than i**.

More formally:

- G[i] for an element A[i] = A[j] such that  
  - j is the **maximum possible index** AND  
  - j < i AND  
  - A[j] < A[i]  

If no such element exists, then consider the nearest smaller element as `-1`.

---

## 🛠️ Input Format
- The only argument given is an integer array **A**.

## 📤 Output Format
- Return the integer array **G** such that G[i] contains the nearest smaller number than A[i].  
- If no such element occurs, G[i] should be **-1**.

---

## 🧮 Examples
### Example 1
**Input:**  

A = [4, 5, 2, 10, 8]

**Output:**  
G = [-1, 4, -1, 2, 2]

**Explanation:**  
- index 0: No element to the left of 4 → G[0] = -1  
- index 1: Nearest smaller is 4 → G[1] = 4  
- index 2: No element smaller than 2 → G[2] = -1  
- index 3: Nearest smaller is 2 → G[3] = 2  
- index 4: Nearest smaller is 2 → G[4] = 2  

---

### Example 2
**Input:**  
A = [3, 2, 1]

**Output:**  
G = [-1, -1, -1]

**Explanation:**  
- No element on the left of each index is smaller → All `-1`

---

## 💡 Approach

We solve this using a **Monotonic Stack**:
1. Initialize an empty stack.  
2. Iterate through the array:  
   - While the stack is not empty and the top element ≥ current element, pop from the stack.  
   - If the stack is empty → No smaller element → Add `-1`.  
   - Otherwise → The top of the stack is the nearest smaller → Add it to the result.  
   - Push the current element onto the stack.  

This ensures we efficiently find the nearest smaller element in **O(N)** time.

---

## ⚡ Java Solution

```java
import java.util.*;

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.size(); i++) {
            while (!stack.isEmpty() && stack.peek() >= A.get(i)) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                list.add(-1);
            } else {
                list.add(stack.peek());
            }

            stack.push(A.get(i));
        }
        return list;
    }
}
```
## 🔄 Dry Run

For input: A = [4, 5, 2, 10, 8]
| i | A[i] | Stack (before)     | Result |
| - | ---- | ------------------ | ------ |
| 0 | 4    | []                 | -1     |
| 1 | 5    | [4]                | 4      |
| 2 | 2    | [4,5] → pop → []   | -1     |
| 3 | 10   | [2]                | 2      |
| 4 | 8    | [2,10] → pop → [2] | 2      |

Final Result = [-1, 4, -1, 2, 2]
