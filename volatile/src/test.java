public class test {
    public static volatile boolean flag=false;
    public static void main(String[] args) throws InterruptedException {
        //开启线程1
          new Thread(new Runnable() {
              @Override
              public void run() {
                  System.out.println("waiting data....");
                  //死循环等待，只有flag值被修改为true才能结束继续往下执行
                  while (!flag){

                  }
                  System.out.println("======success");
              }
          }).start();

          Thread.sleep(3000);

        //开启线程2
          new Thread(new Runnable() {
              @Override
              public void run() {
                  System.out.println("prepare data....");
                  flag=!flag;
              }
          }).start();
    }
}
