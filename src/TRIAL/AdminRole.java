/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author ahmadyasserhamad
 */
public class AdminRole {

    private TrainerDatabase database;

    public void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) {
        if (database.contains(trainerId)) {
            System.out.println("Trainer already exists.");
        }
        Trainer newTrainer = new Trainer(trainerId, name, email, specialty, phoneNumber);
        database.insertRecord(newTrainer);
    }

    public ArrayList<Trainer> getListOfTrainers() {
        return database.returnAllRecords();
    }

    public void removeTrainer(String key) {
        if (database.contains(key)) {
            database.deleteRecord(key);
        }
        System.out.println("Trainer not found in database.");
    }

    public void logout() throws IOException {
        database.saveToFile();
    }

}
