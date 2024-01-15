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
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Shahid Hasan
 */
public class CreditController implements Initializable {

    Connection con =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String pg;
    
    @FXML
    private TextArea CrditTextFieldID;

    @FXML
    private Button CredditBackID;
void txtArea() throws IOException, SQLException, ClassNotFoundException
{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13; " + "databaseName=project1;"; 
        Connection con = DriverManager.getConnection(connectionUrl);


        String sql3= "Select * from paragraph";
        pst = con.prepareStatement(sql3);
        rs = pst.executeQuery();

rs.next();

        pg = rs.getString(2);
       CrditTextFieldID.setFont(Font.font("arial", FontPosture.REGULAR, 20));
       CrditTextFieldID.setText(pg);
}
    @FXML
    void handleCreditBackAction(ActionEvent event) throws IOException {
        Parent Instruction = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
        Scene src1 = new Scene (Instruction);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src1);
        app_primaryStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
txtArea() ;
}catch(Exception e)
{
System.out.println("abcde");
}
    }    
    
}
