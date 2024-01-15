/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class BirthdayEventsController implements Initializable {
    Connection con =null;
    ResultSet rs = null;
    PreparedStatement pst=null  ;
    String venue1; 
    String venue2;
    String food1;
    String food2; 
    String theme1; 
    String theme2; 
    String photo1; 
    String photo2; 
     
    @FXML
    private ComboBox combo1;
     @FXML
    private ComboBox combo2;
      @FXML
    private ComboBox combo3;
          @FXML
    private ComboBox combo4;
           @FXML
    private Button DoneID;
             @FXML
    void handleDoneAction(ActionEvent event) {

    }
     @FXML
    private Button BirthdayBackID;

    @FXML
    void handleBirthdayBackAction(ActionEvent event) throws IOException {
         Parent BirthdayEvents = FXMLLoader.load(getClass().getResource("Events.fxml"));
       
        Scene src2 = new Scene (BirthdayEvents);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();

    }
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13; " + "databaseName=project1;";
            con = DriverManager.getConnection(connectionUrl);
            pst = con.prepareStatement("Select * from BEvent");
            rs = pst.executeQuery();
          
            while(rs.next()) {
                // TODO
             venue1=rs.getString(1);
             food1=rs.getString(2);
             theme1=rs.getString(3);
             photo1=rs.getString(4);
             rs.next();
             venue2=rs.getString(1);
             food2=rs.getString(2);
             theme2=rs.getString(3);
             photo2=rs.getString(4);
             
             ObservableList<String> list1 ;
            
             list1=FXCollections.observableArrayList( venue1,venue2);
             combo1.setItems(list1); 
             ObservableList<String> list2 ;
             list2=FXCollections.observableArrayList( food1,food2);
             combo2.setItems(list2);
             ObservableList<String> list3 ;
             list3=FXCollections.observableArrayList( theme1,theme2);
             combo3.setItems(list3);
             ObservableList<String> list4 ;
             list4=FXCollections.observableArrayList( photo1,photo2);
             combo4.setItems(list4);
            };
             
         
         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BirthdayEventsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BirthdayEventsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
  
 } 