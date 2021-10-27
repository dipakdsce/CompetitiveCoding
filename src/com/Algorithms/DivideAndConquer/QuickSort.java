package com.Algorithms.DivideAndConquer;

public class QuickSort {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int  i = -1;
        for(int j=low; j<=high;j++) {
            if(arr[j] < pivot) {
                i++;
                if(i!=j) {
                    swap(arr, i, j);
                }
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    public void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {20,40,10,30,90,70,80};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
