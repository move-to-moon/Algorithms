package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool1 = Executors.newFixedThreadPool(4);

        try {
            for (int i = 0; i < 10; i++) {
                threadPool1.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + "办理业务");
                    }
                });
            }
        }finally {
            threadPool1.shutdown();
        }


    }
}
