/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;

import factoryexample.Frame;
import java.util.ArrayList;

/**
 *
 * @author Dmitry
 */
public class EnglishTextbook implements Textbook {

    private String name;
    private String grade;
    private String author;
    private String university;
    private static String[] gradeList;
    private static ArrayList<String> universityList;
    private static ArrayList<String> nameList;
    private static ArrayList<String> authorList;

    public EnglishTextbook() {
        this.setGrade(generateGrade());
        this.setUniversity(generateUniversity());
        this.setAuthor(generateAuthor());
        this.setName(generateName());
        Frame.text += "English Textbook " + this.name + " for " + this.grade + " from " + this.university + " by " + this.author + "\n";
        System.out.printf("English Textbook %s for %s from %s by %s%n", this.name, this.grade, this.university, this.author);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    private String generateGrade() {
        return gradeList[(int) Math.floor(Math.random() * gradeList.length)];
    }

    private String generateUniversity() {
        return universityList.get((int) Math.floor(Math.random() * universityList.size()));
    }

    private String generateName() {
        return nameList.get((int) Math.floor(Math.random() * nameList.size()));
    }

    private String generateAuthor() {
        return authorList.get((int) Math.floor(Math.random() * authorList.size()));
    }

    public static void generateGradeList() {
        gradeList = new String[2];
        gradeList[0] = "Bachlor";
        gradeList[1] = "Master";
    }

    public static void generateUniversityList() {
        universityList = new ArrayList<>();
        universityList.add("IsraelX");
        universityList.add("New York University");
        universityList.add("Rice University");
        universityList.add("The Hong Kong Polytechnic University");
        universityList.add("Université de Montréal");
        universityList.add("Dartmouth College");
    }

    public static void generateNameList() {
        nameList = new ArrayList<>();
        nameList.add("Introduction to AI Robotics");
        nameList.add("Introduction to Deep Learning");
        nameList.add("A Course in Semantics");
        nameList.add("Computational Psychiatry");
        nameList.add("Topology");
        nameList.add("Economic Dynamics in Discrete Time");
        nameList.add("Language Acquisition and Development");
    }

    public static void generateAuthorList() {
        authorList = new ArrayList<>();
        authorList.add("Robin R. Murphy");
        authorList.add("Eugene Charniak");
        authorList.add("Daniel Altshuler");
        authorList.add("Terence Parsons");
        authorList.add("Roger Schwarzschild");
        authorList.add("Peggy Seriès");
        authorList.add("Tai-Danae Bradley");
        authorList.add("Kamil Ud Deen");
    }

    @Override
    public String getType() {
        return "EnglishTextbook";
    }

    @Override
    public String getName() {
        return this.name + " for " + this.grade + " from " + this.university + " by " + this.author;
    }
}
