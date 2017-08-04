package example;

/**
 * Created by ${shishiwei} on 2017/6/15 0015.
 */
public class Rectangle {
//    private String width;//宽度
//    private String height;//高度
    public int area;

    public Rectangle() {
//        area = width*height;
    }
    public int getArea(int width,int height){
        return area= width*height;
    }

    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        rec.getArea(3,4); // should get 12
        System.out.println(rec.getArea(3,4));
    }

}
