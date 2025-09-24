/*
=================================================================================
                    📚 BALANCED PARENTHESIS - STACK SOLUTION 📚
=================================================================================

🎯 PROBLEM: Valid Parentheses (LeetCode)
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

📝 APPROACH: Stack-based Solution
• Use a stack to keep track of opening brackets
• For each opening bracket, push it onto the stack
• For each closing bracket, check if it matches the top of the stack
• If stack is empty at the end, parentheses are balanced

⏰ TIME COMPLEXITY: O(n) - Single pass through the string
💾 SPACE COMPLEXITY: O(n) - Stack can store at most n/2 opening brackets

✅ EDGE CASES HANDLED:
• Empty string (valid)
• Single character (invalid unless empty)
• Mismatched brackets
• Extra opening/closing brackets
• Wrong order of brackets

=================================================================================
*/

import java.util.*;

class Solution {
    
    /**
     * 🔧 MAIN SOLUTION: Check if parentheses are balanced using stack
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
            // 🚫 Invalid character (if problem allows only brackets)
            // Note: Remove this else block if other characters are allowed
        }
        
        // ✅ Valid if no unmatched opening brackets remain
        return stack.isEmpty();
    }
    
    /**
     * 🔗 HELPER METHOD: Check if opening and closing brackets match
     * 
     * @param opening Opening bracket character
     * @param closing Closing bracket character
     * @return true if they form a valid pair
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
                            📖 EXAMPLE WALKTHROUGH 📖
=================================================================================

🎯 Example 1: s = "({[]})"

Step-by-step execution:
1. '(' → Push to stack: ['(']
2. '{' → Push to stack: ['(', '{']
3. '[' → Push to stack: ['(', '{', '[']
4. ']' → Pop '[', matches ✅ → Stack: ['(', '{']
5. '}' → Pop '{', matches ✅ → Stack: ['(']
6. ')' → Pop '(', matches ✅ → Stack: []

Result: Stack is empty → Return true ✅

🎯 Example 2: s = "([)]"

Step-by-step execution:
1. '(' → Push to stack: ['(']
2. '[' → Push to stack: ['(', '[']
3. ')' → Pop '[', doesn't match ❌

Result: Return false ❌

=================================================================================
                              🧪 TEST CASES 🧪
=================================================================================

public class TestBalancedParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // ✅ Valid cases
        System.out.println(solution.isValid(""));           // true
        System.out.println(solution.isValid("()"));         // true
        System.out.println(solution.isValid("()[]{}"));     // true
        System.out.println(solution.isValid("({[]})"));     // true
        
        // ❌ Invalid cases
        System.out.println(solution.isValid("("));          // false
        System.out.println(solution.isValid("())"));        // false
        System.out.println(solution.isValid("([)]"));       // false
        System.out.println(solution.isValid("){}"));        // false
    }
}

=================================================================================
                          🚀 OPTIMIZATION NOTES 🚀
=================================================================================

💡 ALTERNATIVE IMPLEMENTATION using HashMap for cleaner matching:

Map<Character, Character> pairs = Map.of(
    ')', '(',
    '}', '{',
    ']', '['
);

// In the main loop:
if (pairs.containsKey(c)) {
    if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
        return false;
    }
} else {
    stack.push(c);
}

📈 PERFORMANCE INSIGHTS:
• Single pass algorithm - optimal time complexity
• Stack operations are O(1)
• Memory usage is proportional to nesting depth
• Early termination on mismatch improves average case

=================================================================================
                               🎓 KEY LEARNINGS 🎓
=================================================================================

1. 📚 Stack is perfect for nested structure problems
2. 🔄 Always handle edge cases (empty input, single character)
3. 🎯 Early termination can improve performance
4. 🧹 Clean helper methods improve code readability
5. ✅ Comprehensive test cases ensure correctness

=================================================================================
*/
