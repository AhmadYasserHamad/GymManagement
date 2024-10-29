/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

/**
 *
 * @author ahmadyasserhamad
 */
public class ClassDatabase extends Database {

    public ClassDatabase(String filename) {
        super(filename);
    }

    @Override
    public Class createRecordFrom(String line) {
        String[] dividedLine = line.split(", ");
        Class newClass = new Class(dividedLine[0], dividedLine[1], dividedLine[2], Integer.parseInt(dividedLine[3]), Integer.parseInt(dividedLine[4]));
        return newClass;
    }

}
