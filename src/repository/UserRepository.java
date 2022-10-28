package repository;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private ArrayList<User> arrayList = new ArrayList();
    private static final String FILE_PATH = "database.txt";

    public UserRepository() {
        readObjectFromFile();
    }

    public void add(User user) {
        arrayList.add(user);
    }

    public List<User> getAll() {
        return arrayList;
    }

    public void save() {
        writeObjectToFile();
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

}
