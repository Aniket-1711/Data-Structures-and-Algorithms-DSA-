# 📚 Approach: Implement Stack Using Queues - LeetCode

## 🎯 Problem Understanding
- **Problem**: Implement a stack using only queue operations
- **Goal**: Create MyStack class with push, pop, top, and empty operations
- **Constraint**: Use only queue operations (offer, poll, peek, isEmpty)

## 💡 Solution Strategy

### 🌟 Optimal Approach: Single Deque (Most Efficient)
Using a single `ArrayDeque` in Java, which supports efficient operations at both ends:

**Key Insight**: Use deque as a stack by using `addLast()` for push and `removeLast()` for pop

### 📋 Algorithm Steps
1. **Push Operation**: Add element to the end of deque using `addLast()`
2. **Pop Operation**: Remove and return element from end using `removeLast()`
3. **Top Operation**: Return end element without removal using `peekLast()`
4. **Empty Operation**: Check if deque is empty using `isEmpty()`

## ⏱️ Time & Space Complexity
- **Time Complexity**: O(1) for all operations
- **Space Complexity**: O(n) where n is the number of elements

## 🎨 Why This Approach?
- ✅ Most efficient solution using deque's double-ended nature
- ✅ All operations are O(1)
- ✅ Clean and simple implementation
- ✅ Takes advantage of ArrayDeque's internal structure

## 🔧 Key Implementation Details
- Use `ArrayDeque<Integer>` for optimal performance
- `addLast()` and `removeLast()` provide stack-like LIFO behavior
- `peekLast()` for viewing top element without modification
- Proper handling of edge cases (empty stack)

## 🌐 Alternative Approaches
See the main code file for comparison with:
- Two queue approach (less efficient)
- Single queue with rotation approach
- Analysis of trade-offs between different methods
