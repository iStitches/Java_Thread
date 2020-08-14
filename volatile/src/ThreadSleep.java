public class ThreadSleep {
    public static void main(String[] args) {
        Celler celler = new Celler();
        new Thread(celler,"售货员1号").start();
        new Thread(celler,"售货员2号").start();
        new Thread(celler,"售货员3号").start();
    }
}

class Celler implements Runnable{
    //模拟票数
    private int ticket=10;

    @Override
    public void run() {
        while(ticket>0){
            System.out.println(Thread.currentThread().getName()+"卖出了第"+ticket+"张票");
            ticket--;
        }
    }
}