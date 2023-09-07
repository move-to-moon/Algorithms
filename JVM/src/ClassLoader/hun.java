package ClassLoader;


import java.util.HashMap;
import java.util.Map;

//一个非空整数数组，
//        只有一个元素只出现一次以外，
//        其它每个元素均出现两次。
//        输出那个只出现了一次的数据。
//        示例 1: 输入: [3,3,2] 输出: 2 示例 2:
//        输入: [7,2,4,2,7] 输出: 4
public class hun {


    public static void main(String[] args) {
        int[] arr = {7,2,4,2,7};

        hun h = new hun();
        int isrepeat = h.isrepeat(arr);
        System.out.println(isrepeat);

    }



    public int isrepeat(int[] arr){
        Map<Integer ,Integer> map = new HashMap<>();

        for(int i = 0 ;i < arr.length ; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        int temp = 0;

        for(Integer s : map.keySet()){
            if(map.get(s) == 1) temp = s;
        }

        return  temp;



    }

}



