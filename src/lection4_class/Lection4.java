package lection4_class;


import java.util.Scanner;

public class Lection4 {
    public static void main(String[] args) {
        //Exercise1();
        Exercise2();
    }

    public static class TimeShift{
        int seconds = 0;
        int minutes = 0;
        int hours = 0;

        public int howMuchSeconds(){
            return seconds + (minutes*60)+(hours*3600);
        }

        public TimeShift(int seconds){
            this.seconds = seconds%60;
            this.minutes = (seconds%3600)/60;
            this.hours = seconds/3600;
        }

        public TimeShift(int seconds, int minute, int hours){
            this.seconds = seconds;
            this.minutes = minute;
            this.hours = hours;
        }

        public void systemOut(){
            System.out.println("Время: " + "часов = " + this.hours + ", минут = " + this.minutes + ", секунд = " + this.seconds);
        }
    }

    public static void Exercise1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите секунды, минуты, часы");
        int seconds = sc.nextInt();
        int minutes = sc.nextInt();
        int hours = sc.nextInt();
        TimeShift showTimeSecMinHours = new TimeShift(seconds,minutes,hours);
        System.out.println("Тест метода получения общего количсетва секунд | Секунды = " + showTimeSecMinHours.howMuchSeconds());
        System.out.println("Введите общее количество секунд");
        int seconds2 = sc.nextInt();
        sc.close();
        TimeShift showTimeSeconds = new TimeShift(seconds2);
        System.out.println("Тест метода вывода данных:");
        showTimeSeconds.systemOut();
    }

    public static class ATM{

        int quantity_20 = 0;
        int quantity_50 = 0;
        int quantity_100 = 0;

        public void adding20(int value20){
            this.quantity_20 = this.quantity_20 + value20;
        }

        public void adding50(int value50){
            this.quantity_50 = this.quantity_50 + value50;
        }

        public void adding100(int value100){
            this.quantity_100 = this.quantity_100 + value100;
        }

        boolean takingOffMoney(int moneyPay) {
            int taking20 = 0;
            int taking50 = 0;
            int taking100 = 0;
            int reserved50 = 0;
            if (moneyPay % 10 == 0) {
                if (moneyPay % 20 != 0) {
                    if (this.quantity_50 == 0) {
                        System.out.println("Невозможно выдать сумму номиналами 100, 50, 20 (нет 50)");
                        return false;
                    } else {
                        reserved50 += 1;
                        moneyPay -= reserved50 * 50;
                    }
                }
                if (moneyPay / 100 <= this.quantity_100) {
                    taking100 = moneyPay / 100;
                    moneyPay -= taking100 * 100;
                } else {
                    taking100 = this.quantity_100;
                    moneyPay -= taking100 * 100;
                }
                if ((moneyPay / 100)*2 <= this.quantity_50-reserved50) {
                    taking50 = (moneyPay / 100)*2;
                    moneyPay -= taking50 * 50;
                } else {
                    taking50 = ((this.quantity_50-reserved50)/2)*2;
                    moneyPay -= taking50 * 50;
                }
                if (moneyPay / 20 <= this.quantity_20) {
                    taking20 = moneyPay / 20;
                    moneyPay -= taking20 * 20;
                    System.out.println("Выдано номиналом 100: " + taking100 + ", номиналом 50: " + (int)(taking50+reserved50) + ", номиналом 20: " + taking20);
                    return true;
                } else {
                    System.out.println("Недостаточно средств в банкомате");
                    return false;
                }
            } else {
                System.out.println("Невозможно выдать сумму номиналами 100, 50, 20");
                return false;
            }
        }

        public ATM(int value20, int value50, int value100){
            this.quantity_20 = value20;
            this.quantity_50 = value50;
            this.quantity_100 = value100;
        }
    }


    public static void Exercise2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите нужную сумму");
        int money = sc.nextInt();
        sc.close();
        ATM myTry = new ATM (20,20,20);
        myTry.takingOffMoney(money);
    }
}
