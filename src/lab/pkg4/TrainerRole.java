/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.util.*;
import java.io.*;
import java.time.*;
import java.time.temporal.*;

/**
 *
 * @author ahmadyasserhamad
 */
public class TrainerRole implements Role {

    private MemberDatabase memberDatabase = new MemberDatabase("Members.txt");
    private ClassDatabase classDatabase = new ClassDatabase("Classes.txt");
    private MemberClassRegistrationDatabase registrationDatabase = new MemberClassRegistrationDatabase("Registration.txt");

    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        if (memberDatabase.contains(memberID)) {
            System.out.println("Member already exists.");
            return;
        }
        Member newMember = new Member(memberID, name, membershipType, email, phoneNumber, status);
        memberDatabase.insertRecord(newMember);
    }

    public ArrayList<Member> getListOfMembers() {
        return memberDatabase.returnAllRecords();
    }

    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        if (classDatabase.contains(classID)) {
            System.out.println("Class already exists.");
            return;
        }
        Class newClass = new Class(classID, className, trainerID, duration, maxParticipants);
        classDatabase.insertRecord(newClass);
    }

    public ArrayList<Class> getListOfClasses() {
        return classDatabase.returnAllRecords();
    }

    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        if (classDatabase.contains(classID) && classDatabase.getRecord(classID).getAvailableSeats() > 0) {
            registrationDatabase.insertRecord(registrationDatabase.createRecordFrom(memberID + ", " + classID + ", " + registrationDate + ", " + "active"));
            classDatabase.getRecord(classID).setAvailableSeats(classDatabase.getRecord(classID).getAvailableSeats() - 1);
            return true;
        }
        if (!classDatabase.contains(classID)) {
            System.out.println("Class does not exist.");
            return false;
        }
        if (!(classDatabase.getRecord(classID).getAvailableSeats() > 0)) {
            System.out.println("No seats available in class.");
            return false;
        }
        return false;
    }

    public boolean cancelRegistration(String memberID, String classID) {
        if (registrationDatabase.contains(memberID.concat(classID))) {
            long difference = Math.abs(ChronoUnit.DAYS.between(registrationDatabase.getRecord(memberID.concat(classID)).getRegistrationDate(), LocalDate.now()));
            String str = registrationDatabase.getRecord(memberID.concat(classID)).lineRepresentation();
            String[] divided = str.split(", ");
            if (difference <= 3 && "active".equals(divided[3])) {
                registrationDatabase.getRecord(memberID.concat(classID)).setRegistrationStatus("canceled");
                classDatabase.getRecord(classID).setAvailableSeats(classDatabase.getRecord(classID).getAvailableSeats() + 1);
                System.out.println("Refund issued to member: " + memberID);
                return true;
            }
            System.out.println("Cannot cancel registration. The class is in the coming three days or is already cancelled.");
            return false;
        }
        System.out.println("Class does not exist.");
        return false;
    }

    public ArrayList<MemberClassRegistration> getListOfRegistrations() {
        return registrationDatabase.returnAllRecords();
    }

    @Override
    public void logout() throws IOException {
        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        registrationDatabase.saveToFile();
    }

}
