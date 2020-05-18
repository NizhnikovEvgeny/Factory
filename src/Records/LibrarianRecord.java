/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Records;

import Books.BookWithQuantity;
import java.util.Date;
import users.User;

/**
 *
 * @author Dmitry
 */
public class LibrarianRecord {
    static int id_all = 1;
    User user;
    BookWithQuantity book;
    Date takeDate;
    Date expireDate;
    Date returnDate;
    int id;
    double debt;
    
    public LibrarianRecord(){
        id = id_all++;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(BookWithQuantity book) {
        this.book = book;
    }

    public void setTakeDate(Date takeDate) {
        this.takeDate = takeDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public User getUser() {
        return user;
    }

    public BookWithQuantity getBook() {
        return book;
    }

    public Date getTakeDate() {
        return takeDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public int getId() {
        return id;
    }

    public double getDebt() {
        return debt;
    }
    
}