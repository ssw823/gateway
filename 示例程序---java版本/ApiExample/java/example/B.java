package example;

/**
 * Created by ${shishiwei} on 2017/7/30 0030.
 */
public class B extends A{
    static{
        System.out.println("子类静态代码块");
    }
    public B(){
        System.out.println("子类构造方法");
    }
    {
        System.out.println("子类初始化块");
    }
    public static void main(String[] args){
        new B();
    }
}
