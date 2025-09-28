/**
 * LeetCode Problem: Compute Decimal Representation
 * Difficulty: Easy
 * Contest: Weekly Contest 469
 * Date: September 28, 2025
 * 
 * Problem Description:
 * Given a positive integer n, express it as a sum of only base-10 components.
 * A base-10 component is the product of a single digit (1-9) and a non-negative power of 10.
 * Examples: 500, 30, 7 are base-10 components; 537, 102, 11 are not.
 * 
 * Example 1:
 * Input: n = 537
 * Output: [500, 30, 7]
 * 
 * Example 2:
 * Input: n = 102
 * Output: [100, 2]
 * 
 * Example 3:
 * Input: n = 6
 * Output: [6]
 * 
 * Constraints: 1 <= n <= 10^9
 * 
 * @author Aniket Gawande
 * @date 2025-09-28
 */

import java.util.*;

class Solution {
    /**
     * Main method to decompose a number into base-10 components
     * 
     * Approach: Extract each non-zero digit and multiply by its place value
     * 1. Use modulo 10 to get the rightmost digit
     * 2. If digit is non-zero, multiply by place value and add to result
     * 3. Divide number by 10 to move to next digit
     * 4. Update place value (multiply by 10)
     * 5. Reverse the result to get descending order
     * 
     * Time Complexity: O(log n) - where n is the input number
     * Space Complexity: O(log n) - for storing the result array
     * 
     * @param n The positive integer to decompose
     * @return Array of base-10 components in descending order
     */
    public int[] decimalRepresentation(int n) {
        ArrayList<Integer> ar = new ArrayList<>();
        int place = 1;  // Place value (1, 10, 100, 1000, ...)
        
        // Extract digits from right to left
        while (n > 0) {
            int num = n % 10;  // Get rightmost digit
            
            // Only add non-zero digits
            if (num != 0) {
                ar.add(num * place);  // Add digit * place value
            }
            
            n /= 10;      // Remove rightmost digit
            place *= 10;  // Move to next place value
        }
        
        // Reverse to get descending order (largest components first)
        Collections.reverse(ar);
        
        // Convert ArrayList to array
        int arr[] = new int[ar.size()];
        for (int i = 0; i < ar.size(); i++) {
            arr[i] = (int) ar.get(i);
        }
        
        return arr;
    }
    
    /**
     * Test method to demonstrate the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println("Test Case 1: n = 537");
        int[] result1 = solution.decimalRepresentation(537);
        System.out.println("Output: " + Arrays.toString(result1));
        System.out.println("Expected: [500, 30, 7]\n");
        
        System.out.println("Test Case 2: n = 102");
        int[] result2 = solution.decimalRepresentation(102);
        System.out.println("Output: " + Arrays.toString(result2));
        System.out.println("Expected: [100, 2]\n");
        
        System.out.println("Test Case 3: n = 6");
        int[] result3 = solution.decimalRepresentation(6);
        System.out.println("Output: " + Arrays.toString(result3));
        System.out.println("Expected: [6]\n");
    }
}
