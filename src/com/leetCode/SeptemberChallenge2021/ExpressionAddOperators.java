package com.leetCode.SeptemberChallenge2021;

import java.util.ArrayList;
import java.util.List;

/*
Given a string num that contains only digits and an integer target, return all possibilities to add the binary operators '+', '-', or '*' between the digits of num so that the resultant expression evaluates to the target value.



Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0*0","0+0","0-0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []


Constraints:

1 <= num.length <= 10
num consists of only digits.
-231 <= target <= 231 - 1
 */
public class ExpressionAddOperators {
    public static void getExpressionUtil(List<String> res, String curExp, String input, int target, int pos, int curVal, int last) {
        if(pos == input.length()) {
            if(curVal == target) {
                res.add(curExp);
            }
            return;
        }

        for(int i=pos; i<input.length(); i++) {
            if(i!=pos && input.charAt(pos) == '0') {
                break;
            }

            String part = input.substring(pos, i+1-pos);
            int cur = Integer.parseInt(part);
            if(pos == 0) {
                getExpressionUtil(res, curExp + part, input, target, i+1, cur, cur);
            } else {
                getExpressionUtil(res, (curExp + "+" + part), input, target, i+1, (curVal + cur), cur);
                getExpressionUtil(res, (curExp + "-" + part), input, target, i+1, (curVal - cur), -cur);
                getExpressionUtil(res, (curExp + "*" + part), input, target, i+1, (curVal - last + last * cur), last * cur);
            }
        }

    }

    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        getExpressionUtil(res, "", num, target, 0, 0, 0);
        return res;
    }

    public static void main(String[] args) {
        String num = "123";
        int target  = 6;
        List<String> results = addOperators(num, target);
        for(String str: results) {
            System.out.println(str);
        }
    }
}
