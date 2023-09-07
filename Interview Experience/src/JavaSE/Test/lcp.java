package JavaSE.Test;



import org.omg.Messaging.SyncScopeHelper;

import java.util.*;

public class lcp {
    public static void main(String[] args) {
        int[] arr1 = {1,4,6,7,9};
        int[] arr2 = {3,5,7,9,10};
        lcp test1 = new lcp();
        int[] arr3 = test1.test(arr1,arr2);
       // System.out.println(Arrays.toString(arr3));
        String[] tokens = {"2","1","+","3","*"};
        int i = test1.evalRPN(tokens);
        System.out.println(i);


    }

    public int[] test(int[] arr1 ,int[] arr2){
        int [] temp = new int[arr1.length+arr2.length];
        int a = 0 ;
        int b = 0 ;
        for (int i = 0;i<temp.length;i++){
            if (a < arr1.length && b < arr2.length) {
                if (arr1[a] <= arr2[b]) {
                    temp[i] = arr1[a];
                    a++;
                } else {
                    temp[i] = arr2[b];
                    b++;
                }
            }
            else if(a >= arr1.length && b < arr2.length){
                temp[i] = arr2[b++];

            }
            else  {
                temp[i] = arr1[a++];
            }

        }
        return temp;
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length();i++){
            if(s.charAt(i) == '(') st.push(')');
            else if(s.charAt(i) == '{') st.push('}');
            else if(s.charAt(i) == '[') st.push(']');

            else if(st.isEmpty() || st.peek() !=s.charAt(i)) return false;

            else st.pop();
        }

        return st.isEmpty();

    }

    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();

        for(String s : tokens){
            if(s.matches("\\d+")) {
                st.push(s);
            }else {
                int num1 =Integer.parseInt(st.pop());
                int num2 =Integer.parseInt(st.pop());
                int res = 0 ;
                if(s.equals("+"))  res = num1 + num2 ;
                if(s.equals("-"))  res = num1 - num2 ;
                if(s.equals("*"))  res = num1 * num2 ;
                if(s.equals("/"))  res = num1 / num2 ;
                st.push(String.valueOf(res));
            }
        }

        return Integer.parseInt(st.pop());


    }



}

class MyStack2 {
    Deque<Integer> queue ;

    public MyStack2() {
        queue  = new ArrayDeque<>();

    }

    public void push(int x) {
        queue.addLast(x);

    }

    public int pop() {
     rever();
    return queue.pollFirst();


    }

    public int top() {


        return queue.peekLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public void rever(){
        if(empty()) return;
        for (int i = 0 ; i < queue.size() - 1;i++){
            queue.addLast(queue.pollFirst());
        }
    }
}

class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> st = new LinkedList<>();
         st.addLast(s.charAt(0));

        for(int i = 1 ;i < s.length();i++){
            if(st.isEmpty() || st.peekLast() != s.charAt(i)) st.addLast(s.charAt(i));
            else st.pollLast();
        }
        StringBuilder ss = new StringBuilder();
        while( !st.isEmpty()){
            ss.append(st.pollFirst());
        }

        return new String(ss);


    }
}

