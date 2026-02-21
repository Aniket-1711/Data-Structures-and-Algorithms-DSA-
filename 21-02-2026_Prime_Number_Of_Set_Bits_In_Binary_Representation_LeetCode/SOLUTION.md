# 🔢 Prime Number of Set Bits in Binary Representation

## 📌 Problem Statement

Given two integers `left` and `right`, return the count of numbers in the inclusive range `[left, right]` that have a **prime number of set bits** in their binary representation.

* A **set bit** is a `1` in the binary form of a number.
* A **prime number** is a number greater than 1 that has only two factors: 1 and itself.

---

## 🧠 Example

### Input

```
left = 6
right = 10
```

### Binary Representation

| Number | Binary | Set Bits | Prime? |
| ------ | ------ | -------- | ------ |
| 6      | 110    | 2        | ✅ Yes  |
| 7      | 111    | 3        | ✅ Yes  |
| 8      | 1000   | 1        | ❌ No   |
| 9      | 1001   | 2        | ✅ Yes  |
| 10     | 1010   | 2        | ✅ Yes  |

### Output

```
4
```

---

## 🚀 Approach

1. Loop from `left` to `right`.
2. Count the number of set bits using `Integer.bitCount()`.
3. Check if the set bit count is prime.
4. If prime → increase count.
5. Return final count.

---

## 💻 Java Implementation

```java
class Solution {
    
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        
        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);
            if (isPrime(setBits)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}
```

---

## ⏱️ Time Complexity

* Loop runs at most `10^4` times
* Bit count is O(1)
* Prime check runs up to √20 (very small)

✅ **Overall Time Complexity:** O(N)

---

## 💡 Key Concepts Used

* Bit Manipulation
* Prime Number Checking
* Simple Iteration

---

## 🎯 Optimization Idea

Since maximum set bits for numbers ≤ 10⁶ is around 20, we can store prime numbers up to 20 in a set and directly check membership instead of computing prime every time.

---

## 🏁 Conclusion

This problem combines bit manipulation and basic number theory. Efficient use of built‑in functions makes the solution clean and fast.

