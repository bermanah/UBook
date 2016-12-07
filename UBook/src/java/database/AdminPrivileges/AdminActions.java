/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AdminPrivileges;

import bean.User;

/**
 *
 * @author reitersg
 */
public class AdminActions {
    
     public static boolean deleteUser(String name) {
        User dropUser = new User(name, null, null, null, null);
        return AdminFunctions.deleteUser(dropUser);     
    }
}
