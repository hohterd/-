package lection11_generics;

public class Numbers <T extends Number, D extends Number> {
    T number1;
    D number2;

    Numbers(T number1, D number2){
        this.number1 = number1;
        this.number2 = number2;
    }


    public static <T extends Number> T add(T number1, T number2) {
        if (number1 instanceof Double & number2 instanceof Double) {
            return (T) Double.valueOf((number1.doubleValue() + number2.doubleValue()));
        } else if (number1 instanceof Integer & number2 instanceof Integer) {
            return (T) Integer.valueOf((number1.intValue() + number2.intValue()));
        } else {
            throw new IllegalArgumentException("Неверный тип данных");
        }
    }

    public static <T extends Number> T sub(T number1, T number2) {
        if (number1 instanceof Double & number2 instanceof Double) {
            return (T) Double.valueOf((number1.doubleValue() - number2.doubleValue()));
        } else if (number1 instanceof Integer & number2 instanceof Integer) {
            return (T) Integer.valueOf((number1.intValue() - number2.intValue()));
        } else {
            throw new IllegalArgumentException("Неверный тип данных");
        }
    }

    public static <T extends Number> T multiply(T number1, T number2) {
        if (number1 instanceof Double & number2 instanceof Double) {
            return (T) Double.valueOf((number1.doubleValue() * number2.doubleValue()));
        } else if (number1 instanceof Integer & number2 instanceof Integer) {
            return (T) Integer.valueOf((number1.intValue() * number2.intValue()));
        } else {
            throw new IllegalArgumentException("Неверный тип данных");
        }
    }

    public static <T extends Number> T divide(T number1, T number2) {
        if (number1 instanceof Double & number2 instanceof Double) {
            return (T) Double.valueOf((number1.doubleValue() / number2.doubleValue()));
        } else if (number1 instanceof Integer & number2 instanceof Integer) {
            return (T) Integer.valueOf((number1.intValue() / number2.intValue()));
        } else {
            throw new IllegalArgumentException("Неверный тип данных");
        }
    }

}
