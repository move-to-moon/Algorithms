package SynchronizeTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int p = in.nextInt();
        int q = in.nextInt();
        int[] grade = new int[n];
        int i=0,count = 0 ;
        int pgrade = 100 ;

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            grade[i++] = in.nextInt();
        }
        //对分数进行排序
        Main main = new Main();
        main.QuickSort(grade,0,grade.length-1);
        //
        HashMap<Integer,Integer> map = new HashMap<>();
        for ( i = n-1 ;i > 0;i--){
            if(grade[i] == grade[i-1]) {
                map.put(i,pgrade);
            }else {
                map.put(i,pgrade);
                pgrade--;
            }
        }
        map.put(0,pgrade);


        for (i = 0 ;i < n ;i++){
            if ((map.get(i)*p+q*grade[i])/100 >= 60){
                count++;
            }
        }
        System.out.println(count);

    }

    public void QuickSort(int arr[],int lo,int hi){

        if (hi  <=lo) return;
        int DCISO = partition(arr,lo,hi);

        QuickSort(arr,lo,DCISO-1);
        QuickSort(arr,DCISO+1,hi);

    }


    public int partition(int arr[],int lo,int hi){
        int left=lo;
        int right=hi+1;
        int value = arr[lo];
        int temp;
        while (true){
            while (arr[++left] > value) {if (left ==hi) break;}
            while (arr[--right] < value) {if (right == lo) break;}
            if (left >= right) break;
            temp = arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
        arr[lo]=arr[right];
        arr[right]=value;
        return right;
    }


}