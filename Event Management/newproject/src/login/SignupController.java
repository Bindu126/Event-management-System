/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class SignupController implements Initializable {

    Connection con =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String chkpassword; 
    int lenpassword;
boolean len;


    @FXML
    private Button SignupSignupID;

    @FXML
    private TextField NameID;

    @FXML
    private TextField EmailSignupID;

    @FXML
    private TextField PhoneID;
 
    @FXML
    private Button SignupBackID;
    
    @FXML
    private PasswordField PasswordSignupID;

    @FXML
    void handleEmailSignupAction(ActionEvent event) {
         
    }

    @FXML
    void handleNameAction(ActionEvent event) {
        
    }

    @FXML
    void handlePasswordSignupAction(ActionEvent event) {
        
    }

    @FXML
    void handlePhoneAction(ActionEvent event) {
        
    }
    
    
        @FXML
    void handleSignupBackAction(ActionEvent event) throws IOException {
        Parent Signup = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene src2 = new Scene (Signup);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
    }
    
    

    @FXML
    void handleSignupSignupAction(ActionEvent event)throws ClassNotFoundException, SQLException,IOException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13; " + "databaseName=project1;"; 
        con = DriverManager.getConnection(connectionUrl);
        lenpassword= PasswordSignupID.getText().length();

try{
        String chkemail= "Select * from LOGIN1 where cEmail=?";
        pst = con.prepareStatement(chkemail);
        pst.setString(1, EmailSignupID.getText());
        rs = pst.executeQuery();

        String sql = "INSERT INTO LOGIN1 (cName, cEmail, cPhone, cPassword) VALUES (?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, NameID.getText());
            pst.setString(2, EmailSignupID.getText());
            pst.setString(3, PhoneID.getText());
            pst.setString(4, PasswordSignupID.getText());
            pst.executeUpdate();
            con.commit();

        Parent Signup = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene src2 = new Scene (Signup);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
   
   }catch(Exception e)
        {

if(NameID.getText().isEmpty()|| EmailSignupID.getText().isEmpty()||PhoneID.getText().isEmpty()|| PasswordSignupID.getText().isEmpty())
{
    JOptionPane.showMessageDialog(null, "Enter all Info");
}
else if(rs.next())
{
JOptionPane.showMessageDialog(null, "Already have a account");
}
else if(lenpassword<=6)
{
JOptionPane.showMessageDialog(null, "password must be at least 6 characters");
}
else
    {
        JOptionPane.showMessageDialog(null, "Input valid info please");
    }  

            System.out.println("Error= "+ e.getMessage());
             NameID.clear();
             EmailSignupID.clear();
             PhoneID.clear();
             PasswordSignupID.clear();
    }  
}


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
}