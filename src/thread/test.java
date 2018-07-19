package thread;

public class test{
   public static class addTest{
      public int count = 0;
      public void add(int num){
         synchronized (this) {
            count += num;
            System.out.println(Thread.currentThread().getName() + "----count:" + count);
         }
      }
   }
   public static class addThread extends Thread {
      public addTest addTest;

      public addThread(addTest a, String addThread) {
         super(addThread);
         this.addTest = a;
      }

      @Override
      public void run() {
         addTest.add(3);
      }
   }
   public static void main(String[] args) {
      addTest a = new addTest();
      new addThread(a,"addThread1").start();
      new addThread(a,"addThread2").start();
      new addThread(a,"addThread3").start();
      new addThread(a,"addThread4").start();
      new addThread(a,"addThread5").start();
      new addThread(a,"addThread6").start();
   }
}
