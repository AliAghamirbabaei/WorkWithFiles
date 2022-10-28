package repository;

import model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private ArrayList<User> arrayList = new ArrayList();
    private static final String FILE_PATH = "database.txt";

    public UserRepository() {
        //readObjectFromFile();
        readLinesFromFile();
    }

    public void add(User user) {
        arrayList.add(user);
    }

    public List<User> getAll() {

        return arrayList;
    }

    public void save() {
        //writeObjectToFile();
        writeLinesToFile();
    }

    public void writeObjectToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(arrayList);
            objectOut.close();
            fileOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void readObjectFromFile() {
        try {
            if (new File(FILE_PATH).exists()) {
                FileInputStream fileIn = new FileInputStream(FILE_PATH);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                arrayList = (ArrayList<User>) objectIn.readObject();
                objectIn.close();
                fileIn.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void writeLinesToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            for (User user : arrayList) {
                osw.write(user.getName() + "-" + user.getPhone()+"\n");
            }
            osw.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readLinesFromFile() {
        try {
            if (new File(FILE_PATH).exists()) {
                List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
                String name;
                String phone;
                for (String line : lines) {
                    String[] splited = line.split("-");
                    name = splited[0];
                    phone = splited[1];
                    arrayList.add(new User(name, phone));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
