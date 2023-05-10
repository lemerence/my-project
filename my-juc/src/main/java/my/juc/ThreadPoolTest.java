package my.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/2/8 17:58
 * @description:
 */
public class ThreadPoolTest {

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()+1,30,1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(10),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {

        threadPoolExecutor.execute(()->{
            System.out.println("1");
            try {
                Thread.sleep(1000*60*60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



    }

}
