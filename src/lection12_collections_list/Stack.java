package lection12_collections_list;


import java.util.*;

public class Stack {
    int size;
    String number;
    List<Integer> stackNumber;

    Stack(String number){
        this.number = number;
        char[] n = this.number.toCharArray();
        Integer[] n2 = new Integer[n.length];
        for (int i = 0; i < n2.length; i++) {
            n2[i] = Character.getNumericValue(n[i]);
        }
        this.size = 30;
        this.stackNumber = new LinkedList<>(Arrays.asList(n2));
    }

    /*List<String> list = new LinkedList<>(Arrays.asList(split));*/

    Stack(String number, int size){
        if(number.length() > size){
            throw new StackException("Заданное значение ".concat(number).concat(" превышает заданный размер стека"));
        }
        this.size = size;
        this.number = number;
        char[] n = this.number.toCharArray();
        Integer[] n2 = new Integer[n.length];
        for (int i = 0; i < n2.length; i++) {
            n2[i] = Character.getNumericValue(n[i]);
        }
        this.stackNumber = new LinkedList<>(Arrays.asList(n2));
    }

    int takeNumber(int takeNumber){
        ListIterator<Integer> listIterator = stackNumber.listIterator();
        while(listIterator.hasNext()){
            Integer temp = listIterator.next();
            if(temp==takeNumber){
                System.out.println("Цифра ".concat(String.valueOf(temp)).concat(" найдена и извлечена"));
                return temp;
            }
            else if(!listIterator.hasNext()){
                throw new StackException("Такой цифры в стеке нет");
            }
        }
        return 0;
    }

    void addNumber(int number){
        if(this.size <= stackNumber.size()){
            throw new StackException("Размер стека полон, невозможно добавить");
        }
        else {
            stackNumber.add(number);
            System.out.println(stackNumber);
        }
    }

    void addNumber(int index, int number) throws ArrayIndexOutOfBoundsException{
        if(index > stackNumber.size()){
            throw new ArrayIndexOutOfBoundsException("Такого элемента нет");
        }
        else if(this.size <= stackNumber.size()){
            throw new StackException("Размер стека полон, невозможно добавить");
        }
        else {
            stackNumber.add(index, number);
            System.out.println(stackNumber);
        }
    }

    void reverseCout(){
        ListIterator<Integer> listIterator = stackNumber.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        System.out.print("Вывод числа в обратном порядке: \n");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous());
        }
        System.out.print("\n");
    }

    public static Stack test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Программа тестирования стека. Введите число");
        String number = sc.next();
        System.out.println("Вы хотите задать размер стека? Нет(0), Да(1)");
        int check = sc.nextInt();
        Stack stack;
        if(check == 0){
            stack = new Stack(number);
        }
        else if(check == 1){
            System.out.println("Введите размер стека");
            int size = sc.nextInt();
            stack = new Stack(number, size);
        }
        else {
            throw new StackException("Неправильный ввод, ожидалось 0 или 1");
        }
        return stack;
    }

    public static void nextMove(Stack stack){
        Scanner sc = new Scanner(System.in);
        System.out.println("Доступны операции над стеком: обратный вывод(0), извлечение цифры из стека(1), добавление цифры в стек(2)");
        int input = sc.nextInt();
        if(input == 0){
            stack.reverseCout();
        }
        else if (input == 1){
            System.out.println("Введите цифру для извлечения");
            int takeNumber = sc.nextInt();
            stack.takeNumber(takeNumber);
        }
        else if (input == 2){
            stackadd(stack);
        }
        else{
            throw new StackException("Неправильный ввод, ожидалось 0, 1 или 2");
        }
    }

    public static void stackadd(Stack stack){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите цифру для добавления в стек");
        int addNumber = sc.nextInt();
        System.out.println("Добавить цифру в конец стека(0) или по индексу(1)");
        int bool = sc.nextInt();
        if(bool == 0){
            stack.addNumber(addNumber);
        }
        else if (bool == 1) {
            System.out.println(stack.stackNumber);
            System.out.println("Куда вы хотите добавить цифру, где первая цифра стека имеет индекс 1, а последняя " + stack.stackNumber.size());
            int index = sc.nextInt();
            try {
                stack.addNumber(index, addNumber);
            }catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }
        else{
            throw new StackException("Неправильный ввод, ожидалось 0 или 1");
        }
    }
}
