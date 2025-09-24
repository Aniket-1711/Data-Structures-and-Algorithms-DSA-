/*
=================================================================================
           🎆 BALANCED PARENTHESES - ALL POSSIBLE SOLUTIONS 🎆
=================================================================================

🎯 PROBLEM: Valid Parentheses (LeetCode)
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

This file contains multiple approaches to solve the balanced parentheses problem:
1. 🐌 Brute Force Approach (Educational)
2. ⚡ Stack-based Approach (Optimal)

=================================================================================
                        🐌 SOLUTION 1: BRUTE FORCE APPROACH
=================================================================================

📈 CONCEPT: 
Recursively check all possible matching pairs by removing them from the string
until either the string becomes empty (valid) or no more pairs can be removed (invalid).

⏰ TIME COMPLEXITY: O(n^3) - Very inefficient for large inputs
• O(n^2) iterations to find and remove pairs
• O(n) for string operations in each iteration

💾 SPACE COMPLEXITY: O(n^2) - Due to string copying in recursion

⚠️ WARNING: This approach is NOT recommended for production use!
It's included here for educational purposes to understand the problem.

*/

import java.util.*;

class BruteForceValidParentheses {
    
    /**
     * 🐌 BRUTE FORCE SOLUTION: Recursively remove matching pairs
     * 
     * @param s Input string containing brackets
     * @return true if brackets are balanced, false otherwise
     */
    public boolean isValidBruteForce(String s) {
        // ✅ Base case: Empty string is valid
        if (s.isEmpty()) {
            return true;
        }
        
        // ❌ Base case: Odd length strings are always invalid
        if (s.length() % 2 == 1) {
            return false;
        }
        
        // 🔍 Look for adjacent matching pairs and remove them
        for (int i = 0; i < s.length() - 1; i++) {
            char current = s.charAt(i);
            char next = s.charAt(i + 1);
            
            // 🔗 Check if current and next characters form a valid pair
            if (isMatchingPair(current, next)) {
                // ✂️ Remove the matching pair and recursively check
                String remaining = s.substring(0, i) + s.substring(i + 2);
                return isValidBruteForce(remaining);
            }
        }
        
        // ❌ No valid pairs found, string is invalid
        return false;
    }
    
    /**
     * 🔗 HELPER: Check if two characters form a valid bracket pair
     */
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}

/*
=================================================================================
                      ⚡ SOLUTION 2: STACK-BASED APPROACH (OPTIMAL)
=================================================================================

📈 CONCEPT:
Use a stack to keep track of opening brackets. For each closing bracket,
check if it matches the most recent opening bracket (top of stack).

⏰ TIME COMPLEXITY: O(n) - Single pass through the string
💾 SPACE COMPLEXITY: O(n) - Stack can store at most n/2 opening brackets

✅ RECOMMENDED: This is the optimal solution!

*/

class OptimalValidParentheses {
    
    /**
     * ⚡ OPTIMAL SOLUTION: Stack-based validation
     * 
     * @param s Input string containing brackets
     * @return true if brackets are balanced, false otherwise
     */
    public boolean isValid(String s) {
        // 📊 Edge case: Empty string is valid
        if (s.isEmpty()) {
            return true;
        }
        
        // 🗃️ Stack to store opening brackets
        Stack<Character> stack = new Stack<>();
        
        // 🔄 Process each character in the string
        for (char c : s.toCharArray()) {
            
            // 📥 Push opening brackets onto stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // 📤 Process closing brackets
            else if (c == ')' || c == '}' || c == ']') {
                
                // ❌ No matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                
                // 🔍 Get the most recent opening bracket
                char top = stack.pop();
                
                // ✅ Check if brackets match
                if (!isMatchingPair(top, c)) {
                    return false;
                }
            }
        }
        
        // ✅ Valid if no unmatched opening brackets remain
        return stack.isEmpty();
    }
    
    /**
     * 🔗 HELPER METHOD: Check if opening and closing brackets match
     */
    private boolean isMatchingPair(char opening, char closing) {
        switch (opening) {
            case '(':
                return closing == ')';
            case '{':
                return closing == '}';
            case '[':
                return closing == ']';
            default:
                return false;
        }
    }
}

/*
=================================================================================
                   🌎 SOLUTION 3: ALTERNATIVE STACK IMPLEMENTATION
=================================================================================

Using HashMap for cleaner bracket matching logic.

*/

