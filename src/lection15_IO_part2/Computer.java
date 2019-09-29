package lection15_IO_part2;

import java.io.*;

public class Computer implements Serializable {
    private static final long serialVersionUID = 12345L;
    int number;
    int time;

    Computer(int number, int time){
        this.number = number;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "number=" + number +
                ", time=" + time +
                '}';
    }

    public void serializeComputer(Computer computer) throws IOException {
        FileOutputStream outputStream = new FileOutputStream
                (File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator + "IdeaProjects"+File.separator+"Computer.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(computer);
        System.out.println("Сериализация " + computer.toString());
        objectOutputStream.close();
    }

    public Computer deserializeComputer() throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream
                (File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator + "IdeaProjects"+File.separator+"Computer.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Computer computer = (Computer) objectInputStream.readObject();
        System.out.println("Десериализация " + computer);
        return computer;
    }
}
