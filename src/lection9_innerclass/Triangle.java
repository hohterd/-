package lection9_innerclass;

public class Triangle extends Polygon{

    Triangle() {
        super(3);
    }

    class Height{
        private double value;

        Height(int pn){
            switch (pn){
                case 1:
                    this.value = (2*getSquare())/(points[1].distance(points[2]));
                    break;
                case 2:
                    this.value = (2*getSquare())/(points[0].distance(points[2]));
                    break;
                case 3:
                    this.value = (2*getSquare())/(points[0].distance(points[1]));
                    break;
                default:
                    throw new GeometryExeption("Неправильная точка");
            }
        }

        public double getHeightValue() {
            return value;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        double height1 = new Height(1).getHeightValue();
        double height2 = new Height(2).getHeightValue();
        double height3 = new Height(3).getHeightValue();
        for (int i = 0; i < points.length; i++) {
            stringBuilder.append("\n\tP")
                    .append((i+1))
                    .append("\tX: ")
                    .append(points[i].x)
                    .append("\t\tY: ")
                    .append(points[i].y);
        }
        StringBuilder info = new StringBuilder();
        info.append("Данная фигура является треугольником, площадь которого равна ").append(getSquare())
                .append(" см^2, с координатами: \n").append(stringBuilder).append("\n}\n")
                .append("С вершинами: \n{\n").append("\tОт точки P1: ".concat(String.valueOf(height1)).concat(" см^2\n"))
                .append("\tОт точки P2: ".concat(String.valueOf(height2)).concat(" см^2\n"))
                .append(("\tОт точки P3: ".concat(String.valueOf(height3)).concat(" см^2\n}")));
        return String.valueOf(info);
    }
}
