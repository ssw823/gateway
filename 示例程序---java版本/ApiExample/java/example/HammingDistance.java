package example;

/**
 * Created by ${shishiwei} on 2017/7/25 0025.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i=0;i<32;i++) {
            count += (xor >> i) & 1;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        int i = hammingDistance.hammingDistance(2, 4);
        System.out.println(i);
    }
}
