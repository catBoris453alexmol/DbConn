package ru.sapteh.model;

import java.util.Objects;

public class Auto {
    public static final String TABLE_NAME = "auto_table";
    public static final String ID_COLUMN = "id";
    public static final String MARKA_COLUMN = "marka";


    private Long id;
    private  String marka;
    private  String model;
    private  String proiz;
    private String  age;
    private  String color;


    public Auto(Long id, String marka, String model, String proiz, String  age, String color){
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.proiz = proiz;
        this.age = age;
        this.color = color;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setGod(String age) {
        this.age = age;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProiz(String proiz) {
        this.proiz = proiz;
    }


    public Long getId(){
        return id;
    }
    public String getMarka() {
        return marka;
    }
    public String getModel(){
        return model;

    }
    public String getProiz(){
        return proiz;

    }
    public String getAge(){
        return age;
    }
    public String getColor(){
        return color;
    }
    @Override
    public String toString() {
        return String.format("%d %s %s %s %s %s", getId(), getMarka(), getModel(),getProiz(), getAge(), getColor());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return id == auto.id &&
                Objects.equals(marka, auto.marka) &&
                Objects.equals(model, auto.model) &&
                Objects.equals(proiz, auto.proiz) &&
                Objects.equals(age, auto.age) &&
                Objects.equals(color, auto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marka, model, proiz, age, color);
    }
}
