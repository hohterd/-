package lection5_wrappers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Lection5 {
    public static void main(String[] args) {
        Numbers integerNumbers = new Numbers(30,20);
        Numbers doubleNumbers = new Numbers(15.5,20.7);

        System.out.println("Результат работы над int: ");
        System.out.println("Сложение: ");
        System.out.println(integerNumbers.add(integerNumbers.integer1,integerNumbers.integer2));
        System.out.println("Вычитание: ");
        System.out.println(integerNumbers.sub(integerNumbers.integer1,integerNumbers.integer2));
        System.out.println("Умножение: ");
        System.out.println(integerNumbers.multiply(integerNumbers.integer1,integerNumbers.integer2));
        System.out.println("Деление: ");
        System.out.println(integerNumbers.division(integerNumbers.integer1,integerNumbers.integer2));

        System.out.println("Результат работы над double: ");
        System.out.println("Сложение: ");
        System.out.println(doubleNumbers.add(doubleNumbers.double1,doubleNumbers.double2));
        System.out.println("Вычитание: ");
        System.out.println(doubleNumbers.sub(doubleNumbers.double1,doubleNumbers.double2));
        System.out.println("Умножение: ");
        System.out.println(doubleNumbers.multiply(doubleNumbers.double1,doubleNumbers.double2));
        System.out.println("Деление: ");
        System.out.println(doubleNumbers.division(doubleNumbers.double1,doubleNumbers.double2));

        System.out.println("Результат работы над BigDecimal: ");
        System.out.println("Сложение: ");
        System.out.println(doubleNumbers.add(BigDecimal.valueOf(doubleNumbers.double1),BigDecimal.valueOf(doubleNumbers.double2)));
        System.out.println("Вычитание: ");
        System.out.println(doubleNumbers.sub(BigDecimal.valueOf(doubleNumbers.double1),BigDecimal.valueOf(doubleNumbers.double2)));;
        System.out.println("Умножение: ");
        System.out.println(doubleNumbers.multiply(BigDecimal.valueOf(doubleNumbers.double1),BigDecimal.valueOf(doubleNumbers.double2)));;
        System.out.println("Деление (точность 16): ");
        System.out.println(doubleNumbers.division(BigDecimal.valueOf(doubleNumbers.double1).setScale(15),BigDecimal.valueOf(doubleNumbers.double2).setScale(15)));;

    }

    static class Numbers {
        int integer1;
        int integer2;
        double double1;
        double double2;

        Numbers(int integer1, int integer2) {
            this.integer1 = integer1;
            this.integer2 = integer2;
        }

        Numbers(double double1, double double2) {
            this.double1 = double1;
            this.double2 = double2;
        }

        int add(int integer1, int integer2){
            return integer1+integer2;
        }

        int sub(int integer1, int integer2){
            return integer1-integer2;
        }

        int multiply(int integer1, int integer2){
            return integer1*integer2;
        }

        int division(int integer1, int integer2){
            return integer1/integer2;
        }

        double add(double double1, double double2){
            return double1+double2;
        }

        double sub(double double1, double double2){
            return double1-double2;
        }

        double multiply(double double1, double double2){
            return double1*double2;
        }

        double division(double double1, double double2){
            return double1/double2;
        }

        BigDecimal add(BigDecimal double1, BigDecimal double2){
            return double1.add(double2);
        }

        BigDecimal sub(BigDecimal double1, BigDecimal double2){
            return double1.subtract(double2);
        }

        BigDecimal multiply(BigDecimal double1, BigDecimal double2){
            return double1.multiply(double2);
        }

        BigDecimal division(BigDecimal double1, BigDecimal double2){
            return double1.divide(double2, RoundingMode.HALF_UP);
        }

    }


}
