import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class test1{
    public static void main(String[] args) {
        System.out.println("main主线程");
        //第一种方式
        new MyThread().start();
        //第二种方式
        new Thread(new Thread2()).start();
        //第三种方式
        FutureTask futureTask = new FutureTask<>(new Thread3());
        new Thread(futureTask,"Callable").start();
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("继承Thread类方式的线程");
    }
}

class Thread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("runnable接口方式的线程");
    }
}

class Thread3 implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "Callable接口的方式的线程";
    }
}
