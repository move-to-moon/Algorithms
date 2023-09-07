package SynchronizeTest;


import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ;i<40;i++){
                    ticket.sale();
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Therad 1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ;i<40;i++){
                    ticket.sale();
                }
            }
        },"Therad 2").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ;i<40;i++){
                    ticket.sale();
                }
            }
        },"Therad 3").start();
    }

}


class Ticket{
    private int number = 30;

   // private final ReentrantLock lock = new ReentrantLock();


    public   synchronized void sale(){
        if(number > 0){
            number--;
            System.out.println(Thread.currentThread().getName()+"卖出一张票,还剩"+number+"张票");
        }
    }
}















