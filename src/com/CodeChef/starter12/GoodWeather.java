package com.CodeChef.starter12;

import java.util.Scanner;

/*

 */
public class GoodWeather {
    public static String isGoodWeather(int[] weathers) {
        int sunnyCount = 0;
        for(int i=0; i<7; i++) {
            if(weathers[i] == 1) {
                sunnyCount++;
            }
        }
        if(sunnyCount >= 4) {
            return "YES";
        } else {
            return "NO";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++) {
            int[] weathers = new int[7];
            for(int j=0; j<7; j++) {
                weathers[j] = scanner.nextInt();
            }
            System.out.println(isGoodWeather(weathers));
        }
    }
}
