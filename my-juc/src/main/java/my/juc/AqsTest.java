package my.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/1/12 14:00
 * @description:
 */
public class AqsTest {

    private static Lock lock = new ReentrantLock();

//    private static final CountDownLatch countDownLatch = new CountDownLatch(1);

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {

        Thread thread1 = new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                System.out.println("thread:"+Thread.currentThread().getName()+"获取到🔒");
            } finally {
                lock.unlock();
            }
        });
        Thread thread2 = new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                System.out.println("thread:"+Thread.currentThread().getName()+"获取到🔒");
            } finally {
                lock.unlock();
            }
        });
        Thread thread3 = new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                System.out.println("thread:"+Thread.currentThread().getName()+"获取到🔒");
            } finally {
                lock.unlock();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(11);

    }

}
