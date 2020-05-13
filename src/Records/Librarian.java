/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Records;

import Books.BookWithQuantity;
import java.util.ArrayList;
import java.util.Date;
import users.User;

/**
 *
 * @author Женя
 */
public class Librarian {

    public void createRecord(Date date, ArrayList<BookWithQuantity> BookList, ArrayList<User> UserList, ArrayList<LibrarianRecord> RecordList) {
        int randomBook = (int) Math.floor(Math.random() * BookList.size());
        int randomUser = (int) Math.floor(Math.random() * UserList.size());
        if (!UserList.get(randomUser).isRegistered) {
            registerUser(UserList.get(randomUser));
        }
        if (BookList.get(randomBook).getQuantity() > 0) {
            LibrarianRecord record = new LibrarianRecord();
            record.setBook(takeBook(randomBook, BookList));
            record.setUser(setBook(randomUser, UserList));
            record.setTakeDate(date);
            giveBookToUser(randomUser, UserList, record);
            RecordList.add(record);
        }

    }

    private BookWithQuantity takeBook(int randomBook, ArrayList<BookWithQuantity> BookList) {
        BookList.get(randomBook).decreaseQuantity();
        return BookList.get(randomBook);
    }

    private User setBook(int randomUser, ArrayList<User> UserList) {

        return UserList.get(randomUser);
    }

    private void giveBookToUser(int randomUser, ArrayList<User> UserList, LibrarianRecord record) {
        UserList.get(randomUser).records.add(record);
    }

    private void registerUser(User user) {
        user.isRegistered = true;
    }
}
