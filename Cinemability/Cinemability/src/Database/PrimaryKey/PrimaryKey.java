package Database.PrimaryKey;
import java.util.Vector;

import Database.FileIO.Fileio;

public class PrimaryKey {
    Fileio file;
    Vector<String[]> primaryKey;
    public PrimaryKey(){
        this.file = new Fileio("PrimaryKey/","PrimaryKey.txt");
        this.file.CreateFile();
        primaryKey = this.file.ReadFile();
    }

    public String getPrimaryKey(){
        return null;
    }
    
    
}
