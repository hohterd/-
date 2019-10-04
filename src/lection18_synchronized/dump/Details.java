package lection18_synchronized.dump;

import java.util.List;
import java.util.Random;

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
    private static final Random RANDOM = new Random();

    public static Details randomDetail()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
