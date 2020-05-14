/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryexample;

import Books.BookFactory;
import Books.BookWithQuantity;
import Books.EnglishBookFactory;
import Books.EnglishTextbook;
import Books.RussianBookFactory;
import Books.RussianFiction;
import Books.RussianTextbook;
import Books.EnglishFiction;
import Records.Librarian;
import Records.LibrarianRecord;
import users.Teacher;
import users.Student;
import users.User;
import users.UserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dmitry
 */
public class DataManipulator {

    ArrayList<User> Users;
    ArrayList<BookWithQuantity> Books = new ArrayList<>();
    ArrayList<LibrarianRecord> Records;

    public DataManipulator() {
    }

    public void initialize() throws IOException {
        //Users
        User.generateNameList();
        User.generateSurnameList();
        User.generatePatronymicList();
        Teacher.generateTeacherSurnameList();
        Student.generateGroupNameList();
        //Books
        EnglishTextbook.generateAuthorList();
        EnglishTextbook.generateGradeList();
        EnglishTextbook.generateNameList();
        EnglishTextbook.generateUniversityList();
        RussianTextbook.generateSubjectList();
        RussianTextbook.generateTypeList();
        RussianFiction.generateActionList();
        RussianFiction.generatePlaceList();
        RussianFiction.generateSubjectList();
        EnglishFiction.generateAuthorList();
        EnglishFiction.generateNameList();
    }

    public void generateData() {

        UserFactory UF = new UserFactory();
        Users = UF.createUsers(50);

        JournalDataManipulator JDM = new JournalDataManipulator();

        BookDataManipulator BDM = new BookDataManipulator();

        Books.addAll(BDM.createTestBook());
        Books.addAll(JDM.createJournals());
        System.out.println("ГЕНЕРАЦИЯ ЗАВЕРШЕНА");
    }

    public void generateRecords() {
        Librarian librarian = new Librarian();
        DateManipulator dateM = new DateManipulator();
        while (!dateM.DateIsOver()) {
            for (int k = 0; k < 100; k++) {
                int peopleTakeToday = (int) Math.floor(Math.random() * Users.size() * 0.10 + 1);
                for (int i = 0; i < peopleTakeToday; i++) {
                    librarian.createRecord(dateM.getDate(), Books, Users);
                }
                int peopleReturnToday = (int) Math.floor(Math.random() * librarian.getNumberOfRegisteredUsers() * 0.1);
                for (int i = 0; i < peopleReturnToday; i++) {
                    try {
                        librarian.returnBook(dateM.getDate(), Books, Users);
                    } catch (Exception ex) {
                        i--;
                    }
                }
                dateM.nextDay();
                System.out.println(dateM.getDate());
            }
        }
    }

    

    private static class JournalDataManipulator {

        public JournalDataManipulator() {

        }

        public ArrayList createJournals() {
            ArrayList<BookWithQuantity> journals = new ArrayList<>();

            JournalDirector JDirector = new JournalDirector();
            JDirector.setJB(new PhysicJournalBuilder());
            journals.addAll(createThematicalJournals(JDirector));

            JDirector.setJB(new AstronomicalJournalBuilder());
            journals.addAll(createThematicalJournals(JDirector));
            return journals;

        }

        private ArrayList<BookWithQuantity> createThematicalJournals(JournalDirector JDirector) {
            ArrayList<BookWithQuantity> ThematicalJournals = new ArrayList<>();

            while (!JDirector.isJournalsIsOver()) {
                JDirector.createJournal();
                ThematicalJournals.add(new BookWithQuantity(JDirector.getJournal()));
            }

            return ThematicalJournals;

        }

    }

    private static class BookDataManipulator {

        public BookDataManipulator() {

        }

        public ArrayList createTestBook() {
            BookFactory factory;
            ArrayList<BookWithQuantity> BookList = new ArrayList<>();
            int i = 0;
            while (i < 100) {
                int R = i - (int) Math.floor(i / 4) * 4;
                switch (R) {
                    case 0: {
                        factory = new RussianBookFactory();
                        BookList.add(new BookWithQuantity(factory.createFiction()));
                    }
                    break;
                    case 1: {
                        factory = new RussianBookFactory();
                        BookList.add(new BookWithQuantity(factory.createTextbook()));
                    }
                    break;
                    case 2: {
                        factory = new EnglishBookFactory();
                        BookList.add(new BookWithQuantity(factory.createFiction()));
                    }
                    break;
                    case 3: {
                        factory = new EnglishBookFactory();
                        BookList.add(new BookWithQuantity(factory.createTextbook()));
                    }
                    break;
                }
                i++;
            }
            return BookList;
        }

    }

}
