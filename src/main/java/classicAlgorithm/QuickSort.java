package classicAlgorithm;

import java.util.HashMap;
import java.util.TreeMap;

public class QuickSort {

    public static void main(String[] args) {

        
        int[] nums = new int[] {1, 23, 4, 5, 5, 4, 3,2 ,2};

        new QuickSort().quickSort2(nums, 0, nums.length - 1);
        for (int n : nums) {
            System.out.println(n);
        }
    }

    private void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int tmp = arr[i];
            while (i < j) {
                while (i < j && arr[j] >= tmp) {
                    j --;
                }

                if (i < j) {
                    arr[i] = arr[j];
                    i ++;
                }

                while (i < j && arr[i] <= tmp) {
                    i ++;
                }

                if (i < j) {
                    arr[j] = arr[i];
                    j --;
                }
            }

            arr[i] = tmp;
            quickSort2(arr, left, i - 1);
            quickSort2(arr, i + 1, right);
        }
    }

//    private void quickSort(int[] arr, int left, int right) {
//
//        if (left < right) {
//
//            int tmp = arr[left];
//            int i = left;
//            int j = right;
//
//            while (i < j) {
//                while (i < j && arr[j] >= tmp) {
//                    j --;
//                }
//
//                if (i < j) {
//                    arr[i] = arr[j];
//                    i ++;
//                }
//
//                while (i < j && arr[i] <= tmp) {
//                    i ++;
//                }
//
//                if (i < j) {
//                    arr[j] = arr[i];
//                    j --;
//                }
//            }
//
//            arr[i] = tmp;
//            quickSort(arr, left, i - 1);
//            quickSort(arr, i + 1, right);
//
//        }
//    }


}

