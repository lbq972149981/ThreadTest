package thread;

public class threadtest3 {
   public static void main(String[] args) {
      new Thread(new Runnable() {
         @Override
         public void run() {
            for(int i=0;i<5;i++){
               try {
                  Thread.sleep(10);
                  System.out.println(Thread.currentThread().getName()+"----"+i);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         }
      }).start();
   }
}
