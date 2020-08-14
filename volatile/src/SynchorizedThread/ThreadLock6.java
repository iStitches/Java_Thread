package SynchorizedThread;

/**
 * 修饰一个静态方法
 */
public class ThreadLock6 {
    public static void main(String[] args) {
        Synch synch1 = new Synch();
        Synch synch2= new Synch();
        Thread thread1 = new Thread(synch1, "AAA");
        Thread thread2 = new Thread(synch2, "BBB");
        thread1.start();
        thread2.start();
    }
}

class Synch implements Runnable{
    private static int count=0;

    @Override
    public void run() {
        method();
    }

    public synchronized static void method(){
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+":"+count);
            count++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
