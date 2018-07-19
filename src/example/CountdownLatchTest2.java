package example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 各个线程执行完成后，主线程做总结性工作的例子
 */
public class CountdownLatchTest2 {
   private final static int THREAD_NUM = 10;
   public static void main(String[] args) {
      CountDownLatch lock = new CountDownLatch(THREAD_NUM);
      ExecutorService exec = Executors.newCachedThreadPool();
      for (int i = 0; i < THREAD_NUM; i++) {
         exec.submit(new CountdownLatchTask(lock, "Thread-"+i));
      }
      try {
         lock.await();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println("大家都执行完成了，做总结性工作");
      exec.shutdown();
   }

   static class CountdownLatchTask implements Runnable{
      private final CountDownLatch lock;
      private final String threadName;
      CountdownLatchTask(CountDownLatch lock, String threadName) {
         this.lock = lock;
         this.threadName = threadName;
      }
      @Override public void run() {
         System.out.println(threadName + " 执行完成");
         lock.countDown();
      }
   }
}