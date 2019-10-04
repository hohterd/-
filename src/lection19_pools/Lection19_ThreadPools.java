package lection19_pools;


public class Lection19_ThreadPools {
    public static void main(String[] args) {
        Exercise1();
        //Exercise2();
    }


    public static void Exercise1(){
        ThreadPoolExercise1 thread = new ThreadPoolExercise1();
        thread.start();

    }

    public static void Exercise2(){
        ThreadPoolExercise2 threadOnePool = new ThreadPoolExercise2();
        ThreadPoolExercise2 threadTenPool = new ThreadPoolExercise2();
        threadOnePool.start();
        threadTenPool.ThreadTenPools();
    }

}
