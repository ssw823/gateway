package example;

/**
 * Created by ${shishiwei} on 2017/6/16 0016.
 */
import java.util.Vector;

public class Main1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String A = "ABCD";
        String B = "CBCE";
        System.out.println(largest(A, B));
    }
    public static int largest(String A, String B) {
        int n = A.length();
        int m = B.length();
        int num = 0;
        int[][] dp = new int[n + 1][m + 1]; // ///不赋值时的初始值为0

        for (int i = 1; i <= n; i++) {
            char c1 = A.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char c2 = B.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {

                    dp[i][j] = 0;
                }
                num = Math.max(num, dp[i][j]);
            }
            //return num;  /////for循环结束后才return
        }
        return num;
    }///largest
}