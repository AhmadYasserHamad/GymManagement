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
public class MemberClassRegistration implements BaseClass {

    private String memberID;
    private String classID;
    private LocalDate registrationDate;
    private String status;

    public MemberClassRegistration(String memberID, String classID, LocalDate registrationDate, String status) {
        this.memberID = memberID;
        this.classID = classID;
        this.registrationDate = registrationDate;
        this.status = status;
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

    @Override
    public String getSearchKey() {
        return memberID.concat(classID);
    }

    public void setRegistrationStatus(String status) {
        this.status = status;
    }

    @Override
    public String lineRepresentation() {
        return memberID + ", " + classID + ", " + registrationDate + ", " + status;
    }

}
