/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import bean.*;
import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.naming.*;
 /**
 * @author reitersg
 */
public class Database {
    public static boolean addUser(User user){
        DBHandler handler = new DBHandler();
        String command = "INSERT INTO user VALUES(";
        command += "'" + user.getUserName() + "'";
        command += ", '" + user.getUserType() + "'";
        command += ", '" + user.getPassword() + "'";
        command += ", '" + user.getEmail() + "'";
        command += ", '" + user.getUniversity() + "'" ;
        command += ")";
        try {
           int resultCount = handler.doCommand(command.toString());
            handler.close();
            return (resultCount > 0);
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean addBook(Book book){
        DBHandler handler = new DBHandler();
        StringBuilder command = new StringBuilder();
        command.append("INSERT INTO book VALUES( ");
        command.append("'" + book.getUserName() + "'");
        command.append(", '" + book.getBookID() + "'");
        command.append(", '" + book.getISBN() + "'");
        command.append(", '" + book.getCondition() + "'");
        command.append(", '" + book.getBookDescription() + "'");
        command.append(", '" + book.getPrice() + "'");
        command.append(", '" + book.isNegotiable() + "'");
        command.append(")");
          try {
           int resultCount = handler.doCommand(command.toString());
            handler.close();
            return (resultCount > 0);
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean addSavedSearch(SavedSearch ss){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        DBHandler handler = new DBHandler();
        StringBuilder command = new StringBuilder();
        command.append("INSERT INTO savedsearches VALUES( ");
        command.append("'" + ss.getUserName() + "'");
        command.append(", '" + ss.getBookID() + "'");
        command.append(", '" + dateFormat.format(date) + "'");
        command.append(", '" + timeFormat.format(date) + "'");
        command.append(")");
        try {
            int resultCount = handler.doCommand(command.toString());
            handler.close();
            return (resultCount > 0);
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
                
    }
    
    public static int checkLogin(User user){
        DBHandler handler = new DBHandler();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM user WHERE Username = '" + user.getUserName() + "' AND password = '"+ user.getPassword() + "';");
        try {
            ResultSet set = handler.doQuery(query.toString());
            int result = 0;
            if (set.first()){
                result = 1;
            }
            handler.close();
            return result;
            
        } catch (SQLException e){
            e.printStackTrace();;
            return 0;
        }
            
    }
    public static ArrayList<Book> searchBooks(String ISBN){
            ArrayList<Book> result = new ArrayList<Book>();
            String query = "SELECT * from book WHERE ISBN = '" + ISBN + "'";
            try {
                DBHandler handler = new DBHandler();
                ResultSet set = handler.doQuery(query);
                ResultSetMetaData rsmd = set.getMetaData();
                while (set.next()){
                    int i = 1; // 1st column
                    String userName = set.getString(i++);
                    int bookID = set.getInt(i++);
                    String ISBN2 = set.getString(i++);
                    String condition = set.getString(i++);
                    String bookDescription = set.getString(i++);
                    long price = set.getLong(i++);
                    int negotiable = set.getInt(i++);
                    Book book = new Book(userName, bookID, ISBN2, condition, bookDescription, price, negotiable);
                    result.add(book);
                }
                handler.close();
             }
             catch (SQLException e){
               e.printStackTrace();
             }
            return result;
    }     
    
    public static ArrayList<SavedSearch> getSavedSearches(String userName){
            ArrayList<SavedSearch> result = new ArrayList<SavedSearch>();
            DBHandler handler = new DBHandler();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * from savedsearches WHERE Username = '" + userName + "'");
            try {
                ResultSet set = handler.doQuery(query.toString());
                while (set.next()){
                      int i = 1; // 1st column
                    String user = set.getString(i++);
                    int bookID = set.getInt(i++);
                    String date = set.getString(i++);
                    String time = set.getString(i++);
                    SavedSearch ss = new SavedSearch(userName, bookID, date, time);
                    result.add(ss);
            }
                handler.close();
                }
             catch (SQLException e){
               e.printStackTrace();
             }
            return result;
    }          
     public static boolean deleteBook(Book book){
        DBHandler handler = new DBHandler();
        StringBuilder command = new StringBuilder();
        command.append("DELETE FROM book WHERE Username = '" + book.getUserName() + "' AND ISBN = '" + book.getISBN() + "'");
         try {
           int resultCount = handler.doCommand(command.toString());
            handler.close();
            return (resultCount > 0);
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        
    }
     
    public static ArrayList<User> getUser(String username){
        ArrayList<User> user = new ArrayList<User>();
            String query = "SELECT * from user WHERE  Username = '" + username + "'";
            try {
                DBHandler handler = new DBHandler();
                ResultSet set = handler.doQuery(query);
                ResultSetMetaData rsmd = set.getMetaData();
                while (set.next()){
                    int i = 1; // 1st column
                    String userName = set.getString(i++);
                    String usertype = set.getString(i++);
                    String password = set.getString(i++);
                    String email = set.getString(i++);
                    String uni = set.getString(i++);
                    User loginUser = new User(userName, usertype, password, email, uni);
                    user.add(loginUser);
                }
                handler.close();
             }
             catch (SQLException e){
               e.printStackTrace();
             }
            return user;
    }  
    
    public static int checkUserName(User user){
        DBHandler handler = new DBHandler();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM user WHERE Username = '" + user.getUserName() + "'");
        try {
            ResultSet set = handler.doQuery(query.toString());
            //handler.close();
            int result = 0;
            if (set.next())
            {
                result = 1;
            }
            handler.close();
            return result;
            
        } catch (SQLException e){
            e.printStackTrace();;
            return 0;
        }
            
    }
    
    public static ArrayList<Book> getSellingBooks(User user){
            ArrayList<Book> result = new ArrayList<Book>();
            String query = "SELECT * from book WHERE Username = '" + user.getUserName() + "'";
            try {
                DBHandler handler = new DBHandler();
                ResultSet set = handler.doQuery(query);
                ResultSetMetaData rsmd = set.getMetaData();
                while (set.next()){
                    int i = 1; // 1st column
                    String userName = set.getString(i++);
                    int bookID = set.getInt(i++);
                    String ISBN2 = set.getString(i++);
                    String condition = set.getString(i++);
                    String bookDescription = set.getString(i++);
                    long price = set.getLong(i++);
                    int negotiable = set.getInt(i++);
                    Book book = new Book(userName, bookID, ISBN2, condition, bookDescription, price, negotiable);
                    result.add(book);
                }
                handler.close();
             }
             catch (SQLException e){
               e.printStackTrace();
             }
            return result;
    } 
    
    public static ArrayList<Book> getBookInfo(int bookID){
            ArrayList<Book> result = new ArrayList<Book>();
            String query = "SELECT * from book WHERE bookID = '" + bookID + "'";
            try {
                DBHandler handler = new DBHandler();
                ResultSet set = handler.doQuery(query);
                ResultSetMetaData rsmd = set.getMetaData();
                while (set.next()){
                    int i = 1; // 1st column
                    String userName = set.getString(i++);
                    int bookID1 = set.getInt(i++);
                    String ISBN2 = set.getString(i++);
                    String condition = set.getString(i++);
                    String bookDescription = set.getString(i++);
                    long price = set.getLong(i++);
                    int negotiable = set.getInt(i++);
                    Book book = new Book(userName, bookID, ISBN2, condition, bookDescription, price, negotiable);
                    result.add(book);
                }
                handler.close();
             }
             catch (SQLException e){
               e.printStackTrace();
             }
            return result;
    } 
}
  

