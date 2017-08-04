package example;

/**
 * Created by ${shishiwei} on 2017/6/16 0016.
 */
public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     * 给出A=“ABCD”，B=“CBCE”，返回 2
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int m = A.length();
        int n = B.length();
        int longest = 0;
        int[][] shuzu = new int[m+1][n+1];
        for(int i = 0;i<A.length();i++){
            for (int j = 0; j < B.length(); j++) {
                if(A.charAt(i) == B.charAt(j)){
                    shuzu[i+1][j+1] = shuzu[i][j] +1;
                }else {
                    shuzu[i+1][j+1] = 0;
                }
                longest = Math.max(shuzu[i][j],longest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int size = solution.longestCommonSubstring("ABCD", "CBCE");
        System.out.println(size);
    }
}
