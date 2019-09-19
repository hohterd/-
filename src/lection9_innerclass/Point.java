package lection9_innerclass;

public class Point implements movable{
    double x;
    double y;

    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(double x, double y) {
        this.x += x;
        this.y += y;
    }

    double distance(Point p){
        return Math.sqrt(Math.pow((p.x-this.x),2)+Math.pow((p.y-this.y),2));
    }
}

