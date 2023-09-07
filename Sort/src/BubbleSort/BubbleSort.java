package BubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[]={33,56,89,90,11,23,43,90};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.BubbleSort(arr);
        System.out.println(Arrays.toString(arr));



    }


    //进行一个优化，增加一个标志flag
    //时间复杂度为O(n^2)
    public void BubbleSort(int[] arr){
        int temp;
        boolean flag = false;
        for (int i = 0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    flag = true;
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;

                }
            }

            if(!flag){
                break;
            }else {
                flag=false;
            }


        }

    }
}
