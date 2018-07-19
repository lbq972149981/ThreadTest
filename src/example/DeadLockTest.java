package example;

/**
   * 简单死锁程序
   * lockA、lockB分别是两个资源，线程A、B必须同是拿到才能工作
   * 但A线程先拿lockA、再拿lockB
   * 线程先拿lockB、再拿lockA
 */
public class DeadLockTest {
   public static void main(String[] args) {
      Object lockA = new Object();
      Object lockB = new Object();
      A a = new A(lockA, lockB);
      B b = new B(lockA, lockB);
      a.start();
      b.start();
   }

   static class A extends Thread{
      private final Object lockA;
      private final Object lockB;
      A(Object lockA, Object lockB) {
         this.lockA = lockA;
         this.lockB = lockB;
      }

      @Override public void run() {
         synchronized (lockA){
            try {
               Thread.sleep(1000);
               synchronized (lockB){
                  System.out.println("Hello A");
               }
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
   }

   static class B extends Thread{
      private final Object lockA;
      private final Object lockB;
      B(Object lockA, Object lockB) {
         this.lockA = lockA;
         this.lockB = lockB;
      }

      @Override public void run() {
         synchronized (lockB){
            try {
               Thread.sleep(1000);
               synchronized (lockA){
                  System.out.println("Hello B");
               }
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
   }
}