package lection20_annotations;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Data
@NoArgsConstructor
public class TransactionalClass {
    private int sumForTransfer;
    private int sumToTransfer;

    TransactionalClass(int sumForTransfer, int sumToTransfer){
        this.sumForTransfer = sumForTransfer;
        this.sumToTransfer = sumToTransfer;
    }

    @Transaction
    public static void transactionMethod() throws NoSuchMethodException {
        System.out.println("Transcation Method");
    }

    public static void notTransactionMethod(){
        System.out.println("Not transaction method");
    }

    public static void ifTransaction(Method method){
        Annotation[] annotation = method.getAnnotations();
        for(Annotation anno: annotation){
            if(anno instanceof Transaction){
                System.out.println("Transaction is started");
                try{
                    method.invoke(new Object());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println("Transaction is ended");
                break;
            }
        }
    }
}
