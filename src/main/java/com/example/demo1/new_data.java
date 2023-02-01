package com.example.demo1;

import java.math.BigInteger;

public class new_data {

    private  Integer id;
    private String classs;
    private String section;
    private String first_name;
    private String last_name;
    private String fathers_name;
    private String mothers_name;
    private String birth_date;
    private String gender;
    private String birth_reg;
    private String religion;
    private String image;
    private String blood_grp;
    private int fathers_mobile;
    private int mothers_mobile;
    private String email;
    private String present_address;
    private String permanent_address;


    public new_data() {
    }

    public new_data(Integer id, String first_name, String last_name, String fathers_name, String mothers_name, String birth_date, String gender, String birth_reg, String religion, String image, String blood_grp, int fathers_mobile, int mothers_mobile, String email, String present_address, String permanent_address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.fathers_name = fathers_name;
        this.mothers_name = mothers_name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.birth_reg = birth_reg;
        this.religion = religion;
        this.image = image;
        this.blood_grp = blood_grp;
        this.fathers_mobile = fathers_mobile;
        this.mothers_mobile = mothers_mobile;
        this.email = email;
        this.present_address = present_address;
        this.permanent_address = permanent_address;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFathers_name() {
        return fathers_name;
    }

    public void setFathers_name(String fathers_name) {
        this.fathers_name = fathers_name;
    }

    public String getMothers_name() {
        return mothers_name;
    }

    public void setMothers_name(String mothers_name) {
        this.mothers_name = mothers_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth_reg() {
        return birth_reg;
    }

    public void setBirth_reg(String birth_reg) {
        this.birth_reg = birth_reg;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBlood_grp() {
        return blood_grp;
    }

    public void setBlood_grp(String blood_grp) {
        this.blood_grp = blood_grp;
    }

    public int getFathers_mobile() {
        return fathers_mobile;
    }

    public void setFathers_mobile(int fathers_mobile) {
        this.fathers_mobile = fathers_mobile;
    }

    public int getMothers_mobile() {
        return mothers_mobile;
    }

    public void setMothers_mobile(int mothers_mobile) {
        this.mothers_mobile = mothers_mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPresent_address() {
        return present_address;
    }

    public void setPresent_address(String present_address) {
        this.present_address = present_address;
    }

    public String getPermanent_address() {
        return permanent_address;
    }

    public void setPermanent_address(String permanent_address) {
        this.permanent_address = permanent_address;
    }
}
