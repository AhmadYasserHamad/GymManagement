/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab.pkg4;

import java.util.*;
import java.io.*;
import java.time.*;

/**
 *
 * @author ahmadyasserhamad
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        AdminRole adminRole = new AdminRole();
        TrainerRole trainerRole = new TrainerRole();

        int choice;
        do {
            System.out.println("\nGym Management System");
            System.out.println("1. Admin Login");
            System.out.println("2. Trainer Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            boolean flag = true;
            switch (choice) {
                case 1:
                    // Admin Menu
                    do {
                        System.out.println("\nAdmin Menu");
                        System.out.println("1. Add Trainer");
                        System.out.println("2. List Trainers");
                        System.out.println("3. Remove Trainer");
                        System.out.println("4. Logout");
                        System.out.print("Enter your choice: ");
                        int adminChoice = scanner.nextInt();

                        switch (adminChoice) {
                            case 1:
                                System.out.print("Enter Trainer ID: ");
                                String trainerId = scanner.next();
                                System.out.print("Enter Trainer Name: ");
                                String name = scanner.next();
                                System.out.print("Enter Trainer Email: ");
                                String email = scanner.next();
                                System.out.print("Enter Trainer Speciality: ");
                                String speciality = scanner.next();
                                System.out.print("Enter Trainer Phone Number: ");
                                String phoneNumber = scanner.next();
                                adminRole.addTrainer(trainerId, name, email, speciality, phoneNumber);
                                break;
                            case 2:
                                for (Trainer trainer : adminRole.getListOfTrainers()) {
                                    System.out.println(trainer.lineRepresentation());
                                }
                                break;
                            case 3:
                                System.out.print("Enter Trainer ID to remove: ");
                                String idToRemove = scanner.next();
                                adminRole.removeTrainer(idToRemove);
                                break;
                            case 4:
                                adminRole.logout();
                                flag = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while (choice != 4 && flag == true);
                    break;

                case 2:
                    // Trainer Menu
                    do {
                        System.out.println("\nTrainer Menu");
                        System.out.println("1. Add Member");
                        System.out.println("2. List Members");
                        System.out.println("3. Add Class");
                        System.out.println("4. List Classes");
                        System.out.println("5. Register Member for Class");
                        System.out.println("6. Cancel Registration");
                        System.out.println("7. List Registrations");
                        System.out.println("8. Logout");
                        System.out.print("Enter your choice: ");
                        int trainerChoice = scanner.nextInt();

                        switch (trainerChoice) {
                            case 1:
                                System.out.print("Enter Member ID: ");
                                String memberId = scanner.next();
                                System.out.print("Enter Member Name: ");
                                String memberName = scanner.next();
                                System.out.print("Enter Membership Type: ");
                                String membershipType = scanner.next();
                                System.out.print("Enter Member Email: ");
                                String memberEmail = scanner.next();
                                System.out.print("Enter Member Phone Number: ");
                                String memberPhoneNumber = scanner.next();
                                System.out.print("Enter Member Status: ");
                                String memberStatus = scanner.next();
                                trainerRole.addMember(memberId, memberName, membershipType, memberEmail, memberPhoneNumber, memberStatus);
                                break;
                            case 2:
                                for (Member member : trainerRole.getListOfMembers()) {
                                    System.out.println(member.lineRepresentation());
                                }
                                break;
                            case 3:
                                System.out.print("Enter Class ID: ");
                                String classId = scanner.next();
                                System.out.print("Enter Class Name: ");
                                String className = scanner.next();
                                System.out.print("Enter Trainer ID: ");
                                String classTrainerId = scanner.next();
                                System.out.print("Enter Class Duration: ");
                                int duration = scanner.nextInt();
                                System.out.print("Enter Maximum Participants: ");
                                int maxParticipants = scanner.nextInt();
                                trainerRole.addClass(classId, className, classTrainerId, duration, maxParticipants);
                                break;
                            case 4:
                                for (Class classObj : trainerRole.getListOfClasses()) {
                                    System.out.println(classObj.lineRepresentation());
                                }
                                break;
                            case 5:
                                System.out.print("Enter Member ID: ");
                                String registrationMemberId = scanner.next();
                                System.out.print("Enter Class ID: ");
                                String registrationClassId = scanner.next();
                                System.out.print("Enter Registration Date (YYYY-MM-DD): ");
                                LocalDate registrationDate = LocalDate.parse(scanner.next());
                                if (trainerRole.registerMemberForClass(registrationMemberId, registrationClassId, registrationDate)) {
                                    System.out.println("Member registered successfully.");
                                } else {
                                    System.out.println("Registration failed. Please check class availability or member status.");
                                }
                                break;
                            case 6:
                                System.out.print("Enter Member ID: ");
                                String cancellationMemberId = scanner.next();
                                System.out.print("Enter Class ID: ");
                                String cancellationClassId = scanner.next();
                                if (trainerRole.cancelRegistration(cancellationMemberId, cancellationClassId)) {
                                    System.out.println("Registration cancelled successfully.");
                                } else {
                                    System.out.println("Cancellation failed. Please check registration status or cancellation policy.");
                                }
                                break;
                            case 7:
                                for (MemberClassRegistration registration : trainerRole.getListOfRegistrations()) {
                                    System.out.println(registration.lineRepresentation());
                                }
                                break;
                            case 8:
                                trainerRole.logout();
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while (choice != 8);
                    break;

                case 3:
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }
}
