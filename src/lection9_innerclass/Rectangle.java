package lection9_innerclass;

import java.util.Scanner;

public class Rectangle extends Polygon {
    double length;

    Rectangle() {
        super(4);
    }

    @Override
    void initialization() {
        for (int i = 0; i <= points.length-1; i++) {
            points[i] = new Point(0,0);
        }
        System.out.println("Создание прямоугольника");
        System.out.println("Введите координаты двух точек");
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 2; i++) {
            System.out.println("Введите х " + i + " точки");
            points[i-1].x = sc.nextDouble();
            System.out.println("Введите у " + i + " точки");
            points[i-1].y = sc.nextDouble();
        }
        System.out.println("Введите длину");
        length = sc.nextDouble();
        points[3].x = ((points[1].y-points[0].y)*length/points[1].distance(points[0]))+points[0].x;
        points[3].y = ((points[0].x-points[1].x)*length/points[1].distance(points[0]))+points[0].y;
        points[2].x = ((points[0].y-points[3].y)*points[1].distance(points[0])/points[3].distance(points[0]))+points[3].x;
        points[2].y = ((points[3].x-points[0].x)*points[1].distance(points[0])/points[3].distance(points[0]))+points[3].y;
    }

    double getDiagonal(){
        return points[0].distance(points[2]);
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
        info.append("Данная фигура является прямоугольником, площадь которого равна ").append(getSquare())
                .append(" см^2, с координатами: \n").append(stringBuilder).append("\n}")
                .append("\nДиагональ которого равна: = ").append(getDiagonal()).append(" см");
        return String.valueOf(info);
    }
}