/*
 * Problem: Rectangular Area Under Histogram
 * Date: 2025-09-26
 * Platform: Smart Interviews
 * 
 * Problem Description:
 * Given an array of integers representing the histogram bar heights,
 * find the area of the largest rectangle that can be formed in the histogram.
 * 
 * Approach: Stack-based solution
 * - Use a stack to keep track of indices of histogram bars
 * - For each bar, if it's higher than the bar at stack top, push current index
 * - If current bar is lower, pop from stack and calculate area with popped bar as smallest
 * - The width is determined by current index and the index after the new stack top
 * 
 * Time Complexity: O(n) - each element is pushed and popped at most once
 * Space Complexity: O(n) - for the stack in worst case
 * 
 * Edge Cases:
 * 1. Empty array - return 0
 * 2. Single element - return that element's value
 * 3. All bars of same height - return height * number of bars
 * 4. Increasing sequence - process all at the end
 * 5. Decreasing sequence - each bar forms rectangle with width 1
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
    
    public static long largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int n = heights.length;
        
        for (int i = 0; i <= n; i++) {
            // Use 0 as height for the extra iteration to process remaining bars
            int currentHeight = (i == n) ? 0 : heights[i];
            
            // Pop from stack while current height is less than stack top height
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                
                // Calculate width: if stack is empty, width is i (entire span from start)
                // Otherwise, width is distance between current index and index after stack top
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                long area = (long) height * width;
                maxArea = Math.max(maxArea, area);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
}

/*
 * Example Walkthrough:
 * Input: [2, 1, 5, 6, 2, 3]
 * 
 * Step by step execution:
 * i=0: stack=[0], height=2
 * i=1: height=1 < heights[0]=2, pop 0, area = 2*1 = 2, stack=[1]
 * i=2: stack=[1,2], height=5
 * i=3: stack=[1,2,3], height=6
 * i=4: height=2 < heights[3]=6, pop 3, area = 6*1 = 6
 *       height=2 < heights[2]=5, pop 2, area = 5*2 = 10 (width from index 1+1 to 4-1)
 *       stack=[1,4]
 * i=5: stack=[1,4,5], height=3
 * i=6: height=0, process remaining bars
 *       pop 5, area = 3*1 = 3
 *       pop 4, area = 2*4 = 8 (width from index 1+1 to 6-1)
 *       pop 1, area = 1*6 = 6 (entire array width)
 * 
 * Maximum area = 10
 * 
 * Key Insights:
 * - Stack maintains indices in increasing order of heights
 * - When we find a smaller height, we know the rectangle with previous heights ends
 * - Width calculation is crucial: distance between current position and position after stack top
 * - Extra iteration with height 0 ensures all remaining bars are processed
 */
