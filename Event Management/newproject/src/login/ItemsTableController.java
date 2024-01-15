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
import java.util.ResourceBundle;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Shahid Hasan
 */
public class ItemsTableController implements Initializable {
    Connection con =null;
    ResultSet rs = null;
    PreparedStatement pst=null  ;
    String test;

    @FXML
    private Button ItemsTableID;

    @FXML
    private TableColumn<ShowData, String> FoodID;

    @FXML
    private TableColumn<ShowData, String> PhotographyID;

    @FXML
    private TableColumn<ShowData, String> ThemeID;

    @FXML
    private TableColumn<ShowData, String> VenueID;

    @FXML
    private TableView<ShowData> TableID;


    private ObservableList<ShowData>oblist;

    @FXML
    void handleItemsTableIDBackAction(ActionEvent event) throws IOException {
        Parent items = FXMLLoader.load(getClass().getResource("OwnerUI.fxml"));
        Scene src3 = new Scene (items );
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src3);
        app_primaryStage.show();
    }
public void open()
{
try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13; " + "databaseName=project1;"; 
        con = DriverManager.getConnection(connectionUrl);

        oblist=FXCollections.observableArrayList();
        rs=con.createStatement().executeQuery("SELECT * FROM BEvent");
        while (rs.next()) {                
            oblist.add(new ShowData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
}
}catch(Exception e){
    System.out.println("abc");
}
        VenueID.setCellValueFactory(new PropertyValueFactory("v"));
        FoodID.setCellValueFactory(new PropertyValueFactory("f"));
        ThemeID.setCellValueFactory(new PropertyValueFactory("t"));
        PhotographyID.setCellValueFactory(new PropertyValueFactory("p"));
    //  TableID.setItems(null);
      TableID.setItems(oblist);
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
open();
    }    
    
}
