/*
 * 3Sum Problem - Main Solution
 * 
 * PROBLEM STATEMENT:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * 
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * 
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 */

import java.util.*;

public class ThreeSum_Solution {
    
    /**
     * MAIN ACCEPTED SOLUTION - Two Pointer Approach
     * This is the optimal solution using sorting and two pointers
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case: if array has less than 3 elements
        if (nums.length < 3) {
            return result;
        }
        
        // Sort the array to use two pointer technique
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Need larger sum
                } else {
                    right--; // Need smaller sum
                }
            }
        }
        
        return result;
    }
    
    /**
     * EXPLANATION OF APPROACH:
     * 
     * 1. SORTING: We first sort the array to enable the two-pointer technique
     *    and make duplicate handling easier.
     * 
     * 2. OUTER LOOP: We iterate through each element as the first element of triplet.
     *    We skip duplicates to avoid duplicate triplets.
     * 
     * 3. TWO POINTERS: For each first element, we use two pointers (left and right)
     *    to find the other two elements that sum to -nums[i].
     * 
     * 4. DUPLICATE HANDLING: We skip duplicates at all three positions to ensure
     *    no duplicate triplets in the result.
     * 
     * 5. POINTER MOVEMENT: 
     *    - If sum == 0: Found triplet, add to result, move both pointers
     *    - If sum < 0: Need larger sum, move left pointer right
     *    - If sum > 0: Need smaller sum, move right pointer left
     */
    
    /**
     * EDGE CASES HANDLED:
     * 
     * 1. Array length < 3: Return empty list
     * 2. All positive numbers: No triplet can sum to 0
     * 3. All negative numbers: No triplet can sum to 0
     * 4. All zeros: Return [[0,0,0]]
     * 5. Duplicate elements: Properly handled to avoid duplicate triplets
     * 6. No valid triplets: Return empty list
     */
    
    /**
     * EXAMPLES HANDLED:
     * 
     * Example 1: [-1,0,1,2,-1,-4]
     * After sorting: [-4,-1,-1,0,1,2]
     * Triplets found: [-1,-1,2], [-1,0,1]
     * 
     * Example 2: [0,1,1]
     * After sorting: [0,1,1]
     * No triplets sum to 0
     * 
     * Example 3: [0,0,0]
     * After sorting: [0,0,0]
     * Triplet found: [0,0,0]
     */
    
    /**
     * TIME COMPLEXITY: O(n²)
     * - Sorting: O(n log n)
     * - Outer loop: O(n)
     * - Inner two pointers: O(n)
     * - Overall: O(n log n) + O(n²) = O(n²)
     * 
     * SPACE COMPLEXITY: O(1) or O(log n)
     * - O(1) if we don't count the output list
     * - O(log n) for the sorting algorithm (depending on implementation)
     * - The result list space is not counted in auxiliary space complexity
     */
    
    // Test method
    public static void main(String[] args) {
        ThreeSum_Solution solution = new ThreeSum_Solution();
        
        // Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test 1: " + solution.threeSum(nums1));
        
        // Test Case 2
        int[] nums2 = {0, 1, 1};
        System.out.println("Test 2: " + solution.threeSum(nums2));
        
        // Test Case 3
        int[] nums3 = {0, 0, 0};
        System.out.println("Test 3: " + solution.threeSum(nums3));
    }
}
