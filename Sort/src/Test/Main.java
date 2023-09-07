package Test;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();

            main.getMinCommonNum(a,b);
        }
    }

    public void getMinCommonNum(int a,int b){
        int num = a;
        for(int n = 1 ; num <= a*b ; n++,num = a*n ){
            if(num % b == 0){
                System.out.println(num);
                return;
            }
        }
    }










}
