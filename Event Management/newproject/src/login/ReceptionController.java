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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 19010
 */
public class ReceptionController implements Initializable {

    /**
     * Initializes the controller class.
     */
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
    private Button ReceptionBackID;

    @FXML
    private ComboBox receptioncombo1;

    @FXML
    private ComboBox receptioncombo2;

    @FXML
    private ComboBox receptioncombo3;

    @FXML
    private ComboBox receptioncombo4;

    @FXML
    private Button ReceptionDONE;



    @FXML
    void handleReceptionDONEAction(ActionEvent event) {

    }

    @FXML
    void handleReceptioncombo1Action(ActionEvent event) {

    }

    @FXML
    void handleReceptioncombo2Action(ActionEvent event) {

    }

    @FXML
    void handleReceptioncombo3Action(ActionEvent event) {

    }

    @FXML
    void handleReceptioncombo4Action(ActionEvent event) {

    }
    
    

    @FXML
    void handleReceptionBackAction(ActionEvent event) throws IOException {
        
              Parent Reception = FXMLLoader.load(getClass().getResource("WeddingEvents.fxml"));
       
        Scene src2 = new Scene (Reception);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13; " + "databaseName=project1;";
            con = DriverManager.getConnection(connectionUrl);
            pst = con.prepareStatement("Select * from Reception");
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
             receptioncombo1.setItems(list1);
             ObservableList<String> list2 ;
             list2=FXCollections.observableArrayList( food1,food2);
             receptioncombo2.setItems(list2);
             ObservableList<String> list3 ;
             list3=FXCollections.observableArrayList( theme1,theme2);
             receptioncombo3.setItems(list3);
             ObservableList<String> list4 ;
             list4=FXCollections.observableArrayList( photo1,photo2);
             receptioncombo4.setItems(list4); 
            };
             
         
         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BirthdayEventsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BirthdayEventsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
        // TODO
    }    
    

