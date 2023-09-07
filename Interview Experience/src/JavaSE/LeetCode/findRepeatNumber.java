package JavaSE.LeetCode;

import java.util.Arrays;

public class findRepeatNumber {

    /*在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
    请找出数组中任意一个重复的数字。

     示例 1：

     输入：
     [2, 3, 1, 0, 2, 5, 3]
     输出：2 或 3
     */
    public static void main(String[] args) {
        findRepeatNumber findRepeatNumber = new findRepeatNumber();
//        int nums[] = {2, 3, 1, 0, 2, 5, 3};
//        int repeatNumber = findRepeatNumber.findRepeatNumber(nums);
//        System.out.println(repeatNumber);

        int[][] matrix = {{1, 4, 7, 11, 15},
                          {2, 5, 8, 12, 19},
                          {3, 6, 9, 16, 22},
                          {10, 13, 14, 17, 24},
                          {18, 21, 23, 26, 30}
        };

        boolean numberIn2DArray = findRepeatNumber.findNumberIn2DArray2(matrix, 22);
        System.out.println(numberIn2DArray);
    }

    public int findRepeatNumber(int[] nums) {

        Arrays.sort(nums);

        for (int i= 0 ;i<nums.length;i++){
            if (nums[i] == nums[i+1]) return nums[i];
        }
        return 0;



    }

    /*
    在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


    示例:
    现有矩阵 matrix 如下：


            [1,   4,  7, 11, 15],
            [2,   5,  8, 12, 19],
            [3,   6,  9, 16, 22],
            [10, 13, 14, 17, 24],
            [18, 21, 23, 26, 30]


*/


    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        for (int i = 0 ;i<matrix.length;i++){
            for(int j = 0; j<matrix[i].length;j++){
                if (target == matrix[i][j]) return true;
            }

        }

        return false;

    }

//利用好每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        //从左下角开始遍历
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;//消去matrix所在的行
            else if(matrix[i][j] < target) j++;//消去martix所在的列
            else return true;
        }
        return false;
    }


}
