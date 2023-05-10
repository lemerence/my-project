package my.juc;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/1/11 15:09
 * @description: https://leetcode.cn/problems/print-foobar-alternately/
 */
public class FooBar {


    private int n;

    public FooBar(int n) {
        this.n = n;
    }


    private volatile boolean type = true;
    private final Object foo=  new Object();

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (foo) {
                while(!type){
                    foo.wait();
                }
                printFoo.run();
                type = false;
                foo.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (foo) {
                while(type){
                    foo.wait();
                }
                printBar.run();
                type = true;
                foo.notifyAll();
            }
        }
    }



//    ReentrantLock lock = new ReentrantLock();


//    private volatile boolean flag = true;
//    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            while (!flag) ;
//            printFoo.run();
//            flag = false;
//            try {
//                cyclicBarrier.await();
//            } catch (BrokenBarrierException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            try {
//                cyclicBarrier.await();
//            } catch (BrokenBarrierException e) {
//                e.printStackTrace();
//            }
//            printBar.run();
//            flag=true;
//        }
//    }

/*    private BlockingQueue<Integer> bar = new LinkedBlockingQueue<>(1);
    private BlockingQueue<Integer> foo = new LinkedBlockingQueue<>(1);

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.put(i);
            printFoo.run();
            bar.put(i);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.take();
            printBar.run();
            foo.take();
        }
    }*/



/*    private volatile boolean flag = true;

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if (flag) {
                printFoo.run();
                i++;
                flag = false;
            } else {
                Thread.yield();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if (!flag) {
                printBar.run();
                i++;
                flag = true;
            } else {
                Thread.yield();
            }
        }
    }*/

/*
    private Semaphore semaphoreFoo = new Semaphore(1);
    private Semaphore semaphoreBar = new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreFoo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphoreBar.release();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphoreFoo.release();
        }
    }*/
}
