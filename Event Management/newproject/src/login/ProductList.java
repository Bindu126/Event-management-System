/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author USER
 */
public class ProductList {

    /**
     * @return the Venue
     */
    public String getVenue() {
        return Venue;
    }

    /**
     * @param Venue the Venue to set
     */
    public void setVenue(String Venue) {
        this.Venue = Venue;
    }
    private String Venue;

    public ProductList(String Venue) {
        this.Venue = Venue;
    }
    
}
