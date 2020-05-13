/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Records;

import Books.BookWithQuantity;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import users.User;

/**
 *
 * @author Женя
 */
public class Librarian {

    int numberOfRegisteredUsers = 0;

    public void createRecord(Date date, ArrayList<BookWithQuantity> BookList, ArrayList<User> UserList) {
        int randomBook = (int) Math.floor(Math.random() * BookList.size());
        int randomUser = (int) Math.floor(Math.random() * UserList.size());
        if (!UserList.get(randomUser).isRegistered) {
            registerUser(UserList.get(randomUser));
        }
        if (BookList.get(randomBook).getQuantity() > 0) {
            LibrarianRecord record = new LibrarianRecord();
            record.setBook(takeBook(randomBook, BookList));
            record.setUser(setUser(randomUser, UserList));
            record.setTakeDate(date);
            Date expireDate = new Date(date.getTime() + (1000 * 60 * 60 * 24));
            record.setExpireDate(expireDate);
            record.pricePerDay = BookList.get(randomBook).getPricePerDay();
            record.pricePerExtraDay = BookList.get(randomBook).getPricePerExtraDay();
            giveBookToUser(randomUser, UserList, record);
        } else {
            System.out.println("КНИГА КОНЧИЛАСЬ");
        }

    }

    public void returnBook(Date date, ArrayList<BookWithQuantity> BookList, ArrayList<User> UserList) throws Exception {
        int randomUser = (int) Math.floor(Math.random() * UserList.size());
        User user = UserList.get(randomUser);
        if (user.isRegistered && !user.records.isEmpty()) {
            int numberOfBookReturn = (int) Math.floor(Math.random() * user.records.size());
            countDebt(date, numberOfBookReturn, user);

            user.records.get(numberOfBookReturn).book.increaseQuantity();
            System.out.println("Количество книг увеличилось и стало " + user.records.get(numberOfBookReturn).book.getQuantity());
            user.records.remove(numberOfBookReturn);
        } else {
            throw new Exception();
        }
    }

    private BookWithQuantity takeBook(int randomBook, ArrayList<BookWithQuantity> BookList) {
        BookList.get(randomBook).decreaseQuantity();
        System.out.println("Количество книг уменьшилось и стало " + BookList.get(randomBook).getQuantity());
        return BookList.get(randomBook);
    }

    private User setUser(int randomUser, ArrayList<User> UserList) {

        return UserList.get(randomUser);
    }

    private void giveBookToUser(int randomUser, ArrayList<User> UserList, LibrarianRecord record) {
        UserList.get(randomUser).records.add(record);
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

        if ((date.getTime() - user.records.get(numberOfBookReturn).expireDate.getTime()) < 0) { //Это если сдал вовремя
            double debt = diff * user.records.get(numberOfBookReturn).pricePerDay;
            user.addToDebt(debt);
            System.out.println(debt);
        } else {            //Если сдал позже срока
            long normalDiffInMillies = Math.abs(user.records.get(numberOfBookReturn).expireDate.getTime() - user.records.get(numberOfBookReturn).takeDate.getTime());
            long normalDiff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            long extraDiffInMillies = Math.abs(date.getTime() - user.records.get(numberOfBookReturn).expireDate.getTime());
            long extraDiff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            double debt = normalDiff * user.records.get(numberOfBookReturn).pricePerDay + extraDiff * user.records.get(numberOfBookReturn).pricePerExtraDay;
            user.addToDebt(debt);
            System.out.println(debt);
        }
    }
}
