/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryexample;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Dmitry
 */
public class FactoryExample {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, SQLException {
        Frame frame = new Frame();
        frame.setVisible(true);
//        DataManipulator DM = new DataManipulator();
//        DM.initialize();
//        DM.generateData();
//        DM.generateRecords();
//        DM.exportToDB();
    }
    
}
