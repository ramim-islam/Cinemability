package Database.DataStructure.Trie;
import java.util.Vector;

public class Trie {
    
    Vector<Integer> BucketforPointer = new Vector<Integer>();
    final int MAX = (int) (2e5 + 10);
    int[][] trie = new int[MAX][300];
    int[] Count = new int[MAX];
    int[] End = new int[MAX];
    int pointer = 0;
   

    public void addString(String str, int userid){
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
        End[node] = userid;
    }


    public int searchString(String str){
        int node = 1;
        for (char ch : str.toCharArray()){
            int edge = (int)ch;
            if (trie[node][edge] == 0){
                return -1;
            }
            node = trie[node][edge];
        }
        return End[node];
    }
   
    public void deleteString(String str){

        if(searchString(str) != 0){
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
            End[node] = 0;
        }
        
    }

   
}
