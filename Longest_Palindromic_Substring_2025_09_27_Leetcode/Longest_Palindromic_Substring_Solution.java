/*
 * LeetCode Problem 5: Longest Palindromic Substring
 * 
 * PROBLEM STATEMENT:
 * Given a string s, return the longest palindromic substring in s.
 * 
 * A palindrome is a string that reads the same forward and backward.
 * 
 * Examples:
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * 
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 * 
 * Constraints:
 * • 1 <= s.length <= 1000
 * • s consist of only digits and English letters.
 * 
 * APPROACH EXPLANATION:
 * This solution uses the "Expand Around Centers" approach:
 * 
 * 1. For each possible center position in the string, we expand outward
 *    to find the longest palindrome centered at that position.
 * 
 * 2. We consider two types of palindromes:
 *    - Odd length palindromes: center is a single character (i, i)
 *    - Even length palindromes: center is between two characters (i, i+1)
 * 
 * 3. For each center, we expand left and right while characters match
 *    and update our result if we find a longer palindrome.
 * 
 * ALGORITHM STEPS:
 * 1. Initialize variables to track start, end positions of longest palindrome
 * 2. For each index i from 0 to n-1:
 *    a. Find longest odd-length palindrome centered at i
 *    b. Find longest even-length palindrome centered between i and i+1
 *    c. Take the maximum of both lengths
 *    d. If this length is greater than current best, update start and end
 * 3. Return substring from start to end
 * 
 * EDGE CASES:
 * • Single character string: Returns the character itself
 * • All characters same: Returns the entire string
 * • No palindrome longer than 1: Returns any single character
 * • Empty string: Not possible due to constraints (1 <= s.length)
 * 
 * TIME COMPLEXITY: O(n²)
 * - We iterate through n possible centers
 * - For each center, we potentially expand up to n/2 positions
 * - Total: O(n * n) = O(n²)
 * 
 * SPACE COMPLEXITY: O(1)
 * - We only use a constant amount of extra space for variables
 * - The input string is not modified
 * 
 * ALTERNATIVE APPROACHES:
 * 1. Brute Force: O(n³) - check all substrings
 * 2. Dynamic Programming: O(n²) time, O(n²) space
 * 3. Manacher's Algorithm: O(n) time, O(n) space (most optimal)
 */
class Solution {
    public String longestPalindrome(String s) {
        int ans=0,start=0, end=0, len1=0,len2=0,len=0;
        for(int i=0;i<s.length();i++){
            len1 = gLL(s, i, i);
            len2= gLL(s, i, i+1);
            len=Math.max(len1, len2);
            if (len > end - start) {
  // found a longer palindrome
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);  
    }
    public int gLL(String str,int p1, int p2){
        while(p1>=0 && p2<str.length() && str.charAt(p1)==str.charAt(p2)){
            p1--;
            p2++;
        }
        return p2-p1-1;
    }
}
