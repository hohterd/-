package lection15_IO_part2;

import java.io.*;
import java.util.Random;

public class Lection15_IO_part2 {
    public static void main(String[] args) {
        Exercise1();
        //Exercise2();
        //Exercise3();
    }

    public static void Exercise1(){
        File file = new File(File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator + "IdeaProjects", "5MBfile.txt");

        TryExercise1 fileNotBuf = new TryExercise1(file);
        TryExercise1 fileBuf = new TryExercise1(file);

        fileNotBuf.notBuf();
        fileBuf.buf();
    }

    public static void Exercise2(){
        try{
            Computer computer = new Computer(5,1);
            computer.serializeComputer(computer);
            computer.deserializeComputer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void Exercise3() {
        try{
            Touchpad touchpad = new Touchpad(true);
            Notebook notebook = new Notebook(8, 3, 100, touchpad, true);
            notebook.serializeComputer(notebook);
            notebook.deserializeComputer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

