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
public interface Database{
    
    public void readFromFile() throws FileNotFoundException;
    public Object createRecordFrom(String line);
    public ArrayList<? extends Object> returnAllRecords();
    public boolean contains(String key);
    public Object getRecord(String key);
    public void deleteRecord(String key);
    public void saveToFile() throws IOException;

}
