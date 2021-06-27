package com.leetCode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(isValidParentheses(input));
    }

    public static boolean isValidParentheses(String s) {
        Stack<Character> parentheses = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                parentheses.push(s.charAt(i));
            } else if(s.charAt(i) == ')') {
                if(parentheses.isEmpty() || parentheses.peek() != '(') {
                    return false;
                } else {
                    parentheses.pop();
                }
            } else if(s.charAt(i) == ']') {
                if(parentheses.isEmpty() || parentheses.peek() != '[') {
                    return false;
                } else {
                    parentheses.pop();
                }
            } else {
                if(parentheses.isEmpty() || parentheses.peek() != '{') {
                    return false;
                } else {
                    parentheses.pop();
                }
            }
        }
        return parentheses.isEmpty();
    }
}
