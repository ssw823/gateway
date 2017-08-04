package example;

/**
 * Created by ${shishiwei} on 2017/6/21 0021.
 */
public class Singleton {
//    private static Singleton instance;
//    public static Singleton getInstance() {
//        // write your code here
//        if(instance != null){
//            instance = new Singleton();
//        }
//    };
//    public Singleton(){
//
//    }
//    public static void main(String[] args) {
//        Singleton singleton = new Singleton();
//        singleton.getInstance();
//    }
    private static int st = 0;      //静态的
    private int index = 0;          //非静态
    public void getInstance(){
        for (int i = 0; i < 5; i++) {
            System.out.println(st++ + " | " + index++);
        }
    }
    public static void main(String[] args) {
        Singleton singleton = new Singleton();
        singleton.getInstance();
    }
}
