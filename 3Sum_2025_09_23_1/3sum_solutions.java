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
    
    /**
     * SOLUTION 3: HASHMAP APPROACH
     * Time Complexity: O(n²)
     * Space Complexity: O(n) - for the hashmap
     * 
     * Uses hashmap to find the third element for each pair.
     * Good when space is not a constraint and we want O(n²) time.
     */
    public List<List<Integer>> threeSumHashMap(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            Set<Integer> seen = new HashSet<>();
            
            for (int j = i + 1; j < nums.length; j++) {
                int complement = 0 - nums[i] - nums[j];
                
                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], complement, nums[j]);
                    Collections.sort(triplet);
                    uniqueTriplets.add(triplet);
                }
                
                seen.add(nums[j]);
            }
        }
        
        result.addAll(uniqueTriplets);
        return result;
    }
    
    /**
     * SOLUTION 4: NO SORT APPROACH WITH HASHMAP
     * Time Complexity: O(n²)
     * Space Complexity: O(n)
     * 
     * Avoids sorting by using hashmap to track elements and handle duplicates.
     * Useful when we cannot modify the original array.
     */
    public List<List<Integer>> threeSumNoSort(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (dups.add(nums[i])) {
                Set<Integer> seen = new HashSet<>();
                
                for (int j = i + 1; j < nums.length; j++) {
                    int complement = 0 - nums[i] - nums[j];
                    
                    if (seen.contains(complement)) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                    
                    seen.add(nums[j]);
                }
            }
        }
        
        return new ArrayList<>(result);
    }
    
    /**
     * SOLUTION 5: OPTIMIZED EARLY TERMINATION
     * Time Complexity: O(n²) - with early termination optimizations
     * Space Complexity: O(1) - excluding result list
     * 
     * Enhanced two-pointer approach with early termination conditions
     * for better average-case performance.
     */
    public List<List<Integer>> threeSumOptimized(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums.length < 3) return result;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Early termination: if smallest element is positive, no solution possible
            if (nums[i] > 0) break;
            
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Early termination: if current + two largest < 0, continue
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0) continue;
            
            // Early termination: if current + two smallest > 0, break
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
            
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
    
    /**
     * COMPLEXITY ANALYSIS SUMMARY:
     * 
     * 1. BRUTE FORCE:
     *    - Time: O(n³) - Three nested loops
     *    - Space: O(1) - Only using constant extra space
     *    - Use case: Very small arrays, educational purposes
     * 
     * 2. TWO POINTERS (OPTIMAL):
     *    - Time: O(n²) - One loop + two pointers
     *    - Space: O(1) - Only using constant extra space
     *    - Use case: General purpose, most efficient for space
     * 
     * 3. HASHMAP:
     *    - Time: O(n²) - Two nested loops with O(1) lookup
     *    - Space: O(n) - Hashmap for storing elements
     *    - Use case: When space is not a constraint
     * 
     * 4. NO SORT HASHMAP:
     *    - Time: O(n²) - Similar to hashmap but without sorting
     *    - Space: O(n) - Multiple hashmaps for tracking
     *    - Use case: When input array cannot be modified
     * 
     * 5. OPTIMIZED TWO POINTERS:
     *    - Time: O(n²) - With early termination for better average case
     *    - Space: O(1) - Constant extra space
     *    - Use case: When expecting many early termination scenarios
     */
    
    /**
     * PERFORMANCE COMPARISON:
     * 
     * For arrays with:
     * - Small size (n < 100): All approaches work fine
     * - Medium size (100 ≤ n ≤ 1000): Avoid brute force
     * - Large size (n > 1000): Use two pointers or optimized version
     * 
     * Memory constraints:
     * - Limited memory: Use two pointers approaches
     * - Plenty memory: Hashmap approaches for potential speed gains
     * 
     * Array modification constraints:
     * - Can modify: Use any sorting-based approach
     * - Cannot modify: Use no-sort hashmap approach
     */
    
    // Test method to compare all approaches
    public static void main(String[] args) {
        ThreeSumMultipleSolutions solutions = new ThreeSumMultipleSolutions();
        
        int[] testArray = {-1, 0, 1, 2, -1, -4};
        
        System.out.println("Input: " + Arrays.toString(testArray));
        System.out.println();
        
        System.out.println("1. Brute Force: " + solutions.threeSumBruteForce(testArray.clone()));
        System.out.println("2. Two Pointers: " + solutions.threeSumTwoPointers(testArray.clone()));
        System.out.println("3. HashMap: " + solutions.threeSumHashMap(testArray.clone()));
        System.out.println("4. No Sort: " + solutions.threeSumNoSort(testArray.clone()));
        System.out.println("5. Optimized: " + solutions.threeSumOptimized(testArray.clone()));
        
        // Performance testing with larger array
        System.out.println("\n=== Performance Test ===");
        int[] largeArray = generateTestArray(1000);
        
        long startTime, endTime;
        
        // Test Two Pointers (skip brute force for large arrays)
        startTime = System.nanoTime();
        solutions.threeSumTwoPointers(largeArray.clone());
        endTime = System.nanoTime();
        System.out.println("Two Pointers: " + (endTime - startTime) / 1_000_000.0 + " ms");
        
        // Test HashMap
        startTime = System.nanoTime();
        solutions.threeSumHashMap(largeArray.clone());
        endTime = System.nanoTime();
        System.out.println("HashMap: " + (endTime - startTime) / 1_000_000.0 + " ms");
        
        // Test Optimized
        startTime = System.nanoTime();
        solutions.threeSumOptimized(largeArray.clone());
        endTime = System.nanoTime();
        System.out.println("Optimized: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
    
    // Helper method to generate test array
    private static int[] generateTestArray(int size) {
        Random random = new Random(42); // Fixed seed for reproducibility
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(2000) - 1000; // Random integers between -1000 and 1000
        }
        return array;
    }
}
