/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AdminPrivileges;

import bean.Book;
import bean.User;
import database.DBHandler;
import java.sql.SQLException;
/**
 *
 * @author reitersg
 */
public class AdminFunctions {
    
        public static boolean deleteBook(Book book){
        DBHandler handler = new DBHandler();
        StringBuilder command = new StringBuilder();
        command.append("DELETE FROM book WHERE Username = " + book.getUserName() + "AND ISBN = " + book.getISBN());
         try {
           int resultCount = handler.doCommand(command.toString());
            handler.close();
            return (resultCount > 0);
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
