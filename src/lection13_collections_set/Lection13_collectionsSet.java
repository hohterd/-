package lection13_collections_set;

import java.util.*;

public class Lection13_collectionsSet {
    public static void main(String[] args) {
        //Exercise1();
        //Exercise2();
        //Exercise3();
        Exercise4();
    }

    public static void Exercise1() {
        List<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.println("Введите 10 целых чисел");
        for (int i = 0; i < 10; i++) {
            x = sc.nextInt();
            list.add(x);
        }
        Set<Integer> unique = new HashSet<>(list);
        countUnique(unique);
    }

    public static void countUnique(Set list) {
        System.out.println(list.size());
    }

    public static void Exercise2() {
        Map<String, String> map = new HashMap<>();
        map.put("Marty", "Stepp");
        map.put("Stuart", "Reges");
        map.put("Jessica", "Miller");
        map.put("Amanda", "Camp");
        map.put("Hal", "Perkins");
        Map<String, String> map2 = new HashMap<>();
        map2.put("Kendrick", "Perkins");
        map2.put("Stuart", "Reges");
        map2.put("Jessica", "Miller");
        map2.put("Amanda", "Reges");
        map2.put("Hal", "Perkins");
        System.out.println(isUnique(map));
        System.out.println(isUnique(map2));
    }

    public static boolean isUnique(Map<String, String> map) {
        Iterator iteratorTemp = map.entrySet().iterator();
        Iterator iteratorCheck = map.entrySet().iterator();
        int counter = 0;
        int innerCounter = 0;
        Map.Entry<String, String> temp;
        Map.Entry<String, String> check;
        while (counter < map.size()) {
            temp = (Map.Entry<String, String>) iteratorTemp.next();
            while (innerCounter < map.size()) {
                check = (Map.Entry<String, String>) iteratorCheck.next();
                if (temp.getValue().equals(check.getValue())) {
                    if (!temp.getKey().equals(check.getKey())) {
                        return false;
                    } else innerCounter++;
                } else innerCounter++;
            }
            counter++;
            innerCounter = 0;
            iteratorCheck = map.entrySet().iterator();
        }
        return true;
    }

    public static void Exercise3() {
        Map<Integer, Integer> polynomialPart1 = new HashMap<>();
        Map<Integer, Integer> polynomialPart2 = new HashMap<>();
        Map<Integer, Integer> result = new HashMap<>();
        StringBuilder polynom = new StringBuilder();
        polynomialPart1.put(4, 3);
        polynomialPart1.put(3, 5);
        polynomialPart1.put(1, 7);
        polynomialPart1.put(0, 5);
        polynomialPart2.put(3, 6);
        polynomialPart2.put(2, -8);
        polynomialPart2.put(0, 7);
        int maxKey = 0;
        for (Integer key : polynomialPart1.keySet()) {
            if (key > maxKey) {
                maxKey = key;
            }
        }
        for (Integer key : polynomialPart2.keySet()) {
            if (key > maxKey) {
                maxKey = key;
            }
        }
        for (int i = maxKey; i >= 0; i--) {
            if (polynomialPart1.get(i) == null) {
                if (polynomialPart2.get(i) == null) {
                    continue;
                }
                result.put(i, polynomialPart2.get(i));
                add(polynom, polynomialPart2.get(i), i);
            } else {
                if (polynomialPart2.get(i) == null) {
                    result.put(i, polynomialPart1.get(i));
                    add(polynom, polynomialPart1.get(i), i);
                } else {
                    result.put(i, polynomialPart1.get(i) + polynomialPart2.get(i));
                    add(polynom, polynomialPart1.get(i) + polynomialPart2.get(i), i);
                }
            }
        }
        if(polynom.charAt(0)=='+'){
            polynom.delete(0,1);
            System.out.println(polynom);
        }else {
            System.out.println(polynom);
        }
    }

    public static StringBuilder add(StringBuilder str, int value, int key){
        if(value >= 0){
            if (key == 1) {
                return str.append("+").append(value).append("x");
            }else if(key == 0){
                return str.append("+").append(value);
            }
            else{
                return str.append("+").append(value).append("x^").append(key);
            }
        }else {
            if (key == 1) {
                return str.append(value).append("x");
            }else if(key == 0){
                return str.append("+").append(value);
            }
            else {
                return str.append(value).append("x^").append(key);
            }
        }
    }

    public static void Exercise4(){
        List<Integer> list = new ArrayList<>(Arrays.asList(15, 20, 30, 2, 5, 71, 9, 8, 23, 56, 6, 82, 150));
        BlackBox blackBox = new BlackBox(list);
        blackBox.getMin(4);
        blackBox.add(178);
        blackBox.getMax(1);

    }
}




