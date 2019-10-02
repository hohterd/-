package lection20_annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class AnalyzeClass {


    public static void analyzeClass(Class clazz) {
        System.out.println("Старт анализа");
        analyzeSuperClass(clazz);
        analyzeName(clazz);
        analyzeInterfaces(clazz);
        analyzeConstructors(clazz);
        analyzeFields(clazz);
        analyzeMethods(clazz);
        System.out.println("Конец анализа");
    }

    public static void analyzeName(Class clazz) {
        System.out.println("Имя класса: " + clazz.getSimpleName());
        System.out.println("-------------------------------------------------------------");
    }

    public static void analyzeSuperClass(Class clazz) {
        System.out.println("-------------------------------------------------------------");
        Class superClass = clazz.getSuperclass();
        if (superClass.getSimpleName() != null) {
            System.out.println("Суперкласс: " + superClass.getSimpleName());
        }
        System.out.println("-------------------------------------------------------------");
    }

    public static void analyzeInterfaces(Class clazz) {
        Class[] interfaces = clazz.getInterfaces();
        if (interfaces.length >= 1) {
            System.out.println("Интерфейсы реализуемые " + clazz.getSimpleName() + ": ");
            for (Class clazzInterface : interfaces) {
                System.out.println(clazzInterface.getSimpleName());
            }
            System.out.println("-------------------------------------------------------------");
        }
        analyzeAnnotations(interfaces);
    }

    public static void analyzeConstructors(Class clazz) {
        Constructor[] constructors = clazz.getConstructors();
        if (constructors.length >= 1) {
            System.out.println("Конструкторы класса " + clazz.getSimpleName() + ": ");
            for (Constructor constructor : constructors) {
                Class[] paramTypes = constructor.getParameterTypes();
                for (Class paramType : paramTypes) {
                    System.out.print(paramType.getSimpleName() + "\n");
                }
                System.out.println();
            }
            System.out.println("-------------------------------------------------------------");
        }
        analyzeAnnotations(constructors);
    }

    public static void analyzeFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length >= 1) {
            System.out.println("Поля класса " + clazz.getSimpleName() + ": \n");
            for (Field field : fields) {
                Class fieldType = field.getType();
                System.out.println("Имя: " + field.getName());
                System.out.println("Тип: " + fieldType.getSimpleName() + "\n");
            }
            System.out.println("-------------------------------------------------------------");
        }
        analyzeAnnotations(fields);
    }


    public static void analyzeMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        if (methods.length >= 1) {
            System.out.println("Методы класса " + clazz.getSimpleName() + ": \n");
            for (Method method : methods) {
                System.out.println("Имя: " + method.getName());
                System.out.println("Возвращаемый тип: " + method.getReturnType().getSimpleName());
                Class[] paramTypes = method.getParameterTypes();
                if (paramTypes.length >= 1) {
                    System.out.print("Типы параметров: ");
                    for (Class paramType : paramTypes) {
                        System.out.print(paramType.getSimpleName());
                    }
                }
                System.out.println("\n");
            }
            System.out.println("-------------------------------------------------------------");
        }
        analyzeAnnotations(methods);
    }

    public static void analyzeAnnotations(Method[] methods){
        for (Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
            if (annotations.length >= 1) {
                System.out.println("Аннотации для методов");
                for (Annotation a : annotations) {
                    System.out.print("@" + a.annotationType().getSimpleName() + " \n");
                }
                System.out.println("-------------------------------------------------------------");
            }
        }
    }

    public static void analyzeAnnotations(Constructor[] constructors){
        for (Constructor constructor: constructors) {
            Annotation[] annotations = constructor.getAnnotations();
            if (annotations.length >= 1) {
                System.out.println("Аннотации для конструкторов");
                for (Annotation a : annotations) {
                    System.out.print("@" + a.annotationType().getSimpleName() + " \n");
                }
                System.out.println("-------------------------------------------------------------");
            }
        }
    }

    public static void analyzeAnnotations(Class[] interfaces){
        for (Class interf: interfaces) {
            Annotation[] annotations = interf.getAnnotations();
            if (annotations.length >= 1) {
                System.out.println("Аннотации для интерфейсов");
                for (Annotation a : annotations) {
                    System.out.print("@" + a.annotationType().getSimpleName() + " \n");
                }
                System.out.println("-------------------------------------------------------------");
            }
        }
    }

    public static void analyzeAnnotations(Field[] fields){
        for (Field field: fields) {
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length >= 1) {
                System.out.println("Аннотации для полей");
                for (Annotation a : annotations) {
                    System.out.print("@" + a.annotationType().getSimpleName() + " \n");
                }
                System.out.println("-------------------------------------------------------------");
            }
        }
    }
}




