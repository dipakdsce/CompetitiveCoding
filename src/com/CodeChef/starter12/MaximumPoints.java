package com.CodeChef.starter12;

import java.util.Scanner;

public class MaximumPoints {
    public static int maximumPoint(int a, int b, int c, int x, int y, int z) {
        int maxPoints = 0;
        int totalMinutes = 240;
        if(x>=y && x>=z) {
            if(a*20 < totalMinutes) {
                maxPoints += 20*x;
                totalMinutes -= a*20;
                if(totalMinutes >= b || totalMinutes >=c) {
                    if(y >= z && totalMinutes >= b ) {
                        if(totalMinutes >= b*20) {
                            maxPoints += 20*y;
                            totalMinutes -= 20*b;
                            if(totalMinutes >= c) {
                                maxPoints += (totalMinutes/c)*z;
                            }
                        } else {
                            maxPoints += (totalMinutes/b)*y;
                        }
                    } else {
                        if(totalMinutes >= c*20) {
                            maxPoints += 20*z;
                            totalMinutes -= c*20;
                            if(totalMinutes >= b) {
                                maxPoints += (totalMinutes/b)*y;
                            }
                        } else {
                            maxPoints += (totalMinutes/c)*z;
                        }
                    }
                }
            } else {
                maxPoints += (totalMinutes/a)*x;
            }
        } else if (y>=x && y>=z) {
            if(b*20 < totalMinutes) {
                maxPoints += 20*y;
                totalMinutes -= b*20;
                if(totalMinutes >= a || totalMinutes >=c) {
                    if (x >= z && totalMinutes >= b) {
                        if (totalMinutes >= a * 20) {
                            maxPoints += 20 * x;
                            totalMinutes -= 20 * a;
                            if (totalMinutes >= c) {
                                maxPoints += (totalMinutes / c) * z;
                            }
                        } else {
                            maxPoints += (totalMinutes / a) * x;
                        }
                    } else {
                        if (totalMinutes >= c * 20) {
                            maxPoints += 20 * z;
                            totalMinutes -= c * 20;
                            if (totalMinutes >= a) {
                                maxPoints += (totalMinutes / a) * x;
                            }
                        } else {
                            maxPoints += (totalMinutes / c) * z;
                        }
                    }
                }
            } else {
                maxPoints += (totalMinutes/b)*y;
            }
        } else {
            if(c*20 < totalMinutes) {
                maxPoints += 20*z;
                totalMinutes -= c*20;
                if(totalMinutes >= a || totalMinutes >=b) {
                    if(y >= x && totalMinutes >= b ) {
                        if(totalMinutes >= b*20) {
                            maxPoints += 20*y;
                            totalMinutes -= 20*b;
                            if(totalMinutes >= a) {
                                maxPoints += (totalMinutes/a)*x;
                            }
                        } else {
                            maxPoints += (totalMinutes/b)*y;
                        }
                    } else {
                        if(totalMinutes >= a*20) {
                            maxPoints += 20*x;
                            totalMinutes -= a*20;
                            if(totalMinutes >= b) {
                                maxPoints += (totalMinutes/b)*y;
                            }
                        } else {
                            maxPoints += (totalMinutes/a)*x;
                        }
                    }
                }
            } else {
                maxPoints += (totalMinutes/c)*z;
            }
        }
        return maxPoints;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            System.out.println(maximumPoint(a, b, c, x, y, z));
        }
    }
}
