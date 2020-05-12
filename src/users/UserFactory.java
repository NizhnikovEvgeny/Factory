/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import factoryexample.Frame;
import java.util.ArrayList;

/**
 *
 * @author Dmitry
 */
public class UserFactory {

    public UserFactory() {
        
    }
    
    public User createUser(double rn){
        if (rn < 0.75){
            Student stud = new Student();
//            Frame.text+="Студент " + stud.getSurname()+ " " + stud.getName() +" из группы " + stud.getGroupName() + "\n";
//            System.out.printf("Студент %s %s из группы %s\n", stud.getSurname(), stud.getName(), stud.getGroupName());
            return stud;
        } 
        else {
            Teacher teach = new Teacher();
//            Frame.text+="Преподаватель " + teach.getSurname() + " " + teach.getName() + " " + teach.getPatronymic() + " с кафедры " + teach.getDivision()+"\n"; 
//            System.out.printf("Преподаватель %s %s %s с кафедры %d\n", teach.getSurname(), teach.getName(), teach.getPatronymic(), teach.getDivision());
            return teach;
        }
    }
    
    public ArrayList<User> createUsers(int num_of_users){
        
        ArrayList<User> UsersArray = new ArrayList<User>();
        for (int i = 0; i < num_of_users; i++) {
            double rn = Math.random();
            UsersArray.add(createUser(rn));
        }
        
        return UsersArray;
    }
}
