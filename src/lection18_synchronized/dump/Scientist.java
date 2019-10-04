package lection18_synchronized.dump;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static lection18_synchronized.dump.Details.*;
public class Scientist extends Thread{
    Map<Details, Integer> stash = createMap();
    int robots;

    private static Map<Details, Integer> createMap() {
        Map<Details, Integer> myMap = new HashMap<>();
        myMap.put(RIGHT_HAND,0);
        myMap.put(RIGHT_LEG,0);
        myMap.put(LEFT_HAND,0);
        myMap.put(LEFT_LEG,0);
        myMap.put(BODY,0);
        myMap.put(HEAD,0);
        myMap.put(CPU,0);
        myMap.put(RAM,0);
        myMap.put(HDD,0);
        return myMap;
    }


    Scientist(String name){
        super(name);
    }

    @Override
    public void run() {
        while(Dump.night<100){
            Random random = new Random();
            getDetails(Dump.getDetails(random.nextInt(4)+1));
            try {
                Scientist.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            int limitFactor = stash.get(RIGHT_HAND);
            for (Map.Entry<Details, Integer> pair : stash.entrySet()) {
                if (pair.getValue() < limitFactor) {
                    limitFactor = pair.getValue();
                }
            }
            robots = limitFactor;
            System.out.println("После 100 ночей " + getName() + " собрал " + robots + " роботов");
        }

    public synchronized void getDetails(List<Details> list){
        for (int i = 0; i < list.size(); ++i) {
            stash.put(list.get(i),stash.get(list.get(i))+1);
        }
    }

}
