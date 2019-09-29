package lection15_IO_part2;

import java.io.*;

public class Notebook extends Computer {
    private static final long serialVersionUID = 214525L;

    Notebook(int number, int time, int power, Touchpad touchpad, boolean internet) {
        super(number, time);
        this.touchpad = touchpad;
        this.power = power;
        this.internet = internet;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "power=" + power +
                ", internet=" + internet +
                ", touchpad power=" + touchpad.isOn +
                ", touchpad location=" + touchpad.x + " " + touchpad.y +
                ", number=" + number +
                ", time=" + time +
                '}';
    }

    transient int power;
    boolean internet;
    Touchpad touchpad;

    public void serializeNotebook(Notebook notebook) throws IOException {
        FileOutputStream outputStream = new FileOutputStream
                (File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator + "IdeaProjects"+File.separator+"Notebook.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(notebook);
        System.out.println("Сериализация " + notebook.toString());
        objectOutputStream.close();
    }

    public Notebook deserializeNotebook() throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream
                (File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator + "IdeaProjects"+File.separator+"Computer.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Notebook notebook = (Notebook) objectInputStream.readObject();
        System.out.println("Десериализация " + notebook);
        return notebook;
    }
}
