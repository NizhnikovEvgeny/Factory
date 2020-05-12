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
    User user;
    BookWithQuantity book;
    Date takeDate;
    Date expireDate;
    
    public LibrarianRecord(){
        
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
    
}