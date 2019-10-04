package lection18_synchronized.store;

import java.util.ArrayList;
import java.util.List;

public class ReceiptArchive {
    private static List<Receipt> archive = new ArrayList<>();
    private final static Object lock = new Object();

    static void add(Receipt receipt) {
        synchronized (lock) {
            archive.add(receipt);
        }
    }

    static int size() {
        synchronized (lock) {
            return archive.size();
        }
    }
}
