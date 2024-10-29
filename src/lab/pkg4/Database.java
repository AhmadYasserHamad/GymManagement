/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.util.*;
import java.io.*;

/**
 *
 * @author ahmadyasserhamad
 */
public abstract class Database<T extends BaseClass> {

    private String filename;
    private ArrayList<T> records = new ArrayList<>();

    public Database(String filename) {
        this.filename = filename;
        readFromFile();
    }

    public void readFromFile() {
        try {
            File file = new File(filename);
            Scanner fileContent = new Scanner(file);
            while (fileContent.hasNextLine()) {
                String classStr = fileContent.nextLine();
                T newrecord = createRecordFrom(classStr);
                records.add(newrecord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract T createRecordFrom(String line);

    public ArrayList<T> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (T record : records) {
            if (record.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public T getRecord(String key) {
        for (T record : records) {
            if (record.getSearchKey().equals(key)) {
                return record;
            }
        }
        System.out.println("Record does not exist.");
        return null;
    }

    public void insertRecord(T record) {
        if (contains(record.getSearchKey())) {
            System.out.println("Record already exists.");
        } else {
            records.add(record);
        }
    }

    public void deleteRecord(String key) {
        if (contains(key)) {
            records.remove(getRecord(key));
        } else {
            System.out.println("Record does not exist.");
        }
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter(filename);
            for (T record : records) {
                writer.write(record.lineRepresentation());
                writer.write("\r\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
