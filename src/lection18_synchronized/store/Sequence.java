package lection18_synchronized.store;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
    static int buyersToday = 0;
    static int buyersDone = 0;
    private static List<Buyer> line = new ArrayList<>();
    final static Object lock = new Object();

    static void getInLine (Buyer buyer) {
        synchronized (lock) {
            line.add(buyer);
        }
    }

    public static int size() {
        synchronized (lock) {
            return line.size();
        }
    }

    static Buyer getOutFirst () {
        synchronized (lock) {
            return line.remove(0);
        }
    }
}
