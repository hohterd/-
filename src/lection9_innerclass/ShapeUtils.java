package lection9_innerclass;

public enum  ShapeUtils {
    TRIANGLE ("Треугольник"),
    RECTANGLE ("Прямоугольник"),
    SHAPE ("Это не треугольник и не прямоугольник");

    private String shape;

    ShapeUtils(String shape){
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    static boolean isRectangle(Polygon polygon) {
        if (polygon.points.length != 4) {
            return false;
        }

        double angle1 = (double) Math.atan2(polygon.points[0].y - polygon.points[1].y, polygon.points[0].x - polygon.points[1].x);
        double angle2 = (double) Math.atan2(polygon.points[0].y - polygon.points[3].y, polygon.points[0].x - polygon.points[3].x);
        double calculatedAngle = (double) Math.toDegrees(angle1 - angle2);
        if (calculatedAngle < 0) {
            calculatedAngle += 360;
        }

        if (calculatedAngle != 90) {
            return false;
        }

        if (polygon.points[0].distance(polygon.points[2]) != polygon.points[1].distance(polygon.points[3])) {
            return false;
        }
        return true;
    }

    static boolean isTriangle(Polygon polygon) {
        if (polygon.points.length != 3) {
            return false;
        }
        double length1 = polygon.points[0].distance(polygon.points[1]);
        double length2 = polygon.points[1].distance(polygon.points[2]);
        double length3 = polygon.points[0].distance(polygon.points[2]);
        if ((length1+length2 <= length3) | (length2+length3 <= length1) | (length1+length3 <= length2)) {
            return false;
        }
        return true;
    }

    static ShapeUtils isShape(Polygon polygon){
        if(isRectangle(polygon)){
            System.out.println("Это фигура ");
            return RECTANGLE;
        }
        else if (isTriangle(polygon)){
            System.out.println("Это фигура ");
            return TRIANGLE;
        }
        else {
            System.out.println("Это фигура ");
            return SHAPE;
        }
    }
}
