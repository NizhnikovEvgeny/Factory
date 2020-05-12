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
public class EnglishFiction implements Fiction{
    private String auhtor;
    private String name;
    private int year;
    private static ArrayList<String> authorList;
    private static ArrayList<String> nameList;
    public EnglishFiction() {
        this.setAuhtor(generateAuthor());
        this.setName(generateName());
        this.setYear(generateYear());
        Frame.text+= this.auhtor + " has written \"" + this.name + "\" in " + this.year + "\n";
        System.out.printf("%s has written \"%s\" in %d%n", this.auhtor, this.name, this.year);
    }

    public void setAuhtor(String auhtor) {
        this.auhtor = auhtor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuhtor() {
        return auhtor;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getAuthorList() {
        return authorList;
    }

    public ArrayList<String> getNameList() {
        return nameList;
    }
    
    public static void generateAuthorList(){
        authorList = new ArrayList<>();
        authorList.add("Agatha Christie");
        authorList.add("Albert Camus");
        authorList.add("Alfred Hitchcock");
        authorList.add("Allen Ginsberg");
        authorList.add("André Gide");
        authorList.add("Andrew Carnegie");
        authorList.add("Anne Frank");
        authorList.add("Anne Morrow Lindbergh");
        authorList.add("Anne Sexton");
        authorList.add("Arthur Conan Doyle");
        authorList.add("Arthur Miller");
        authorList.add("Carl Jung");
    }
    public static void generateNameList(){
        nameList = new ArrayList<>();
        nameList.add("In Search of Lost Time");
        nameList.add("Don Quixote");
        nameList.add("Pilgrim's Progress");
        nameList.add("Robinson Crusoe");
        nameList.add("Gulliver's Travels");
        nameList.add("Tom Jones");
        nameList.add("Clarissa");
        nameList.add("Dangerous Liaisons");
        nameList.add("Frankenstein");
    }
    private String generateAuthor(){
        return authorList.get((int) Math.floor(Math.random()*authorList.size()));
    }
    private String generateName(){
        return nameList.get((int) Math.floor(Math.random()*nameList.size()));
    }
    private int generateYear(){
        return (int) Math.floor(Math.random()*2000+1);
    }
}
