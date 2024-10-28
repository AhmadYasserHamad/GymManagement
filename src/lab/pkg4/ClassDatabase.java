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
public class ClassDatabase implements Database {

    private ArrayList<Class> records = new ArrayList();
    private String filename;


    public ClassDatabase(String filename) {
        this.filename = filename;
        try {
            readFromFile();
        } catch (IOException e) {
        }
    }

    @Override
    public void readFromFile() throws FileNotFoundException {
        File file = new File(filename);
        Scanner fileContent = new Scanner(file);
        while (fileContent.hasNextLine()) {
            String classStr = fileContent.nextLine();
            Class newclass = createRecordFrom(classStr);
            records.add(newclass);
        }
    }

    @Override
    public Class createRecordFrom(String line) {
        String[] dividedLine = line.split(", ");
        Class newClass = new Class(dividedLine[0], dividedLine[1], dividedLine[2], Integer.parseInt(dividedLine[3]), Integer.parseInt(dividedLine[4]));
        return newClass;
    }

    @Override
    public ArrayList<Class> returnAllRecords() {
        return records;
    }

    @Override
    public boolean contains(String key) {
        for (Class classInstance : records) {
            if (classInstance.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Class getRecord(String key) {
        for (Class classInstance : records) {
            if (classInstance.getSearchKey().equals(key)) {
                return classInstance;
            }
        }
        System.out.println("Class does not exist.");
        return null;
    }

    public void insertRecord(Class record) {
        if (contains(record.getSearchKey())) {
            System.out.println("Class record already exists.");
        } else {
            records.add(record);
        }
    }
    

    @Override
    public void deleteRecord(String key) {
        if (contains(key)) {
            records.remove(getRecord(key));
        } else {
            System.out.println("Class record does not exist.");
        }
    }

    @Override
    public void saveToFile() throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (Class classInstance : records) {
            writer.write(classInstance.lineRepresentation());
            writer.write("\r\n");
        }
        writer.close();
    }

}
