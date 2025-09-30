# Approach: Floyd's Cycle Detection Algorithm (Two-Pointer Technique)

## Problem
Detect if a linked list has a cycle and return the node where the cycle begins.

## Solution Strategy

### Phase 1: Detect if Cycle Exists
- Use two pointers: `slow` (moves 1 step) and `fast` (moves 2 steps)
- If there's a cycle, they will eventually meet
- If `fast` reaches null, there's no cycle

### Phase 2: Find Cycle Start Node
- Once slow and fast meet, keep one pointer (`p2`) at meeting point
- Place another pointer (`p1`) at the head
- Move both pointers one step at a time
- The node where they meet is the start of the cycle

## Why This Works
Mathematically, when slow and fast meet:
- Distance traveled by slow = x + y
- Distance traveled by fast = x + y + z + y (completes one cycle)
- Since fast moves twice as fast: 2(x + y) = x + 2y + z
- Solving: x = z

This means the distance from head to cycle start equals the distance from meeting point to cycle start.

## Complexity
- **Time Complexity**: O(n) - traverse list at most twice
- **Space Complexity**: O(1) - only using pointers

## Edge Cases Handled
- No cycle (fast reaches null)
- Single node with no cycle
- Entire list is a cycle
- Cycle starts at the head
