# 🔢 Check Digitorial Permutation

## 📝 Problem Overview

A number is called **digitorial** if:

> Sum of factorials of its digits = the number itself

You are given an integer `n`.

Your task is to check:

👉 Does **any permutation** of digits of `n` form a digitorial number?

⚠️ A permutation starting with `0` is invalid.

---

## 📌 Key Idea

Instead of generating all permutations (which is costly), we use a smart observation:

If:

```
Sum of factorials of digits of n = X
```

Then we check:

* Do digits of `X` match digits of `n`?
* If yes → Some permutation of `n` equals `X`
* If no → Not possible

So we compare **digit frequency**.

---

## 🧠 Why This Works

If digit counts are same:

* Both numbers contain same digits
* That means one is a permutation of the other
* So permutation exists that equals the factorial sum

---

## 💻 Java Implementation

```java
class Solution {
    public boolean isDigitorialPermutation(int n) {
        int ar[] = new int[10];
        int fact = 1;
        ar[0] = 1;

        // Precompute factorials from 0! to 9!
        for(int i = 1; i < ar.length; i++) {
            fact *= i;
            ar[i] = fact;
        }

        int temp = n;
        int ans = 0;
        int a[] = new int[10];

        // Calculate factorial sum and count digits of n
        while(temp > 0) {
            int num = temp % 10;
            ans += ar[num];
            temp /= 10;
            a[num]++;
        }

        int b[] = new int[10];
        int t = ans;

        // Count digits of factorial sum
        while(t > 0) {
            b[t % 10]++;
            t /= 10;
        }

        // Compare digit frequencies
        for(int i = 0; i < 10; i++) {
            if(a[i] != b[i]) return false;
        }

        return true;
    }
}
```

---

## 🔍 Example

### Example 1

```
Input: 145
```

Calculation:

```
1! + 4! + 5! = 1 + 24 + 120 = 145
```

Digits match ✔

Output: `true`

---

### Example 2

```
Input: 10
```

Calculation:

```
1! + 0! = 1 + 1 = 2
```

Digits of 10 ≠ Digits of 2 ❌

Output: `false`

---

## ⏱ Complexity

* Time Complexity: O(d)

  * d = number of digits (max 10)

* Space Complexity: O(1)

  * Fixed size arrays (size 10)

---

## ✅ Key Takeaways

✔ No need to generate permutations

✔ Just compare digit frequencies

✔ Precompute factorials for efficiency

✔ Clean simulation + hashing approach

---

