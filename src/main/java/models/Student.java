package models;

import java.util.ArrayList;

public class Student {
    private String name;
    private int age;
    private String cohort;
    private int id;
    private static ArrayList<Student> instances = new ArrayList<>();


    public Student(String name, Integer age, String cohort) {
        this.name = name;
        this.age = age;
        this.cohort = cohort;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return name;
    }
    public Integer getAge(){
        return age;
    }
    public String getCohort() {
        return cohort;
    }

    public static ArrayList<Student> getAll(){
        return instances;
    }

    public static void clearAllStudents(){
        instances.clear();
    }
    public int getId() {
        return id;
    }
    public static Student findById(int id){
        return instances.get(id-1);
    }

}
