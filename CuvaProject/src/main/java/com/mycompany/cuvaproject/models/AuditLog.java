
package com.mycompany.cuvaproject.models;
import java.time.LocalDateTime;

public class AuditLog {
    private int logId;
    private String userCedula;
    private String action;
    private LocalDateTime dateTime;


    public AuditLog(int logId, String userCedula, String action, LocalDateTime dateTime) {
        this.logId = logId;
        this.userCedula = userCedula;
        this.action = action;
        this.dateTime = dateTime;
    }



    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }


    public String getUserCedula() {
        return userCedula;
    }

    public void setUserCedula(String userCedula) {
        this.userCedula = userCedula;
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
