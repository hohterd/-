package lection10_exceptions;

import java.util.Random;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        //Exercise1();
        //Exercise2();
        //Exercise3Checked();
        //Exercise4Uncheked();
        //Exercise5();
        //Exercise6();
        Exercise7();
    }

    public static void Exercise1(){
        String string = null;
        try{
            string.equals("Try");
        }catch (NullPointerException e) {
            System.out.println("Найдено nullPoint исключение");
            e.printStackTrace();
        }
    }

    public static void Exercise2(){
        int[] numbers = new int[5];
        try{
            for (int i = 0; i <= numbers.length; i++) {
                System.out.println(numbers[i]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Выход за пределы массива");
            e.printStackTrace();
        }
    }

    public static void Exercise3Checked(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите пароль");
        String password = sc.next();
        System.out.println("Введите пароль повторно");
        String passwordCheck = sc.next();
        sc.close();
        try{
            PasswordChecked(password, passwordCheck);
        }catch (PasswordExeption e){
            e.printStackTrace();
        }
    }

    public static void PasswordChecked(String password, String passwordCheck) throws PasswordExeption{
        if(password.equals(passwordCheck)){
            System.out.println("Всё отлично!");
        }else{
            throw new PasswordExeption("Пароли не одинаковые");
        }
    }

    public static void Exercise4Uncheked() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите пароль");
        String password = sc.next();
        System.out.println("Введите пароль повторно");
        String passwordCheck = sc.next();
        sc.close();
        PasswordUncheked(password, passwordCheck);
    }

    public static void PasswordUncheked(String password, String passwordCheck) throws PasswordRunTimeExeption{
        if(password.equals(passwordCheck)){
            System.out.println("Всё отлично!");
        }else{
            throw new PasswordRunTimeExeption("Пароли не одинаковые");
        }
    }

    public static void Exercise5(){
        try{
            Exercise5_1();
        }catch (MyMathException e){
            e.printStackTrace();
        }
    }

    public static void Exercise5_1() throws MyMathException {
        int number1 = 5;
        int number2 = 0;
        try {
            System.out.println(number1 / number2);
        } catch (Exception e) {
            throw new MyMathException("Причина: " + e);
        }
    }

    public static void Exercise6(){
        int[] numbers = new int[9];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
            System.out.println(numbers[i]);
        }
        try{
            for (int i = 0; i <= numbers.length; i++) {
                int a = numbers[i+1]/numbers[i];
                if(a*10>50){
                    System.out.println(a = Integer.parseInt(null));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void Exercise7(){
        Random random = new Random();
        int number = random.nextInt(1);
        try{
            if(number==1) System.out.println("Normal number");
            else throw new MyMathException("Bad number");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("Выполненние finally происходит всегда в конце, если не будет error");
        }
    }

}
