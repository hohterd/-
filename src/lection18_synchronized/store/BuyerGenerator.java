package lection18_synchronized.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuyerGenerator extends Thread{

    @Override
    public void run () {
        List<Buyer> buyers = new ArrayList<>();
        Random random = new Random();
        System.out.println("Магазин открывается.");
        int num = 1;
        Sequence.buyersToday = random.nextInt(10)+10;
        while (num<=Sequence.buyersToday) {
            buyers.add(new Buyer(num));
            buyers.get(buyers.size()-1).start();
            ++num;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Двери магазина закрываются (покупателей только выпускают).");

    }

}
