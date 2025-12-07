# 🧩 Largest Prime from Consecutive Prime Sum [[the Sieve of Eratosthenes (Sieve of Primes)]]

## 📌 Problem Statement

You are given an integer **n**.

You must find the **largest prime number ≤ n** that can be written as the **sum of one or more consecutive prime numbers starting from 2**.

If no such prime exists, return **0**.

---

## ✅ Examples

### Example 1

**Input:**

```
n = 20
```

**Explanation:**
Consecutive prime sums starting from 2:

* `2 = 2`
* `5 = 2 + 3`
* `17 = 2 + 3 + 5 + 7`

All are prime and ≤ 20. The largest is **17**.

**Output:**

```
17
```

---

### Example 2

**Input:**

```
n = 2
```

**Explanation:**
Only possible sum is `2` itself.

**Output:**

```
2
```

---

## ⚙️ Constraints

* `1 <= n <= 5 * 10^5`

---

## 🧠 Approach (Easy to Understand)

### Step 1: Find all prime numbers up to `n`

* Use **Sieve of Eratosthenes** to mark prime numbers efficiently.

### Step 2: Store all primes

* Save all prime numbers in a list for easy iteration.

### Step 3: Calculate consecutive prime sums

* Start adding primes from **2** one by one.
* Stop when the sum becomes greater than `n`.
* If the current sum is **prime**, update the answer.

The last valid prime sum is the required result ✅

---

## 💻 Java Code

```java
class Solution {
    public int largestPrime(int n) {
        boolean primes[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            primes[i] = true;
        }

        primes[0] = primes[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        List<Integer> primeNums = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (primes[i]) {
                primeNums.add(i);
            }
        }

        int result = 0, primeSum = 0;
        for (int i : primeNums) {
            primeSum += i;
            if (primeSum > n) break;
            if (primes[primeSum]) {
                result = primeSum;
            }
        }
        return result;
    }
}
```

---

## 🚀 Key Points

* Uses **Sieve of Eratosthenes** ✅
* Only consecutive primes starting from **2** ✅
* Efficient and within constraints ✅

---

🎯 **Time Complexity:** `O(n log log n)`
🎯 **Space Complexity:** `O(n)`

---


