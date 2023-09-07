package JavaSE.excise;

public class lcp11 {


    public void is(String s1 ,String s2){
        int n = Math.min(s1.length(),s2.length());

        for(int i = 0 ;i < n ; i++){
            if(s1.charAt(i) > s2.charAt(i)) System.out.println("s1大"); 
        }

        System.out.println("s2大");


    }
}


