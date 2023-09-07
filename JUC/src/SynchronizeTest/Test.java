package SynchronizeTest;

public class Test {


        public static int getValue(int i) throws Exception {
            throw new Exception("try");

        }

        public static void main(String[] args) throws Exception {
            System.out.println(getValue(0));

        }

}
