package SynchorizedThread;

/**
 * 指定给某个方法添加锁
 */
public class ThreadLock4 {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(ticket,"用户A").start();
        new Thread(ticket,"用户B").start();
        new Thread(ticket,"用户C").start();
    }

}

class Ticket implements Runnable{
    private static int ticknum=10;
    private boolean flag=true;

    @Override
    public void run() {
        try {
            while(flag){
                Thread.sleep(100);
                sellTicket();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //给卖票的方法加锁----某一时刻只能有一个人来卖票
    private synchronized void sellTicket() {
        if(ticknum>0){
            System.out.println(Thread.currentThread().getName()+"卖出了:"+ticknum);
            ticknum--;
        }
        else{
            flag=false;
        }
    }
}
