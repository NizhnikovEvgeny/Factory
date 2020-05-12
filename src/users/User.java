/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import Records.LibrarianRecord;
import factoryexample.ExcelExporter;
import static users.Teacher.TeacherSurnameList;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dmitry
 */
public abstract class User {
    
    public ArrayList<LibrarianRecord> records;
    public int ID;
    public String Name;
    public String Surname;
    public String Patronymic;
    
    public static int GLOBAL_ID = 0;
    
    public static ArrayList<String> NameList;
    public static ArrayList<String> SurnameList;
    public static ArrayList<String> PatronymicList;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public void setPatronymic(String Patronymic) {
        this.Patronymic = Patronymic;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPatronymic() {
        return Patronymic;
    }
    
    
    public static void generateNameList() throws IOException{
        NameList = ExcelExporter.exportNames();
    }
    public static void generateSurnameList() throws IOException{
        SurnameList = ExcelExporter.exportSurnames();
    }

    public static void generatePatronymicList() throws IOException{
        PatronymicList = ExcelExporter.exportPatronymics();
    }
    
    public static int numGenerate(){
        int rn = (int) Math.floor(Math.random()*NameList.size());
        return rn;
    }
    public static String generateName(int rn){
  
       return NameList.get(rn);
       
    }
    public static String generateSurname(int rn){
        int ran = (int) Math.floor(Math.random()*SurnameList.size());
        if (rn<NameList.indexOf("София")) {
        return SurnameList.get(ran);
        } else {
        return SurnameList.get(ran)+"а";    
        }
    }
    
    public static int generateID(){
        int newID = GLOBAL_ID;
        GLOBAL_ID++;
        return  newID;
    }
}



