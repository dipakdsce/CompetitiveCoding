package com.CodeChef.OctoberLongChallenge;

import java.util.Arrays;
import java.util.Scanner;

public class DIGITREM {

    public static int findMin(int n, int d) {
        int temp = n;
        int count = 0;
        int c = 0;
        int rem;
        while(temp > 0) {
            rem = temp%10;
            temp = temp/10;
            c++;
            if(rem == d) {
                temp =(int) (temp*Math.pow(10, c) + (rem+1)*Math.pow(10, c-1));
                count = temp - n;
                c = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            char[] number = String.valueOf(n).toCharArray();
            String resultString = "";
            int length = number.length;
            if (d == 0) {
                int j =0;
                for (j = 0; j < length; j++) {
                    if (number[j] == '0') {
                        number[j] = '1';
                        break;
                    }
                }
                for (int k = j + 1; k < length; k++) {
                    number[k] = '1';
                }
                resultString = String.valueOf(number);
            } else if (d == 9) {
                if (number[0] == '9') {
                    for (int j = 0; j < length; j++) {
                        number[j] = '0';
                    }
                    resultString = "1" + String.valueOf(number);
                } else {
                    int j = 0;
                    for (j = 0; j < length; j++) {
                        if (number[j] == '9') {
                            for (int k = j - 1; k >= 0; k--) {
                                if (number[k] <= '7') {
                                    number[k]++;
                                    break;
                                } else {
                                    number[k] = '0';
                                }
                            }
                            break;
                        }
                    }
                    for (int k = j; k < length; k++) {
                        number[k] = '0';
                    }
                    if(number[0] == '0') {
                        resultString = "1" + String.valueOf(number);
                    } else {
                        resultString = String.valueOf(number);
                    }}
            } else {
                int j = 0;
                for(j=0; j<length; j++) {
                    if(number[j] - 48  == d) {
                        number[j]++;
                        break;
                    }
                }
                for(int k=j+1; k<length; k++) {
                    number[k] = '0';
                }
                resultString = String.valueOf(number);
            }
            int resultNumber = Integer.parseInt(resultString);
            System.out.println(resultNumber - n);
        }
    }
}
