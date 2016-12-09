/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AdminPrivileges;

import bean.Book;
import bean.User;
import java.util.ArrayList;

/**
 *
 * @author reitersg
 */
public class AdminActions {
    
     public static boolean deleteUser(String name) {
        User dropUser = new User(name, null, null, null, null);
        return AdminFunctions.deleteUser(dropUser);     
    }
     
    public static boolean deleteBook(int bookID) {
         Book dropBook = new Book(null, bookID, null, null, null, 0.0, 0);
         return AdminFunctions.deleteBook(dropBook);
    }
     
    public static ArrayList<User> getUsers(){
        return AdminFunctions.listUsers();
    }
    
    public static ArrayList<Book> getBooks(){
        return AdminFunctions.listBooks();
    }
}
