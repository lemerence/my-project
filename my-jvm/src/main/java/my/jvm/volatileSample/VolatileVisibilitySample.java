package my.jvm.volatileSample;

/**
 * @Author: YST
 * @Date: 2021/4/25 23:34
 * @Version: 1.0
 * @Description: volatile关键字
 *
 * 1.volatile有哪些作用？工作中怎么使用
 * 2.volatile底层实现原理
 * 3.双重检查锁定的单例需不需要加volatile
 * 4。jmm原子操作
 * 5.伪共享
 * 6。jdk如何解决伪共享
 */
public class VolatileVisibilitySample {

    private static volatile boolean flag = false;


    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程一拿到的flag："+flag);
                while (!flag){

                }
                System.out.println("线程一执行。。。flag:"+flag);
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                shortWait(1000000000*1000);

                flag = true;
                System.out.println("线程二修改了flag:"+flag);
            }
        });
        thread2.start();

        try {
            //main 等待1、2执行完
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("执行结束");

    }

    
    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
    }

}
