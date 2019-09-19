package lection9_innerclass;

public class Circle extends Figure implements movable{
    Point centre;
    double radius;

    Circle(Point centre, double radius){
        this.centre = centre;
        this.radius = radius;
    }

    @Override
    double getSquare() {
        return Math.PI*Math.pow(radius, 2);
    }

    @Override
    public void move(double x, double y) {
        this.centre.move(x,y);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Данная фигура является кругом, площадь которого равна ").append(getSquare())
                .append(" см^2, с координатами центра: по X:").append(centre.x)
                .append(" Y:").append(centre.y)
                .append(", диагональ которого := ").append(+ radius).append(" см");
        return String.valueOf(info);
    }
}
