package ThreadPool;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
          while (in.hasNextInt()) {
               list.add(in.nextInt());
          }
       int  k = list.size() - 1;
        int num1 = 0 ,num2 = 0;
        for(int i = 0 ;i < k-1 ;i++ ){
            for (int j = i+1; j<k-1 ;j++){
                if (list.get(i) + list.get(j) == list.get(k)){
                    num1 = i;
                    num2 = j;
                    break;
                }
            }
        }

        System.out.println(num1 + " " +num2);












    }

}
