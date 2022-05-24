package com.example.ticketapp.db;

public class Users {
    private String name;
    private String surname;
    private String mail;
    private String password;
    private int authority;
    private int status;
    private String date;

    public Users(String name, String surname, String mail, String password, int authority, int status, String date) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
        this.authority = authority;
        this.status = status;
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public int getAuthority() {
        return authority;
    }

    public int getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }
}
