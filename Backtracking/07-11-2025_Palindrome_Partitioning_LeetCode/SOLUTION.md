# 🎯 Palindrome Partitioning (LeetCode Problem)

This repository contains the solution for the LeetCode problem **"Palindrome Partitioning"**.

---

## 📜 Problem Description

Given a string `s`, partition `s` such that **every substring** of the partition is a **palindrome**. Return all possible palindrome partitionings of `s`.

---

### 🧩 **Example 1:**

```
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
```

### 🧩 **Example 2:**

```
Input: s = "a"
Output: [["a"]]
```

### **Constraints:**

* 1 <= s.length <= 16
* s contains only lowercase English letters.

---

## 💡 Solution Approach: **Backtracking**

This problem asks for **all possible partitions**, which is a strong signal to use **backtracking**. The main idea is to try every possible **"cut"** in the string and check whether each cut forms a valid palindrome.

---

### 🔹 **Step 1: Recursive Logic (Pick / Don’t Pick Style)**

We define a helper function that takes:

* The remaining part of the string `s`.
* A temporary list of palindromic substrings found so far.

We loop over the string and try every possible **cut position**:

1. **Iterate:** Loop `i` from `0` to `s.length() - 1`.
2. **Create Partition:** Take substring `leftPart = s.substring(0, i + 1)`.
3. **Check Palindrome:** If `leftPart` is a palindrome → explore further.
4. **Choose:** Add `leftPart` to the current list.
5. **Recurse:** Call the helper for the remaining string `s.substring(i + 1)`.
6. **Backtrack:** Remove the last added substring before trying the next cut.

This process explores **all combinations** of palindrome partitions.

---

### 🔹 **Step 2: The `isPalindrome` Helper**

A simple **two-pointer** function:

* Start one pointer (`p1`) at the beginning and another (`p2`) at the end.
* Move inward while `s.charAt(p1) == s.charAt(p2)`.
* If any characters differ, return `false`.
* If the loop completes, it’s a palindrome → return `true`.

```java
public boolean isPalindrome(String s) {
    int p1 = 0;
    int p2 = s.length() - 1;
    while (p1 <= p2) {
        if (s.charAt(p1) != s.charAt(p2)) {
            return false;
        }
        p1++;
        p2--;
    }
    return true;
}
```

---

### 🛑 **Step 3: Base Case**

When the remaining string `s` becomes empty (`s.length() == 0`):

* It means we’ve successfully partitioned the entire original string into valid palindromes.
* At this point, we **add a copy** of our current list to the result.

---

## 💻 Full Java Implementation

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        pdp(s, result, list);
        return result;
    }

    /**
     * The main backtracking helper function.
     *
     * @param s      The remaining part of the string to partition.
     * @param result The final list of all valid partitions.
     * @param list   The temporary list for the current partition being built.
     */
    public void pdp(String s, List<List<String>> result, List<String> list) {

        // Base Case: We've successfully partitioned the whole string.
        if (s.length() == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        // Iterate through all possible "cut" points
        for (int i = 0; i < s.length(); i++) {
            // Create the first piece (substring)
            String leftPart = s.substring(0, i + 1);

            // Check if this piece is a palindrome
            if (isPalindrome(leftPart)) {
                // 1. Choose (Add the piece to our list)
                list.add(leftPart);
                
                // 2. Explore (Recurse on the rest of the string)
                pdp(s.substring(i + 1), result, list);

                // 3. Unchoose (Backtrack)
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * Helper function to check if a string is a palindrome.
     */
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        while (p1 <= p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}
```

---

## 📊 Complexity Analysis

| Type                    | Complexity     | Description                                                                                                                    |
| ----------------------- | -------------- | ------------------------------------------------------------------------------------------------------------------------------ |
| ⏱️ **Time Complexity**  | **O(N × 2^N)** | Each position can be cut or not, leading to 2^(N−1) partitions. Each substring check takes O(N), giving a total of O(N × 2^N). |
| 💾 **Space Complexity** | **O(N)**       | Recursion depth is at most N (one cut per character). The list for current partitions also takes O(N) space.                   |

---

### ✅ Summary

* Use **backtracking** to explore all possible palindrome partitions.
* Use **two-pointer** method to check palindromes efficiently.
* Apply **backtracking** with **Choose → Explore → Unchoose** steps.
* Handle base case carefully to store valid results.

---

✨ This backtracking approach generates all **valid palindrome partitions** efficiently, balancing clarity, simplicity, and performance.
