# Maximum Subarray Sum - Kadane's Algorithm

## 🎯 Problem Statement
Find the maximum sum of any contiguous subarray within a given array of numbers.

## 🧠 Approach: Kadane's Algorithm

### Core Idea
The key insight is that at any position, we have two choices:
1. **Extend** the existing subarray by including the current element
2. **Start fresh** with a new subarray from the current element

We choose the option that gives us the maximum sum.

### Algorithm Steps
1. Initialize `max_sum` with the first element (handles all negative arrays)
2. Initialize `current_sum` with the first element
3. For each element from index 1 to n-1:
   - Update `current_sum = max(element, current_sum + element)`
   - Update `max_sum = max(max_sum, current_sum)`
4. Return `max_sum`

### Why It Works
- **Local Decision**: At each step, we make the optimal local choice
- **Global Optimum**: The local optimal choices lead to the global optimum
- **Dynamic Programming**: We're building the solution based on previous results

### Key Insight
`current_sum = max(arr[i], current_sum + arr[i])`
- If `current_sum + arr[i] < arr[i]`, it means the previous subarray is dragging us down
- Better to start fresh with just `arr[i]`
- Otherwise, extend the existing subarray

## 📊 Complexity Analysis
- **Time Complexity**: O(n) - Single pass through the array
- **Space Complexity**: O(1) - Only using constant extra space

## 🎨 Example Walkthrough
```
Array: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Step by step:

i=0: current_sum = -2, max_sum = -2
i=1: current_sum = max(1, -2+1) = 1, max_sum = max(-2, 1) = 1
i=2: current_sum = max(-3, 1-3) = -2, max_sum = max(1, -2) = 1
i=3: current_sum = max(4, -2+4) = 4, max_sum = max(1, 4) = 4
i=4: current_sum = max(-1, 4-1) = 3, max_sum = max(4, 3) = 4
i=5: current_sum = max(2, 3+2) = 5, max_sum = max(4, 5) = 5
i=6: current_sum = max(1, 5+1) = 6, max_sum = max(5, 6) = 6
i=7: current_sum = max(-5, 6-5) = 1, max_sum = max(6, 1) = 6
i=8: current_sum = max(4, 1+4) = 5, max_sum = max(6, 5) = 6

Result: 6 (subarray [4, -1, 2, 1])
```

## 🔍 Edge Cases Handled
1. **All negative numbers**: Returns the least negative number
2. **All positive numbers**: Returns the sum of all elements
3. **Single element**: Returns that element
4. **Empty array**: Usually handled by input validation

## 🌟 Alternative Approaches
1. **Brute Force**: O(n³) - Check all possible subarrays
2. **Improved Brute Force**: O(n²) - Optimize inner loop
3. **Divide and Conquer**: O(n log n) - Recursive approach
4. **Kadane's Algorithm**: O(n) - Optimal solution ✅

## 🏆 Why Kadane's Algorithm is Optimal
- **Linear time complexity**: Can't do better than O(n) since we need to look at each element
- **Constant space**: No additional data structures needed
- **Simple and elegant**: Easy to understand and implement
- **Handles all edge cases**: Robust solution

This is the gold standard solution for the Maximum Subarray Sum problem!
