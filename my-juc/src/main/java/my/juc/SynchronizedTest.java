package my.juc;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/1/12 14:55
 * @description:
 */
public class SynchronizedTest {


    public static void main(String[] args) {


            synchronized (SynchronizedTest.class) {

                Thread thread = Thread.currentThread();

                int i = 1;

            }



    }

}
