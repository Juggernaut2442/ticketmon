package com.example.ticketapp.db;

public class Tickets {
    private int TicketID;
    private int UserID;
    private String subject;
    private String message;
    private int status;
    private String date;

    public Tickets(int ticketID, int userID, String subject, String message, int status, String date) {
        TicketID = ticketID;
        UserID = userID;
        this.subject = subject;
        this.message = message;
        this.status = status;
        this.date = date;
    }

    public int getTicketID() {
        return TicketID;
    }

    public void setTicketID(int ticketID) {
        TicketID = ticketID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
