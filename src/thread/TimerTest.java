package thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest{
   public static void main(String[] args) {
      Timer timer = new Timer();
      Timert timert = new Timert(10,timer);
      timer.schedule(timert,1,1000);
   }
}
class Timert extends TimerTask{
   private int imgIndex;//每张图片索引
   private int imgCount;//总图片数
   private Timer timer;//计时器
   public Timert(int imgCount, Timer timer) {
      this.imgCount = imgCount;
      this.timer = timer;
   }
   @Override
   public void run() {
      if(++imgIndex<=imgCount){
         System.out.println("游戏正在加载第"+imgIndex+"张图片");
      }else {
         System.out.println("游戏加载成功");
         timer.cancel();
      }
   }
}
