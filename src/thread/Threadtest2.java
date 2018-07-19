package thread;

public class Threadtest2 {
   public static void main(String[] args) {
      ThreadB thread1 = new ThreadB();
      Thread t1 = new Thread(thread1);
      t1.setName("AA");
      t1.start();
      ThreadB thread2 = new ThreadB();
      Thread t2 = new Thread(thread2);
      t2.setName("BB");
      t2.start();
   }
}
class ThreadB implements Runnable{

   @Override
   public void run() {
      for(int i=0;i<5;i++){
         try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName()+"----"+i);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}