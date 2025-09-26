/*
 * ===============================================================================
 * PROBLEM: Rectangular Area Under Histogram
 * DATE: 2025-09-26
 * PLATFORM: Smart Interviews
 * DIFFICULTY: Medium
 * ===============================================================================
 * 
 * PROBLEM DESCRIPTION:
 * Given an array of integers representing the histogram bar heights,
 * find the area of the largest rectangle that can be formed in the histogram.
 * 
 * INPUT FORMAT:
 * - First line contains n (number of bars)
 * - Second line contains n space-separated integers (heights of bars)
 * 
 * OUTPUT FORMAT:
 * - Single integer representing the maximum rectangular area
 * 
 * CONSTRAINTS:
 * - 1 ≤ n ≤ 10^5
 * - 0 ≤ height[i] ≤ 10^4
 * 
 * EXAMPLES:
 * Input: [2, 1, 5, 6, 2, 3]
 * Output: 10
 * Explanation: The largest rectangle can be formed with bars at indices 2,3 
 *              (heights 5,6) with minimum height 5 and width 2, giving area = 5*2 = 10
 * 
 * Input: [6, 2, 5, 4, 5, 1, 6]
 * Output: 12
 * Explanation: Rectangle from index 2 to 4 (heights 5,4,5) with min height 4 and width 3 = 12
 * 
 * ===============================================================================
 * ALGORITHM EXPLANATION:
 * ===============================================================================
 * 
 * APPROACH: Stack-Based Optimal Solution
 * 
 * KEY INSIGHT:
 * For each bar, we want to find the maximum area of rectangle where this bar
 * is the shortest (limiting height). This requires finding:
 * 1. How far can we extend to the LEFT (first smaller element on left)
 * 2. How far can we extend to the RIGHT (first smaller element on right)
 * 
 * ALGORITHM STEPS:
 * 1. Use a stack to maintain indices of bars in increasing order of heights
 * 2. For each bar:
 *    - If current bar is taller than stack top → push current index
 *    - If current bar is shorter → start calculating areas
 *      • Pop from stack and treat popped bar as the shortest in rectangle
 *      • Width = current_index - (new_stack_top_index + 1)
 *      • Area = height[popped_index] * width
 * 3. Add extra iteration with height 0 to process remaining bars
 * 
 * WHY THIS WORKS:
 * - Stack maintains increasing heights, so when we find a smaller bar,
 *   all taller bars in stack can't extend further right
 * - For each popped bar, the width is determined by:
 *   • Right boundary: current position (first smaller on right)
 *   • Left boundary: element after new stack top (first smaller on left)
 * 
 * TIME COMPLEXITY: O(n)
 * - Each element is pushed exactly once and popped at most once
 * - Total operations = 2n = O(n)
 * 
 * SPACE COMPLEXITY: O(n)
 * - Stack can contain all indices in worst case (strictly increasing sequence)
 * 
 * ===============================================================================
 * EDGE CASES HANDLED:
 * ===============================================================================
 * 
 * 1. EMPTY ARRAY: Return 0
 *    Input: []
 *    Output: 0
 * 
 * 2. SINGLE ELEMENT: Return that element's value
 *    Input: [5]
 *    Output: 5
 * 
 * 3. ALL BARS SAME HEIGHT: height * number_of_bars
 *    Input: [4, 4, 4, 4]
 *    Output: 16 (4 * 4)
 * 
 * 4. STRICTLY INCREASING: Each bar processed at end with full remaining width
 *    Input: [1, 2, 3, 4, 5]
 *    Output: 9 (height 3 with width 3: from index 0 to 2)
 * 
 * 5. STRICTLY DECREASING: Each bar forms rectangle with width 1
 *    Input: [5, 4, 3, 2, 1]
 *    Output: 5 (first bar with height 5 and width 1)
 * 
 * 6. ALL ZEROS: Return 0
 *    Input: [0, 0, 0]
 *    Output: 0
 * 
 * 7. MIXED WITH ZEROS: Zeros act as separators
 *    Input: [2, 3, 0, 4, 5]
 *    Output: 8 (bars 4,5 with min height 4 and width 2)
 * 
 * ===============================================================================
 * STEP-BY-STEP TRACE EXAMPLE:
 * ===============================================================================
 * 
 * Input: [2, 1, 5, 6, 2, 3]
 * 
 * Initial: stack = [], maxArea = 0
 * 
 * i=0: height=2, stack=[] → push(0) → stack=[0]
 * i=1: height=1 < heights[0]=2
 *      → pop(0), height=2, width=1-0=1, area=2*1=2, maxArea=2
 *      → push(1) → stack=[1]
 * i=2: height=5 > heights[1]=1 → push(2) → stack=[1,2]
 * i=3: height=6 > heights[2]=5 → push(3) → stack=[1,2,3]
 * i=4: height=2 < heights[3]=6
 *      → pop(3), height=6, width=4-(2+1)=1, area=6*1=6, maxArea=6
 *      → height=2 < heights[2]=5
 *      → pop(2), height=5, width=4-(1+1)=2, area=5*2=10, maxArea=10
 *      → push(4) → stack=[1,4]
 * i=5: height=3 > heights[4]=2 → push(5) → stack=[1,4,5]
 * i=6: height=0 (extra iteration)
 *      → pop(5), height=3, width=6-(4+1)=1, area=3*1=3
 *      → pop(4), height=2, width=6-(1+1)=4, area=2*4=8
 *      → pop(1), height=1, width=6-0=6, area=1*6=6
 * 
 * Final Result: maxArea = 10
 * 
 * ===============================================================================
 */

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        
        System.out.println(largestRectangleArea(heights));
        sc.close();
    }
    
    /**
     * Calculates the largest rectangular area in a histogram using stack-based approach
     * 
     * @param heights Array of integers representing bar heights
     * @return Maximum rectangular area possible
     */
    public static long largestRectangleArea(int[] heights) {
        // Handle edge case: empty array
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int n = heights.length;
        
        // Process each bar + one extra iteration with height 0
        for (int i = 0; i <= n; i++) {
            // Use 0 as height for the extra iteration to process remaining bars
            int currentHeight = (i == n) ? 0 : heights[i];
            
            // Pop from stack while current height is less than stack top height
            // This means we found the right boundary for rectangles with taller bars
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                
                // Calculate width for the rectangle with 'height' as the shortest bar
                // If stack is empty: width spans from start (0) to current position (i)
                // If stack not empty: width spans from (stack.peek() + 1) to (i - 1)
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                // Calculate area and update maximum
                long area = (long) height * width;
                maxArea = Math.max(maxArea, area);
            }
            
            // Push current index to maintain increasing order in stack
            stack.push(i);
        }
        
        return maxArea;
    }
}

