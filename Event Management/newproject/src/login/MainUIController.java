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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 19010
 */
public class MainUIController implements Initializable {

        Connection con =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
String abc;

    @FXML
    private Button LogoutID;

    @FXML
    private Button InstructionsID;

    @FXML
    private Button PaymentID;

    @FXML
    private Button EventsID;

    @FXML
    private Button CreditID;

    @FXML
    void handleEventsAction(ActionEvent event) throws ClassNotFoundException, SQLException,IOException {
        Parent MainUI = FXMLLoader.load(getClass().getResource("Events.fxml"));
        Scene src2 = new Scene (MainUI);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
    }

    @FXML
    void handleInstructionsAction(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        Parent ins = FXMLLoader.load(getClass().getResource("Instruction.fxml"));
        Scene src2 = new Scene (ins);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();


        


    }

    @FXML
    void handleLogoutAction(ActionEvent event)throws ClassNotFoundException, SQLException,IOException {

        Parent MainUI = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene src2 = new Scene (MainUI);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
        
    }

    @FXML
    void handlePaymentAction(ActionEvent event) throws IOException {
        Parent Payment1 = FXMLLoader.load(getClass().getResource("Payment.fxml"));
        Scene srcr = new Scene (Payment1);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(srcr);
        app_primaryStage.show();

    }
    
    @FXML
    void handleCreditAction(ActionEvent event) throws IOException, ClassNotFoundException, SQLException{
        Parent ins1 = FXMLLoader.load(getClass().getResource("Credit.fxml"));
        Scene src2 = new Scene (ins1);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
