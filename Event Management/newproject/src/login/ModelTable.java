/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author USER
 */
class ModelTable {
    String venue,food,theme,photgraphy;

      public ModelTable(String venue, String food, String theme, String photgraphy) {
        this.venue =  venue;
        this.food =  food;
        this.theme =  theme;
        this.photgraphy =  photgraphy;
    }

    public String getVenue() {
        return venue;
    }

//    public void setVenue(String venue) {
//        this.venue = venue;
//    }

    public String getFood() {
        return food;
    }

//    public void setFood(String food) {
//        this.food = food;
//    }

    public String getTheme() {
        return theme;
    }

//    public void setTheme(String theme) {
//        this.theme = theme;
//    }

    public String getPhotgraphy() {
        return photgraphy;
    }

//    public void setPhotgraphy(String photgraphy) {
//        this.photgraphy = photgraphy;
//    }


    
}
