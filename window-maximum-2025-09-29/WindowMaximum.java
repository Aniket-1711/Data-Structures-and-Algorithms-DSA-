import java.util.*;

/*
 * ===================================================================
 *                    SMART INTERVIEWS - WINDOW MAXIMUM (SLIDING WINDOW MAXIMUM)
 * ===================================================================
 * Problem: Given an array of integers and a window size k, 
 *          find the maximum element in each sliding window of size k.
 *
 * Approach: Using Deque (Double-Ended Queue)
 * - The deque stores indices of array elements
 * - We maintain indices in decreasing order of their values
 * - The front of deque always contains index of maximum element in current window
 *
 * Time Complexity: O(n) - Each element is added and removed at most once
 * Space Complexity: O(k) - Deque can store at most k elements
 * ===================================================================
 */

public class WindowMaximum {
    
    /**
     * Main method to find maximum in each sliding window using Deque approach
     * 
     * @param arr The input array
     * @param k The window size
     * @return List of maximum elements for each window
     */
    public static List<Integer> slidingWindowMaximum(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case: if array is empty or k is invalid
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return result;
        }
        
        // Deque to store indices of array elements
        // Front of deque will always have index of maximum element in current window
        Deque<Integer> deque = new ArrayDeque<>();
        
        // Process each element of the array
        for (int i = 0; i < arr.length; i++) {
            
            // Step 1: Remove indices that are out of current window
            // If front element is outside the current window, remove it
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            
            // Step 2: Remove indices whose corresponding values are smaller than current element
            // We remove from rear because we want to maintain decreasing order
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            
            // Step 3: Add current element index to deque
            deque.offerLast(i);
            
            // Step 4: If we have processed at least k elements, 
            // the front of deque has the maximum of current window
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }
        
        return result;
    }
    
    /**
     * Alternative implementation with detailed step-by-step explanation
     */
    public static void slidingWindowMaximumDetailed(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            System.out.println("Invalid input");
            return;
        }
        
        Deque<Integer> deque = new ArrayDeque<>();
        System.out.println("Processing array: " + Arrays.toString(arr));
        System.out.println("Window size: " + k);
        System.out.println("\n--- Step by step execution ---");
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println("\nProcessing index " + i + " (value: " + arr[i] + ")");
            
            // Remove out of window indices
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                int removedIndex = deque.pollFirst();
                System.out.println("  Removed out-of-window index: " + removedIndex + " (value: " + arr[removedIndex] + ")");
            }
            
            // Remove smaller elements from rear
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                int removedIndex = deque.pollLast();
                System.out.println("  Removed smaller element index: " + removedIndex + " (value: " + arr[removedIndex] + ")");
            }
            
            // Add current index
            deque.offerLast(i);
            System.out.println("  Added current index: " + i + " (value: " + arr[i] + ")");
            System.out.println("  Current deque indices: " + deque);
            
            // If we have a complete window, add the maximum
            if (i >= k - 1) {
                int maxIndex = deque.peekFirst();
                System.out.println("  Window [" + (i-k+1) + ", " + i + "] maximum: " + arr[maxIndex]);
            }
        }
    }
    
    /**
     * Test method with various test cases
     */
    public static void main(String[] args) {
        System.out.println("=== SMART INTERVIEWS - WINDOW MAXIMUM SOLUTION ===");
        System.out.println("Using Deque (Double-Ended Queue) - Optimal O(n) Solution\n");
        
        // Test Case 1: Standard case
        int[] arr1 = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k1 = 3;
        System.out.println("Test Case 1:");
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Window size: " + k1);
        List<Integer> result1 = slidingWindowMaximum(arr1, k1);
        System.out.println("Result: " + result1);
        System.out.println();
        
        // Test Case 2: Decreasing array
        int[] arr2 = {5, 4, 3, 2, 1};
        int k2 = 3;
        System.out.println("Test Case 2 (Decreasing array):");
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Window size: " + k2);
        List<Integer> result2 = slidingWindowMaximum(arr2, k2);
        System.out.println("Result: " + result2);
        System.out.println();
        
        // Test Case 3: Increasing array
        int[] arr3 = {1, 2, 3, 4, 5};
        int k3 = 3;
        System.out.println("Test Case 3 (Increasing array):");
        System.out.println("Array: " + Arrays.toString(arr3));
        System.out.println("Window size: " + k3);
        List<Integer> result3 = slidingWindowMaximum(arr3, k3);
        System.out.println("Result: " + result3);
        System.out.println();
        
        // Test Case 4: Single element window
        int[] arr4 = {7, 2, 4, 6, 8};
        int k4 = 1;
        System.out.println("Test Case 4 (Window size 1):");
        System.out.println("Array: " + Arrays.toString(arr4));
        System.out.println("Window size: " + k4);
        List<Integer> result4 = slidingWindowMaximum(arr4, k4);
        System.out.println("Result: " + result4);
        System.out.println();
        
        // Detailed execution for understanding
        System.out.println("\n=== DETAILED STEP-BY-STEP EXECUTION ===");
        int[] detailedArr = {1, 3, -1, -3, 5, 3, 6, 7};
        int detailedK = 3;
        slidingWindowMaximumDetailed(detailedArr, detailedK);
    }
}

/*
 * ===================================================================
 *                           ALGORITHM EXPLANATION
 * ===================================================================
 * 
 * The Sliding Window Maximum problem can be solved optimally using a Deque.
 * 
 * KEY INSIGHTS:
 * 1. We need to efficiently find maximum in each sliding window
 * 2. Brute force O(n*k) is too slow for large inputs
 * 3. Deque helps us maintain a decreasing sequence of potential maximums
 * 
 * DEQUE OPERATIONS:
 * - We store INDICES (not values) in the deque
 * - Front always contains index of current window's maximum
 * - We maintain indices in decreasing order of their values
 * 
 * ALGORITHM STEPS:
 * For each element at index i:
 * 1. Remove indices that are outside current window (i-k+1 to i)
 * 2. Remove indices from rear whose values are ≤ current element
 * 3. Add current index to rear
 * 4. If window is complete (i ≥ k-1), front element is the maximum
 * 
 * WHY THIS WORKS:
 * - When we add a larger element, all smaller elements before it 
 *   can never be maximum in any future window containing the larger element
 * - So we remove them from deque to maintain decreasing order
 * - This ensures deque only contains potential maximums
 * 
 * EXAMPLE TRACE:
 * Array: [1, 3, -1, -3, 5, 3, 6, 7], k=3
 * 
 * i=0: arr[0]=1, deque=[0], window not complete
 * i=1: arr[1]=3, remove 0 (arr[0]=1 < arr[1]=3), deque=[1], window not complete
 * i=2: arr[2]=-1, deque=[1,2], window=[1,3,-1], max=arr[1]=3
 * i=3: arr[3]=-3, deque=[1,2,3], window=[3,-1,-3], max=arr[1]=3
 * i=4: arr[4]=5, remove out-of-window 1, remove smaller 2,3, deque=[4], window=[-1,-3,5], max=arr[4]=5
 * ... and so on
 * 
 * ===================================================================
 */
