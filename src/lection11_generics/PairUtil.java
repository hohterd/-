package lection11_generics;

public final class PairUtil {
    public static <V, K> Pair<K, V> swap(Pair <K, V> arg){
        return new <V,K> Pair(arg.getArgument2(), arg.getArgument1());
    }
}

