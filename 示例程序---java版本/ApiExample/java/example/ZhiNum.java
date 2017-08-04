package example;

import java.util.Scanner;

/**
 * Created by ${shishiwei} on 2017/6/21 0021.
 */
public class ZhiNum {
    public boolean isUgly(int num) {
        // Write your code here
        if(num>1){
            for(int i=2;i<num;i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ChouNum chouNum = new ChouNum();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        boolean ugly = chouNum.isUgly(num);
        System.out.println(ugly);
        if(ugly == false){
            System.out.println(num+"不是质数");
        }else {
            System.out.println(num+"是质数");
        }
    }
}
