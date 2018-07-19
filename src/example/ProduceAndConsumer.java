package example;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 用阻塞队列快速实现生产者-消费者
 */
public class ProduceAndConsumer {
   public static void main(String[] args) {
      final BlockingQueue<Integer> list = new ArrayBlockingQueue<Integer>(10);
      Procude procude = new Procude(list);
      Consumer consumer = new Consumer(list);
      procude.start();
      consumer.start();
   }

   static class Procude extends Thread{
      private final BlockingQueue<Integer> list;
      Procude(BlockingQueue<Integer> list) {
         this.list = list;
      }
      @Override public void run() {
         while(true){
            try {
               Integer take = list.take();
               System.out.println("消费数据：" + take);
//                    Thread.sleep(1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
   }

   static class Consumer extends Thread{
      private final BlockingQueue<Integer> list;
      Consumer(BlockingQueue<Integer> list) {
         this.list = list;
      }
      @Override public void run() {
         while (true){
            try {
               int i = new Random().nextInt(100);
               list.put(i);
               System.out.println("生产数据：" + i);
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
   }
}