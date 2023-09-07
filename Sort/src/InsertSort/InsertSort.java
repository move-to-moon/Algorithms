package InsertSort;

import BubbleSort.BubbleSort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int arr[]={33,56,89,90,11,23,43,90};
        InsertSort bubbleSort = new InsertSort();
        bubbleSort.InsertSortUse(arr);
        System.out.println(Arrays.toString(arr));



    }

    public void InsertSortUse(int[] arr){
        int temp;
        for (int i =1;i<arr.length;i++){
            for (int j = i ; j>0 && arr[j]<arr[j-1];j--){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }



    public void InsertSort(int[] arr){

        for (int i =1;i<arr.length;i++) {

            int insertValue = arr[i];

            int preInsertValueIndex=i-1;

            while (preInsertValueIndex >= 0 && arr[preInsertValueIndex] > insertValue) {
               arr[preInsertValueIndex+1]=arr[preInsertValueIndex];
                preInsertValueIndex--;

            }
            arr[preInsertValueIndex+1]=insertValue;

            System.out.println("第" +i+"次排序：");
            System.out.println(Arrays.toString(arr));


        }

    }
}
