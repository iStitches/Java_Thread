package SynchorizedThread;

public class ThreadLock5 implements Runnable{
    private byte[] lock=new byte[0];  //特殊对象充当锁

    @Override
    public void run() {

    }

    public void method(){
        synchronized (lock){
            //xxxxxx todo 同步代码块
        }
    }
}
