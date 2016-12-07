/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import bean.Book;
import bean.SavedSearch;
import bean.User;
import java.util.ArrayList;

/**
 *
 * @author reitersg
 */
public class DatabaseActions {

   
    public static boolean addUser(String userName, String userType, String password, String email,
            String university) {

        User newUser = new User(userName, userType, password, email, university);
        return Database.addUser(newUser);
    }

    public static boolean addBook(String userName, float ISBN, String condition, String description, double price, int negotiable) {
        Book newBook = new Book(userName, ISBN, condition, description, price, negotiable);
        return Database.addBook(newBook);
    }
    public static boolean addSavedSearch(String userName, int bookID) {
        SavedSearch ss = new SavedSearch();
        ss.setBookID(bookID);
        ss.setUserName(userName);
        return Database.addSavedSearch(ss);
    }
    
    public static ArrayList<Book> searchBooks(String ISBN) {
        return Database.searchBooks(ISBN);
    } 

    public static ArrayList<SavedSearch> getSavedSearches(String userName){
        return Database.getSavedSearches(userName);
    }

    
}
