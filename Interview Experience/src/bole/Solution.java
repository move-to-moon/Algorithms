package bole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param k int整型
     * @return int整型一维数组
     */
    public int[] heap_top_k (int[] nums, int k) {
        // write code here
     HeapSort(nums);
     int[]  res = new int[k] ;
     for(int i = 0 ; i < k ;i++){
         res[i] = nums[i];
     }
    return  res;
    }

    private static void HeapSort(int[] arr){
         int len = arr.length ;
         for (int i = len/2 - 1 ;i >=0 ;i--){
             heapify(arr,i,len);
         }
         for (int j =len -1;j > 0 ;j--){
             swap(arr,0,j);
             heapify(arr,0,j);
         }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp  = arr[i];
        arr[i] = arr[j];
        arr[j] = temp ;
    }

    private static void heapify(int[] arr, int i, int len) {
        int temp = arr[i] ;
        for(int k = i * 2 + 1 ;k < len ;k = k* 2 +1){
            if(k + 1 < len && arr[k] > arr[k+1]) k++;
            if (arr[k] < temp){
                arr[i] = arr[k];
                i = k ;
            }else {
                break;
            }
        }
        arr[i] = temp ;
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 输入s为一个长度为n的字符串，t是一个长度为m的字符串， 1<= s.length <= 10**9,  1 <= t.length <= 10**9。
     * @param s string字符串
     * @param t string字符串
     * @return int整型
     */
    public int MatchString (String s, String t) {
        // write code here
        int[] hash = new int[26];
        for (int i = 0 ;i < s.length();i++){
            hash[s.charAt(i) - 'a']++;
        }
        int count = 0 ;

        while (true) {

            for (int i = 0; i < t.length(); i++) {
                hash[t.charAt(i) - 'a']--;
            }
            int j = 0;
            for (; j < hash.length; j++) {
                if (hash[j] < 0) break;
            }
            if (j == 26) count++;
            else break;
        }

        return count ;

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 输入为一个长度为n的数组p，每个位置代表一个筐内有多少竹子，h为饲养员离开的时间，都是INT类型 ，1 <= n <= 10**4， n <= h <= 10**9, 1 <= p[i] <= 10**9
     * @param p int整型ArrayList 输入为一个长度为n的数组p，每个位置代表一个筐内有多少竹子
     * @param h int整型 饲养员离开的时间
     * @return int整型
     */
    public int EatingSpeed (ArrayList<Integer> p, int h) {
        // write code here
        int m = 4 ;
        int time = 0 ;
       while (true){
           time = 0 ;
           for (Integer integer : p) {
               time = time + integer / m + 1;
           }

           if (time <= h) break;
           else {
               m++;
           }


       }

       return m;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int i = s.MatchString("dogabcd", "dog");
//       // System.out.println(i);
//        int[] arr = {10, 6,10, 1, 8, 7, 5, 8, 9, 9, 8,3,2,5,4,2,0};
//        s.HeapSort(arr);
//        System.out.println(Arrays.toString(arr));
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(5);
//        list.add(7);
//        list.add(11);
//        list.add(17);
//        int i = s.EatingSpeed(list, 16);
//        System.out.println(i);

        

    }
}
