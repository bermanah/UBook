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
}
