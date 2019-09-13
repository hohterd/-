package lection11_generics;

public final class PairUtil {
    public static <K, V> Pair swap(Pair <K, V> arg){
        K temp = arg.getArgument1();
        arg.setArgument1((K) arg.getArgument2());
        arg.setArgument2((V) temp);
        return arg;
    }
}

