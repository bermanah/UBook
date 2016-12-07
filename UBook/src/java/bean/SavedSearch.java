/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author reitersg
 */
public class SavedSearch {
    String userName;
    int bookID;
    String dateOfSearch;
    String timeOfSearch;
    
    public SavedSearch(String userName, int bookID, String dateOfSearch, String timeOfSearch) {
        this.userName = userName;
        this.bookID = bookID;
        this.dateOfSearch = dateOfSearch;
        this.timeOfSearch = timeOfSearch;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getDateOfSearch() {
        return dateOfSearch;
    }

    public void setDateOfSearch(String dateOfSearch) {
        this.dateOfSearch = dateOfSearch;
    }

    public String getTimeOfSearch() {
        return timeOfSearch;
    }

    public void setTimeOfSearch(String timeOfSearch) {
        this.timeOfSearch = timeOfSearch;
    }
    
    
}
