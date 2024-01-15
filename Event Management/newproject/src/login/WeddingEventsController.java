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
public class WeddingEventsController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
    private Button WeddingEventsBackID;

    @FXML
    private Button WeddingProgramID;

    @FXML
    private Button HoludProgramID;

    @FXML
    private Button ReceptionProgramID;

    @FXML
    void handleHoludProgramAction(ActionEvent event)throws ClassNotFoundException, SQLException,IOException {
        
        Parent WeddingEvents = FXMLLoader.load(getClass().getResource("HoludPro.fxml"));
        Scene src2 = new Scene (WeddingEvents);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();

    }

    @FXML
    void handleReceptionProgramAction(ActionEvent event)throws ClassNotFoundException, SQLException,IOException {
        
        Parent WeddingEvents = FXMLLoader.load(getClass().getResource("Reception.fxml"));
        Scene src2 = new Scene (WeddingEvents);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();

    }

    @FXML
    void handleWeddingEventsBackAction(ActionEvent event)throws ClassNotFoundException, SQLException,IOException {

        Parent WeddingEvents = FXMLLoader.load(getClass().getResource("Events.fxml"));
        Scene src2 = new Scene (WeddingEvents);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
    }

    @FXML
    void handleWeddingProgramAction(ActionEvent event) throws IOException {
       Parent WeddingEvents = FXMLLoader.load(getClass().getResource("WeddingProgram.fxml"));
        Scene src2 = new Scene (WeddingEvents);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
