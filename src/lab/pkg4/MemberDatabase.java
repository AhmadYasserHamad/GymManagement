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
public class MemberDatabase implements Database {

    private ArrayList<Member> records = new ArrayList();
    private String filename;

    public MemberDatabase(String filename) {
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
            String member = fileContent.nextLine();
            Member newMember = createRecordFrom(member);
            records.add(newMember);
        }
    }

    @Override
    public Member createRecordFrom(String line) {
        String[] dividedLine = line.split(", ");
        Member newMember = new Member(dividedLine[0], dividedLine[1], dividedLine[2], dividedLine[3], dividedLine[4], dividedLine[5]);
        return newMember;
    }

    @Override
    public ArrayList<Member> returnAllRecords() {
        return records;
    }

    @Override
    public boolean contains(String key) {
        for (Member member : records) {
            if (member.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
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
        if (contains(record.getSearchKey())) {
            System.out.println("Member record already exists.");
        } else {
            records.add(record);
        }
    }

    @Override
    public void deleteRecord(String key) {
        if (contains(key)) {
            records.remove(getRecord(key));
        } else {
            System.out.println("Member record does not exist.");
        }
    }

    @Override
    public void saveToFile() throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (Member member : records) {
            writer.write(member.lineRepresentation());
            writer.write("\r\n");
        }
        writer.close();
    }

}
