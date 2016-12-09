/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AdminPrivileges;

import bean.Book;
import bean.User;
import database.DBHandler;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author reitersg
 */
public class AdminFunctions {
    
 
        public static boolean deleteUser(User user){
            DBHandler handler = new DBHandler();
            StringBuilder command = new StringBuilder();
            command.append("DELETE FROM user WHERE Username = '" + user.getUserName() + "'");
            try {
                int resultCount = handler.doCommand(command.toString());
                handler.close();
                return (resultCount > 0);
            } catch (SQLException e) {
                e.printStackTrace();
               return false;
            }
        }
        
        public static boolean deleteBook(Book book){
            DBHandler handler = new DBHandler();
            StringBuilder command = new StringBuilder();
            command.append("DELETE FROM book WHERE bookID = '" + book.getBookID() + "'");
            try {
                int resultCount = handler.doCommand(command.toString());
                handler.close();
                return (resultCount > 0);
            } catch (SQLException e) {
                e.printStackTrace();
               return false;
            }
        }
        
        public static ArrayList<Book> listBooks(){
        ArrayList<Book> result = new ArrayList<Book>();
        String query = "SELECT * from book";
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
            
    public static ArrayList<User> listUsers(){
        ArrayList<User> result = new ArrayList<User>();
        String query = "SELECT * from user";
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
                result.add(loginUser);
            }
            handler.close();
         }
         catch (SQLException e){
           e.printStackTrace();
         }
        return result;
    } 
}
