# Sort List - LeetCode

## Problem Statement
Given the head of a linked list, return the list after sorting it in ascending order.

## Approach: Merge Sort (Divide and Conquer)

### Algorithm Overview
This solution uses the **Merge Sort** algorithm, which is optimal for sorting linked lists with O(n log n) time complexity.

### Key Steps:

1. **Base Case**: If the list is empty or has only one node, it's already sorted.

2. **Find Middle**: Use the slow-fast pointer technique to find the middle of the linked list.
   - Slow pointer moves one step at a time
   - Fast pointer moves two steps at a time
   - When fast reaches the end, slow will be at the middle

3. **Split**: Divide the linked list into two halves at the middle point.

4. **Recursive Sort**: Recursively sort both halves.

5. **Merge**: Merge the two sorted halves into a single sorted list.
   - Compare nodes from both halves
   - Attach the smaller node to the result
   - Continue until both halves are exhausted

### Why Merge Sort for Linked Lists?
- **No Extra Space for Array**: Unlike arrays, linked lists don't need O(n) extra space for merging
- **Efficient Splitting**: Finding middle and splitting is O(n)
- **Stable Sort**: Maintains relative order of equal elements
- **Optimal Time Complexity**: O(n log n) in all cases

## Complexity Analysis

### Time Complexity: O(n log n)
- Finding middle: O(n)
- Splitting into log n levels
- Merging at each level: O(n)
- Total: O(n) × O(log n) = O(n log n)

### Space Complexity: O(log n)
- Recursion stack depth: O(log n)
- No additional data structures needed

## Edge Cases Handled
1. Empty list (null head)
2. Single node list
3. Already sorted list
4. Reverse sorted list
5. List with duplicate values
