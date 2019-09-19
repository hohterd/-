package lection9_innerclass;

import java.util.Scanner;

public class Geometry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Triangle triangle = new Triangle();
        triangle.initialization();
        System.out.println(triangle.getSquare());
        System.out.println(triangle.toString());

        Rectangle rect = new Rectangle();
        rect.initialization();
        System.out.println(rect.getSquare());

        System.out.println(triangle.isEqualSquare(rect));

        System.out.println(ShapeUtils.isShape((triangle)));
        System.out.println(ShapeUtils.isShape((rect)));

        sc.close();
    }
}
