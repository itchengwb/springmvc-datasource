package digester.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/8/17  15:21
 * Discribe: Template
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {

       /* //1,创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors. newSingleThreadExecutor();*/
        //2,创建一个可重用固定线程数的线程池
        // ExecutorService pool = Executors.newFixedThreadPool(2);
        //3创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newCachedThreadPool();


        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口

        Thread t1 = new MyThread();

        Thread t2 = new MyThread();

        Thread t3 = new MyThread();

        Thread t4 = new MyThread();

        Thread t5 = new MyThread();

        //将线程放入池中进行执行

        pool.execute(t1);

        pool.execute(t2);

        pool.execute(t3);

        pool.execute(t4);

        pool.execute(t5);

        //关闭线程池

        pool.shutdown();

    }

}
