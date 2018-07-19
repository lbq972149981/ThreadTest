package thread;

public class Threadtest7 {
   public static void main(String[] args) {
      ThreadF thread1 = new ThreadF();
      thread1.setName("AA");
      thread1.start();
      Daemon daemon = new Daemon();
      daemon.setName("Daemon");
      daemon.setDaemon(true);
      daemon.start();
   }
}
class Daemon extends Thread{
   @Override
   public void run() {
      for(int i=0;i<20;i++){
         try {
            Thread.sleep(1001);
            System.out.println(Thread.currentThread().getName()+"---"+i);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
class ThreadF extends Thread{
   @Override
   public void run() {
      for(int i=0;i<20;i++){
         try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName()+"---"+i);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}