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
public class RussianFiction implements Fiction{
    private String name;
    private static ArrayList<String> actionList;
    private static ArrayList<String> subjectList;
    private static ArrayList<String> placeList;
    public RussianFiction() {
        this.setName(generateName());
        Frame.text+= "Русская литература " + this.name + "\n";
        System.out.println("Русская литература " + this.name);
    }

    public void setName(String name) {
        this.name = name;
    }
    private String generateName(){
        return generateAction()+" "+generateSubject()+" по "+generatePlace();
    }
    private String generateAction(){
        return actionList.get((int) Math.floor(Math.random()*actionList.size()));
    }
    private String generateSubject(){
        return subjectList.get((int) Math.floor(Math.random()*subjectList.size()));
    }
    private String generatePlace(){
        return placeList.get((int) Math.floor(Math.random()*placeList.size()));
    }
    public static void generateActionList(){
        actionList = new ArrayList<>();
        actionList.add("Похождения");
        actionList.add("Путешествия");
        actionList.add("Прогулки");
        actionList.add("Поездки");
    }
    public static void generateSubjectList(){
        subjectList = new ArrayList<>();
        subjectList.add("Анны Каренины");
        subjectList.add("Бабы-Яги");
        subjectList.add("Кощея Бессмертного");
        subjectList.add("Кота Бегемота");
        subjectList.add("Маргариты");
        subjectList.add("Онегина");
        subjectList.add("Доктора Жевага");
        subjectList.add("Тараса Бульбы");
        subjectList.add("Штирлица");
        subjectList.add("Гумилёва");
    }
    public static void generatePlaceList(){
        placeList = new ArrayList<>();
        placeList.add("полям");
        placeList.add("лугам");
        placeList.add("морям");
        placeList.add("пляжам");
        placeList.add("лесам");
        placeList.add("островам");
    }
}
