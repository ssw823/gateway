package example;

import java.util.Scanner;

/**
 * Created by ${shishiwei} on 2017/6/21 0021.
 */
public class ChouNum {
        /**
         * @param num an integer
         * @return true if num is an ugly number or false
         */
        public boolean isUgly(int num) {
            // Write your code here
            if(num == 0){
                return false;
            }
            while (num % 2 == 0){
                num = num/2;
            }
            while(num % 3 == 0){
                num = num/3;
            }
            while(num % 5 == 0) {
                num = num / 5;
            }
            if(num == 1){
                return true;
            }else {
                return false;
            }
        }

    public static void main(String[] args) {
        ChouNum chouNum = new ChouNum();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        boolean ugly = chouNum.isUgly(num);
        System.out.println(ugly);
        if(ugly == false){
            System.out.println(num+"不是chou数");
        }else {
            System.out.println(num+"是chou数");
        }
    }
}
