package example;

import javax.lang.model.element.VariableElement;

/**
 * Created by ${shishiwei} on 2017/6/19 0019.
 */
public class Cheng {
    TestZX testZX = new TestZX();
    public  void wo(){
        testZX.lala();
    }
    public static void main(String[] args) {
        int n = 5;
        for(int i=1; i<=n; i++) {
            for (int j = 0; j < i-1; j++) {
                System.out.print(i);
                System.out.print("*");
            }
//            int j = 0;
//            while(j < i-1) {
//                System.out.print(i);
//                System.out.print("*");
//                j++;
//            }
            System.out.println(i);
        }
        for(int i=n; i>=1; i--) {
            int j = 0;
            while(j < i-1) {
                System.out.print(i);
                System.out.print("*");
                j++;
            }
            System.out.println(i);
        }
    }

}
