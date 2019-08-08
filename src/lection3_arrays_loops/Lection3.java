package lection3_arrays_loops;

import java.util.Random;
import java.util.Scanner;

public class Lection3 {

    public static void main(String[] args) {
        Exercise1();
        //Exercise2();
        //Exercise3();
        //Exercise4();
        //Exercise5();
        //Exercise6();
        //Exercise7();
        //Exercise8();
        //Exercise9();
        //Exercise10While();
        //Exercise10For();
    }

    public static void Exercise1() {
        int array[] = new int[]{1, 2, 3, 4, 5, 7, 10, 12};
        for (int value : array) {
            System.out.println(value);
        }
        int j = array.length - 1;
        do {
            System.out.println(array[j]);
            --j;
        } while (j >= 0);
    }

    public static void Exercise2() {
        int naturalNumbers[] = new int[100];
        for (int counter = 0; counter < naturalNumbers.length; counter++) {
            for (int number = 1; counter < naturalNumbers.length; number++) {
                if (number % 13 == 0) {
                    naturalNumbers[counter] = number;
                    counter++;
                } else if (number % 17 == 0) {
                    naturalNumbers[counter] = number;
                    counter++;
                }
            }
        }
        for (int i = 0; i < naturalNumbers.length; i++) {
            System.out.println(naturalNumbers[i]);
        }
    }

    public static void Exercise3() {
        int numbers[] = new int[5];
        int result = 0;
        numbers[0] = 0;
        numbers[numbers.length - 1] = 9;
        for (int i = 1; i < numbers.length - 1; i++) {
            Random random = new Random();
            int chislo = random.nextInt(10);
            numbers[i] = chislo;
        }
        for (int counter = 0; counter < numbers.length; counter++) {
            if (numbers[counter] == 0) {
                while (numbers[counter] != 9) {
                    result += numbers[counter];
                    ++counter;
                }
                continue;
            } else continue;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+"\t");
        }
        System.out.println("\n"+result);
    }

    public static void Exercise4() {
        Random random = new Random();
        int arrayNumbers[] = new int[3];
        for (int i = 0; i < arrayNumbers.length; i++) {
            int number = random.nextInt(90);
            number += 10;
            arrayNumbers[i] = number;
            System.out.println(arrayNumbers[i]);
        }
        for (int check = 1; check < arrayNumbers.length; check++) {
            if (arrayNumbers[check - 1] > arrayNumbers[check]) {
                System.out.println("Это не строго возрастающая последовательность");
                break;
            } else if (check == arrayNumbers.length - 1) {
                System.out.println("Это строго возрастающая последовательность");
            } else continue;
        }
    }

    public static void Exercise5() {
        int butterfly[][] = new int[][]
                {
                        {1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 0},
                        {0, 0, 1, 0, 0},
                        {0, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1}
                };
        for (int i = 0; i < butterfly.length; i++) {
            for (int j = 0; j < butterfly.length; j++) {
                if (butterfly[i][j] == 1) {
                    System.out.print("*" + "\t");
                } else System.out.print(" " + "\t");
            }
            System.out.println();
        }
    }

    public static void Exercise6() {
        int arrayComparsion1[][] = new int[3][3];
        int arrayComparsion2[][] = new int[3][3];
        Random random = new Random();
        for (int i = 0; i < arrayComparsion1.length; i++) {
            for (int j = 0; j < arrayComparsion1.length; j++) {
                int number1 = random.nextInt(6);
                arrayComparsion1[i][j] = number1;
            }
        }
        for (int i = 0; i < arrayComparsion2.length; i++) {
            for (int j = 0; j < arrayComparsion2.length; j++) {
                int number1 = random.nextInt(5);
                arrayComparsion2[i][j] = number1;
            }
        }
        for (int i = 0; i < arrayComparsion1.length; i++) {
            for (int j = 0; j < arrayComparsion1.length; j++) {
                if(arrayComparsion1[i][j]==arrayComparsion2[i][j]){
                    System.out.println("Элементы массивов равны");
                }
                else System.out.println("Элемент массивов не равны");
            }
        }
    }

    public static String Exercise7(){
        Random random = new Random();
        String deckSuit[] = new String[]{"Hearts", "Spades", "Clubs", "Diamonds"};
        String deckValue[] = new String[]{"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
        int suit = random.nextInt(4);//4
        int value = random.nextInt(13);//14
        //System.out.println(deckValue[value]+" of "+deckSuit[suit]);
        return deckValue[value]+" of "+deckSuit[suit];
    }

    public static void Exercise8() {
        String deckShuffle[] = new String[52];
        boolean duplicate = false;
        int counter = 0;
        while(counter !=52){
            String card = Exercise7();
            duplicate = false;
            for (int i = 0; i < deckShuffle.length; i++) {
                if(card.equals(deckShuffle[i])) {
                    duplicate = true;
                }
            }
            if (!duplicate){
                deckShuffle[counter] = card;
                ++counter;
            }
        }
        for (String deck : deckShuffle) {
            System.out.println(deck);
        }
    }

    public static void Exercise9(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int number = sc.nextInt();
        sc.close();
        boolean ifNotSimple = false;
        for (int check = 2; check < number; check++) {
            if(number%check==0){
                ifNotSimple = true;
                break;
            }
        }
        if(ifNotSimple){
            System.out.println("Число составное");
        }
        else {
            System.out.println("Число простое");
        }
    }

    public static void Exercise10While(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int factorial = sc.nextInt();
        sc.close();
        int counter = factorial;
        while(counter>1){
            factorial *=counter-1;
            counter -= 1;
        }
        System.out.println(factorial);
    }

    public static void Exercise10For(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int factorial = sc.nextInt();
        sc.close();
        for (int count = factorial-1; count > 0; count--) {
            factorial *= count;
        }
        System.out.println(factorial);
    }

}
