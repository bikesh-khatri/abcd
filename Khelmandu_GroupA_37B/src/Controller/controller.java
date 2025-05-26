package Controller;

import Dao.Dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.Userdata;
import View.SignUp;


public class controller {
    private final Dao Dao = new Dao();
    private final SignUp userView;
    
    
    public controller(SignUp userView) {
        this.userView= userView;
        userView.addAdduserListener(new AdduserListener());
    }
    
    public void open() {
        this.userView.setVisible(true);
        
    }
    public void close(){
        this.userView.dispose();
    }
    
    class AdduserListener implements ActionListener {
       
        public void actionPerformed(ActionEvent e) {
            System.out.println("signup clicked!");
            try {
                String firstName = userView.getFname();
                String lastName = userView.getLname();
                String phoneNumber = userView.getNumber();
                String pass = userView.getPassword();
                 if (firstName.isEmpty() || firstName.equals("First name")) {
                    JOptionPane.showMessageDialog(null, "Please enter your first name");
                    return;
                }
                if (lastName.isEmpty() || lastName.equals("Last name")) {
                    JOptionPane.showMessageDialog(null, "Please enter your last name");
                    return;
                }
                if (phoneNumber.isEmpty() || phoneNumber.equals("Phone number")) {
                    JOptionPane.showMessageDialog(null, "Please enter your phone number");
                    return;
                }
                if (pass.isEmpty() || pass.equals("mismatch")|| pass.equals("password")) {
                    JOptionPane.showMessageDialog(null, "Please enter a password");
                    return;
                }
                Userdata user = new Userdata(firstName,lastName, Long.parseLong(phoneNumber), pass);
                boolean check = Dao.checkuser(user);
                if(check) {
                    JOptionPane.showMessageDialog(userView,  "Duplicate user");
                }
                else {
                    Dao.signup(user);
                }
            }
            catch (Exception ex) {
                System.out.println("Error adding user: " + ex.getMessage());
            }
        }
    }
}