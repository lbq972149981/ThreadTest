package thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolTest {
   @Test
   public void test(){
      //固定个数线程
//    ExecutorService service = Executors.newFixedThreadPool(8);
      //单个线程
//    ExecutorService service = Executors.newSingleThreadExecutor();
      ExecutorService service = Executors.newCachedThreadPool();
      for(int i=0;i<10;i++){
         Runnable run = new Runnable() {
            @Override
            public void run() {
               System.out.println(Thread.currentThread().getName()+"启动");
            }
         };
         service.execute(run);
      }
      service.shutdown();
      try {
         service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
         System.out.println("完毕");
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
