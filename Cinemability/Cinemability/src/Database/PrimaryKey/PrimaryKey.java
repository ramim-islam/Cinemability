package Database.PrimaryKey;
import java.util.Vector;

import Database.FileIO.Fileio;

public class PrimaryKey {
    Fileio file;
    Vector<Vector<String>> primaryKey = new Vector<Vector<String>>();
    public PrimaryKey(){
        this.file = new Fileio("PrimaryKey/","PrimaryKey.txt");
        this.file.CreateFile();
        primaryKey = this.file.ReadFile();
    }


    // Need to Improve Key Management
    public String getPrimaryKey(){
        if (primaryKey.isEmpty()){
            for (Integer i = 1; i <= 100; i++){
                String y = Integer.toString(i);
                Vector<String>x = new Vector<String>();
                x.add(y);
                primaryKey.add(x);
                this.file.AppendData(x);
            }  
        }
        String pk = primaryKey.lastElement().lastElement();
        primaryKey.remove(primaryKey.size() - 1);
        return pk;
    }
    
    
}
