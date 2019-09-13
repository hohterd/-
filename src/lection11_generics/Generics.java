package lection11_generics;

public class Generics {
    public static void main(String[] args) {
        //Exercise1_2();
        Exercise4();
    }

    public static void Exercise1_2(){
        Pair myTry = new Pair(10, "sup");
        System.out.println(myTry.getArgument1());
        System.out.println(myTry.getArgument2());
        myTry = PairUtil.swap(myTry);
        System.out.println(myTry.getArgument1());
        System.out.println(myTry.getArgument2());
    }

    public static void Exercise4(){
        Numbers <Double> doubleNumbers = new Numbers(15.4,9.2);
        Numbers <Integer> integerNumbers = new Numbers(18,6);

        System.out.println(Numbers.add(doubleNumbers.number1,doubleNumbers.number2));
        System.out.println(Numbers.sub(doubleNumbers.number1,doubleNumbers.number2));
        System.out.println(Numbers.multiply(doubleNumbers.number1,doubleNumbers.number2));
        System.out.println(Numbers.divide(doubleNumbers.number1,doubleNumbers.number2));

        System.out.println(Numbers.add(integerNumbers.number1,integerNumbers.number2));
        System.out.println(Numbers.sub(integerNumbers.number1,integerNumbers.number2));
        System.out.println(Numbers.multiply(integerNumbers.number1,integerNumbers.number2));
        System.out.println(Numbers.divide(integerNumbers.number1,integerNumbers.number2));
    }
}


