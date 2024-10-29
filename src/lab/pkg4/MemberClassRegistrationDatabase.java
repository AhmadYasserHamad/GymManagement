/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.time.*;
import java.time.format.*;

/**
 *
 * @author ahmadyasserhamad
 */
public class MemberClassRegistrationDatabase extends Database {

    public MemberClassRegistrationDatabase(String filename) {
        super(filename);
    }
    
    @Override
    public MemberClassRegistration createRecordFrom(String line) {
        String[] dividedLine = line.split(", ");
        MemberClassRegistration newRegistration = new MemberClassRegistration(dividedLine[0], dividedLine[1], LocalDate.parse(dividedLine[2], DateTimeFormatter.ISO_DATE), dividedLine[3]);
        return newRegistration;
    }

}
