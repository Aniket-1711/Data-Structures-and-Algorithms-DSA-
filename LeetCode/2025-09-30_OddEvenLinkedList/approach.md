# Odd Even Linked List

## Problem Statement

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

## Examples

### Example 1:
**Input:** head = [1,2,3,4,5]
**Output:** [1,3,5,2,4]

### Example 2:
**Input:** head = [2,1,3,5,6,4,7]
**Output:** [2,3,6,7,1,5,4]

## Constraints

- The number of nodes in the linked list is in the range [0, 10^4]
- -10^6 <= Node.val <= 10^6

## Approach

### Algorithm: Two-Pointer Technique

This problem can be efficiently solved using a two-pointer approach that maintains separate chains for odd and even positioned nodes.

#### Key Insights:
1. **Separate Chains**: Maintain two separate linked lists - one for odd indices and one for even indices
2. **Preserve Order**: The relative order within each group must be maintained
3. **In-Place Rearrangement**: Rearrange pointers without creating new nodes
4. **Merge**: Connect the end of the odd list to the head of the even list

#### Step-by-Step Process:

1. **Initialize Pointers**:
   - `odd`: Points to the current odd-positioned node (starts at head)
   - `even`: Points to the current even-positioned node (starts at head.next)
   - `evenHead`: Saves the head of the even list to connect later

2. **Traverse and Separate**:
   - Iterate through the list
   - Connect odd nodes: `odd.next = odd.next.next`
   - Connect even nodes: `even.next = even.next.next`
   - Move pointers: `odd = odd.next` and `even = even.next`

3. **Merge Lists**:
   - After traversal, connect the last odd node to the head of even list
   - `odd.next = evenHead`

4. **Edge Cases**:
   - Empty list (head == null)
   - Single node (head.next == null)
   - Two nodes

### Complexity Analysis

**Time Complexity:** O(n)
- Single pass through the linked list
- Each node is visited exactly once
- Where n is the number of nodes in the list

**Space Complexity:** O(1)
- Only using a constant number of pointers
- No additional data structures required
- In-place rearrangement of the linked list

### Why This Approach Works

1. **Efficiency**: Single pass solution with constant extra space
2. **Order Preservation**: By following next.next pointers, we maintain the relative order within each group
3. **Clean Separation**: Keeping separate odd and even chains makes the logic simple and clear
4. **No Extra Memory**: Reuses existing nodes and only manipulates pointers
