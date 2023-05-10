package my.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/1/12 16:52
 * @description:
 */
public class VolatileTest {

    private static volatile int count = 0;

    private static boolean flag = false;

    public static void main(String[] args) {

        Thread thread1 = new Thread(()->{
            while (true) {
                System.out.println(flag);
            }
        });

        Thread thread2 = new Thread(()->{
            flag = true;
            System.out.println("-----------");
        });

        thread1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();

    }

    private static void extracted1() {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                count++;
            }
            System.out.println(count);
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                count++;
            }
            System.out.println(count);
        });
        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("==="+count);
    }
}
