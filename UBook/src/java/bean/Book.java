/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Random;
import java.util.UUID;

/**
 *
 * @author reitersg
 */
public class Book {

    Random rnd = new Random();
    private String userName;
    private int bookID = rnd.nextInt(10000000);
    private int ISBN;

    public Book(String userName, int bookID, int ISBN2, String condition, String bookDescription, long price, int negotiable) {
        this.setUserName(userName);
        this.setNegotiable(negotiable);
        this.setISBN(ISBN2);
        this.setPrice(price);
        this.setCondition(condition);
        this.setBookID(bookID);
        this.setBookDescription(bookDescription);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBookID() {
        return bookID;
    }
    
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int isNegotiable() {
        return this.negotiable;
    }

    public void setNegotiable(int negotiable) {
           this.negotiable = negotiable;
    }
    private String condition;
    private String bookDescription;
    private long price;
    private int negotiable;

}
