/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryexample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Женя
 */
public class ExcelExporter {
    private static ArrayList<String> list;
    private static ArrayList<String> export(Path file_path) throws FileNotFoundException, IOException{
        list = new ArrayList<>();
        XSSFWorkbook MyBook = new XSSFWorkbook(new FileInputStream(file_path.toString()));
        XSSFSheet MySheet = MyBook.getSheetAt(0);
        int rowCount = MySheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rowCount; i++) {       // Возможно i надо сделать от 0
            list.add(MySheet.getRow(i).getCell(0).toString());
        }
            return list;
    }
    
    public static ArrayList<String> exportNames() throws IOException{
        Path file_path = FileSystems.getDefault().getPath("Names.xlsx");
        return export(file_path);
    }
    public static ArrayList<String> exportSurnames() throws IOException{
        Path file_path = FileSystems.getDefault().getPath("StudSurnames.xlsx");
        return export(file_path);
    }
    public static ArrayList<String> exportPatronymics() throws IOException{
        Path file_path = FileSystems.getDefault().getPath("Patronyms.xlsx");
        return export(file_path);
    }
    public static ArrayList<String> exportTeacherSurnames() throws IOException{
        Path file_path = FileSystems.getDefault().getPath("TeacherSurnames.xlsx");
        return export(file_path);
    }
}
