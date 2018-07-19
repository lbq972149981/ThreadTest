package thread;

public class Account1Test {
   public static class Account {
      private String Sno;
      private int balance;
      private boolean flag = false;//false 没钱可以存 true 有钱可以取
      public Account(String sno, int balance) {
         Sno = sno;
         this.balance = balance;
      }
      public String getSno() {
         return Sno;
      }
      public void setSno(String sno) {
         Sno = sno;
      }
      public int getBalance() {
         return balance;
      }
      public void setBalance(int balance) {
         this.balance = balance;
      }

      /**
       * 取钱
       * @param money
       */
      public  void draw(int money){
         synchronized(this) {
            if (!flag) {
               try {
                  wait();
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            } else {
               System.out.println(Thread.currentThread().getName() + "-----取了" + money + "钱");
               balance -= money;
               flag = false;
               try {
                  Thread.currentThread().sleep(100);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
               notifyAll();
            }
         }
      }
      public synchronized void save(int money) {
         synchronized (this) {
            if (flag) {
               try {
                  wait();
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            } else {
               System.out.println(Thread.currentThread().getName() + "-----存了" + money + "钱");
               balance += money;
               flag = true;
               try {
                  Thread.currentThread().sleep(100);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
               notifyAll();
            }
         }
      }
   }
   public static class DrawMoney extends Thread {
      private Account account;
      private int money;

      public DrawMoney(Account account, String name, int money) {
         super(name);
         this.account = account;
         this.money = money;
      }

      @Override
      public void run() {
         for(int i=0;i<10;i++){
            account.draw(money);
         }
      }
   }
   public static class SaveMoney extends Thread {
      private Account account;
      private int money;

      public SaveMoney(Account account, String name, int money) {
         super(name);
         this.account = account;
         this.money = money;
      }
      @Override
      public void run() {
         for(int i=0;i<10;i++){
            account.save(money);
         }
      }
   }
   public static void main(String[] args) {
      Account a1 = new Account("001",0);
      new DrawMoney(a1,"取钱人",800).start();
      new SaveMoney(a1,"存钱人A",800).start();
//      new SaveMoney(a1,"存钱人B",800).start();
//      new SaveMoney(a1,"存钱人C",800).start();
   }
}
