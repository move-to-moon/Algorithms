package QuickSort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[]={33,-1,56,89,90,11,23,43,90};
        //int arr[] ={8,9,1,7,2,3,5,4,6,0};
        QuickSort quickSort = new QuickSort();
        quickSort.QuickSort(arr,0,arr.length-1);
        //System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr
     * @param lo
     * @param hi
     */



    public void QuickSort(int arr[],int lo,int hi){

        if (hi  <=lo) return;
        int DCISO = partition(arr,lo,hi);
        System.out.println(Arrays.toString(arr));
        QuickSort(arr,lo,DCISO-1);//对左边进行排序
        QuickSort(arr,DCISO+1,hi);

    }


    public int partition(int arr[],int lo,int hi){
        int left=lo;
        int right=hi+1;
        int value = arr[lo];
        int temp;
        while (true){
            while (arr[++left] < value) {if (left ==hi) break;}
            while (arr[--right] > value) {if (right == lo) break;}
            if (left >= right) break;
            temp = arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
        arr[lo]=arr[right];
        arr[right]=value;
        return right; //对于返回的right可能不太好理解，可以画图自己试试
    }
}
