package lection18_synchronized.dump;

public class Lection18_ThreadSynchro {
    public static void main(String[] args) throws InterruptedException {
        Exercise1();
    }

    public static void Exercise1() throws InterruptedException {
        Scientist scientist1 = new Scientist("Прислужник 1");
        Scientist scientist2 = new Scientist("Прислужник 2");
        Factory factory = new Factory();
        Dump dump = new Dump();
        scientist1.start();
        scientist2.start();
        factory.start();
        dump.start();
        scientist1.join();
        scientist2.join();
        if(scientist1.robots > scientist2.robots){
            System.out.println("Победил ученый номер 1");
        }else if (scientist1.robots == scientist2.robots) {
            System.out.println("Ничья!");
        } else {
            System.out.println("Победил ученый номер 2");
        }
    }
}
