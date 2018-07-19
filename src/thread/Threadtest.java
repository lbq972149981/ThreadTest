package thread;

import org.junit.Test;

public class Threadtest {
   public static void main(String[] args) {
      ThreadA thread1 = new ThreadA();
      thread1.setName("A");
      thread1.start();
      ThreadA thread2 = new ThreadA();
      thread2.setName("B");
      thread2.start();
   }
}
class ThreadA extends Thread{
   @Override
   public void run() {
      for(int i=0;i<5;i++){
         try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"----"+i);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
