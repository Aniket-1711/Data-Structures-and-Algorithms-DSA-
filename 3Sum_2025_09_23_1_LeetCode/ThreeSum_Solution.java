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
