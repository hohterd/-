package lection19_pools;



import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExercise2 extends Thread{
    static int[] array;
    int min;

    ThreadPoolExercise2(){
        array = generateArray();
        this.min = array[0];
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            if(min>array[i]){
                min = array[i];
            }
        }
        long endTime = System.nanoTime();
        System.out.println(String.format("Время выполнения %d наносекунд, минимальный элемент %d", (endTime - startTime), min));
    }

    public int[] generateArray(){
        Random random = new Random();
        int[] array = new int[random.nextInt(1000000)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(300)+1;
        }
        return array;
    }

    public void ThreadTenPools(){
        ExecutorService service = Executors.newFixedThreadPool(10);
        AtomicInteger i = new AtomicInteger();
        long startTime = System.nanoTime();
        for (i.set(1); i.get() < array.length; i.getAndIncrement()) {
            service.submit(() -> {
                if(min>array[i.get()]){
                    min = array[i.get()];
                }
            });
        }
        service.shutdown();
        long endTime = System.nanoTime();
        System.out.println(String.format("Время выполнения %d наносекунд, минимальный элемент %d", (endTime - startTime), min));

    }
}
