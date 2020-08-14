public class ThreadJoin implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<200;i++){
            System.out.println("join..."+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin thread = new ThreadJoin();
        Thread thread1 = new Thread(thread);
        thread1.start();

        for(int i=0;i<1000;i++){
            if(i==50){
                thread1.join();   //插队
            }
            System.out.println("main..."+i);
        }
    }
}
