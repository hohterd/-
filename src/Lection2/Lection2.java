package Lection2;

import java.util.Scanner;

public class Lection2{
    public static void main(String[] args) {
        //Exercise1();
        //Exercise2();
        //Exercise2_1();
        //Exercise3();
        Exercise4();
    }

    public static void Exercise1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое слово");
        String word1 = sc.next();
        System.out.println("Введите второе слово");
        String word2 = sc.next();
        sc.close();
        if (word1.equals(word2)) {
            System.out.println("Отлично! Слова одинаковы");
        }
        else if (word1.equalsIgnoreCase(word2)) {
            System.out.println("Хорошо. Почти одинаковы");
        }
        else if (word1.length() == word2.length()) {
            System.out.println("Ну, хотя бы они одной длины");
        }
        else {
            System.out.println("Слова полностью отличаются");
        }
    }

    public static void Exercise2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int number = sc.nextInt();
        sc.close();
        if (number%100 == 11 || number%100 == 12 || number%100 == 13 || number%100 == 14){
            System.out.println(number + " Рублей");
        }
        else {
            if (number%10 == 1 ){
                System.out.println(number + " Рубль");
            }
            else if (number%10 == 2 || number%10 == 3 || number%10 == 4){
                System.out.println(number + " Рубля");
            }
            else {
                System.out.println(number + " Рублей");
            }
        }
    }

    public static void Exercise2_1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int number = sc.nextInt();
        sc.close();
        int number2 = number;
        number2 %= 100;
        switch (number2){
            case 11:
            case 12:
            case 13:
            case 14:
                System.out.println(number + " Рублей");
                break;
            default:
                number2 %= 10;
                switch (number2){
                    case 1:
                        System.out.println(number + " Рубль");
                        break;
                    case 2:
                    case 3:
                    case 4:
                        System.out.println(number + " Рубля");
                        break;
                    default:
                        System.out.println(number + " Рублей");
                        break;
                }
        }
    }

    public static void Exercise3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите год");
        int year = sc.nextInt();
        boolean checkYear;
        sc.close();
        if (year%4==0){
            if(year%100==0){
                if (year%400==0){
                    System.out.println(year + " високосный год");
                }
                else{
                    System.out.println(year + " не високосный год");
                }
            }
            else{
                System.out.println(year + " високосный год");
            }
        }
        else{
            System.out.println(year + " не високосный год");
        }
    }

    public static void Exercise4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите день");
        int day = sc.nextInt();
        System.out.println("Введите месяц");
        int month = sc.nextInt();
        System.out.println("Введите год");
        int year = sc.nextInt();
        sc.close();
        if(month>12 || month <=0){
            System.out.println("Нереальная дата");
        }
        else {
            switch(month){
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    if(day<=31 && day>0){
                        System.out.println(day + "." + month + "." + year +" реальная дата");
                        break;
                    }
                    else {
                        System.out.println(day + "." + month + "." + year + " нереальная дата");
                        break;
                    }
                case 2:
                    if(IsLeapYear(year)==true) {
                        if (day <= 29 && day > 0) {
                            System.out.println(day + " февраля " + year + " реальная дата");
                            break;
                        }
                        else {
                            System.out.println(day + " февраля " + year + " нереальная дата");
                            break;
                        }
                    }
                    else {
                        if (day <= 28 && day > 0) {
                            System.out.println(day + " февраля " + year + " реальная дата");
                            break;
                        }
                        else {
                            System.out.println(day + " февраля " + year + " нереальная дата");
                            break;
                        }
                    }
                case 4: case 6: case 9: case 11:
                    if(day<=30 && day>0){
                        System.out.println(day + "." + month + "." + year + " реальная дата ");
                        break;
                    }
                    else {
                        System.out.println(day + "." + month + "." + year + " нереальная дата ");
                        break;
                    }
            }
        }
    }

    public static boolean IsLeapYear(int isleap){
        boolean checkYear;
        if (isleap%4 == 0){
            if( isleap%100 == 0){
                if (isleap%400 == 0){
                    checkYear = true;
                    return checkYear;
                }
                else{
                    checkYear = false;
                    return checkYear;
                }
            }
            else{
                checkYear = true;
                return checkYear;
            }
        }
        else{
            checkYear = false;
            return checkYear;
        }
    }

}

