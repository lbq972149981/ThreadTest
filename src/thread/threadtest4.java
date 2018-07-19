package thread;

public class threadtest4 {
   public static void main(String[] args) {
      ThreadC threadC = new ThreadC();
      threadC.setName("AAA");
      threadC.start();
   }

}
class ThreadC extends Thread{
   @Override
   public void run() {
      for(int i=0;i<5;i++){
         try {
            Thread.sleep(1001);
            /**
             * 1.Thread.currentThread().stop();//强制停止，不建议使用
             * 2.使用boolean break；
             * 3.使用interrupt中断，停止线程，但是他需要三种状态
             * sleep、wait、join
             *
             */
            if(i==3){
//              Thread.currentThread().stop();//强制停止，不建议使用

            }
            System.out.println(Thread.currentThread().getName()+"----"+i);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}