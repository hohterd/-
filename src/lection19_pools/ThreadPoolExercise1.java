package lection19_pools;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExercise1 extends Thread {

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        int next;
        System.out.println("Введите целое число");
        while((next = sc.nextInt())!=-1){
            ScheduledExecutorService thread = Executors.newSingleThreadScheduledExecutor();
            int finalNext = next;
            thread.schedule(() -> System.out.printf("Я спал %d секунд%n", finalNext), next, TimeUnit.SECONDS);
            System.out.println("Введите целое число");
            thread.shutdown();
        }
        System.out.println("Ввод завершен");
    }


}
