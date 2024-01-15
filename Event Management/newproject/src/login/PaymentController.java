/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

 

/**
 * FXML Controller class
 *
 * @author USER
 */
public class PaymentController implements Initializable {
    
    @FXML
    private Button PaymentBackID;
     @FXML
    private Button Confirm_ID;
    @FXML
    void handleConfirmAction(ActionEvent event) {

    }

    @FXML
    void handlePaymentBackAction(ActionEvent event) throws IOException {
        Parent Payment = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
       
        Scene src4 = new Scene (Payment);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src4);
        app_primaryStage.show();

    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
