public class lambda {
    //3.静态内部类
    static class like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("like2执行了。。。。");
        }
    }

    public static void main(String[] args) {
        //4.局部内部类
        class like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("like3执行了。。。。");
            }
        }

        ILike like1=new like1();
        like1.lambda();

        ILike like2=new like2();
        like2.lambda();

        ILike like3=new like3();
        like3.lambda();

        //5.匿名内部类
        ILike like4=new ILike() {
            @Override
            public void lambda() {
                System.out.println("like4执行了。。。。");
            }
        };
        like4.lambda();

        //6.lambda表达式简化
        ILike like5=()->{
            System.out.println("like5执行了。。。。");
        };
        like5.lambda();
    }
}

//1.定义一个函数式接口
interface ILike{
    void lambda();
}


//2.实现类
class like1 implements ILike{
    @Override
    public void lambda() {
        System.out.println("like1执行了。。。。");
    }
}