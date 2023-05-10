package my.juc.single;


import java.util.concurrent.CountDownLatch;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/2/3 14:07
 * @description:
 */
public class SingleInstance {

    private static SingleInstance instance;

    private static SingleInstance getInstance() {

        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(1000);

        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(SingleInstance.getInstance());
                countDownLatch.countDown();
            });
            thread.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
