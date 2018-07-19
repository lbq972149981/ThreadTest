package thread;

public class Threadtest5 {
   public static void main(String[] args) {
      ThreadD thread1 = new ThreadD();
      thread1.setName("A");
      //优先级 1-10
      //MAX_PRIORITY:10
      //MIN_PRIORITY:1
      //NORM_PRIORITY:5
      thread1.setPriority(Thread.MIN_PRIORITY);
      thread1.start();
      ThreadD thread2 = new ThreadD();
      thread2.setPriority(Thread.NORM_PRIORITY);
      thread2.setName("B");
      thread2.start();
   }
}
class ThreadD extends Thread{
   @Override
   public void run() {
      for(int i=0;i<500;i++){
         try {
            Thread.sleep(1);
            //yield 让出当前控制权
            //结果为A B A B ...
            //A线程执行到此处时，不继续执行，等待B线程
            //不一定一定准确
            yield();
            System.out.println(Thread.currentThread().getName()+"----"+i);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
