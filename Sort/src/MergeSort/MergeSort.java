package MergeSort;

import java.util.Arrays;

public class MergeSort {

    private static int[] temp;

    public static void main(String[] args) {
        int arr[]={33,-1,56,89,90,11,23,43,90};
        MergeSort mergeSort = new MergeSort();
        temp = new int[arr.length];
        mergeSort.sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));


    }

    public void merge(int[] arr,int left,int mid,int right){
        int i = left;
        int j = mid+1;


        for (int k = left;k<=right;k++){
            temp[k]=arr[k];
        }
        for(int k = left;k<right;k++){
            if (i>mid) arr[k]=temp[j++];
            else if(j>right) arr[k]=temp[i++];
            else if(temp[j]>temp[i]) arr[k]=temp[i++];
            else arr[k]=temp[j++];
        }
    }

    public void sort(int[] arr,int left,int right){
        if (left >= right) return;
        int mid = left +(right - left)/2;
        sort(arr,left,mid);
        sort(arr,mid+1,right);
        merge(arr,left, mid,right);
    }
}
