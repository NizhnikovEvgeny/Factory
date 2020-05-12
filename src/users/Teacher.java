/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import factoryexample.ExcelExporter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dmitry
 */
public class Teacher extends User{
    public int Department;
    public static ArrayList<String> TeacherSurnameList;

    public void setDepartment(int Department) {
        this.Department = Department;
    }
    public Teacher(){
        int rn = (int) Math.floor(Math.random()*TeacherSurnameList.size());
        this.setName(generateTeacherName(rn));
        this.setSurname(generateTeacherSurname(rn));
        this.setID(generateID());
        this.setDepartment(18);
        this.setPatronymic(generatePatronymic(rn));
    }

    public int getDivision() {
        return Department;
    }

    public void setPatronymic(String Patronymic) {
        this.Patronymic = Patronymic;
    }

    public String generateTeacherSurname(int rn){
        return TeacherSurnameList.get(rn);
    }
    public String generateTeacherName(int rn){   
        if (rn<TeacherSurnameList.indexOf("Божко")) {
            return User.NameList.get((int) Math.floor(Math.random()*20));
        } else {
            return User.NameList.get((int) Math.floor(Math.random()*20+20));
        }
    }
    public String generatePatronymic(int rn){
        if (rn<TeacherSurnameList.indexOf("Божко")) {
            return User.PatronymicList.get((int) Math.floor(Math.random()*PatronymicList.size()))+"вич";
        } else {
            return User.PatronymicList.get((int) Math.floor(Math.random()*PatronymicList.size()))+"вна";
        }
    }
    public static void generateTeacherSurnameList() throws IOException{
        TeacherSurnameList = ExcelExporter.exportTeacherSurnames();
    }
}
