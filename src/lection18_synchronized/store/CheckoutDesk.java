package lection18_synchronized.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CheckoutDesk extends Thread {
    private Buyer currentBuyer;

    CheckoutDesk(int num){
        super("Касса "+num);
    }

    @Override
    public void run() {
        Random random = new Random();
        while (Sequence.buyersDone < Sequence.buyersToday | Sequence.buyersToday == 0) {
            if (Sequence.size() == 0) {
                try {
                    sleep(random.nextInt(100)+50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                currentBuyer = Sequence.getOutFirst();
                System.out.println(currentBuyer.getName() + " проходит на " + getName() + ".");
                currentBuyer.price = calculateCost(currentBuyer.basket);
                synchronized (currentBuyer) {
                    currentBuyer.notify();
                }
                while (currentBuyer.cash == 0) {
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Receipt receipt = formReceipt(currentBuyer.basket, currentBuyer.cash);
                ReceiptArchive.add(receipt);
                receipt.print();
                synchronized (currentBuyer) {
                    currentBuyer.notify();
                }
            }

        }
    }

    private double calculateCost(Map<Good, Integer>  basket) {
        double sum = 0;
        for (Map.Entry<Good, Integer> good : basket.entrySet()) {
            sum += good.getKey().price * good.getValue() * (1-good.getKey().discount);
            System.out.println(getName()+" пробивает "+good.getKey().name+" ("+good.getValue()+" шт.) по "+good.getKey().price+" (скидка "+(double) Math.round(good.getKey().discount*10000)/100+"%)");
            }
        sum = (double) Math.round(sum * 100) / 100;
        System.out.println(getName()+": общая стоимость товаров для "+currentBuyer.getName()+" с учетом скидки "+sum);
        return sum;
    }

    private Receipt formReceipt (Map<Good, Integer>  basket, double cash) {
        List<Item> items = new ArrayList<>();
        int no = 1;
        for (Map.Entry<Good, Integer> good : basket.entrySet()) {
            Item currentItem = new Item(no, good.getKey(), good.getValue());
            items.add(currentItem);
            ++no;
        }
        return new Receipt(Integer.parseInt(this.getName().substring(this.getName().length()-1)),items,currentBuyer.price,(double) Math.round((cash-currentBuyer.price)*100)/100);
    }
}
