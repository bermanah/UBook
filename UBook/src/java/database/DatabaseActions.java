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

    public static boolean addBook(String userName, String ISBN, String condition, String description, double price, int negotiable) {
        Book newBook = new Book(userName, ISBN, condition, description, price, negotiable);
        return Database.addBook(newBook);
    }
    
    public static boolean addSavedSearch(String userName, int bookID) {
        SavedSearch ss = new SavedSearch();
        ss.setBookID(bookID);
        ss.setUserName(userName);
        return Database.addSavedSearch(ss);
    }
    public static boolean deleteBook(int bookID) {
        Book dropBook = new Book();
        dropBook.setBookID(bookID);
        return Database.deleteBook(dropBook);
    }
    
    public static ArrayList<Book> searchBooks(String ISBN) {
        return Database.searchBooks(ISBN);
    } 
    public static boolean checkLogin(String userName, String password) {
        User user  = new User(userName, null, password, null, null);
        int check = Database.checkLogin(user);
        if (check == 1){
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<SavedSearch> getSavedSearches(String userName){
        return Database.getSavedSearches(userName);
    }
    
    public static ArrayList<User> getUser(String username){
        return Database.getUser(username);
    }
    
    public static boolean checkUserName(String userName) {
        User user  = new User(userName, null, null, null, null);
        int check = Database.checkUserName(user);
        if (check == 0){
            return true;
        } else {
            return false;
        }
    }
    
    public static ArrayList<Book> getSellingBooks(String username){
        User user = new User(username, null, null, null, null);
        return Database.getSellingBooks(user);
    }
    
    public static Book getBooksInfo(int bookID){
        ArrayList<Book> list = new ArrayList<Book>();
        Book book = new Book(list.get(1).getUserName(), list.get(1).getISBN(), list.get(1).getCondition(), list.get(1).getBookDescription(), 
                list.get(1).getPrice(), list.get(1).isNegotiable());
        return book;

    }




    
}
