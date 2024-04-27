package Database.FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.Vector;

public class Fileio {
    
    File file;
    String routePath = System.getProperty("user.dir") + "/Cinemability/Cinemability/src/Database/";
    public Fileio(String dir, String filename){
        this.file = new File(routePath + dir, filename);
    }

    public void CreateFile(){
        if(!file.exists()){
            try {file.createNewFile();} 
            catch (IOException e) {e.printStackTrace();}
        }
    }

    public Vector<String[]> ReadFile(){
        Vector <String[]> Data = new Vector<String[]>();
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()){
                String[] data = input.nextLine().split("\\s");
                Data.add(data);
            }
        } 
        catch (FileNotFoundException e) {e.printStackTrace();}
        return Data;
    }

    public void WriteData(Vector<String[]> data){
        
    }

    public void DeleteData(){

    }

    public void AppendData(String[] Data){
        try {
            for (String data : Data){
                Files.write(Paths.get(routePath), data.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {}
    }
}
