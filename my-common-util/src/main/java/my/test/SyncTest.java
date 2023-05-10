package my.test;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/2/1 15:30
 * @description:
 */
public class SyncTest {

    public synchronized void method() throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        Thread.sleep(1000 * 1);
    }


    public static void main(String[] args) {

        SyncTest syncTest = new SyncTest();

        Thread thread1 = new Thread(() -> {
            try {
                syncTest.method();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            try {
                syncTest.method();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread2");

        Thread thread3 = new Thread(() -> {
            try {
                syncTest.method();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread3");


        thread1.start();
        thread2.start();
        thread3.start();
    }

}
