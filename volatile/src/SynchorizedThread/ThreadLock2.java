package SynchorizedThread;

/**
 * 多个线程访问synchronized和非synchronized代码块
 */

public class ThreadLock2 {
    public static void main(String[] args) {
        SyncThread1 syncThread1 = new SyncThread1();
        new Thread(syncThread1,"A").start();
        new Thread(syncThread1,"B").start();
    }
}

class SyncThread1 implements Runnable{
    private static int count;

    SyncThread1(){
        count=0;
    }

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("A"))
            editCount();
        else if(Thread.currentThread().getName().equals("B"))
            printCount();
    }

    //加了锁的方法
    public synchronized void editCount(){
        try {
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+":"+(count++));
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //未加锁的方法
    public void printCount(){
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"----count:"+count);
        }
    }
}

