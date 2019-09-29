package lection16_lambdas;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lection16_lambdas {
    public static void main(String[] args) {
        Exercise1();
        Exercise2();
        Exercise3();
        Exercise4();
        Exercise5();
    }

    public static void Exercise1() {
        List<Integer> numbers =  Stream.of(15,20,67,84,26,95,21,253,5).
                filter(numb -> numb%2!=0).filter(numb -> numb%5==0).collect(Collectors.toList());
        ListIterator<Integer> listIterator = numbers.listIterator();
        int sum = 0;
        while(listIterator.hasNext()){
            sum += listIterator.next();
        }
        System.out.println(sum/numbers.size());
    }

    public static void Exercise2(){
        StringValidator strings = (list) -> {
            Set<String> set = new HashSet<>(list);
            Iterator<String> iterator = set.iterator();
            int quantity = 0;
            while(iterator.hasNext()){
                if(iterator.next().length()>=8){
                    quantity++;
                }
            }
            return quantity;
        };
        System.out.println(strings.checkString(Arrays.asList("Опять понедельник",
                "Вторник", "Среда..", "Четверг, уже почти!",
                "Ура, пятница!!", "Ой, суббота", "Воскресенье:(")));
    }

    public static void Exercise3(){
        StringMapValidator mapValidator = (map) ->  {
            int sum =0;
            for (Map.Entry<String, Integer> pair: map.entrySet()) {
                if(pair.getKey().length() < 7){
                    sum += pair.getValue();
                }
            }
            return sum;
        };
        Map<String, Integer> map = new HashMap<>();
        map.put("Один", 1); map.put("Шестьсот", 600);
        map.put("Пятнадцать", 15); map.put("Девять", 9);
        map.put("Десять", 10); map.put("Двадцать три", 23);
        map.put("Пять", 5); map.put("Сто", 100);
        System.out.println(mapValidator.sumKey(map));
    }

    public static void Exercise4(){
        IntegerToString intgerToString = (list) -> {
            StringBuilder stringBuilder = new StringBuilder();
            ListIterator listIterator = list.listIterator();
            while(listIterator.hasNext()){
                stringBuilder.append(listIterator.next());
            }
            return stringBuilder;
        };
        System.out.println(intgerToString.concat(Arrays.asList(1,5,10,15,20,25)));
    }

    public static void Exercise5(){
        List<Person> persons = Arrays.asList(new Person("Sergey", "Korolyov", 22),
                new Person("Dmitry", "Babitsky", 30), new Person("Maksim", "Dubinets", 25),
                new Person("Alexander", "Mytnik", 20), new Person("Abdulmanapkhabib", "Nurmagomedov", 30));
        List<Person> person = persons.stream()
                            .filter(p -> p.firstName.length()<=15)
                            .sorted(Comparator.comparingInt(Person::getAge).reversed())
                            .collect(Collectors.toList());

        System.out.println(person.get(0).firstName +" "+person.get(0).lastName);
    }

}