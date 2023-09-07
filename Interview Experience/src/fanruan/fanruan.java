package fanruan;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class fanruan {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix int整型二维数组
     * @return int整型一维数组
     */
    public int[] isRectangleCover (int[][] matrix) {
        // write code here
        if(matrix[0].length == 0) return null;

        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int u = Integer.MIN_VALUE;
        int d = Integer.MAX_VALUE;

        Set<String> set = new HashSet<>();
        int[] arr = new int[2];
        int area = 0 ;
        for (int[] re : matrix){
            l = Math.min(re[0],l);
            r = Math.max(re[2],r);
            u = Math.max(re[3],u);
            d = Math.min(re[1],d);
            area = area + (re[2] - re[0]) *(re[3] - re[1]);
            String ld = re[0] +"_" + re[1];
            String lu = re[0] +"_" + re[3];
            String rd = re[2] +"_" + re[1];
            String ru = re[2] +"_" + re[3];
            if (!set.add(ld)){
                set.remove(ld);
            }
            if (!set.add(lu)){
                set.remove(lu);
            }
            if (!set.add(rd)){
                set.remove(rd);
            }
            if (!set.add(ru)){
                set.remove(ru);
            }
        }
        if (!set.contains(l + "_" +d)) arr[0] = -1 ;
        if(area == (r - l) * (u -d)) arr[0] = 1 ;
        else  arr[0] = -1;

        arr[1] = area ;
        return arr ;
    }
}
