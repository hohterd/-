package lection9_innerclass;

import java.util.Scanner;

public class Rhombus extends Polygon{
    Point center = new Point(0,0);
    double length;

    Rhombus() {
        super(4);
    }

    @Override
    void initialization() {
        for (int i = 0; i <= points.length-1; i++) {
            points[i] = new Point(0,0);
        }
        System.out.println("Создание ромба");
        System.out.println("Введите координаты центра");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите х");
        center.x = sc.nextDouble();
        System.out.println("Введите у");
        center.y = sc.nextDouble();

        System.out.println("Введите координаты первой точки");
        System.out.println("Введите х");
        points[0].x = sc.nextDouble();
        System.out.println("Введите у");
        points[0].y = sc.nextDouble();

        System.out.println("Введите длину");
        length = sc.nextDouble();

        points[2].x = center.x+(center.x-points[0].x);
        points[2].y = center.y+(center.y-points[0].y);
        points[1].x = ((points[0].y-center.y)*length/points[0].distance(center))+center.x;
        points[1].y = ((center.x-points[0].x)*length/points[0].distance(center))+center.y;
        points[3].x = center.x+(center.x-points[1].x);
        points[3].y = center.y+(center.y-points[1].y);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i = 0; i < points.length; i++) {
            stringBuilder.append("\n\tP")
                    .append((i+1))
                    .append("\tX: ")
                    .append(points[i].x)
                    .append("\t\tY: ")
                    .append(points[i].y);
        }
        StringBuilder info = new StringBuilder();
        info.append("Данная фигура является ромбом, площадь которого равна ").append(getSquare())
                .append(" см^2, с координатами: \n").append(stringBuilder).append("\n}");
        return String.valueOf(info);
    }
}