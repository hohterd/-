package lection12_collections_list;

import java.util.*;

import static lection12_collections_list.Stack.nextMove;
import static lection12_collections_list.Stack.test;

public class Lection12_Collections {
    public static void main(String[] args) {
        Exercise1();
        //Exercise2();
        //Exercise3();
        //Exercise4();
        //Exercise5();
        //Exercise6();
        //Exercise7();
    }

    public static void Exercise1() {
        List<Integer> marks = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 24; i++) {
            marks.add(random.nextInt(10) + 1);
        }
        System.out.print(marks);
        for (ListIterator<Integer> iterator = marks.listIterator(); iterator.hasNext(); ) {
            if (iterator.next() < 4) {
                iterator.remove();
            }
        }
        System.out.println("\n" + marks);
    }


    public static void Exercise2() {
        List<Integer> marks = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 24; i++) {
            marks.add(random.nextInt(10) + 1);
        }
        System.out.println(marks);
        Integer max = marks.get(0);
        ListIterator<Integer> iterator = marks.listIterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next > max) {
                max = next;
            }
        }
        System.out.println("\n" + max);
    }

    public static void Exercise3() {
        List<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Jack");
        names.add("Brad");
        ListIterator<String> listIterator = names.listIterator();
        System.out.println(names);
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        System.out.println("Способ первый через ListIterator");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        System.out.println("Способ второй через fori");
        for (int i = names.size()-1; i >= 0; i--) {
            System.out.println(names.get(i));
        }
    }

    public static void Exercise4(){
        Scanner sc = new Scanner(System.in);
        nextMove(test());
        sc.close();
    }

    public static void Exercise5(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое множество целых чисел");
        String string = sc.nextLine();
        List<Integer> multiple1 = getMultiple(string);
        System.out.println("Введите второе множество целых чисел для проверки");
        String string2 = sc.nextLine();
        sc.close();
        List<Integer> multiple2 = getMultiple(string2);
        getIntersections(multiple1, multiple2);
        getCombination(multiple1, multiple2);
    }

    public static List getMultiple(String string){
        String[] stringParts = string.split(" ");
        List <Integer> multiple;
        return multiple = new LinkedList(Arrays.asList(stringParts));
    }

    public static void getIntersections(List multiple, List multiple2){
        List<Integer> intersection = multiple;
        intersection.retainAll(multiple2);
        System.out.println("Пересечения двух множеств" + intersection);
    }

    public static void getCombination(List multiple, List multiple2){
        multiple.removeAll(multiple2);
        multiple.addAll(multiple2);
        System.out.println("Объединение двух множеств" + multiple);
    }

    public static void Exercise6(){
        Map<String, Integer> frequency_dictionary = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст");
        String text = sc.nextLine();
        for (String word : text.replaceAll("[^а-яА-Яa-zA-Z ]", "").toLowerCase().split("\\s+")) {
            Integer frequency = frequency_dictionary.get(word);
            frequency_dictionary.put(word, frequency == null ? 1 : frequency +1);
        }
        for(Map.Entry<String, Integer> pair : frequency_dictionary.entrySet()) {
            System.out.println(pair.getKey()+"\t"+pair.getValue());
        }
    }


    public static void Exercise7(){
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            numbers.add(random.nextInt(50)-30);
        }
        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);
    }


}
