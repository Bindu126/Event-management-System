/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package login;

import java.io.IOException;
import java.net.URL;
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

public class OwnerUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button InsertID;

    @FXML
    private Button DeleteID;

    @FXML
    private Button UpdateID;

    @FXML
    private Button CurrentID;

    @FXML
    private Button EditorLogoutID;

    @FXML
    void handleCurrentAction(ActionEvent event) throws IOException {
        Parent Owner = FXMLLoader.load(getClass().getResource("ItemsTable.fxml"));
        Scene src2 = new Scene (Owner);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
    }

    @FXML
    void handleDeleteAction(ActionEvent event) {

    }

    @FXML
    void handleEditorLogoutAction(ActionEvent event) throws IOException {
        
        Parent Owner = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene src2 = new Scene (Owner);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();

    }

    @FXML
    void handleInsertAction(ActionEvent event) throws IOException {

        Parent Owner = FXMLLoader.load(getClass().getResource("Insert.fxml"));
        Scene src2 = new Scene (Owner);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
        
    }

    @FXML
    void handleUpdateAction(ActionEvent event) {

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
