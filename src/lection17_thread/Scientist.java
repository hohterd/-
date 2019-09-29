package lection17_thread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static lection17_thread.Details.*;

public class Scientist extends Thread{
    static Map<Details, Integer> stash = createMap();

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


    Scientist(){
        super("Ученый");
    }

    @Override
    public void run() {
        while(Dump.night<50){
            Random random = new Random();
            getDetails(Dump.getDetails(random.nextInt(4)+1));
            try {
                Scientist.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int limitFactor = stash.get(RIGHT_HAND);
        for(Map.Entry<Details,Integer> pair: stash.entrySet()){
            if(limitFactor<pair.getValue()){
                limitFactor = pair.getValue();
            }
        }
        System.out.println("После 50 ночей было собрано "+ limitFactor +" роботов");
    }

    public static void getDetails(List<Details> list){
        for (int i = 0; i < list.size(); ++i) {
            stash.put(list.get(i),stash.get(list.get(i))+1);
        }
    }

}
