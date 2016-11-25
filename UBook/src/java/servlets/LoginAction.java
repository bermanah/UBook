/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import database.Database;
/**
 *
 * @author reitersg
 */
public class LoginAction extends ActionSupport {
    private User user;
    @Override
     public String execute(){
         int exists = Database.checkLogin(user);
         if (exists == 1){
             return SUCCESS;
         } else {
             return ERROR;
         }
     }
     
}
