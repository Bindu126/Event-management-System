/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable {
    Connection con =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
     
    @FXML
    private Label label;

    @FXML
    private Button Button;

    @FXML
    private TextField Email;

    @FXML
    private TextField Password;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException {
         
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13; " + "databaseName=project1;"; 
        con = DriverManager.getConnection(connectionUrl);
        String sql= "Select * from LOGIN1 where Email=? and Password= ? ";
        pst = con.prepareStatement(sql);
        pst.setString(1, Email.getText());
        pst.setString(2, Password.getText());
        rs = pst.executeQuery();
        if(rs.next())  { 
             JOptionPane.showMessageDialog( null,"Email and Password Matched"); 
            
        }  
        else{
           JOptionPane.showMessageDialog(null, "Email and Password Incorrect"); 
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        // TODO
    }    

     
         
     
    
}
