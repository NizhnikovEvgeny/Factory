/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Books.BookWithQuantity;
import Records.LibrarianRecord;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import users.User;

/**
 *
 * @author Женя
 */
public class DBManipulator {

    private String url = "jdbc:mysql://localhost/";
    private String username = "root";
    private String password = "root";
    private Connection con;

    public DBManipulator() {
    }

    private void connect() throws SQLException {
        con = DriverManager.getConnection(url, username, password);
    }

    public void checkConnection() throws SQLException {
        if (con.isValid(5)) {
            System.out.println("Работаем");
        } else {
            System.out.println("НЕ работаем");
        }
    }

    public void work(ArrayList<User> users, ArrayList<BookWithQuantity> books, ArrayList<LibrarianRecord> records) throws SQLException {
        connect();
        checkConnection();
        Statement statement = con.createStatement();
        boolean notDone = true;
        while (notDone) {
            try {
                statement.execute("CREATE TABLE factory.user("
                        + "id INT PRIMARY KEY,"
                        + "name VARCHAR(50),"
                        + "debt DECIMAL(20,2));");
                statement.execute("CREATE TABLE factory.book("
                        + "id INT PRIMARY KEY,"
                        + "name VARCHAR(300),"
                        + "type VARCHAR(20));");
                statement.execute("CREATE TABLE factory.record("
                        + "id INT PRIMARY KEY,"
                        + "book_id INT,"
                        + "user_id INT,"
                        + "take_date VARCHAR(50),"
                        + "expire_date VARCHAR(50),"
                        + "return_date VARCHAR(50),"
                        + "debt DECIMAL(8,2),"
                        + "FOREIGN KEY (book_id) REFERENCES factory.book (id),"
                        + "FOREIGN KEY (user_id) REFERENCES factory.user (id));");
                notDone = false;
            } catch (SQLException e) {
                statement.execute("DROP TABLE factory.record");
                statement.execute("DROP TABLE factory.user");
                statement.execute("DROP TABLE factory.book");
            }
        }
        for (User user : users) {
            statement.executeUpdate("INSERT INTO factory.user(id,name,debt)"
                    + " VALUES (" + user.getID() + ", '" + user.getName() + " " + user.getPatronymic() + " " + user.getSurname() + "' ," + "ROUND(" + user.getDebt() + ",2)" + ");");
        }
        for (BookWithQuantity book : books) {
            statement.execute("INSERT INTO factory.book(id,name,type) "
                    + "VALUES (" + book.getId() + ", '" + book.getBook().getName() + "' , '" + book.getBook().getType() + "' );");
        }
        for (LibrarianRecord record : records) {
            statement.execute("INSERT INTO factory.record(id,book_id,user_id,take_date,expire_date,return_date,debt) "
                    + "VALUES (" + record.getId() + ","
                    + record.getBook().getId() + ","
                    + record.getUser().getID() + ", '"
                    + record.getTakeDate() + "' , '"
                    + record.getExpireDate() + "' , '"
                    + record.getReturnDate() + "' ,"
                    + record.getDebt() + ");");
        }
        con.close();
    }
}
