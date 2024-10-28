/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.time.*;

/**
 *
 * @author ahmadyasserhamad
 */
public class MemberClassRegistration {

    private String memberID;
    private String classID;
    private String status;
    private LocalDate registrationDate;

    public MemberClassRegistration(String memberID, String classID, String status, LocalDate registrationDate) {
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.registrationDate = registrationDate;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getClassID() {
        return classID;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getSearchKey() {
        return memberID.concat(classID);
    }
    
    public void setRegistrationStatus(String status){
        this.status = status;
    }
    
    public void setRegistrationDate(LocalDate date){
        registrationDate = date;
    }

    public String lineRepresentation() {
        return memberID.concat(", " + classID + ", " + registrationDate + ", " + status);
    }

}
