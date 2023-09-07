package JavaSE.Hexin;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        int n = Integer.parseInt(tmp[0]);

        int m = Integer.parseInt(tmp[1]);

        int k = Integer.parseInt(tmp[2]);

        String s = br.readLine();





            for (int i = 1; i <= n; i++) {


                    for (int j = 1; j <= n - i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 1; j <= 2 * i - 1; j++) {
                        System.out.print("*");
                    }
                System.out.println();
            }

            //树干，树干的位置与第一颗星的位置一样，即：n-1
            for (int i = 1; i <= m; i++) {
                // 输出空格,个数为n-i
                for (int j = 1; j <= n - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                System.out.println();
            }





        }












}
