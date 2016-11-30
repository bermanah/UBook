/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * 
 * @author Thomas Erlendson
 * @version 1.0
 */
public class Book {
    private String userName;
    private int bookID;
    private int isbn;
    private double price;
    private boolean negotiable;
    private String condition;
    private String description;
    
    /**
     * Initialize a Book object.
     * 
     * @param seller - The person selling the book
     * @param id - the book's id
     * @param isbn - the ISBN 
     * @param price - price of the book
     * @param negotiable - if the price is negotiable
     * @param condition - short description of the condition
     * @param description - description of the book itself
     */
    public Book(String seller, int id, int isbn, double price, boolean negotiable,
            String condition, String description) {
        this.userName = seller;
        this.bookID = id;
        this.isbn = isbn;
        this.price = price;
        this.negotiable = negotiable;
        this.condition = condition;
        this.description = description;
    }

    /**
     * Get the book's seller.
     * @return The book's seller
     */    
    public String getUserName() {
        return userName;
    }

    /**
     * Get the book's ID.
     * @return the book's ID.
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * Get the book's ISBN.
     * @return the book's ISBN
     */
    public int getISBN() {
        return isbn;
    }

    /**
     * Get the book's price.
     * @return the price of the book
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the book's negotiaion status.
     * @return whether the book's price is negotiable 
     */
    public boolean isNegotiable() {
        return negotiable;
    }

    /**
     * Get the condition of the book.
     * @return the condition of the book
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Get the book;s description.
     * @return the description of the book
     */
    public String getBookDescription() {
        return description;
    }
}
