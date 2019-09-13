package lection11_generics;

public class Pair <K,V> {
    private K argument1;
    private V argument2;

    Pair(K argument1,V argument2){
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    public K getArgument1() {
        return argument1;
    }

    public void setArgument1(K argument1) {
        this.argument1 = argument1;
    }

    public V getArgument2() {
        return argument2;
    }

    public void setArgument2(V argument2) {
        this.argument2 = argument2;
    }
}






