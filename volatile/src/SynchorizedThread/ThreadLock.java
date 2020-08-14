package SynchorizedThread;

/**
 * Synchorized的用法
 */

public class ThreadLock {
    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        new Thread(syncThread,"AAA").start();
        new Thread(syncThread,"BBB").start();
//        SyncThread thread1=new SyncThread();
//        SyncThread thread2=new SyncThread();
//        new Thread(thread1,"AAA").start();
//        new Thread(thread2,"BBB").start();
    }
}

class SyncThread implements Runnable{
    private static int count;

    SyncThread(){
        count=0;
    }

    @Override
    public synchronized void run() {
            try {
                for(int i=0;i<5;i++){
                    System.out.println(Thread.currentThread().getName()+":"+(count++));
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}

