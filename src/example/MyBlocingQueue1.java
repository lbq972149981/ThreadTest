package example;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模仿ArrayBlockingQueue实现阻塞队列
 */
public class MyBlocingQueue1<E> {
   private final List list;
   private final int limit;//有大小限制的
   private final Lock lock = new ReentrantLock();
   private final Condition notFull = lock.newCondition();
   private final Condition notEmpty = lock.newCondition();

   public MyBlocingQueue1(int limit) {
      this.limit = limit;
      this.list = new LinkedList<E>();
   }

   public void put(E e) throws InterruptedException {
      lock.lock();
      try {
         while (list.size() == limit){
            notFull.await();
         }
         list.add(e);
         notEmpty.signalAll();
      }finally {
         lock.unlock();
      }
   }
   public E take() throws InterruptedException {
      lock.lock();
      try {
         while (list.size() == 0){
            notEmpty.await();
         }
         E remove = (E) list.remove(0);
         notFull.signalAll();
         return remove;
      }finally {
         lock.unlock();
      }
   }
}