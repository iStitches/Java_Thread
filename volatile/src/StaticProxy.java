/**
 * 静态代理:
 * 总结：
 * 代理对象和真实对象需要实现同一个接口
 * 代理对象中包含着能调用的真实对象作为属性
 */
public class StaticProxy {
    public static void main(String[] args) {
        new Company(new Person()).HappyMarry();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是一个小县城");
            }
        }).start();
    }
}


//婚礼接口
interface  Marry{
    public void HappyMarry();
}

//待结婚的人
class Person implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("xxx要结婚了，超开心！");
    }
}

//婚庆公司
class Company implements Marry{
    private Marry marry;

    Company(Marry marry){
        this.marry=marry;
    }

    @Override
    public void HappyMarry() {
        before();
        this.marry.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("婚礼结束啦。。。。。");
    }

    private void before() {
        System.out.println("婚礼筹备中。。。。。");
    }
}