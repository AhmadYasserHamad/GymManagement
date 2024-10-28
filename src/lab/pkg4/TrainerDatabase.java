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
public class TrainerDatabase implements Database {

    private ArrayList<Trainer> records = new ArrayList();
    private String filename;

    public TrainerDatabase(String filename) {
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
            String trainer = fileContent.nextLine();
            Trainer newTrainer = createRecordFrom(trainer);
            records.add(newTrainer);
        }
    }

    @Override
    public Trainer createRecordFrom(String line) {
        String[] dividedLine = line.split(", ");
        Trainer newTrainer = new Trainer(dividedLine[0], dividedLine[1], dividedLine[2], dividedLine[3], dividedLine[4]);
        return newTrainer;
    }

    @Override
    public ArrayList<Trainer> returnAllRecords() {
        return records;
    }

    @Override
    public boolean contains(String key) {
        for (Trainer trainer : records) {
            if (trainer.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Trainer getRecord(String key) {
        for (Trainer trainer : records) {
            if (trainer.getSearchKey().equals(key)) {
                return trainer;
            }
        }
        System.out.println("Trainer does not exist.");
        return null;
    }

    public void insertRecord(Trainer record) {
        if (contains(record.getSearchKey())) {
            System.out.println("Trainer record already exists.");
        } else {
            records.add(record);
        }
    }

    @Override
    public void deleteRecord(String key) {
        if (contains(key)) {
            records.remove(getRecord(key));
        } else {
            System.out.println("Trainer record does not exist.");
        }
    }

    @Override
    public void saveToFile() throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (Trainer trainer : records) {
            writer.write(trainer.lineRepresentation());
            writer.write("\r\n");
        }
        writer.close();
    }

}
