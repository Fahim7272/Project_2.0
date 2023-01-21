package com.example.demo1;

import java.math.BigInteger;

public class new_data {

    private static Integer id;
    private static String first_name;
    private static String last_name;
    private static String fathers_name;
    private static String mothers_name;
    private static String birth_date;
    private static String gender;
    private static BigInteger birth_reg;
    private static String religion;
    private static String image;
    private static String blood_grp;

    public new_data() {
    }

    public new_data(Integer id, String first_name, String last_name, String fathers_name, String mothers_name, String birth_date, String gender, BigInteger birth_reg, String religion, String image, String blood_grp) {
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
    }


    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        new_data.id = id;
    }

    public static String getFirst_name() {
        return first_name;
    }

    public static void setFirst_name(String first_name) {
        new_data.first_name = first_name;
    }

    public static String getLast_name() {
        return last_name;
    }

    public static void setLast_name(String last_name) {
        new_data.last_name = last_name;
    }

    public static String getFathers_name() {
        return fathers_name;
    }

    public static void setFathers_name(String fathers_name) {
        new_data.fathers_name = fathers_name;
    }

    public static String getMothers_name() {
        return mothers_name;
    }

    public static void setMothers_name(String mothers_name) {
        new_data.mothers_name = mothers_name;
    }

    public static String getBirth_date() {
        return birth_date;
    }

    public static void setBirth_date(String birth_date) {
        new_data.birth_date = birth_date;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        new_data.gender = gender;
    }

    public static BigInteger getBirth_reg() {
        return birth_reg;
    }

    public static void setBirth_reg(BigInteger birth_reg) {
        new_data.birth_reg = birth_reg;
    }

    public static String getReligion() {
        return religion;
    }

    public static void setReligion(String religion) {
        new_data.religion = religion;
    }

    public static String getImage() {
        return image;
    }

    public static void setImage(String image) {
        new_data.image = image;
    }

    public static String getBlood_grp() {
        return blood_grp;
    }

    public static void setBlood_grp(String blood_grp) {
        new_data.blood_grp = blood_grp;
    }

}
