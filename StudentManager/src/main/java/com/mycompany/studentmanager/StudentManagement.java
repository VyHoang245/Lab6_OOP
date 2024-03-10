/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.studentmanager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 *
 * @author vygir
 */

class StudentManagement {

    static ArrayList<Student> list;

    public ArrayList<Student> getList() {
        return list;
    }

   
    
    public StudentManagement() {
        this.list= loadStudent();
    }

    public static Student findStudentById(String studentID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentID().compareTo(studentID) == 0) {
                return list.get(i);
            }
        }
        return null;
    }

    public boolean addStudent(Student stu) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentID().compareTo(stu.getStudentID()) == 0) {
                return false;
            }
        }
        list.add(stu);
        saveStudent(list);
        return true;
    }
    
    public ArrayList<Student> getListStudent(){
        return list;
    }
    public int getSize(){
        return list.size();
    }
    static String fileName = "D:\\Students2.Dat";
    public static void saveStudent(ArrayList<Student> student) {
        try {
            FileOutputStream f = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(f);
            oStream.writeObject(student);
            oStream.close();
        } catch (IOException e) {
            System.out.println("Error save file"+ e.getMessage());
        }
    }

    public static ArrayList<Student> loadStudent() {
        ArrayList<Student> student= new ArrayList<>();
        try {
            FileInputStream f = new FileInputStream(fileName);
            ObjectInputStream inStream = new ObjectInputStream(f);
            student = (ArrayList<Student>) inStream.readObject();
            inStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Error load file");
        }
        return student;
    }

}
