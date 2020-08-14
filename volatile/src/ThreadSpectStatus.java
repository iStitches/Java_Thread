public class ThreadSpectStatus {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(){
            @Override
            public void run() {
                for(int i=1;i<=5;i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("////");
            }
        };

        Thread.State state = thread.getState();
        System.out.println(state);  //NEW

        thread.start();
        state= thread.getState();
        System.out.println(state);  //Runnable

        while(state !=Thread.State.TERMINATED){
            state=thread.getState();
            Thread.sleep(100);
            System.out.println(state);   //Terminated
        }
    }
}
