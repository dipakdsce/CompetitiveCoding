package com.hackerearth;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
Problem
Alice is rearranging her library. She takes the innermost shelf and reverses the order of books. She breaks the walls of the shelf. In the end, there will be only books and no shelf walls. Print the order of books.

Opening and closing walls of shelves are shown by '/' and '\' respectively whereas books are represented by lower case alphabets.

Input format

The first line contains string  displaying her library.

Output format

Print only one string displaying Alice's library after rearrangement.

Constraints


Note

The first character of the string is '/' and the last character of the string is '\' indicating outermost walls of the shelf.

Sample Input
/u/love\i\
Sample Output
iloveu
Time Limit: 2
Memory Limit: 256
Source Limit:
Explanation
/u/love\i\

Here Katrina breaks the inner most shelf and reverse the order. So the library will be  /uevoli\ .

Now she breaks the outermost wall and reverses the order. So the library will be iloveu.
 */
public class AlicesLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(new StringBuilder(str).reverse());
        /*Stack<String> reverseString = new Stack<>();
        ArrayList<String> strings = new ArrayList<>();

        StringBuffer stringBuffer = new StringBuffer();
        boolean flag = false;
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) >= 97 && str.charAt(i) <=122) {
                stringBuffer.append(str.charAt(i));
            } else {
                if(flag) {
                    strings.add(stringBuffer.toString());
                    flag = false;
                } else {
                    reverseString.push(stringBuffer.toString());
                    flag = true;
                }
                stringBuffer.delete(0, stringBuffer.length());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder);
        for(String s : strings) {
            stringBuilder.append(new StringBuilder(reverseString.pop()).reverse()).append(s);
        }
        stringBuilder.append(new StringBuilder(reverseString.pop()).reverse());
        System.out.println(stringBuilder.toString());*/
    }
}
