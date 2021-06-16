package my.juc;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author: YST
 * @Date: 2021/4/24 20:17
 * @Version: 1.0
 * @Description: future
 */
public class FutureTest {
    /**
     * @Author: YST
     * @Date: 20:49 2021/4/24
     * @Param: []
     * @Return: void
     * @Description: FutureTask有返回值 get方法有参
     **/
    @Test
    public void test1() throws ExecutionException, InterruptedException, TimeoutException {
        // 有返回值  死循环get
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("--------------callable.call----业务代码执行");
                return "FutureTask返回值";
            }
        });

        Thread thread = new Thread(task);
        thread.start();
        //死循环 获取返回值
        System.out.println(task.get(10*1000,TimeUnit.MILLISECONDS));
    }

    /**
     * @Author: YST
     * @Date: 20:46 2021/4/24
     * @Param: []
     * @Return: void
     * @Description: CompletableFuture可加线程池 有返回值 get方法无参
     **/
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        //无返回值
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "------------执行业务代码");
            }
        });

        System.out.println(voidCompletableFuture.get());


        //有返回值  带线程池
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {

                System.out.println(Thread.currentThread().getName() + "------------执行业务代码");

                return "CompletableFuture返回值";
            }
        }, Executors.newCachedThreadPool());
        System.out.println(objectCompletableFuture.get());

    }


    /**
     * @Author: YST
     * @Date: 20:47 2021/4/24
     * @Param: []
     * @Return: void
     * @Description:  A线程执行完后，B线程需要拿到A的结果，再执行B线程
     **/
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {

                System.out.println(Thread.currentThread().getName() + "------------A执行业务代码");

                return "A";
            }
        },Executors.newCachedThreadPool()).thenApplyAsync(s -> {
            System.out.println(Thread.currentThread().getName() + "------------B执行业务代码");
            return s+"B";
        }).thenAcceptAsync(s -> {
            System.out.println(Thread.currentThread().getName() + "------------c执行业务代码");
            System.out.println(s);
        },Executors.newCachedThreadPool());

    }

    /**
     * @Author: YST
     * @Date: 20:47 2021/4/24
     * @Param: []
     * @Return: void
     * @Description:  A线程执行完后，B线程需要拿到A的结果，再执行B线程
     **/
    @Test
    public void test4() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {

            }
        });
        voidCompletableFuture.whenComplete((a,b)->{
            System.out.println(a+":"+b);
        });
        voidCompletableFuture.exceptionally((t)->{
            System.out.println(t.getMessage());
            return null;
        });
    }

    @Test
    public void test5() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFutureU = CompletableFuture.supplyAsync(() -> {
            return "U";
        });
        CompletableFuture<String> CompletableFutureT = CompletableFuture.supplyAsync(() -> {
            return "T";
        });
        //对异步结果聚合
        completableFutureU.thenCombine(CompletableFutureT,(u,t)->{return u+t;})
                .thenAcceptAsync(System.out::println);

    }
}
