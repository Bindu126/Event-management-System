/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable {
    Connection con =null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    PreparedStatement pst = null;
    
    
    
    
    
    
    
        @FXML
    private Label label;

    @FXML
    private Button LoginID;

    @FXML
    private TextField EmailID;

    @FXML
    private TextField PasswordID;

    @FXML
    private Button SignupID;

    @FXML
    void handleEmailAction(ActionEvent event) {
        
    }

    
        @FXML
    void handlePasswordAction(ActionEvent event) {

    }

    @FXML
    void handleSignupAction(ActionEvent event)throws ClassNotFoundException, SQLException,IOException {
     
        Parent Login = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Scene src1 = new Scene (Login);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src1);
        app_primaryStage.show();

    }



    @FXML
    void handleLoginAction(ActionEvent event)throws ClassNotFoundException, SQLException,IOException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13; " + "databaseName=project1;"; 
        con = DriverManager.getConnection(connectionUrl);

        String sql= "Select * from LOGIN1 where cEmail=? and cPassword= ? ";
        pst = con.prepareStatement(sql);
        pst.setString(1, EmailID.getText());
        pst.setString(2, PasswordID.getText());
        rs = pst.executeQuery();
        if(rs.next())  { 
             //JOptionPane.showMessageDialog( null,"Email and Password Matched"); 
                
        Parent Login = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
        Scene src2 = new Scene (Login);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
             
             
        } 
 
        
else{

        String sql1= "Select * from LOGIN2 where oEmail=? and oPassword= ? ";
        pst = con.prepareStatement(sql1);
        pst.setString(1, EmailID.getText());
        pst.setString(2, PasswordID.getText());
        rs1 = pst.executeQuery();
if(rs1.next())
{
 Parent Login1 = FXMLLoader.load(getClass().getResource("OwnerUI.fxml"));
        Scene src3 = new Scene (Login1);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src3);
        app_primaryStage.show();
}
else{
           JOptionPane.showMessageDialog(null, "Email and Password Incorrect");
}
 }
        
        
    }
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        // TODO
    }    
     
}