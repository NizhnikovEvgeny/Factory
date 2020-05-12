/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.util.ArrayList;

/**
 *
 * @author Dmitry
 */
public class Student extends User{
    public String GroupName;

    public String getGroupName() {
        return GroupName;
    }
    
    private static ArrayList<String> GroupNameList;
    
    public Student(){
        int rn = User.numGenerate();
        this.setName(User.generateName(rn));
        this.setSurname(User.generateSurname(rn));
        this.setID(generateID());
        this.setGroupName(generateGroupName());
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }
    
    
    
    public String getDivision() {
        return GroupName;
    }
    
    
    public static void generateGroupNameList(){
        GroupNameList = new ArrayList<String>();
        GroupNameList.add("Б19-901");
        GroupNameList.add("Б18-901");
        GroupNameList.add("Б17-901");
        GroupNameList.add("Б16-901");
    }
    public static String generateGroupName(){
        
       double rn = Math.random()*GroupNameList.size();
       
       int rni = (int) Math.floor(rn);
       if (rni==4){
           rni = 3;
       }
       return GroupNameList.get(rni);
       
    }
}
