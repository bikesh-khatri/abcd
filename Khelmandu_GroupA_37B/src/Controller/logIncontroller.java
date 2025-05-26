/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.Dao;

import View.LogIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author khatr
 */
public class logIncontroller {
    
    private final Dao Dao = new Dao();
    private final LogIn userView;
    
    
    public logIncontroller (LogIn userView) {
        this.userView= userView;
        userView.logInListener(new LogInListener());
    }
    
    public void open() {
        this.userView.setVisible(true);
        
    }
    public void close(){
        this.userView.dispose();
    }

    private static class LogInListener implements ActionListener {

        public LogInListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("sdfasdfasdf");
        }
    }
    
}
