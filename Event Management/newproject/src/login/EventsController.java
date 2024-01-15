/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package login;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 19010
 */
public class EventsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
        @FXML
    private Button BirthdayID;

    @FXML
    private Button WeddingID;

    @FXML
    private Button EventsBackID;

    @FXML
    void handleBirthdayAction(ActionEvent event) throws IOException {

Parent Events = FXMLLoader.load(getClass().getResource("BirthdayEvents.fxml"));
        Scene src2 = new Scene (Events);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
    }

    @FXML
    void handleEventsBackAction(ActionEvent event)throws ClassNotFoundException, SQLException,IOException {

        Parent Events = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
        Scene src2 = new Scene (Events);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
        
    }

    @FXML
    void handleWeddingAction(ActionEvent event)throws ClassNotFoundException, SQLException,IOException {

        Parent Events = FXMLLoader.load(getClass().getResource("WeddingEvents.fxml"));
        Scene src2 = new Scene (Events);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
