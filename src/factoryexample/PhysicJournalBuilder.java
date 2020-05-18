/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryexample;

/**
 *
 * @author Dmitry
 */
public class PhysicJournalBuilder extends JournalBuilder{
    
    
    private final int YearBegin = 2000;

    public PhysicJournalBuilder() {
        YearCurrent = YearBegin;
    }
    
    @Override
    public void createJName() {
        this.journal.setJName("Юные физики и инженеры");
        this.journal.setType("PhysicJournal");
    }

    

    protected void tickCounter() {
        this.VolumeCounter++;
        if (this.VolumeCounter > 12){
            this.VolumeCounter = 1;
            YearCurrent++;
        }
    }
    
}
