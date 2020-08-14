package SynchorizedThread;

/**
 * 指定要给某个对象加锁
 */
public class ThreadLock3 {
    public static void main(String[] args) {
        Account account = new Account("招商银行", 300);
        Operator operator = new Operator(account);

        Thread threads[]=new Thread[5];
        for(int i=0;i<5;i++){
            threads[i]=new Thread(operator,"Thread"+i);
            threads[i].start();
        }


    }
}

/**
 * 银行账户类
 */
class Account{
    private String name;
    private float amount;

    public Account(String name,float money){
        this.name=name;
        amount=money;
    }

    //存钱
    public void saveMoney(float amt){
        amount+=amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //取钱
    public void getMoney(float amt){
        if(amount<amt){
            System.out.println("余额不足了");
            return;
        }
        amount-=amt;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //查询余额
    public float getBalance(){
        return amount;
    }
}

/**
 * 账户操作类
 */
class Operator implements Runnable{
    //每一个操作对象对应着一个银行账户
    private Account account;

    public Operator(Account account){
        this.account=account;
    }

    @Override
    public void run() {
        synchronized (account){
            //模拟取钱
            if(account.getBalance()<100){
                System.out.println("余额不足了....");
            }
            else{
                account.getMoney(100);
                System.out.println(Thread.currentThread().getName()+"取出了100元");
            }
        }
    }
}


