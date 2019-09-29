package lection17_thread;


public class MyThread extends Thread{
    private long sum = 0L;

    public long getSum() {
        return sum;
    }

    public void run() {
        System.out.println("Начало суммирования");
        for (int i = 1; i <= 10000000; i++) {
            if(i%2==0){
                if (i%3==0){
                    this.sum += i;
                }
            }
            if(i%1000000==0){
                try {
                    System.out.println("Поток суммирования засыпает на 10 мс");
                    MyThread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("Поток суммирования просыпается");
                }
            }
        }
        System.out.println("Конец потока суммирования");
    }
}
