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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 19010
 */




public class InsertController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection con =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String gt = null;
      @FXML
    private TextField Venue_Insert_ID;

    @FXML
    private TextField Food_Insert_ID;

    @FXML
    private TextField Theme_Insert_ID;

    @FXML
    private TextField Photography_Insert_ID;

    @FXML
    private Button InsertBackID;
    
    @FXML
    private Button Insert_INTO_insertID;
    
    @FXML
    private ComboBox Insert_ComboID;

    @FXML
    void handleFood_Insert_Action(ActionEvent event) {

    }

    @FXML
    void handleInsertBackAction(ActionEvent event) throws IOException {
        
        Parent Insert = FXMLLoader.load(getClass().getResource("OwnerUI.fxml"));
        Scene src2 = new Scene (Insert);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();

    }

    @FXML
    void handleInsert_ComboAction(ActionEvent event) {
        

    }

    @FXML
    void handlePhotography_Insert_Action(ActionEvent event) {

    }

    @FXML
    void handleTheme_Insert_Action(ActionEvent event) {

    }

    @FXML
    void handleVenue_Insert_Action(ActionEvent event) {

    }
    
    @FXML
    void handleInsert_INTO_insertAction(ActionEvent event) throws ClassNotFoundException, SQLException{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13; " + "databaseName=project1;"; 
        con = DriverManager.getConnection(connectionUrl);
        
           gt = Insert_ComboID.getValue().toString();

if(gt == "Birthday Event")
{
        String sql = "INSERT INTO BEvent (Venue, Food, Theme, Photography) VALUES (?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, Venue_Insert_ID.getText());
            pst.setString(2, Food_Insert_ID.getText());
            pst.setString(3, Theme_Insert_ID.getText());
            pst.setString(4, Photography_Insert_ID.getText());
            pst.executeUpdate();
            con.commit();
}
if(gt == "Wedding Program")
{
          String sql = "INSERT INTO WedPro (Venue, Food, Theme, Photography) VALUES (?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, Venue_Insert_ID.getText());
            pst.setString(2, Food_Insert_ID.getText());
            pst.setString(3, Theme_Insert_ID.getText());
            pst.setString(4, Photography_Insert_ID.getText());
            pst.executeUpdate();
            con.commit();
}
if(gt == "Holud Program")
{
        String sql = "INSERT INTO Holud (Venue, Food, Theme, Photography) VALUES (?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, Venue_Insert_ID.getText());
            pst.setString(2, Food_Insert_ID.getText());
            pst.setString(3, Theme_Insert_ID.getText());
            pst.setString(4, Photography_Insert_ID.getText());
            pst.executeUpdate();
            con.commit();
}
if(gt == "Reception Program")
{
        String sql = "INSERT INTO Reception (Venue, Food, Theme, Photography) VALUES (?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, Venue_Insert_ID.getText());
            pst.setString(2, Food_Insert_ID.getText());
            pst.setString(3, Theme_Insert_ID.getText());
            pst.setString(4, Photography_Insert_ID.getText());
            pst.executeUpdate();
            con.commit();
}

            Venue_Insert_ID.clear();
            Food_Insert_ID.clear();
            Theme_Insert_ID.clear();
            Photography_Insert_ID.clear();

   
    
    
    
   } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list1 ;
            
             list1=FXCollections.observableArrayList( "Birthday Event","Wedding Program","Holud Program","Reception Program");
             Insert_ComboID.setItems(list1);
        


    }    
    
}
