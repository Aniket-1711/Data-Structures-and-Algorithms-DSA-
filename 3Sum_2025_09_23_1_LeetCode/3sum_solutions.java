/*
 * 3Sum Problem - Multiple Solution Approaches
 * 
 * This file contains 5 different approaches to solve the 3Sum problem,
 * demonstrating various algorithmic techniques and their trade-offs.
 */
import java.util.*;
public class ThreeSumMultipleSolutions {
    
    /**
     * SOLUTION 1: BRUTE FORCE APPROACH
     * Time Complexity: O(n³)
     * Space Complexity: O(1) - excluding result list
     * 
     * This is the most straightforward approach using three nested loops.
     * Not recommended for large inputs due to cubic time complexity.
     */
    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        
        // Sort to handle duplicates easily
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        uniqueTriplets.add(triplet);
                    }
                }
            }
        }
        
        result.addAll(uniqueTriplets);
        return result;
    }
    
    /**
     * SOLUTION 2: TWO POINTER APPROACH (OPTIMAL)
     * Time Complexity: O(n²)
     * Space Complexity: O(1) - excluding result list
     * 
     * This is the most efficient approach for the general case.
     * Uses sorting + two pointers technique.
     */
    public List<List<Integer>> threeSumTwoPointers(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums.length < 3) return result;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
    
    // ... (continuing with remaining methods)
}
