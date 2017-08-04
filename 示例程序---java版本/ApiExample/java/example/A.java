package example;

/**
 * Created by ${shishiwei} on 2017/7/30 0030.
 */
class A{
    static {
        System.out.println("父类静态代码块");
    }
    public A(){
        System.out.println("父类构造方法");
    }
    {
        System.out.println("父类初始化块");
    }
}

