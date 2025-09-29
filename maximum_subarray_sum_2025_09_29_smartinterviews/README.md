# Maximum Subarray Sum Problem

## Problem Statement
Given an array of integers, find the maximum subarray sum.

## Input Format
The first line of input contains T - number of test cases. It is followed by 2T lines. First line of each test case contains N - size of the array and the second line contains N integers - elements of the array.

## Output Format
For each test case, print the maximum subarray sum, followed by the start and end indices of the subarray, separated by new line. If multiple subarrays give the same sum, consider the lexicographically smaller one for the answer.

## Constraints
20 points
1 <= T <= 100
1 <= N <= 102

30 points
1 <= T <= 100
1 <= N <= 103

50 points
1 <= T <= 100
1 <= N <= 104

General Constraints
-103 <= A[i] <= 103

## Example
### Input
```
3
9
-24 0 28 28 55 -31 -27 -45 -24
10
40 5 39 45 31 -44 73 -16 -31 27
7
57 18 -14 17 31 16 -16
```

### Output
```
111 1 4
189 0 6
125 0 5
```

## Solution Code
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        while(testCases-- > 0) {
            int size = sc.nextInt();
            int ar[] = new int[size];
            int max = Integer.MIN_VALUE;
            boolean allNeg = true;
            int index = -1;
            
            // Read input and check for all negative elements
            for(int i = 0; i < size; i++) {
                ar[i] = sc.nextInt();
                if(ar[i] >= 0) {
                    allNeg = false;
                }
                if(ar[i] > max) {
                    max = ar[i];
                    index = i;
                }
            }
            
            // Edge case: All elements are negative
            if(allNeg) {
                System.out.println(max + " " + index + " " + index);
                continue;
            }
            
            // Kadane's algorithm with index tracking
            int start = 0, last = -1;
            int sum = 0, ans = Integer.MIN_VALUE;
            int bestStart = 0;
            
            for(int i = 0; i < size; i++) {
                if(sum < 0) {
                    start = i;
                    sum = 0;
                }
                sum += ar[i];
                
                // Update best subarray considering lexicographic order
                if(sum > ans || (sum == ans && (start < bestStart || (start == bestStart && i < last)))) {
                    ans = sum;
                    bestStart = start;
                    last = i;
                }
            }
            
            System.out.println(ans + " " + bestStart + " " + last);
        }
    }
}
```

## Algorithm Explanation

This solution uses **Kadane's Algorithm** with modifications to track indices and handle edge cases:

### Main Logic:
1. **Input Processing**: Read test cases and array elements while tracking the maximum element and checking if all elements are negative.

2. **Edge Case Handling**: 
   - If all elements are negative, the maximum subarray is the single largest element.
   - Return the maximum element with its index as both start and end.

3. **Kadane's Algorithm with Index Tracking**:
   - Maintain running sum and reset when it becomes negative
   - Track the current subarray's start position
   - Update the best answer when a better sum is found

4. **Lexicographic Ordering**:
   - When multiple subarrays have the same sum, choose the one that starts earlier
   - If start positions are same, choose the one that ends earlier

### Edge Cases Handled:

1. **All Negative Elements**: 
   - Returns the maximum single element as the subarray
   - Start and end indices are the same (position of max element)

2. **Multiple Optimal Subarrays**:
   - Chooses lexicographically smaller subarray (earlier start, then earlier end)
   - Ensures consistent output for identical maximum sums

3. **Single Element Array**:
   - Handled naturally by the algorithm
   - Returns the element itself with indices (0,0)

4. **Mixed Positive/Negative Arrays**:
   - Uses Kadane's algorithm to find optimal contiguous subarray
   - Properly resets and tracks indices during traversal

### Time Complexity: O(N) for each test case
### Space Complexity: O(N) for storing the array
