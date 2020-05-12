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
public class RussianTextbook implements Textbook{
    private String type;
    private String subject;
    private static ArrayList<String> typeList;
    private static ArrayList<String> subjectList;
    public RussianTextbook() {
        this.setSubject(generateSubject());
        this.setType(generateType());
//        Frame.text+= "Русский учебник типа: " + this.type + " по предмету " + this.subject +"\n";
//        System.out.printf("Русский учебник типа: %s по предмету %s%n", this.type,this.subject);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public static void generateSubjectList(){
        subjectList = new ArrayList<>();
        subjectList.add("Конструирование");
        subjectList.add("Материаловедение для высоковольтной электрофизической аппаратуры");
        subjectList.add("Проектирование ТВЭЛ ядерных энергетических установок");
        subjectList.add("Практика управления техническим проектом");
        subjectList.add("Проектирование ТВЭЛ");
        subjectList.add("Актуальные проблемы разработки информационно-измерительных систем ЯЭУ");
        subjectList.add("Технологическая подготовка производства");
        subjectList.add("Основы формирования затрат разработки и последующего производства инновационной продукции");
        subjectList.add("Детали машин и основы конструирования");
        subjectList.add("Системы обеспечения безопасности ЯЭУ");
    }
    public static void generateTypeList(){
        typeList = new ArrayList<>();
        typeList.add("Учебник");
        typeList.add("Пособие");
        typeList.add("Лабораторный практикум");
        typeList.add("Задачник");
        typeList.add("Сборник решений для учителя");
    }
    private String generateSubject(){
        return subjectList.get((int) Math.floor(Math.random()*subjectList.size()));
    }
    private String generateType(){
        return typeList.get((int) Math.floor(Math.random()*typeList.size()));
    }
}
