package thread;

public class Threadtest6 {
   public static void main(String[] args) {
      for(int i=0;i<10;i++){
         if(i==4){
            ThreadE thread2 = new ThreadE();
            thread2.setName("BB");
            thread2.start();
            try {
               thread2.join();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }

            ThreadE thread3 = new ThreadE();
            thread3.setName("CC");
            thread3.start();

         }
         System.out.println(i);
      }

   }
}
class ThreadE extends Thread{
   @Override
   public void run() {
      for(int i=0;i<10;i++) {
         try {
            Thread.currentThread().sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         System.out.println(Thread.currentThread().getName()+"---"+i);
      }
   }
}