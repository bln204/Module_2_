package bai_tap.TestCircle;

public class Main {
    public static  void main(String[] args) {
        Circle circle = new Circle(5.0);
        Circle circle2 = new Circle();

        System.out.println("Bán kính hình tròn là: " + circle2.getRadius());
        System.out.println("Bán kính hình tròn là: " + circle2.getArea());

        System.out.println("Bán kính hình tròn là: " + circle.getRadius());
        System.out.println("Diện tích hình tròn là: " + circle.getArea());
    }
}
