package lection14_IO_part1;

import java.io.*;
import java.util.*;

public class Lection14_IO_part1 {
    public static void main(String[] args) {
        //Exercise1();
        //Exercise2();
        //Exercise3();
        //Exercise4();
        //Exercise5();
        Exercise6(File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator + "IdeaProjects");
        //Exercise7();
    }

    public static void Exercise1() {
        File file = new File(File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator + "IdeaProjects", "Exercise1.txt");

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             FileInputStream fileInputStream = new FileInputStream(file)) {

            fileOutputStream.write("So close no matter how far\n".getBytes());
            fileOutputStream.write("Couldn't be much more from the heart\n".getBytes());
            fileOutputStream.write("Forever trusting who we are\n".getBytes());
            fileOutputStream.write("And nothing else matters".getBytes());

            int i;
            while ((i = fileInputStream.read()) >= 0) {
                System.out.print((char) i);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            //System.out.println("\n"+file.delete());
        }
    }

    public static void Exercise2() {
        File file = new File(File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator + "IdeaProjects", "Exercise1.txt");

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int i;
            while ((i = fileInputStream.read()) >= 0) {
                if (Character.isUpperCase(i)) {
                    while (!Character.isWhitespace(i)) {
                        System.out.print((char) i);
                        i = fileInputStream.read();
                    }
                    System.out.println();
                } else ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Exercise3() {
        File file = new File(File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator + "IdeaProjects", "Exercise1.txt");

        int i;
        char temp = 0;
        StringBuilder firstWord = new StringBuilder();
        StringBuilder secondWord = new StringBuilder();
        char nextTemp;
        boolean check = true;

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            while ((i = fileInputStream.read()) >= 0) {
                if (check) {
                    while (!Character.isWhitespace(i) & i != -1) {
                        firstWord.append((char) i);
                        temp = (char) i;
                        i = fileInputStream.read();
                    }
                } else {
                    temp = firstWord.charAt(firstWord.length() - 1);
                }

                if (check) {
                    i = fileInputStream.read();
                    nextTemp = (char) i;
                } else {
                    nextTemp = (char) i;
                }
                while (!Character.isWhitespace(i) & i != -1) {
                    secondWord.append((char) i);
                    i = fileInputStream.read();
                }

                if (Character.toLowerCase(temp) == Character.toLowerCase(nextTemp)) {
                    System.out.println(firstWord + " " + secondWord);
                    firstWord.setLength(0);
                    firstWord.append(secondWord);
                    secondWord.setLength(0);
                    check = false;
                } else {
                    firstWord.setLength(0);
                    firstWord.append(secondWord);
                    secondWord.setLength(0);
                    check = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Exercise4() {
        File file = new File(File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator + "IdeaProjects", "Numbers.txt");
        Map<Integer, Integer> numbersMap = new HashMap<>();
        int counterString = 1;
        int counterNumbers = 0;
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int temp;
            while ((temp = fileInputStream.read()) >= 0) {
                while (temp != '\n' & temp >= 0) {
                    if (Character.isDigit(temp)) {
                        counterNumbers = 0;
                        numbersMap.putIfAbsent(counterString, counterNumbers);
                        while (Character.isDigit(temp)) {
                            temp = fileInputStream.read();
                            counterNumbers++;
                        }
                        if (counterNumbers > numbersMap.get(counterString)) {
                            numbersMap.put(counterString, counterNumbers);
                        }
                    } else {
                        temp = fileInputStream.read();
                    }
                }
                counterString++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<Integer, Integer> pair : numbersMap.entrySet()) {
            System.out.println("Строка " + pair.getKey() + ":" + " наибольше число цифр, идущих подряд " + pair.getValue());
        }
    }

    public static void Exercise5() {
        File file = new File(File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator + "IdeaProjects", "Exercise5.txt");

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
            FileInputStream fileInputStream = new FileInputStream(file)) {
            Random random = new Random();

            int intOutput;
            byte byteOutput;

            for (int i = 0; i < 20; i++) {
                intOutput = random.nextInt(255)+256;
                for (int j = 0; j <= 3; j++) {
                    byteOutput = (byte) (intOutput >> j*8);
                    fileOutputStream.write(byteOutput);
                }
            }
            int input;
            int res;
            while((input = fileInputStream.read()) >= 0){
                res = 0;
                for (int j = 0; j <=3; j++) {
                    res = res | (input << j*8);
                    if (j !=3) {
                        input =fileInputStream.read();
                    }
                }
                System.out.println("Result: "+res);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<File> Exercise6(String directoryName) {
        File directory = new File(directoryName);

        List<File> resultList = new ArrayList<>();
        File[] fileList = directory.listFiles();
        resultList.addAll(Arrays.asList(fileList));
        for (File file : fileList) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                resultList.addAll(Exercise6(file.getAbsolutePath()));
            }
        }
        return resultList;
    }

    public static void Exercise7(){
        File fileJava = new File(File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator + "IdeaProjects", "MyJava.txt");
        File fileNew = new File(File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator + "IdeaProjects", "My.txt");

        try(FileInputStream fileJavaInput = new FileInputStream(fileJava);
            FileOutputStream fileNewOutput = new FileOutputStream(fileNew);
            FileInputStream fileNewInput = new FileInputStream(fileNew)){

            int temp;
            List<Character> list = new ArrayList<>();
            while((temp = fileJavaInput.read()) >= 0){
                list.add((char) temp);
                while(temp != '\n' & temp >= 0){
                    temp = fileJavaInput.read();
                    list.add((char) temp);
                }
                for (int i = list.size()-1; i >= 0; i--) {
                    fileNewOutput.write(list.get(i));
                }
                list.clear();
            }
            System.out.println("Файл с Java-кодом в обратном порядке");
            int sout2;
            while((sout2 = fileNewInput.read()) >= 0){
                System.out.print((char)sout2);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}




