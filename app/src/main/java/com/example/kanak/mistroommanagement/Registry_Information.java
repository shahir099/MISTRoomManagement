package com.example.kanak.mistroommanagement;

public class Registry_Information {
    String mail,emsid,dept,name,phn,gender,pass;

    public Registry_Information(String mail, String emsid, String dept, String name, String phn, String gender, String pass) {
        this.mail = mail;
        this.emsid = emsid;
        this.dept = dept;
        this.name = name;
        this.phn = phn;
        this.gender = gender;
        this.pass = pass;
    }

    public Registry_Information() {
    }

    public String getEmail() {
        return mail;
    }

    public String getEMSID() {
        return emsid;
    }

    public String getDept() {
        return dept;
    }

    public String getName() {
        return name;
    }

    public String getCell() {
        return phn;
    }

    public String getGender() {
        return gender;
    }

    public String getPass() { return pass; }
}


