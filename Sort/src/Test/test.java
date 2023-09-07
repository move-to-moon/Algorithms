package Test;

import java.util.HashMap;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int b;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int count = 0;
            int a = in.nextInt();
            if (a == 0){
                return;
            }

            if (a%3 == 0){
                a=a/3;
                for (int i =3;a >= 1;){
                     count = count + a;
                    a=a/i;
                }
                System.out.println(count);
            }

            else if (a%3 == 1){
                 b = (a-1)/3;
                for (int i =3;b >= 1;){
                    count = count + b;
                    b=b/i;
                }
                System.out.println(count+1);

            }
            else  {
                b=(a-2)/3;
                for (int i =3;b >= 1;){
                    count = count + b;
                    b=b/i;
                }
                System.out.println(count+1);

            }


        }
    }
}

