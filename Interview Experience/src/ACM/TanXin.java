package ACM;

import java.util.Arrays;

public class TanXin {
    public static void main(String[] args) {

    }


    public int findContentChildren(int[] g, int[] s) {
        boolean[] useds = new boolean[s.length];
        boolean[] usedg = new boolean[g.length];
        Arrays.fill(useds,false);
        Arrays.fill(usedg,false);
        Arrays.sort(s);
        Arrays.sort(g);
        int i ,j=0  ;
        int result = 0 ;
        for(i = 0 ;i < g.length;i++){
            if (j < s.length && s[j] <= g[i]){
                result++;
                j++;
            }

        }



        return result;
    }
}
