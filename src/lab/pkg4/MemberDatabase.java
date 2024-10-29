/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

/**
 *
 * @author ahmadyasserhamad
 */
public class MemberDatabase extends Database {

    public MemberDatabase(String filename) {
        super(filename);
    }
    
    @Override
    public Member createRecordFrom(String line) {
        String[] dividedLine = line.split(", ");
        Member newMember = new Member(dividedLine[0], dividedLine[1], dividedLine[2], dividedLine[3], dividedLine[4], dividedLine[5]);
        return newMember;
    }
}
