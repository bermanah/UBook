/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import bean.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.*;
 /**
 * @author reitersg
 */
public class Database {
    public static boolean addUser(User user){
        DBHandler handler = new DBHandler();
        StringBuilder command = new StringBuilder();
        command.append("INSERT INTO user VALUES( ");
        command.append("'" + user.getUserName() + "'");
        command.append(", '" + user.getUserType() + "'");
        command.append(", '" + user.getPassword() + "'");
        command.append(", '" + user.getEmail() + "'");
        command.append(", '" + user.getUniversity() + "'" );
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
        query.append("SELECT count(*) FROM user WHERE Username = " + user.getUserName() + "AND password = "+user.getPassword());
        try {
            ResultSet set = handler.doQuery(query.toString());
            handler.close();
            set.first();
            return set.getInt(1);
        } catch (SQLException e){
            e.printStackTrace();;
            return 0;
        }
            
    }
    public static ArrayList<Book> searchBooks(String ISBN){
            ArrayList<Book> result = new ArrayList<Book>();
            DBHandler handler = new DBHandler();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * from book WHERE ISBN = " + ISBN);
            try {
                ResultSet set = handler.doQuery(query.toString());
                while (set.next()){
                      int i = 1; // 1st column
                String userName = set.getString(i++);
                int bookID = set.getInt(i++);
                int ISBN2 = set.getInt(i++);
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
            query.append("SELECT * from savedsearches WHERE Username = " + userName);
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
}
  

