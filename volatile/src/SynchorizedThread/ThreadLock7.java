package SynchorizedThread;

/**
 * 修饰一个类
 */
public class ThreadLock7 {
    public static void main(String[] args) {
        Synch1 synch1 = new Synch1();
        Synch1 synch2= new Synch1();
        Thread thread1 = new Thread(synch1, "AAA");
        Thread thread2 = new Thread(synch2, "BBB");
        thread1.start();
        thread2.start();
    }
}

class Synch1 implements Runnable{
    private static int count=0;

    @Override
    public void run() {
        method();
    }

    public synchronized void method(){
        synchronized (Synch1.class){
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
}
