/*
 * Smart Interviews Problem: Changing Directories
 * 
 * Problem Description:
 * You are given a sequence of 'cd' (change directory) commands.
 * Starting from the root directory "/", simulate the execution of these commands
 * and print the final absolute path.
 * 
 * Commands:
 * - cd /path: changes to absolute path
 * - cd path: changes to relative path (relative to current directory)
 * - cd ..: goes up one directory level (parent directory)
 * - cd .: stays in current directory
 * 
 * APPROACH:
 * 1. Use a Stack to maintain the current directory path components
 * 2. Process each cd command:
 *    - If starts with '/', it's absolute path - clear stack and add components
 *    - If '..', pop from stack (go to parent)
 *    - If '.', do nothing (stay in current)
 *    - Otherwise, push to stack (go to subdirectory)
 * 3. Construct final path from stack components
 * 
 * Time Complexity: O(n) where n is total length of all commands
 * Space Complexity: O(d) where d is maximum directory depth
 */

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        
        // Stack to maintain current directory path components
        Stack<String> pathStack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            String command = br.readLine().trim();
            
            // Extract the path from "cd path" command
            String path = command.substring(3); // Remove "cd "
            
            processPath(pathStack, path);
        }
        
        // Build final absolute path
        String result = buildAbsolutePath(pathStack);
        System.out.println(result);
        
        br.close();
    }
    
    private static void processPath(Stack<String> pathStack, String path) {
        if (path.startsWith("/")) {
            // Absolute path - clear stack and process from root
            pathStack.clear();
            
            if (path.length() > 1) {
                // Split by '/' and process each component
                String[] components = path.substring(1).split("/");
                for (String component : components) {
                    if (!component.isEmpty()) {
                        processComponent(pathStack, component);
                    }
                }
            }
        } else {
            // Relative path - split by '/' and process each component
            String[] components = path.split("/");
            for (String component : components) {
                if (!component.isEmpty()) {
                    processComponent(pathStack, component);
                }
            }
        }
    }
    
    private static void processComponent(Stack<String> pathStack, String component) {
        if (component.equals("..")) {
            // Go to parent directory - pop if stack not empty
            if (!pathStack.isEmpty()) {
                pathStack.pop();
            }
        } else if (!component.equals(".")) {
            // Regular directory name - push to stack
            // (ignore "." as it means stay in current directory)
            pathStack.push(component);
        }
    }
    
    private static String buildAbsolutePath(Stack<String> pathStack) {
        if (pathStack.isEmpty()) {
            return "/";
        }
        
        StringBuilder result = new StringBuilder();
        for (String dir : pathStack) {
            result.append("/").append(dir);
        }
        
        return result.toString();
    }
}

/*
 * EXAMPLE EXECUTION:
 * Input:
 * 4
 * cd /home
 * cd user
 * cd ..
 * cd documents
 * 
 * Execution trace:
 * Initially: []
 * cd /home: ["home"]
 * cd user: ["home", "user"]
 * cd ..: ["home"]
 * cd documents: ["home", "documents"]
 * 
 * Final path: /home/documents
 * 
 * EDGE CASES HANDLED:
 * 1. Going to parent from root (ignored)
 * 2. Multiple consecutive slashes in path
 * 3. Paths ending with slash
 * 4. Empty directory names between slashes
 * 5. Mix of absolute and relative paths
 * 
 * COMPLEXITY ANALYSIS:
 * - Time: O(n) where n is sum of all command lengths
 * - Space: O(d) where d is maximum directory depth
 * 
 * This solution efficiently handles all edge cases and provides
 * optimal time complexity for the directory navigation problem.
 */
