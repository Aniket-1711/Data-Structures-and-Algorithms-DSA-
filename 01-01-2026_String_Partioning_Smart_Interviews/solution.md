# String Partitioning using Dynamic Programming

## 📌 Problem Statement

You are given:

* A string **S** of length **N**
* A list **L** containing **K** valid substrings (dictionary words)

Your task is to:

1. **Count the total number of ways** to partition the string **S** such that **every partition exists in L**.
2. **Find the minimum number of cuts** required to partition the string **S** in a valid way.

🔹 It is guaranteed that **at least one valid partition exists**.

---

## 🧠 Key Observations

* The order of partitions matters.
* We need to check **all possible prefixes** of the string.
* Overlapping subproblems make this a **Dynamic Programming** problem.

---

## 🚀 Approach (Bottom-Up Dynamic Programming)

We use two DP arrays:

* `dpWays[i]` → Number of valid ways to partition prefix `S[0...i-1]`
* `dpMin[i]` → Minimum number of segments needed for prefix `S[0...i-1]`

### 🔁 State Transition

For every `i` from `1` to `N`, try all `j < i`:

* If substring `S[j...i-1]` exists in the dictionary:

  * `dpWays[i] += dpWays[j]`
  * `dpMin[i] = min(dpMin[i], dpMin[j] + 1)`

### 🧩 Base Case

* `dpWays[0] = 1` (empty string has one valid way)
* `dpMin[0] = 0`

---

## 🧪 Sample Test Case

### **Input**

```
1
15
smartinterviews
6
s sm smart inter view views
```

### **Explanation**

Some valid partitions are:

* `smart | inter | views`
* `sm | art | inter | view | s`
* `s | mart | inter | views`

### **Output**

```
6 2
```

* **6** valid partitioning ways
* **2** cuts (3 segments)

---

## 💻 Java Implementation

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int k = sc.nextInt();

            HashSet<String> dict = new HashSet<>();
            for (int i = 0; i < k; i++) {
                dict.add(sc.next());
            }

            long[] dpWays = new long[n + 1];
            long[] dpMin = new long[n + 1];
            Arrays.fill(dpMin, Long.MAX_VALUE);

            dpWays[0] = 1;
            dpMin[0] = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    String sub = s.substring(j, i);
                    if (dict.contains(sub)) {
                        dpWays[i] += dpWays[j];
                        dpMin[i] = Math.min(dpMin[i], dpMin[j] + 1);
                    }
                }
            }

            // dpMin[n] - 1 gives number of cuts
            System.out.println(dpWays[n] + " " + (dpMin[n] - 1));
        }
        sc.close();
    }
}
```

---

## 📊 Time and Space Complexity

### ⏱ Time Complexity

* **O(N²)** per test case
* Two nested loops over string length
* Dictionary lookup is **O(1)** using `HashSet`

### 💾 Space Complexity

* **O(N)** for DP arrays

---

## ✅ Why This Solution Works Well

* Efficient for **N ≤ 50**
* Avoids exponential recursion
* Clean and interview-friendly

---

## 📌 Final Notes

* This is a **classic string DP problem**
* Frequently asked in **coding interviews & contests**
* Can be further optimized using **Trie-based matching** (optional)
