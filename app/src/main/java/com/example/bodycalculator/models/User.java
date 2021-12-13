package com.example.bodycalculator.models;

public class User {
 /*   public enum KEYS{
        AGE,
        IS_MAN,
        HEIGH,
        BODY_MASS,
        STEPS_PER_DAY,
        CSS,
        SAD,
        DAD,
        PS,
        JEL
    }*/

    public enum KEYS{
        USER
    }

    private double age;
    private boolean isMan;
    private double height;
    private double bodyMass;
    private double stepsPerDay;
    private double CSS;
    private double SAD;
    private double DAD;
    private double PS;
    private double JEL;

    public User() {
    }

    public User(double age, boolean isMan, double height,
                double bodyMass, double stepsPerDay,
                double CSS, double SAD, double DAD, double PS, double JEL) {
        this.age = age;
        this.isMan = isMan;
        this.height = height;
        this.bodyMass = bodyMass;
        this.stepsPerDay = stepsPerDay;
        this.CSS = CSS;
        this.SAD = SAD;
        this.DAD = DAD;
        this.PS = PS;
        this.JEL = JEL;
    }


    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBodyMass() {
        return bodyMass;
    }

    public void setBodyMass(double bodyMass) {
        this.bodyMass = bodyMass;
    }

    public double getStepsPerDay() {
        return stepsPerDay;
    }

    public void setStepsPerDay(double stepsPerDay) {
        this.stepsPerDay = stepsPerDay;
    }

    public double getCSS() {
        return CSS;
    }

    public void setCSS(double CSS) {
        this.CSS = CSS;
    }

    public double getSAD() {
        return SAD;
    }

    public void setSAD(double SAD) {
        this.SAD = SAD;
    }

    public double getDAD() {
        return DAD;
    }

    public void setDAD(double DAD) {
        this.DAD = DAD;
    }

    public double getPS() {
        return PS;
    }

    public void setPS(double PS) {
        this.PS = PS;
    }

    public double getJEL() {
        return JEL;
    }

    public void setJEL(double JEL) {
        this.JEL = JEL;
    }
}
