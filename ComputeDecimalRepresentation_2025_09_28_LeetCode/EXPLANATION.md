# Compute Decimal Representation - LeetCode Solution

## 📋 Problem Summary

**Problem:** Compute Decimal Representation  
**Difficulty:** Easy  
**Contest:** Weekly Contest 469  
**Date Solved:** September 28, 2025  
**LeetCode Problem Link:** [Compute Decimal Representation](https://leetcode.com/contest/weekly-contest-469/problems/compute-decimal-representation/)

## 🎯 Problem Statement

Given a positive integer `n`, express it as a sum of only base-10 components using the fewest base-10 components possible.

A **base-10 component** is the product of a single digit (1-9) and a non-negative power of 10.

**Examples of base-10 components:** 500, 30, 7  
**NOT base-10 components:** 537, 102, 11

### Examples:

#### Example 1:
```
Input: n = 537
Output: [500, 30, 7]
Explanation: 537 = 500 + 30 + 7 (3 base-10 components)
```

#### Example 2:
```
Input: n = 102
Output: [100, 2]
Explanation: 102 = 100 + 2 (2 base-10 components)
```

#### Example 3:
```
Input: n = 6
Output: [6]
Explanation: 6 is already a base-10 component
```

### Constraints:
- `1 <= n <= 10^9`

## 💡 Solution Approach

### Key Insight
To get the minimum number of base-10 components, we need to break down the number digit by digit, where each non-zero digit contributes one component (digit × place_value).

### Algorithm Steps:

1. **Extract digits from right to left** using modulo 10 operation
2. **Calculate place value** (1, 10, 100, 1000, ...)
3. **For each non-zero digit**: multiply digit by place value and add to result
4. **Skip zero digits** (they don't contribute to the sum)
5. **Reverse the result** to get components in descending order
6. **Convert to array** and return

### Why This Works:
- Each digit position can only contribute ONE base-10 component at most
- Zero digits contribute nothing (0 × place_value = 0)
- Non-zero digits must be represented as (digit × place_value)
- This gives us the minimum number of components

## 🔍 Step-by-Step Walkthrough

### Example: n = 537

| Step | n | n % 10 | place | Component | ArrayList |
|------|---|--------|-------|-----------|----------|
| 1    | 537 | 7 | 1 | 7×1 = 7 | [7] |
| 2    | 53 | 3 | 10 | 3×10 = 30 | [7, 30] |
| 3    | 5 | 5 | 100 | 5×100 = 500 | [7, 30, 500] |
| 4    | 0 | - | - | - | [7, 30, 500] |

**After reverse:** [500, 30, 7]

### Example: n = 102

| Step | n | n % 10 | place | Component | ArrayList |
|------|---|--------|-------|-----------|----------|
| 1    | 102 | 2 | 1 | 2×1 = 2 | [2] |
| 2    | 10 | 0 | 10 | Skip (0) | [2] |
| 3    | 1 | 1 | 100 | 1×100 = 100 | [2, 100] |
| 4    | 0 | - | - | - | [2, 100] |

**After reverse:** [100, 2]

## ⏱️ Complexity Analysis

### Time Complexity: O(log n)
- We process each digit of the number exactly once
- Number of digits in n is log₁₀(n), hence O(log n)
- Collections.reverse() takes O(log n) time
- Converting to array takes O(log n) time
- **Overall: O(log n)**

### Space Complexity: O(log n)
- ArrayList stores at most log₁₀(n) components (one per non-zero digit)
- Result array has same size
- **Overall: O(log n)**

## 🧪 Test Cases & Results

| Input | Expected Output | Actual Output | Status |
|-------|----------------|---------------|--------|
| 537 | [500, 30, 7] | [500, 30, 7] | ✅ |
| 102 | [100, 2] | [100, 2] | ✅ |
| 6 | [6] | [6] | ✅ |
| 1000 | [1000] | [1000] | ✅ |
| 1010 | [1000, 10] | [1000, 10] | ✅ |

## 🏆 Performance Stats

**LeetCode Submission Results:**
- **Runtime:** 2ms (beats 73.11% of Java submissions)
- **Memory:** 43.4 MB
- **Test Cases Passed:** 1000/1000 ✅
- **Contest Performance:** Accepted in Weekly Contest 469

## 🔄 Alternative Approaches

### Approach 1: String Processing
```java
public int[] decimalRepresentation(int n) {
    String s = String.valueOf(n);
    List<Integer> result = new ArrayList<>();
    
    for (int i = 0; i < s.length(); i++) {
        int digit = s.charAt(i) - '0';
        if (digit != 0) {
            int placeValue = (int) Math.pow(10, s.length() - 1 - i);
            result.add(digit * placeValue);
        }
    }
    
    return result.stream().mapToInt(i -> i).toArray();
}
```
**Pros:** More intuitive, processes left to right  
**Cons:** String conversion overhead, Math.pow() overhead

### Approach 2: Recursive
```java
public int[] decimalRepresentation(int n) {
    List<Integer> result = new ArrayList<>();
    helper(n, 1, result);
    Collections.reverse(result);
    return result.stream().mapToInt(i -> i).toArray();
}

private void helper(int n, int place, List<Integer> result) {
    if (n == 0) return;
    
    int digit = n % 10;
    if (digit != 0) {
        result.add(digit * place);
    }
    
    helper(n / 10, place * 10, result);
}
```
**Pros:** Clean recursive structure  
**Cons:** Extra function call overhead, stack space usage

## 🎯 Key Learnings

1. **Digit Extraction Pattern:** `n % 10` to get rightmost digit, `n / 10` to remove it
2. **Place Value Calculation:** Start with 1, multiply by 10 each iteration
3. **Optimization:** Skip zero digits to avoid unnecessary work
4. **Result Order:** Problem requires descending order, so reverse the result
5. **Base-10 Components:** Understanding that each non-zero digit position contributes exactly one component

## 📚 Related Problems

- [Add Digits (LeetCode 258)](https://leetcode.com/problems/add-digits/)
- [Sum of Digits in Base K (LeetCode 1837)](https://leetcode.com/problems/sum-of-digits-in-base-k/)
- [Number of Steps to Reduce a Number to Zero (LeetCode 1342)](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/)

## 🏷️ Tags
`Math` `Array` `String` `Number Theory` `Contest Problem`