class AlternativeStackSolution {
    
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        
        // 🗺️ Map closing brackets to their opening counterparts
        Map<Character, Character> pairs = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // 📤 If it's a closing bracket
            if (pairs.containsKey(c)) {
                // ❌ No opening bracket available or mismatch
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            } else {
                // 📥 Push opening brackets
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}

/*
=================================================================================
                         📊 PERFORMANCE COMPARISON 📊
=================================================================================

🏁 APPROACH COMPARISON:

1. 🐌 BRUTE FORCE:
   • Time: O(n^3) - Very slow for large inputs
   • Space: O(n^2) - High memory usage due to string copying
   • Use case: Educational understanding only
   • Max recommended input: n < 20

2. ⚡ STACK-BASED (OPTIMAL):
   • Time: O(n) - Linear time, optimal
   • Space: O(n) - Proportional to nesting depth
   • Use case: Production code, interviews
   • Handles: Any reasonable input size

3. 🌎 ALTERNATIVE STACK:
   • Time: O(n) - Same as optimal
   • Space: O(n) - Same as optimal
   • Use case: Cleaner code, easier to extend
   • Benefit: More readable, easier to maintain

=================================================================================
                            🧪 COMPREHENSIVE TESTING 🧪
=================================================================================
*/

public class BalancedParenthesesTester {
    public static void main(String[] args) {
        // 🎯 Create instances of all solutions
        BruteForceValidParentheses bruteForce = new BruteForceValidParentheses();
        OptimalValidParentheses optimal = new OptimalValidParentheses();
        AlternativeStackSolution alternative = new AlternativeStackSolution();
        
        // 🧪 Test cases
        String[] testCases = {
            "",           // Empty string
            "()",         // Simple valid
            "()[]{}",     // Multiple types
            "({[]})",     // Nested valid
            "(",          // Single opening
            "())",        // Extra closing
            "([)]",       // Wrong order
            "){}"         // Starts with closing
        };
        
        boolean[] expected = {true, true, true, true, false, false, false, false};
        
        System.out.println("📊 TESTING ALL SOLUTIONS:");
        System.out.println("=".repeat(50));
        
        for (int i = 0; i < testCases.length; i++) {
            String test = testCases[i];
            boolean exp = expected[i];
            
            // ⚠️ Only test brute force on small inputs
            boolean bruteResult = test.length() <= 10 ? 
                bruteForce.isValidBruteForce(test) : exp; // Skip if too large
            
            boolean optimalResult = optimal.isValid(test);
            boolean altResult = alternative.isValid(test);
            
            // 📊 Results
            String status = (bruteResult == exp && optimalResult == exp && altResult == exp) ? 
                "✅ PASS" : "❌ FAIL";
            
            System.out.printf("Test: %-10s | Expected: %-5s | Brute: %-5s | Optimal: %-5s | Alt: %-5s | %s%n",
                "\"" + test + "\"", exp, bruteResult, optimalResult, altResult, status);
        }
        
        System.out.println("\n🎆 PERFORMANCE ANALYSIS:");
        System.out.println("For production use, always choose the Stack-based approach!");
        System.out.println("Brute force is included only for educational understanding.");
    }
}

/*
=================================================================================
                         🎓 KEY LEARNING POINTS 🎓
=================================================================================

1. 📚 ALGORITHMIC THINKING:
   • Sometimes the most obvious solution (brute force) is not efficient
   • Stack data structure naturally fits nested problems
   • Always consider time and space complexity

2. 🚀 OPTIMIZATION STRATEGIES:
   • Look for patterns that suggest specific data structures
   • Avoid string manipulation when possible (expensive)
   • Single pass algorithms are often optimal

3. 🧠 PROBLEM-SOLVING APPROACH:
   • Start with understanding the problem thoroughly
   • Consider multiple approaches
   • Analyze trade-offs between different solutions
   • Test edge cases comprehensively

4. 💼 REAL-WORLD APPLICATIONS:
   • Compiler syntax checking
   • Mathematical expression validation
   • HTML/XML tag matching
   • Code editor bracket highlighting

=================================================================================
                            🎯 INTERVIEW TIPS 🎯
=================================================================================

✅ DO:
• Mention that you know multiple approaches
• Start with the optimal stack solution
• Explain why stack is the right data structure
• Discuss time and space complexity
• Test with edge cases
• Consider extensions (different bracket types, etc.)

❌ DON'T:
• Jump straight to coding without explanation
• Forget to handle edge cases
• Use brute force as your first solution
• Ignore the interviewer's hints
• Skip complexity analysis

=================================================================================
*/
