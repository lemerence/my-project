package my.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/1/10 18:15
 * @description:
 */
public class Deadlock {

    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void main(String[] args) {
//        deadlockV1();
        deadlockV2();


    }

    private static void deadlockV2() {

        Thread thread1 = new Thread(() -> {
            synchronized (obj1) {
                System.out.println("thread1 get resource obj1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj2) {
                    System.out.println("thread1 get resource obj2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (obj2) {
                System.out.println("thread2 get resource obj2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj1) {
                    System.out.println("thread2 get resource obj1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    private static void deadlockV1() {
        Thread thread1 = new Thread(() -> {

            try {
                lock1.lock();
                System.out.println(" thread1 get lock1 ");
                Thread.sleep(1000);

                lock2.lock();
                System.out.println(" thread1 get lock2 ");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock2.unlock();
                lock1.unlock();

            }
            System.out.println("thread1 end");
        });

        Thread thread2 = new Thread(() -> {

            try {
                lock2.lock();
                System.out.println(" thread2 get lock2 ");
                Thread.sleep(1000);

                lock1.lock();
                System.out.println(" thread2 get lock1 ");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
            }


            System.out.println("thread2 end");

        });

        thread1.start();
        thread2.start();
    }


}
