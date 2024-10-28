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
public class MemberDatabase {

    private ArrayList<Member> records = new ArrayList();
    ;
    private String filename;

    public MemberDatabase(String filename) {
        this.filename = filename;
    }

    public void readFromFile() throws FileNotFoundException {
        File file = new File(filename);
        Scanner fileContent = new Scanner(file);
        while (fileContent.hasNextLine()) {
            String trainer = fileContent.nextLine();
            String[] dividedMember = trainer.split(",");
            Member newMember = new Member(dividedMember[0], dividedMember[1], dividedMember[2], dividedMember[3], dividedMember[4], dividedMember[5]);
            records.add(newMember);
        }
    }

    public Member createRecordFrom(String line) {
        String[] dividedLine = line.split(",");
        Member newMember = new Member(dividedLine[0], dividedLine[1], dividedLine[2], dividedLine[3], dividedLine[4], dividedLine[5]);
        return newMember;
    }

    public ArrayList<Member> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (Member member : records) {
            if (member.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Member getRecord(String key) {
        for (Member member : records) {
            if (member.getSearchKey().equals(key)) {
                return member;
            }
        }
        System.out.println("Member does not exist.");
        return null;
    }

    public void insertRecord(Member record) {
        for (Member member : records) {
            if (member.equals(record)) {
                System.out.println("Record already exists.");
                return;
            }
        }
        records.add(record);
    }

    public void deleteRecord(String key) {
        for (Member member : records) {
            if (member.getSearchKey().equals(key)) {
                records.remove(member);
            }
        }
        System.out.println("No records found matching the key.");
    }

    public void saveToFile() throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (Member member : records) {
            writer.write(member.lineRepresentation());
        }
    }

}
