package lection20_annotations;


import java.lang.reflect.Method;

import static lection20_annotations.AnalyzeClass.analyzeClass;

public class Lection20_annotations {
    public static void main(String[] args) {
        Exercise1();
        //Exercise2();
    }

    public static void Exercise1(){
        TransactionalClass transactionalClass = new TransactionalClass();
        try {
            Method method = transactionalClass.getClass().getMethod("transactionMethod");
            TransactionalClass.ifTransaction(method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void Exercise2()  {
        Class clazz = TransactionalClass.class;
        analyzeClass(clazz);
    }

}
