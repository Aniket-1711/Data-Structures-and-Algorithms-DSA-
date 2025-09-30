# Intersection of Two Linked Lists - LeetCode

## Problem Statement
Given the heads of two singly linked lists `headA` and `headB`, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

## Approach: Length Difference Method

### Algorithm
1. **Calculate lengths of both lists**
   - Traverse both linked lists completely to find their lengths
   - Store length1 for list A and length2 for list B

2. **Align the starting points**
   - Calculate the difference between the two lengths: `diff = |len1 - len2|`
   - Move the pointer of the longer list forward by `diff` nodes
   - This ensures both pointers are equidistant from the potential intersection point

3. **Traverse simultaneously to find intersection**
   - Move both pointers one step at a time
   - Compare the nodes (using reference equality `==`, not value equality)
   - If pointers point to the same node, that's the intersection point
   - If they reach null without matching, there's no intersection

### Key Insights
- The solution uses the fact that after aligning, both lists have the same distance to the intersection
- Uses reference equality (`a == b`) to check if nodes are the same, not just have the same value
- Handles edge cases: null lists, lists of different lengths, no intersection

### Complexity Analysis
- **Time Complexity**: O(m + n)
  - Where m and n are the lengths of the two linked lists
  - First pass: traverse both lists to get lengths - O(m) + O(n)
  - Second pass: align and find intersection - O(max(m,n))
  - Overall: O(m + n)

- **Space Complexity**: O(1)
  - Only uses a constant amount of extra space for pointers
  - No additional data structures used

### Submission Results
- **Status**: Accepted ✓
- **Test Cases Passed**: 40/40
- **Runtime**: 11 ms (beats 8.64% of Java submissions)
- **Memory**: 48.3 MB (beats 83.36% of Java submissions)

## Alternative Approaches

### 1. Two Pointer (Elegant Solution)
- Start two pointers at headA and headB
- When pointer reaches end, redirect to the other list's head
- They will meet at intersection after at most 2 passes
- Time: O(m+n), Space: O(1)

### 2. Hash Set
- Store all nodes of one list in a HashSet
- Traverse second list and check if any node exists in the set
- Time: O(m+n), Space: O(m) or O(n)

### 3. Stack-Based
- Push both lists onto stacks
- Pop from both until nodes differ
- Last common node is the intersection
- Time: O(m+n), Space: O(m+n)
