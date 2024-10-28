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
public class ClassDatabase {
    
    private ArrayList<Class> records = new ArrayList();;
    private String filename;

    public ClassDatabase(String filename) {
        this.filename = filename;
    }
    
    public void readFromFile() throws FileNotFoundException {
        File file = new File(filename);
        Scanner fileContent = new Scanner(file);
        while (fileContent.hasNextLine()) {
            String classStr = fileContent.nextLine();
            String[] dividedClass = classStr.split(",");
            Class newclass = new Class(dividedClass[0], dividedClass[1], dividedClass[2], Integer.parseInt(dividedClass[3]), Integer.parseInt(dividedClass[4]));
            records.add(newclass);
        }
    }

    public Class createRecordFrom(String line) {
        String[] dividedLine = line.split(",");
        Class newClass = new Class(dividedLine[0], dividedLine[1], dividedLine[2], Integer.parseInt(dividedLine[3]), Integer.parseInt(dividedLine[4]));
        return newClass;
    }

    public ArrayList<Class> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (Class classInstance : records) {
            if (classInstance.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }
    
    public Class getRecord(String key){
        for (Class classInstance : records){
            if(classInstance.getSearchKey().equals(key)){
                return classInstance;
            }
        }
        System.out.println("Class does not exist.");
        return null;
    }

    public void insertRecord(Class record) {
        for (Class classInstance : records) {
            if (classInstance.equals(record)) {
                System.out.println("Record already exists.");
                return;
            }
        }
        records.add(record);
    }

    public void deleteRecord(String key) {
        for (Class classInstance : records) {
            if (classInstance.getSearchKey().equals(key)) {
                records.remove(classInstance);
            }
        }
        System.out.println("No records found matching the key.");
    }

    public void saveToFile() throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (Class classInstance : records) {
            writer.write(classInstance.lineRepresentation());
        }
    }
    
}
