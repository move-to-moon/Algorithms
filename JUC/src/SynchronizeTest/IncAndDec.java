package SynchronizeTest;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IncAndDec {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ;i<40;i++){
                   share.Incr();
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"AA").start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ;i<40;i++){
                    share.Desc();
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"BB").start();
    }

}


class Share{
    private int number = 0 ;

     Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();



    public void Incr(){
        lock.lock();

        try {

            while (number != 0) {
                condition.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName()+"::"+number);
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void Desc(){
       lock.lock();
       try{
       while (number == 0){
           condition.await();
       }

       number--;
       System.out.println(Thread.currentThread().getName()+"::"+number);
       condition.signalAll();
    } catch (InterruptedException e) {
           e.printStackTrace();
       }finally {
           lock.unlock();
       }
       }
    }

class Solution {
    public String reverseString(char[] s) {
        char temp ;
        for (int i = 0 ;i < s.length/2 ; i++){
            temp = s[s.length -i -1];
            s[s.length -i -1] =s[i];
            s[i] = temp;
        }
        return String.valueOf(s);
    }


    public String reverseWords(String s) {

        StringBuffer stringBuffer = new StringBuffer();
        int i = s.indexOf(" ");
        if (i < 0) return reverseString(s.toCharArray());
        String substring = s.substring(0, i);
        while (i  > 0){

            String string = reverseString(substring.toCharArray());
            stringBuffer.append(string);
            int temp = i + 1;
            i = s.indexOf(" ",i+1);
            substring = s.substring(temp, i);
        }
        return String.valueOf(stringBuffer);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0 ;
        int right = 0 ;
        int count = 0;
        int size = 0;
        List list = new ArrayList();
        for(;right<nums.length;right++){
            count = count + nums[right];
            list.add(nums[right]);
            if (count == target) Math.max(size,list.size());
            while(count > target) {
                count = (int) (count - nums[left]);
                list.remove(0);
                left++;

            }
        }
        return size;
    }
}
