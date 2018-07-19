package thread;

public class AccountTest {
   public static class Account {
      private String Sno;
      private int balance;
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
   }

   public static class DrawMoney extends Thread{
      private Account account;
      private int drawAmount;
      public DrawMoney(Account account,String name, int drawAmount) {
         super(name);
         this.account = account;
         this.drawAmount = drawAmount;
      }
      @Override
      public  void run() {
         //取钱
         synchronized(account) {
            if (account.getBalance() >= this.drawAmount) {
               try {
                  Thread.sleep(100);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
               account.setBalance(account.getBalance() - this.drawAmount);
               System.out.println(this.getName() + "取了" + this.drawAmount + "钱");
            } else {
               System.out.println("余额不足，不能取钱");
            }
         }
      }
   }
   public static void main(String[] args) throws InterruptedException {
      Account a = new Account("001",800);
      DrawMoney d1 = new DrawMoney(a,"甲",800);
      d1.start();
      DrawMoney d2  = new DrawMoney(a,"乙",800);
      d2.start();
   }
}
