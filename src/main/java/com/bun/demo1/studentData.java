package com.bun.demo1;

import java.sql.Date;

public class studentData {
    private Integer studentID;
    private String year, section, lastName, firstName;
    private Date birth;
    private String gender, status, image;
    private Double mathematics, basicenglish, fil, sci, tech, aralinP, mapeh, finals;

    public studentData(Integer studentID, String year, String section, String lastName, String firstName, Date birth, String gender, String status, String image) {
        this.studentID = studentID;
        this.year = year;
        this.section = section;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birth = birth;
        this.gender = gender;
        this.status = status;
        this.image = image;
    }

    public studentData(Integer studentID, String year, String section, Double mathematics, Double basicenglish, Double fil, Double sci, Double tech, Double aralinP, Double mapeh, Double finals) {
        this.studentID = studentID;
        this.year = year;
        this.section = section;
        this.mathematics = mathematics;
        this.basicenglish = basicenglish;
        this.fil = fil;
        this.sci = sci;
        this.tech = tech;
        this.aralinP = aralinP;
        this.mapeh = mapeh;
        this.finals = finals;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public String getYear() {
        return year;
    }

    public String getSection() {
        return section;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirth() {
        return birth;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public Double getMathematics() {
        return mathematics;
    }

    public Double getBasicenglish() {
        return basicenglish;
    }

    public Double getFil() { return fil; }

    public Double getSci() { return sci; }

    public Double getTech() { return tech; }

    public Double getAralinP() { return aralinP; }

    public Double getMapeh() { return mapeh; }

    public Double getFinals() {
        return finals;
    }
}
