/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Records;

import Books.BookWithQuantity;
import factoryexample.DataManipulator;
import factoryexample.DateManipulator;
import factoryexample.Frame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import users.User;

/**
 *
 * @author Женя
 */
public class Librarian {

    int numberOfRegisteredUsers = 0;
    public ArrayList<LibrarianRecord> allRecords = new ArrayList<>();

    public void createRecord(Date date, ArrayList<BookWithQuantity> BookList, ArrayList<User> UserList, DateManipulator dateM) {
        int randomBook = (int) Math.floor(Math.random() * BookList.size());
        int randomUser = (int) Math.floor(Math.random() * UserList.size());
        User user = UserList.get(randomUser);
        BookWithQuantity book = BookList.get(randomBook);
        if (!user.isRegistered) {
            registerUser(user);
        }
        if (book.getQuantity() > 0) {
            LibrarianRecord record = new LibrarianRecord();
            record.setBook(takeBook(book));
            record.setUser(user);
            record.setTakeDate(date);
            record.setExpireDate(dateM.getNextMonth());
            giveBookToUser(user, record);
            allRecords.add(record);
        } else {
            Frame.text += "КНИГА КОНЧИЛАСЬ\n";
            System.out.println("КНИГА КОНЧИЛАСЬ");
        }

    }

    public void returnBook(Date date, ArrayList<BookWithQuantity> BookList, ArrayList<User> UserList) {
        int randomUser = (int) Math.floor(Math.random() * UserList.size());
        User user = UserList.get(randomUser);
        int numberOfBookReturn = (int) Math.floor(Math.random() * user.records.size());
        countDebt(date, numberOfBookReturn, user);
        user.records.get(numberOfBookReturn).book.increaseQuantity();
        System.out.println("Количество книг увеличилось и стало " + user.records.get(numberOfBookReturn).book.getQuantity());
        Frame.text += "Количество книг увеличилось и стало " + user.records.get(numberOfBookReturn).book.getQuantity() + "\n";
        user.records.get(numberOfBookReturn).setReturnDate(date);
        user.records.remove(numberOfBookReturn);
        if (!user.hasBooks()) {
            UserList.remove(randomUser);
        }
    }

    private BookWithQuantity takeBook(BookWithQuantity book) {
        book.decreaseQuantity();
        System.out.println("Количество книг уменьшилось и стало " + book.getQuantity());
        Frame.text += "Количество книг уменьшилось и стало " + book.getQuantity() + "\n";
        return book;
    }

    private User setUser(int randomUser, ArrayList<User> UserList) {

        return UserList.get(randomUser);
    }

    private void giveBookToUser(User user, LibrarianRecord record) {
        user.records.add(record);
    }

    private void registerUser(User user) {
        user.isRegistered = true;
        user.records = new ArrayList<>();
        numberOfRegisteredUsers++;
    }

    public int getNumberOfRegisteredUsers() {
        return numberOfRegisteredUsers;
    }

    private void countDebt(Date date, int numberOfBookReturn, User user) {
        long diffInMillies = Math.abs(date.getTime() - user.records.get(numberOfBookReturn).takeDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        //Это если сдал вовремя
        double debt = diff * user.records.get(numberOfBookReturn).book.getPricePerDay();

        if (date.getTime() > user.records.get(numberOfBookReturn).expireDate.getTime()) {      //Если сдал позже срока
            long normalDiffInMillies = Math.abs(user.records.get(numberOfBookReturn).expireDate.getTime() - user.records.get(numberOfBookReturn).takeDate.getTime());
            long normalDiff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            long extraDiffInMillies = Math.abs(date.getTime() - user.records.get(numberOfBookReturn).expireDate.getTime());
            long extraDiff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            debt = normalDiff * user.records.get(numberOfBookReturn).book.getPricePerDay() + extraDiff * user.records.get(numberOfBookReturn).book.getPricePerExtraDay();
        }
        user.addToDebt(debt);
        user.records.get(numberOfBookReturn).setDebt(debt);
        System.out.println(debt);
        Frame.text += debt + "\n";
    }
}
