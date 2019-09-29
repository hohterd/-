package lection15_IO_part2;

import java.io.Serializable;

public class Touchpad implements Serializable {
    transient boolean isOn;
    double x;
    double y;

    Touchpad(boolean on){
        this.isOn = on;
        x = 0.0;
        y = 0.0;
    }
}
