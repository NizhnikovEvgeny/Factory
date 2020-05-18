/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryexample;

import Books.Bookable;

/**
 *
 * @author Dmitry
 */
public class Journal implements Bookable{
    public String JName;
    public String type;

    public void setType(String type) {
        this.type = type;
    }
    public int volume;
    public int year;
    
    public String getJName() {
        return JName;
    }

    public int getYear() {
        return year;
    }

    public int getVolume() {
        return volume;
    }

    public void setJName(String JName) {
        this.JName = JName;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setYear(int year) {
        this.year = year;
    }

    

    @Override
    public String getName() {
        return JName;
    }

    @Override
    public String getType() {
        return type;
    }

    

    
    
    
    
}
