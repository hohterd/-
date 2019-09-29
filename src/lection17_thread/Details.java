package lection17_thread;

import java.security.SecureRandom;
import java.util.List;

public enum Details {
    RIGHT_HAND,
    LEFT_HAND,
    RIGHT_LEG,
    LEFT_LEG,
    BODY,
    HEAD,
    CPU,
    RAM,
    HDD;

    private static final List<Details> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final SecureRandom RANDOM = new SecureRandom();

    public static Details randomDetail()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
