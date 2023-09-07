package JavaSE.Hexin;

import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入需要打印的行数:");
        int n = input.nextInt();

        // 圣诞树最高层
//        for (int i = 1; i <= n - 2; i++) {
//            // 输出空格,个数为（n-i）
//            for (int j = 1; j <= n - i; j++) {
//                System.out.print(" ");
//            }
//            // 输出图形的形状，个数为（2*i-1）
//            for (int k = 1; k <= 2 * i - 1; k++) {
//                System.out.print("*");
//            }
//            System.out.println(); // 换行
//        }

//        // 圣诞树中间层
//        for (int i = 1; i <= n - 1; i++) {
//            for (int j = 1; j <= n - i; j++) {
//                System.out.print(" ");
//            }
//            for (int k = 1; k <= 2 * i - 1; k++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //树干，树干的位置与第一颗星的位置一样，即：n-1
        for (int i = 1; i <= 2; i++) {
            // 输出空格,个数为n-i
            for (int j = 1; j <= n - 1; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }

    }
}
