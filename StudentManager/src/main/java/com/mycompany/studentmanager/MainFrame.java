/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author vygir
 */
public class MainFrame extends JFrame {

    private JButton checkTotalStudent, newStudent;
 
    StudentManagement students;

    public MainFrame() {
        students = new StudentManagement();
        //init form
        setTitle("Student Management");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //layout controll
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel option = new JPanel(new GridLayout(1, 2, 5, 5));
        checkTotalStudent = new JButton("Check total Student");
        newStudent = new JButton("New Student");
        option.add(checkTotalStudent);
        option.add(newStudent);

        mainPanel.add(option, BorderLayout.NORTH);
        add(mainPanel);
        setVisible(true);

        checkTotalStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "There are " + students.getList().size() + " students in the database");

            }
        }
        );
        newStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewStudentDialog(students);
            }

        });

    }

    public static void main(String[] args) {
        //new MainFrame().setVisible(true);
        new Main().setVisible(true);
        
    }

}
