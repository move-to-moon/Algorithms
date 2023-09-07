package SelectSort;

import java.util.Arrays;

//时间复杂度为：O(n^2)
public class SelectSort {
    public static void main(String[] args) {
        int arr[]={33,-1,56,89,90,11,23,43,90};
        SelectSort selectSort = new SelectSort();
        selectSort.SelectSort(arr);
        System.out.println(Arrays.toString(arr));


        System.out.println();

    }

    //自己写的
    public void SelectSort(int[] arr) {
        int minIndex = 0;
        int temp;
        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[minIndex] > arr[j]) {
                    flag = true;
                    minIndex = j;
                }
            }
            if (flag = true) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                flag = false;
            }
            System.out.println("第" +(i+1)+"次排序：");
            System.out.println(Arrays.toString(arr));

        }
    }
    //韩老师写的
    public void SelectSortT(int[] arr) {
        for (int i = 0 ;i<arr.length-1;i++){
            int minIndex=i;
            int min=arr[i];
            for (int j =i+1;j<arr.length;j++){
                if (min > arr[j]){
                    min = arr[j];
                    minIndex=j;
                }
            }

            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i]=min;
            }
            System.out.println("第" +(i+1)+"次排序：");
            System.out.println(Arrays.toString(arr));

        }
    }

}
