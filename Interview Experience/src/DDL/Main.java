package DDL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int array_rows = 0;
        int array_cols = 0;
        array_rows = in.nextInt();
        array_cols = in.nextInt();

        int[][] array = new int[array_rows ][array_cols ];
        for(int array_i=0; array_i<array_rows; array_i++) {
            for(int array_j=0; array_j<array_cols ; array_j++) {
                array[array_i][array_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }
        for(int i = 0 ; i < array.length ;i++){
            for(int j = 0 ; j < array[i].length ;j++){
                System.out.println(array[i][j]);
            }
        }


        //res = new Solution().pathSum(array);
        //System.out.println(String.valueOf(res));

    }
}
