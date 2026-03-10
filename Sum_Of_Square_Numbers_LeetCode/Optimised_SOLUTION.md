# 🔢 633. Sum of Square Numbers

## 📌 Problem

Given a **non-negative integer `c`**, determine whether there exist two integers `a` and `b` such that:

a² + b² = c

Return **true** if such numbers exist, otherwise return **false**.

---

## 🧠 Approach – Two Pointer Technique

The idea is based on the observation that:

* The **smallest possible value** for `a` is `0`
* The **largest possible value** for `b` is `√c`

So we use **two pointers**:

* `lo` → starts from `0`
* `hi` → starts from `√c`

We calculate:

```
lo² + hi²
```

### Logic

1. If the sum equals `c`
   → we found valid numbers → **return true**

2. If the sum is **greater than `c`**
   → decrease `hi` to reduce the value.

3. If the sum is **less than `c`**
   → increase `lo` to increase the value.

Continue until `lo > hi`.

---

## 💻 Java Implementation

```java
class Solution {
    public boolean judgeSquareSum(int c) {
        long lo = 0, hi = (long)Math.sqrt(c);

        while(lo <= hi){
            long num = lo * lo + hi * hi;

            if(num == c){
                return true;
            }
            else if(num > c){
                hi--;
            }
            else{
                lo++;
            }
        }

        return false;
    }
}
```

---

## ⏱️ Complexity Analysis

**Time Complexity**

```
O(√c)
```

Because the pointers move at most `√c` times.

**Space Complexity**

```
O(1)
```

Only constant extra space is used.

---

## 📊 Example

### Input

```
c = 5
```

### Steps

```
0² + 2² = 4   (too small → increase lo)
1² + 2² = 5   (match found)
```

### Output

```
true
```

---

## ✅ Key Points

* Uses **two pointer technique**
* Start from **smallest and largest possible values**
* Adjust pointers based on the sum
* Efficient solution with **constant space**
