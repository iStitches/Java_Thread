public class ThreadStopMethods {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 myThread1 = new MyThread1();
        new Thread(myThread1).start();

        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            if(i==9){
                myThread1.stop();
                System.out.println("线程停止了");   //手动停止此线程
            }
        }
    }
}

class MyThread1 implements Runnable{
    // 提供一个外部标志位来控制线程的状态
    private boolean flag=true;

    @Override
    public void run() {
        while(flag){
            System.out.println("thread ......is  running");
        }
    }

    // 提供一个公用的线程停止方法
    public void stop(){
        this.flag=false;
    }
}