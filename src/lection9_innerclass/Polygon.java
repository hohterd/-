package lection9_innerclass;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Polygon extends Figure implements movable {
    Point[] points;

    Polygon(int n){
        if (n<=2){
            throw new GeometryExeption("Многоугольник не может сождержать менее 3 точек" );
        }
        this.points = new Point[n];
    }

    void initialization(){
        for (int i = 0; i <= points.length-1; i++) {
            points[i] = new Point(0,0);
        }
        System.out.println("Создание многоугольника");
        System.out.println("Введите координаты вершин");
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= points.length; i++) {
            System.out.println("Введите координаты x"+i);
            points[i-1].x = sc.nextDouble();
            System.out.println("Введите координаты y"+i);
            points[i-1].y = sc.nextDouble();
        }
    }

    @Override
    double getSquare() {
        double res = 0, s = 0;
        for (int i = 0; i < points.length; i++) {
            if (i == 0) {
                s = points[i].x*(points[points.length-1].y - points[i+1].y);  //если i == 0, то y[i-1] заменяем на y[n-1]
                res += s;
            }
            else
            if (i == points.length-1) {
                s = points[i].x*(points[i-1].y - points[0].y); // если i == n-1, то y[i+1] заменяем на y[0]
                res += s;
            }
            else {
                s = points[i].x*(points[i-1].y - points[i+1].y);
                res += s;
            }
        }
        return abs(res/2);
    }

    @Override
    public void move(double x, double y) {
        for (int i = 0; i < points.length; i++) {
            points[i].move(x,y);
        }
    }

    boolean isEqualSquare(Figure figure){
        if(this.getSquare()==figure.getSquare()){
            System.out.println("Площади равны");
            return true;
        }
        else {
            System.out.println("Площади не равны");
            return false;
        }
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
        info.append("Данная фигура является многоугольником, площадь которого равна ")
                .append(getSquare()).append(" см^2, с координатами: \n").append(stringBuilder).append("\n}");
        return String.valueOf(info);
    }
}
