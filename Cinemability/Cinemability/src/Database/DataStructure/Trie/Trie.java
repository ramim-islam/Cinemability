package Database.DataStructure.Trie;
import java.util.Vector;


public class Trie{
    
    public class DynamicObject <GenericObj>{
        public Vector <GenericObj> List;
        DynamicObject(){
            List = new Vector<GenericObj>();
        }
    }
    
    Vector<Integer> BucketforPointer = new Vector<Integer>();
    final int MAX = (int) (2e5 + 10);
    int[][] trie = new int[MAX][300];
    int[] Count = new int[MAX];
    @SuppressWarnings("rawtypes")
    DynamicObject[] End = new DynamicObject[MAX];
    int pointer = 0;
   

    @SuppressWarnings("unchecked")
    public <GenericObj> void Insert(String str, GenericObj obj){
        int node = 1;
        for (char ch : str.toCharArray()){
            int edge = (int)ch;
            if (trie[node][edge] == 0){
                if (!BucketforPointer.isEmpty()){
                    trie[node][edge] = (int)BucketforPointer.lastElement();
                    BucketforPointer.remove(BucketforPointer.size() - 1);
                }else trie[node][edge] = ++pointer;
            }
            node = trie[node][edge];
            Count[node]++;
        }
        End[node].List.add(obj);
    }


    @SuppressWarnings("rawtypes")
    public DynamicObject search(String str){
        int node = 1;
        for (char ch : str.toCharArray()){
            int edge = (int)ch;
            if (trie[node][edge] == 0)return null;
            node = trie[node][edge];
        }
        return End[node];
    }
   
    public void delete(String str){

        if(search(str) != null){
            int node = 1;
            for (char ch : str.toCharArray()){
                int edge = (int)ch;
                int Tempnode = trie[node][edge];
                if (Count[trie[node][edge]] == 1){
                    BucketforPointer.add(trie[node][edge]);
                    trie[node][edge] = 0;
                }
                node = Tempnode;
                Count[node]--;
            }
            End[node] = null;
        }
        
    }
}
