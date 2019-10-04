package lection18_synchronized.store;

import java.util.HashMap;
import java.util.Random;

public class Buyer extends Thread{

    HashMap basket = new HashMap();
    double price = 0;
    double cash = 0;

    Buyer(int num){
        super("Покупатель "+num);
    }

    @Override
    public void run () {
        Random random = new Random();
        System.out.println(getName()+" зашел в магазин.");
        int wish = random.nextInt(Good.values().length);
        if (wish == 0) {
            System.out.println(getName()+" не выбрал ничего и покинул магазин.");
            ++Sequence.buyersDone;
        } else {
            while (basket.size()<wish) {
                chooseGood();
            }
            Sequence.getInLine(this);
            System.out.println(getName()+" встал в очередь (место в очереди "+Sequence.size()+").");
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            payOff();
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(getName()+" получил чек и выходит из магазина.");
            ++Sequence.buyersDone;
        }
    }

    private void think () {
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void chooseGood () {
        Random random = new Random();
        think();
        Good temp = Good.randomGood();
        while (basket.containsKey(temp)) {temp = Good.randomGood();}
        int number = random.nextInt(3)+1;
        basket.put(temp,number);
        System.out.println(getName()+" выбрал товар "+temp.name+" в количестве "+number+".");
    }

    private void payOff () {
        Random random = new Random();
        cash = price*(1 + (double) random.nextInt(20)/100);
        cash = (double) Math.round((cash*100)/100)+1;
        System.out.println(getName()+" передает для оплаты "+cash);
    }
}
