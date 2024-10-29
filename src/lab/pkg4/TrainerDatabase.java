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
public class TrainerDatabase extends Database {

    public TrainerDatabase(String filename) {
        super(filename);
    }

    @Override
    public Trainer createRecordFrom(String line) {
        String[] dividedLine = line.split(", ");
        Trainer newTrainer = new Trainer(dividedLine[0], dividedLine[1], dividedLine[2], dividedLine[3], dividedLine[4]);
        return newTrainer;
    }
}
