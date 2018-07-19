package thread;

import org.junit.Test;

import java.util.concurrent.*;
public class CallThreadPool {
   @Test
   public void test() throws ExecutionException, InterruptedException {
      ExecutorService service = Executors.newFixedThreadPool(8);
      for(int i=0;i<10;i++){
         Future<String> future = service.submit(new mycall());
         System.out.println(future.get());;
      }
   }
   public class mycall implements Callable<String>{

      @Override
      public String call() throws Exception {
         return Thread.currentThread().getName()+"启动了！";
      }
   }
}
