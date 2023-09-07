package fanruan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fanruan2 {
    public static void main(String[] args) {
        fanruan2 d = new fanruan2();
        System.out.println(d.findLuckyNum(3));

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 找出第n个幸运数，返回字符串表示的数字
     * @param n int整型 第n个
     * @return string字符串
     */
    public String findLuckyNum (int n) {
        // write code here
        List<Integer> list = new ArrayList<>();

        int[] arr = {2,3,4,6,7,8,9,12,14,16,18};

       for(Integer s : arr){
           list.add(s);
       }

        for(int i = 0 ; i < arr.length ; i++){
            for (int j = i ;j <arr.length ;j++ ){
                if(arr[i] * arr[j] > 18) list.add(arr[i] * arr[j]);
            }
        }
        Collections.sort(list);


        return String.valueOf(list.get( n - 1));
    }
}
