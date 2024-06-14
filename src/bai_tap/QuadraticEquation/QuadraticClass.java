package bai_tap.QuadraticEquation;

public class QuadraticClass {
    double a, b, c;

    public QuadraticClass(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        return delta;
    }
    public double getRoot1(double a, double b, double c) {
        double delta = getDiscriminant(a, b, c);
        double x1 = 0;
        if (delta < 0) {
            System.out.println("Vô nghiệm");
        } else {
             x1 = (-b + Math.sqrt(delta)) / (2 * a);

        }
        return x1;
    }
    public double getRoot2(double a, double b, double c) {
        double delta = getDiscriminant(a, b, c);
        double x2 = 0;
        if (delta < 0) {
            System.out.println("Vô nghiệm");
        } else {
            x2 = (-b - Math.sqrt(delta)) / (2 * a);
        }
        return x2;
    }
}
