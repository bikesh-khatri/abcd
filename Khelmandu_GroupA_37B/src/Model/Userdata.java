/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author khatr
 */
public class Userdata {
    private String f_name;

    public String getFname() {
        return f_name;
    }

    public void setFname(String fname) {
        this.f_name = fname;
    }
    private String l_name;

    public String getLname() {
        return l_name;
    }

    public void setLname(String lname) {
        this.l_name = lname;
    }

    public long getNumber() {
        return ph_number;
    }

    public void setNumber(long number) {
        this.ph_number = number;
    }
    private String password;

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    
    
    private long ph_number;
    
    
    public Userdata(String fname,String lname, long number,String password) {
        this.f_name =fname;
        this.l_name =lname;
        this.ph_number = number;
        this.password=password;
    }
 }
    

