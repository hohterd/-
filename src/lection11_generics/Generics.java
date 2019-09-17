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
        Numbers doubleNumbers = new Numbers(15,9);

        System.out.println(Numbers.add(doubleNumbers.number1,doubleNumbers.number2));
        System.out.println(Numbers.sub(doubleNumbers.number1,doubleNumbers.number2));
        System.out.println(Numbers.multiply(doubleNumbers.number1,doubleNumbers.number2));
        System.out.println(Numbers.divide(doubleNumbers.number1,doubleNumbers.number2));

    }
}


