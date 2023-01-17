package com.codegym.staticoop;

public class Student {
    int rollno;
    String name;
    public static String college = "BachKhoa";

    public Student(int rollno, String name, String college) {
        this.rollno = rollno;
        this.name = name;
        this.college = college;
    }



    public static void main(String[] args) {
        Student s1 = new Student(1, "Phu", "Bach Khoa");
        Student s2 = new Student(2, "Yen", "Bach Khoa");
        Student s3 = new Student(3, "Nhan", "Bach Khoa");
        Student s4 = new Student(4, "Nghia", "Bach Khoa");
        Student s5 = new Student(5, "Phung", "Bach Khoa");

        System.out.println(s1.college);
        System.out.println(Student.college);

    }

}
