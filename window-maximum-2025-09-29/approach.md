# 🚀 Smart Interviews - Window Maximum (Sliding Window Maximum)

## 📋 Problem Statement

Given an array of integers and a window size `k`, find the maximum element in each sliding window of size `k`.

**Example:**
- Input: `arr = [1, 3, -1, -3, 5, 3, 6, 7]`, `k = 3`
- Output: `[3, 3, 5, 5, 6, 7]`

**Windows:**
- `[1, 3, -1]` → max = 3
- `[3, -1, -3]` → max = 3  
- `[-1, -3, 5]` → max = 5
- `[-3, 5, 3]` → max = 5
- `[5, 3, 6]` → max = 6
- `[3, 6, 7]` → max = 7

---

## 🎯 Approach: Deque-Based Optimal Solution

### 💡 Key Insights

1. **Brute Force is Inefficient**: Checking every window by iterating through all elements gives O(n*k) complexity
2. **Deque Magic**: We can maintain potential maximums using a deque (double-ended queue)
3. **Smart Filtering**: Remove elements that can never be maximum in future windows

### 🔧 Algorithm Strategy

**Core Idea**: Use a deque to store **indices** (not values) of array elements in a way that:
- The front always contains the index of the maximum element in the current window
- Indices are maintained in **decreasing order of their corresponding values**

### 📊 Step-by-Step Process

For each element at index `i`:

1. **🧹 Clean Out-of-Window Elements**: Remove indices from front that are outside current window `[i-k+1, i]`

2. **⚡ Remove Smaller Elements**: Remove indices from rear whose values are ≤ current element
   - *Why?* If current element is larger, those smaller elements can never be maximum in any future window containing the current element

3. **➕ Add Current Index**: Add current index to the rear

4. **🎯 Extract Maximum**: If window is complete (`i ≥ k-1`), the front element gives us the maximum

---

## 🔍 Visual Example Walkthrough

**Array**: `[1, 3, -1, -3, 5, 3, 6, 7]`, **k = 3**

| Step | i | arr[i] | Action | Deque (indices) | Window | Max |
|------|---|--------|---------|-----------------|--------|-----|
| 1 | 0 | 1 | Add 0 | [0] | - | - |
| 2 | 1 | 3 | Remove 0 (3>1), Add 1 | [1] | - | - |
| 3 | 2 | -1 | Add 2 | [1,2] | [1,3,-1] | **3** |
| 4 | 3 | -3 | Add 3 | [1,2,3] | [3,-1,-3] | **3** |
| 5 | 4 | 5 | Remove out: 1, Remove smaller: 2,3, Add 4 | [4] | [-1,-3,5] | **5** |
| 6 | 5 | 3 | Add 5 | [4,5] | [-3,5,3] | **5** |
| 7 | 6 | 6 | Remove 5 (6>3), Add 6 | [4,6] | [5,3,6] | **6** |
| 8 | 7 | 7 | Remove 4 (out of window), Remove 6 (7>6), Add 7 | [7] | [3,6,7] | **7** |

**Result**: `[3, 3, 5, 5, 6, 7]` ✅

---

## ⚙️ Implementation Details

### 🏗️ Data Structures Used
- **Deque<Integer>**: `ArrayDeque()` for O(1) operations at both ends
- **ArrayList<Integer>**: To store results

### 🔄 Key Operations
- `deque.peekFirst()`: Get front element (current maximum index)
- `deque.pollFirst()`: Remove front element  
- `deque.peekLast()`: Get rear element
- `deque.pollLast()`: Remove rear element
- `deque.offerLast()`: Add to rear

### 🛡️ Edge Cases Handled
- Empty array
- k = 1 (each element is maximum of its own window)
- k = array length (entire array is one window)
- Array with duplicate elements
- Strictly increasing/decreasing arrays

---

## 📈 Complexity Analysis

### ⏰ Time Complexity: **O(n)**
- Each element is added to deque **exactly once**
- Each element is removed from deque **at most once**  
- Total operations = 2n = O(n)

### 💾 Space Complexity: **O(k)**
- Deque stores at most k indices at any time
- In worst case (strictly increasing sequence), deque grows to size k

---

## 🆚 Alternative Approaches Comparison

| Approach | Time | Space | Pros | Cons |
|----------|------|-------|------|------|
| **Brute Force** | O(n*k) | O(1) | Simple to understand | Too slow for large inputs |
| **Segment Tree** | O(n log k) | O(k) | Good for range queries | Overkill for this problem |
| **Deque (Optimal)** | O(n) | O(k) | Linear time, efficient | Requires understanding of deque |
| **Multiset/PriorityQueue** | O(n log k) | O(k) | Easy to implement | Extra log factor |

---

## 🎨 Why This Approach is Optimal

1. **No Redundant Work**: We never recalculate maximums for overlapping portions
2. **Smart Pruning**: Elements that can't be maximum are immediately discarded
3. **Perfect Data Structure**: Deque provides O(1) operations at both ends
4. **Linear Scan**: Each element is processed exactly once

---

## 🚦 Implementation Tips

1. **Store Indices, Not Values**: This helps in checking window boundaries
2. **Maintain Decreasing Order**: Always remove smaller elements from rear
3. **Check Window Boundaries**: Remove out-of-window elements from front
4. **Complete Window Check**: Only add to result when `i >= k-1`

---

## 🔧 Testing Strategy

The solution includes comprehensive test cases:
- **Standard case**: Mixed positive/negative numbers
- **Edge cases**: Single element, window size 1
- **Special patterns**: Increasing, decreasing sequences
- **Detailed tracing**: Step-by-step execution for learning

---

## 🌟 Key Takeaways

✅ **Deque is perfect for sliding window problems involving min/max**  
✅ **Storing indices instead of values provides more flexibility**  
✅ **Maintaining sorted order in deque eliminates need for repeated sorting**  
✅ **Each element enters and exits deque at most once → O(n) complexity**  
✅ **Understanding the "why" behind element removal is crucial**

This approach demonstrates the power of choosing the right data structure to transform a quadratic solution into a linear one! 🚀
