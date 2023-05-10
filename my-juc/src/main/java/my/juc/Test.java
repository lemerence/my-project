package my.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/1/10 16:42
 * @description:
 */
public class Test {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {

        lock.lock();

        lock.lock();

        Thread.sleep(1000);

        new Thread(()->{
            lock.lock();
        }).start();


    }

}
