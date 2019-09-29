package lection17_thread;

public class Lection17_Thread {
    public static void main(String[] args) {
        //Exercise1();
        Exercise2();
    }



    public static void Exercise1(){
        MyThread myThread = new MyThread();
        MyDaemonThread myDaemonThread = new MyDaemonThread(myThread);
        myThread.start();
        myDaemonThread.start();
    }

    public static void Exercise2(){
        Scientist scientist = new Scientist();
        Factory factory = new Factory();
        Dump dump = new Dump();
        scientist.start();
        factory.start();
        dump.start();
    }


}


