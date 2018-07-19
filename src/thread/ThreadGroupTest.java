package thread;

import org.junit.Test;
public class ThreadGroupTest implements Runnable{
   @Test
   public  void func(){
      ThreadGroup pGroup = new ThreadGroup("pGroup");
      Thread thread1 = new Thread(pGroup,this,"thread1");
      Thread thread2 = new Thread(pGroup,this,"thread2");
      Thread thread3 = new Thread(pGroup,this,"thread3");
      thread1.start();
      thread2.start();
      thread3.start();
      Thread[] threads = new Thread[pGroup.activeCount()];
      int count = pGroup.enumerate(threads);
      for(int i=0;i<count;i++){
         System.out.println("线程组中："+threads[i].getName()+"被found");
      }
   }
   @Override
   public void run() {
      for(int i=0;i<2;i++){
         System.out.println(Thread.currentThread().getName()+"---"+i);
      }
   }
}
