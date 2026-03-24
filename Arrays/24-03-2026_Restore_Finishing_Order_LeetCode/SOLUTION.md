# 🏁 Restore Finishing Order

## 📌 Problem Summary

Given:

* `order` → final race finishing order of participants
* `friends` → IDs of selected participants (subset)

Goal:
Return the `friends` in the **same order they finished the race**.

---

## 💡 Approach

Instead of rearranging or sorting, we **filter the original order**.

### Steps:

1. Store all `friends` in a **HashSet** for fast lookup ⚡
2. Traverse the `order` array
3. If an element exists in the set → add it to result
4. Return the result as an array

---

## 🧠 Key Insight

* The `order` array already represents the correct sequence
* We only need to **pick elements that belong to friends**
* No sorting or complex logic required ❌

---

## 🧾 Code (Java)

```java
import java.util.*;

class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int f : friends) {
            set.add(f);
        }

        List<Integer> result = new ArrayList<>();
        for (int o : order) {
            if (set.contains(o)) {
                result.add(o);
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
```

---

## ⏱️ Time & Space Complexity

| Complexity | Value |
| ---------- | ----- |
| Time       | O(n)  |
| Space      | O(f)  |

* `n` → size of `order`
* `f` → size of `friends`

---

## ✅ Example

### Input:

```
order = [3,1,2,5,4]
friends = [1,3,4]
```

### Output:

```
[3,1,4]
```

---

## 🚀 Summary

* Use **HashSet for fast lookup**
* Traverse once
* Filter elements
* Maintain original order

---