/*
 * ===============================================================================
 * ALTERNATIVE APPROACHES CONSIDERED:
 * ===============================================================================
 * 
 * 1. BRUTE FORCE O(n³):
 *    - For each pair of indices, find minimum height and calculate area
 *    - Too slow for large inputs
 * 
 * 2. BRUTE FORCE OPTIMIZED O(n²):
 *    - For each starting index, extend right while tracking minimum height
 *    - Better but still too slow for competitive programming
 * 
 * 3. DIVIDE AND CONQUER O(n log n) average, O(n²) worst:
 *    - Find minimum element, recursively solve left and right parts
 *    - Consider rectangle spanning across minimum element
 *    - Complex implementation, worse average case than stack approach
 * 
 * 4. STACK-BASED O(n): ✓ CHOSEN
 *    - Optimal time and space complexity
 *    - Clean and intuitive implementation
 *    - Handles all edge cases naturally
 * 
 * ===============================================================================
 * COMMON MISTAKES TO AVOID:
 * ===============================================================================
 * 
 * 1. INTEGER OVERFLOW:
 *    - Use 'long' for area calculations since height can be 10⁴ and width can be 10⁵
 *    - Maximum area could be 10⁹, which exceeds int range
 * 
 * 2. WIDTH CALCULATION ERROR:
 *    - Incorrect: width = i - stack.peek()
 *    - Correct: width = i - stack.peek() - 1
 *    - The -1 is crucial because we want distance between boundaries
 * 
 * 3. FORGETTING EXTRA ITERATION:
 *    - Must process remaining elements in stack after main loop
 *    - Extra iteration with height=0 handles this elegantly
 * 
 * 4. EMPTY STACK HANDLING:
 *    - When stack is empty after pop, width extends from start (index 0)
 *    - Width = current_index, not current_index - (-1) - 1
 * 
 * ===============================================================================
 * TESTING STRATEGY:
 * ===============================================================================
 * 
 * Test with:
 * 1. Given examples: [2,1,5,6,2,3] → 10
 * 2. Edge cases: [], [5], [0,0,0]
 * 3. Patterns: increasing [1,2,3,4], decreasing [4,3,2,1]
 * 4. Same heights: [3,3,3,3]
 * 5. Large values: test integer overflow scenarios
 * 6. Mixed with zeros: [2,3,0,4,5]
 * 
 * ===============================================================================
 */
