package bai_tap.QuadraticEquation;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập a: ");
        double a = scanner.nextDouble();
        System.out.println("Nhập b: ");
        double b = scanner.nextDouble();
        System.out.println("Nhập c: ");
        double c = scanner.nextDouble();

        QuadraticClass quadraticEquation = new QuadraticClass(a, b, c);
        System.out.println("Delta = " + quadraticEquation.getDiscriminant(a,b,c));
        System.out.println("Nghiệm X1 = "+quadraticEquation.getRoot1(a,b,c));
        System.out.println("Nghiệm X2 = " +quadraticEquation.getRoot2(a,b,c));
    }
}
