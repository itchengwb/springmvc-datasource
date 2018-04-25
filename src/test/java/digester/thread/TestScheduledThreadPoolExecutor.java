package digester.thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/8/17  15:55
 * Discribe: Template
 */
public class TestScheduledThreadPoolExecutor {
    //加载配置文件
    // 注册Servivce
    //调用service方法
    //查看返回结果

    public static void main(String[] args) {

        final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        final int count = 10;

        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间就触发异常
            int num = count;
            @Override
            public void run() {
                //throw new RuntimeException();

                if(num == 0){
                    exec.shutdown();
                    System.out.println("=======one结束=========");
                }
                System.out.println("========one="+num+"========");
                num -= 1;
            }

        }, 1000, 500, TimeUnit.MILLISECONDS);

        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间打印系统时间，证明两者是互不影响的
            int num = count;
            @Override
            public void run() {

                if(num == 0){
                    exec.shutdown();
                    System.out.println("=======two结束=========");
                }
                System.out.println(System.nanoTime());
                System.out.println("========two="+num+"========");
                num -= 1;
            }

        }, 1000, 1000, TimeUnit.MILLISECONDS);

    }

}
