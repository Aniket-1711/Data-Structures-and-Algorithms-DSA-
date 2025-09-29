# maximum subarray sum - approach

## algorithm: kadane's algorithm

this solution uses kadane's algorithm, which is an optimal linear time algorithm to find the maximum sum of a contiguous subarray.

## code variables explanation

### input variables

• n: integer representing the size/length of the array
• arr[]: integer array of size n containing the input elements
• sc: scanner object for reading input from standard input

### algorithm variables

• currentSum: long variable that tracks the maximum sum of subarray ending at the current position
• maxSum: long variable that stores the overall maximum subarray sum found so far

## how the algorithm works

1. initialization: set both currentSum and maxSum to the first element of the array
2. iterate through array: starting from the second element (index 1):
   • for each element arr[i], calculate currentSum = max(arr[i], currentSum + arr[i])
   • this decides whether to:
     ■ start a new subarray from current element (arr[i]), or
     ■ extend the existing subarray (currentSum + arr[i])
   • update maxSum = max(maxSum, currentSum) to track the global maximum
3. return result: the final maxSum contains the maximum subarray sum

## time complexity

• o(n) - single pass through the array

## space complexity

• o(1) - only using constant extra space for variables

## key insight

the algorithm works on the principle that if the sum of elements up to a point becomes negative, it's better to start fresh from the next element rather than carrying the negative sum forward.
