package RadixSort;

import java.util.Arrays;

//用空间换时间的经典算法
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 3 ,748,14,214,542};
        RadixSort radixSort = new RadixSort();
        radixSort.RadixSort(arr);
        String s = Arrays.toString(arr);
        System.out.println(s);


    }


    public void RadixSort(int[] arr) {

        //定义一个二维数组,每个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];

        //查询需要遍历的次数
        int Max = arr[0];
        int count;
        for (int j = 0; j < arr.length; j++) {
            if (Max < arr[j]) Max = arr[j];
        }
        count = (Max + "").length();


        for (int x = 0; x < count; x++) {

            //定义一维数组来记录每个桶中的数量

            int[] bucketelement = new int[10];

            //对每个元素的个位进行处理
            for (int j = 0; j < arr.length; j++) {
                int i = arr[j] % 10;
                bucket[i][bucketelement[i]] = arr[j];
                bucketelement[i]++;

            }
            int index = 0;

            //遍历每一个桶,并将数据放回原数组
            for (int j = 0; j < bucket.length; j++) {
                if (bucketelement[j] != 0) {
                    for (int l = 0; l < bucketelement[j]; l++) {
                        arr[index++] = bucket[j][l];

                    }
                }
            }
        }

        }


}
