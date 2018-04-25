package org.bobo.mvc.thread;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/8/13  2:51
 * Discribe: Template
 */
import java.io.*;
import java.lang.Thread;
class MyThread extends Thread{
    public int x = 0;
    public void run(){
        System.out.println(++x);
        }
}

class R implements Runnable{
    private int x = 0;
    public void run(){
        System.out.println(++x);
        }
}
public class Test {
    public static void main(String[] args) throws Exception{
        for(int i=0;i<10;i++){
             Thread t = new MyThread();
             t.start();
            }
        Thread.sleep(10000);//让上面的线程运行完成
        R r = new R();
        for(int i=0;i<10;i++){
             Thread t = new Thread(r);
             t.start();
            }
        }
    /**
     * 上面10个线程对象产生的10个线程运行时打印了10次1。
     * 下面10个线程对象产生的10个线程运行时打印了1到10。我们把下面的10个线程称为同一实例(Runnable实例)的多个线程。
     */
}
