package lection17_thread;


public class MyDaemonThread extends Thread{
    MyThread myThread;

    public MyDaemonThread(MyThread myThread){
        super("Поток Daemon | sum: = ");
        setDaemon(true);
        this.myThread = myThread;
    }

    public void run() {
        while(true) {
            try {
                System.out.println(getName() + myThread.getSum());
                MyDaemonThread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
