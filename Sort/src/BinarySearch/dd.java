package BinarySearch;

public class dd {
    public static void main(String[] args) {
        System.out.println(1%7);
        int[] newnums = new int[2];
    }
}
class Solution {
    public int search(int[] nums, int target) {

        int low = 0 ;
        int high = nums.length -1;
        int mid,guess = 0 ;
        while (low <= high){
            mid = (low + high)/2 ;
            guess=nums[mid];

            if (guess == target) return mid;
            if (guess > target) low = mid +1;
            else high = mid -1 ;
        }
        return -1;
    }
}