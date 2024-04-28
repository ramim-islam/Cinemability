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
        this.routePath = routePath + dir;
        this.file = new File(routePath, filename);
        this.routePath += filename;
    }

    public void CreateFile(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } 
            catch (IOException e) {e.printStackTrace();}
        }
    }

    public Vector<Vector<String>> ReadFile(){
        Vector <Vector<String>> Data = new Vector<Vector<String>>();
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()){
                String[] data = input.nextLine().split(",");
                Vector <String> vectorData = new Vector<String>();
                for (String eachdata: data) vectorData.add(eachdata);
                Data.add(vectorData);
            }
            input.close();
        } 
        catch (FileNotFoundException e) {e.printStackTrace();}
        
        return Data;
    }

    public void WriteData(Vector<Vector<String>> data){
        
    }

    public void DeleteData(){

    }

    public void AppendData(Vector<String> Data){
        System.out.println(routePath);
        try {
            String stringData = "";
            for (String data : Data)stringData += data + ",";
            stringData += System.lineSeparator();
            Files.write(Paths.get(routePath), stringData.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {}
    }
}
