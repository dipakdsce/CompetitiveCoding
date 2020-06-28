package com.geeksforgeeks;


// { Driver Code Starts
//Initial Template for Java

import java.util.*;


// } Driver Code Ends
//User function Template for Java

// Geeks clas with functions insert and freq
// insert : to insert element into ArrayList
// freq : function to count frequency of element
class Geeks {
    // Function to insert element

    public  void insert(ArrayList<Character> clist, char c) {

        //add c to clist
        clist.add(c);
    }

    // Function to count frequency of element
    public void freq(ArrayList<Character> clist, char c) {
        HashMap<Character, Integer> freq = new HashMap();
        for(int i=0; i < clist.size(); i++) {
            Character c1 = clist.get(i);
            if (freq.containsKey(c1)) {
                int val = freq.get(c1);
                freq.put(c1, val + 1);
            } else {
                freq.put(c1, 1);
            }
        }
        if (freq.containsKey(c))
            System.out.println(freq.get(c));
        else
            System.out.println("Not Present");

    }
}


// { Driver Code Starts.

// Driver class with driver code
class ArrayListOperation {
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            // Declaring ArrayList
            ArrayList<Character> clist = new ArrayList<Character>();

            int q = sc.nextInt();

            // Looping for queries
            while (q-- > 0) {
                char ch = sc.next().charAt(0);
                Geeks obj = new Geeks();

                if (ch == 'i') {
                    char c = sc.next().charAt(0);
                    obj.insert(clist, c);
                }

                if (ch == 'f') {
                    char c = sc.next().charAt(0);
                    obj.freq(clist, c);
                }
            }
        }
    }
}  // } Driver Code Ends

