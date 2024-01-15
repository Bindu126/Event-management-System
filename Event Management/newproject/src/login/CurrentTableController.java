/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CurrentTableController implements Initializable {
    Connection con =null;
    ResultSet rs = null;
    PreparedStatement pst=null  ;
    String test;

      @FXML
    private TableView<ModelTable> TableID;

    @FXML
    private TableColumn<ModelTable,String> VenueID;

    @FXML
    private TableColumn <ModelTable,String>FoodID;

    @FXML
    private TableColumn<ModelTable,String> ThemeID;

    @FXML
    private TableColumn <ModelTable,String>PhotographyID;
    ObservableList<ModelTable> oblist;
 
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13; " + "databaseName=project1;"; 
        con = DriverManager.getConnection(connectionUrl);
        oblist=FXCollections.observableArrayList();
            pst = con.prepareStatement("Select * from BEvent");
            rs = pst.executeQuery();
      
            while(rs.next()) {
                 
              
         oblist.add(new ModelTable(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
          VenueID.setCellValueFactory(new PropertyValueFactory("venue"));
          FoodID.setCellValueFactory(new PropertyValueFactory("food"));
          ThemeID.setCellValueFactory(new PropertyValueFactory("theme"));
           PhotographyID.setCellValueFactory(new PropertyValueFactory("photography"));
           TableID.setItems(oblist);
           
            }
        } catch (Exception e) {
            System.out.println("error="+e.getMessage());
        }
        
             
        // TODO
    }    
    
}
