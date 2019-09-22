package lection13_collections_set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlackBox {
    private List<Integer> numbers = new ArrayList();

    BlackBox(List list){
        numbers = list;
    }

    public void add(int number){
        numbers.add(number);
    }

    public int getMin(int index){
        Collections.sort(numbers);
        System.out.println(numbers.get(index-1));
        return numbers.get(index-1);
    }

    public int getMax(int index){
        numbers.sort(Collections.reverseOrder());
        System.out.println(numbers.get(index-1));
        return numbers.get(index-1);
    }
}
