/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author vygir
 */
public class NewStudentDialog extends JFrame{
    private JDialog newStudent;
    private JTextField idField, lastField, midField, firstField, yearOfBirth;
    private JRadioButton rb1, rb2;
    private JComboBox school;
    private JButton saveButton, clearButton, cancelButton;
    StudentManagement students;
    private Student stu;

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }
    
    
    public NewStudentDialog(StudentManagement students) {
        this.students=students;
        newStudent = new JDialog(newStudent, true);
        newStudent.setTitle("New Srudent");
        setSize(500, 500);
        setLocationRelativeTo(null);
        JPanel idPanel = new JPanel(new GridLayout(1,2,5,5));
        JPanel namePanel  = new JPanel(new GridLayout(1, 4, 5, 5));
        JPanel birthAndGender = new JPanel(new GridLayout(1,4,5,5));
        JPanel button = new JPanel(new GridLayout(1,3,5,5));
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(5,1,5,5));
        
        idField = new JTextField();
        lastField = new JTextField();
        midField = new JTextField();
        firstField = new JTextField();
        yearOfBirth = new JTextField();
        rb1 = new JRadioButton("Male");
        rb2 = new JRadioButton("Female");
        rb1.setBounds(75, 50, 100, 30);
        rb2.setBounds(75, 100, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        String[] schoolStage = {"Elementary School","Middle School","High School"};
        school = new JComboBox(schoolStage);
        saveButton = new JButton("Save");
        clearButton = new JButton("Clear");
        cancelButton = new JButton("Cancel");
        
        idPanel.add(new JLabel("Student ID "));
        idPanel.add(idField);
        namePanel.add(new JLabel("Last-Mid-First Name "));
        namePanel.add(lastField);
        namePanel.add(midField);
        namePanel.add(firstField);
        birthAndGender.add(new JLabel("Year of Birth"));
        birthAndGender.add(yearOfBirth);
        birthAndGender.add(rb1);
        birthAndGender.add(rb2);
        button.add(saveButton);
        button.add(clearButton);
        button.add(cancelButton);
        
        inputPanel.add(idPanel);
        inputPanel.add(namePanel);
        inputPanel.add(birthAndGender);
        inputPanel.add(button);
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        add(mainPanel);
        setVisible(true);
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
                if(!students.addStudent(stu)){
                    JOptionPane.showMessageDialog(null,"The id exist");
                    clear();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Successful");
                }
                clear();
                
            }
            
        });
        clearButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
            
        });
        cancelButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
        
        
    }
    public void addStudent(){
        String id = idField.getText();
        String last = lastField.getText();
        String mid = midField.getText();
        String first = firstField.getText();
        int birth = Integer.parseInt(yearOfBirth.getText()) ;
        String gender = "";
        if (rb1.isSelected()){
            gender = "Male";
        }
        if(rb2.isSelected()){
            gender = "Female";
        }
        String school = (String) this.school.getItemAt(this.school.getSelectedIndex());
        stu = new Student(id, last, mid, first, birth, gender, school);
    }
    public void clear(){
        idField.setText("");
        lastField.setText("");
        midField.setText("");
        firstField.setText("");
        yearOfBirth.setText("");
    }
    
    
}
