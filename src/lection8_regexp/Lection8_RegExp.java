package lection8_regexp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lection8_RegExp {
    public static void main(String[] args) {
        //Exercise1();
        //Exercise2();
        //Exercise3();
        //Exercise4();
        Exercise5();
    }

    public static void Exercise1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите почтовый ящик: ");
        String mail = sc.nextLine();
        sc.close();
        Pattern patternMail = Pattern.compile("^[a-z]\\w+@{1}[a-z0-9-]+\\.org$|^[a-z]\\w+@{1}[a-z0-9-]+\\.com$" , Pattern.CASE_INSENSITIVE);
        if (mail.matches(String.valueOf(patternMail))){
            System.out.println("Почтовый ящик ".concat(mail.concat(" верный")));
        }
        else{
            System.out.println("Почтовый ящик ".concat(mail.concat(" неверный")));
        }
    }

    public static void Exercise2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String stringHex = sc.nextLine();
        sc.close();
        Pattern hexNumbers = Pattern.compile("\\b0x[a-f0-9]+\\b",Pattern.CASE_INSENSITIVE);
        Matcher checkHex = hexNumbers.matcher(stringHex);
        while(checkHex.find()){
            System.out.println(checkHex.group());
        }
    }

    public static void Exercise3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = sc.nextLine();
        sc.close();
        Pattern checkText = Pattern.compile("<p\\s.+?>|<p>");
        Matcher tagText = checkText.matcher(text);
        StringBuilder tempTag = new StringBuilder();
        int counter1 = 0;
        int counter2 = 0;
        while(tagText.find()){
            if(tagText.group().equals("<p>")){
                counter1++;
            }
            else{
                tagText.appendReplacement(tempTag, "<p>");
                tagText.appendTail(tempTag);
                counter2++;
            }
        }
        tagText.appendTail(tempTag);
        System.out.println(tempTag);
        System.out.println("Найдено обычных тегов <p>: ".concat(String.valueOf(counter1)).concat(", найдено и заменено параметрезированных тегов <p>: ").concat(String.valueOf(counter2)));
    }


    public static void Exercise4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String stringMob = sc.nextLine();
        sc.close();
        Pattern checkNumbers = Pattern.compile("(\\+{1}375)([0-9]{2})([0-9]{3})([0-9]{2})([0-9]{2})");
        Matcher checkMob = checkNumbers.matcher(stringMob);
        StringBuilder tempMob = new StringBuilder();
        while (checkMob.find()){
            checkMob.appendReplacement(tempMob, "$1 ($2) $3-$4-$5");
        }
        checkMob.appendTail(tempMob);
        System.out.println(tempMob);
    }

    public static void Exercise5(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String checkIP = sc.nextLine();
        sc.close();
        Pattern patternIP = Pattern.compile("\\b[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$");
        Matcher matcherIP = patternIP.matcher(checkIP);
        if(matcherIP.find()){
            String[] adressIP = checkIP.split("[.]");
            for (int i = 0; i < adressIP.length; i++) {
                if (Integer.parseInt(adressIP[i]) > 255) {
                    System.out.println(checkIP.concat(" адрес IPv4 не правильный"));
                    break;
                }
                else if(Integer.parseInt(adressIP[i]) < 10 & adressIP[i].length()>1){
                    System.out.println(checkIP.concat(" адрес IPv4 не правильный"));
                    break;
                }
                else if(Integer.parseInt(adressIP[i]) > 10 & Integer.parseInt(adressIP[i]) < 99 & adressIP[i].length()>2){
                    System.out.println(checkIP.concat(" адрес IPv4 не правильный"));
                    break;
                }
                else if (i == adressIP.length-1){
                    System.out.println(checkIP.concat(" адрес IPv4 правильный"));
                }
            }
        }
        else{
            System.out.println(checkIP.concat(" адрес IPv4 не правильный"));
        }
    }



}
